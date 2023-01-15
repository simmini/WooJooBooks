package net.ict.wjbooks_kakao.service;

import net.ict.wjbooks_kakao.domain.SellBoard;
import net.ict.wjbooks_kakao.dto.*;

import java.util.List;
import net.ict.wjbooks_kakao.constant.*;
import java.util.Objects;
import java.util.stream.Collectors;

public interface SellBoardService {
    Long register(SellBoardDTO boardFormDto);

    SellBoardDTO readOne(Long id);

    void modify(SellBoardDTO boardFormDto);

    void remove(Long id);

    PageResponseDTO<SellBoardFormDTO> list(PageRequestDTO pageRequestDto);

    //댓글의 숫자까지 처리
    PageResponseDTO<SellBoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

    //게시글의 이미지와 댓글의 숫자까지 처리
    PageResponseDTO<SellBoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO);


    default SellBoardDTO entityToDTO(SellBoard board) {
        String condition = "";
        if (!Objects.isNull(board.getSellCondition())) {
            switch (board.getSellCondition()) {
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
        String status = "";
        if (!Objects.isNull(board.getSellStatus())) {
            status = board.getSellStatus().toString();
        }
        SellBoardDTO boardDTO = SellBoardDTO.builder()
                .id(board.getId())
                .title(board.getSellTitle())
                .sellContent(board.getSellContent())
                .bookWriter(board.getBookWriter())
                .bookDate(board.getBookDate())
                .bookPublisher(board.getBookPublisher())
                .sellCondition(condition)
                .bookPrice(board.getBookPrice())
                .bookTitle(board.getBookTitle())
                .sellPrice(board.getSellPrice())
                .sellStatus(status)
                .build();

        List<String> fileNames =
                board.getImageSet().stream().sorted().map(boardImage ->
                        boardImage.getUuid()+"_"+boardImage.getFileName()).collect(Collectors.toList());

        boardDTO.setFileNames(fileNames);

        return boardDTO;
    }
}
