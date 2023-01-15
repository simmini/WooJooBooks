package net.ict.wjbooks_kakao.dto;

import lombok.*;
import net.ict.wjbooks_kakao.domain.SellBoardImg;
import org.modelmapper.ModelMapper;
@Getter @Setter
public class SellBoardImgDTO {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardImgDto of(SellBoardImg boardImg){
        return modelMapper.map(boardImg, BoardImgDto.class);
    }
}