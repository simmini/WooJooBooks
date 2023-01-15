package net.ict.wjbooks_kakao.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import net.ict.wjbooks_kakao.constant.*;
import net.ict.wjbooks_kakao.domain.SellBoard;
import net.ict.wjbooks_kakao.domain.QSellBoard;
import net.ict.wjbooks_kakao.domain.QReply;
import net.ict.wjbooks_kakao.dto.SellBoardImageDTO;
import net.ict.wjbooks_kakao.dto.SellBoardListAllDTO;
import net.ict.wjbooks_kakao.dto.SellBoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SellBoardSearchImpl extends QuerydslRepositorySupport implements SellBoardSearch {

    public SellBoardSearchImpl(){
        super(SellBoard.class);
    }

    @Override
    public Page<SellBoard> search1(Pageable pageable) {

        QSellBoard board = QSellBoard.sellBoard;

        JPQLQuery<SellBoard> query = from(board);

        BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

        booleanBuilder.or(board.bookTitle.contains("11")); // title like ...

        booleanBuilder.or(board.sellContent.contains("11")); // content like ....

        query.where(booleanBuilder);
        query.where(board.id.gt(0L));


        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<SellBoard> list = query.fetch();

        long count = query.fetchCount();


        return null;

    }

    @Override
    public Page<SellBoard> searchAll(String[] types, String keyword, Pageable pageable) {

        QSellBoard board = QSellBoard.sellBoard;
        JPQLQuery<SellBoard> query = from(board);

        if( (types != null && types.length > 0) && keyword != null ){ //검색 조건과 키워드가 있다면

            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type: types){

                switch (type){
                    case "t":
                        booleanBuilder.or(board.bookTitle.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.sellContent.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.bookWriter.contains(keyword));
                        break;
                }
            }//end for
            query.where(booleanBuilder);
        }//end if

        //bno > 0
        query.where(board.id.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<SellBoard> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);

    }

    @Override
    public Page<SellBoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable) {

        QSellBoard board = QSellBoard.sellBoard;
        QReply reply = QReply.reply;

        JPQLQuery<SellBoard> query = from(board);
//        query.leftJoin(reply).on(reply.board.eq(board));

        query.groupBy(board);

        if( (types != null && types.length > 0) && keyword != null ){

            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type: types){

                switch (type){
                    case "t":
                        booleanBuilder.or(board.bookTitle.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.sellContent.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.bookWriter.contains(keyword));
                        break;
                }
            }//end for
            query.where(booleanBuilder);
        }

        //bno > 0
        query.where(board.id.gt(0L));

        JPQLQuery<SellBoardListReplyCountDTO> dtoQuery = query.select(Projections.bean(SellBoardListReplyCountDTO.class,
                board.id,
                board.bookTitle,
                board.bookWriter,
                board.regTime,
                reply.count().as("replyCount")
        ));

        this.getQuerydsl().applyPagination(pageable,dtoQuery);

        List<SellBoardListReplyCountDTO> dtoList = dtoQuery.fetch();

        long count = dtoQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);
    }

    @Override
    public Page<SellBoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable) {

        QSellBoard board = QSellBoard.sellBoard;
        QReply reply = QReply.reply;

        JPQLQuery<SellBoard> boardJPQLQuery = from(board);

        if( (types != null && types.length > 0) && keyword != null ){

            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type: types){

                switch (type){
                    case "t":
                        booleanBuilder.or(board.sellTitle.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.bookPublisher.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.bookWriter.contains(keyword));
                        break;
                }
            }//end for
            boardJPQLQuery.where(booleanBuilder);
        }

        boardJPQLQuery.groupBy(board);

        getQuerydsl().applyPagination(pageable, boardJPQLQuery); //paging



        JPQLQuery<SellBoard> tupleJPQLQuery = boardJPQLQuery.select(board);

        List<SellBoard> tupleList = tupleJPQLQuery.fetch();

        List<SellBoardListAllDTO> dtoList = tupleList.stream().map(res -> {
            String condition = "";
            if (!Objects.isNull(res.getSellCondition())) {
                switch (res.getSellCondition()) {
                    case NEW: {
                        condition = "새것";
                        break;
                    }
                    case AlmostNew: {
                        condition = "거의 새것";
                        break;
                    }
                    case OLD: {
                        condition = "사용감 있음";
                        break;
                    }
                }
            }
            SellBoardListAllDTO dto = SellBoardListAllDTO.builder()
                    .id(res.getId())
                    .sellTitle(res.getSellTitle())
                    .sellWriter(res.getBookWriter())
                    .sellPrice(res.getSellPrice())
                    .sellCondition(condition)
                    .build();

            //SellBoardImage를 SellBoardImageDTO 처리할 부분
            List<SellBoardImageDTO> imageDTOS = res.getImageSet().stream().sorted()
                    .map(boardImage -> SellBoardImageDTO.builder()
                            .uuid(boardImage.getUuid())
                            .fileName(boardImage.getFileName())
                            .ord(boardImage.getOrd())
                            .build()
                    ).collect(Collectors.toList());

            dto.setSellBoardImageDto(imageDTOS);

            return dto;
        }).collect(Collectors.toList());

        long totalCount = boardJPQLQuery.fetchCount();
        return new PageImpl<>(dtoList, pageable, totalCount);
    }

}
