package net.ict.wjbooks.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * net.ict.wjbooks.dto.QBoardMainDto is a Querydsl Projection type for BoardMainDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardMainDto extends ConstructorExpression<BoardMainDto> {

    private static final long serialVersionUID = -206157749L;

    public QBoardMainDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> sellTitle, com.querydsl.core.types.Expression<String> bookTitle, com.querydsl.core.types.Expression<String> imgUrl, com.querydsl.core.types.Expression<Integer> price) {
        super(BoardMainDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class}, id, sellTitle, bookTitle, imgUrl, price);
    }

}

