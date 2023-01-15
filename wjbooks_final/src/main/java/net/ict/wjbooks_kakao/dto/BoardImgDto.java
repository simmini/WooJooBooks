package net.ict.wjbooks_kakao.dto;

import lombok.Getter;
import lombok.Setter;
import net.ict.wjbooks_kakao.domain.BoardImg;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class BoardImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardImgDto of(BoardImg boardImg){
        return modelMapper.map(boardImg, BoardImgDto.class);
    }
}
