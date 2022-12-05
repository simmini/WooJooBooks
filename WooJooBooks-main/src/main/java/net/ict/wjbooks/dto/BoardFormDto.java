package net.ict.wjbooks.dto;


import lombok.Getter;
import lombok.Setter;
import net.ict.wjbooks.domain.Board;
import net.ict.wjbooks.domain.File;
import net.ict.wjbooks.domain.Member;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BoardFormDto {


    private Long id; //게시물 번호

    private Member member; //회원 번호

    private File file; //파일 번호

    /*=============================================*/
    @NotBlank(message="책 이름을 등록해주세요")
    private String sellTitle;

    @NotBlank(message="상품 상세 설명을 적어주세요")
    private String sellContent;

    @NotNull(message="상품 가격을 적어주세요")
    private Long sellPrice;

    @NotNull
    private boolean sellState;

    @NotNull(message="책 상태를 선택해주세요")
    private Long sellCondition;

    @NotNull
    private Long sellView;

    /*=============================================*/
    @NotBlank(message="책 이름을 등록해주세요")
    private String bookTile;

    @NotBlank(message="출판사 이름을 등록해주세요")
    private String bookPublisher;

    @NotBlank(message="저자 이름을 등록해주세요")
    private String bookWriter;

    @NotNull(message="출판일을 등록해주세요")
    private Date bookDate;

    @NotBlank(message="책 정가를 등록해주세요")
    private String bookPrice;

       /* @Column(nullable = false, name = "b_isbn")
        @NotBlank
        private Long bookIsbn;*/

    /* ==================================================*/

    private List<FileDto> fileDtoList=new ArrayList<>();

    private List<Long>fileIds =new ArrayList<>();

    private static ModelMapper modelMapper =new ModelMapper();

    public Board createBoard(){
        return modelMapper.map(this,Board.class);
    }

    public static BoardFormDto of(Board board){
        return modelMapper.map(board,BoardFormDto.class);
    }

}