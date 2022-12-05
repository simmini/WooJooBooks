package net.ict.wjbooks.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardMainDto {
    private Long id;
    private String sellTitle;
    private String bookTitle;
    private String imgUrl;
    private Integer price;

    @QueryProjection
    public BoardMainDto(Long id, String sellTitle, String bookTitle, String imgUrl, Integer price){
        this.id=id;
        this.sellTitle=sellTitle;
        this.bookTitle=bookTitle;
        this.imgUrl=imgUrl;
        this.price=price;
    }
}
