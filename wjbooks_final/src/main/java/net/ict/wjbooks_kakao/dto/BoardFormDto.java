package net.ict.wjbooks_kakao.dto;

import lombok.Getter;
import lombok.Setter;
import net.ict.wjbooks_kakao.constant.SellCondition;
import net.ict.wjbooks_kakao.constant.SellStatus;
import net.ict.wjbooks_kakao.domain.Board;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BoardFormDto {
    private Long id;

    @NotEmpty(message = "제목을 입력하세요")
    private String sellTitle;

    @NotNull(message = "내용을 입력하세요")
    private String sellContent;

    @NotBlank(message = "판매가격을 입력하세요.")
    private Integer sellPrice;

    private SellStatus sellStatus;

    private SellCondition sellCondition;

    @NotEmpty
    private String bookTitle;

    @NotEmpty
    private String bookPublisher;

    @NotEmpty
    private String bookDate;

    @NotBlank
    private Integer bookPrice;

    @NotEmpty
    private String category_a;

    @NotNull
    private String category_b;

    private List<BoardImgDto> boardImgDtoList = new ArrayList<>();

    private List<Long> boardImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Board createBoard(){
        return modelMapper.map(this, Board.class);
    }

    public static BoardFormDto of(Board board){
        return modelMapper.map(board, BoardFormDto.class);
    }
}
