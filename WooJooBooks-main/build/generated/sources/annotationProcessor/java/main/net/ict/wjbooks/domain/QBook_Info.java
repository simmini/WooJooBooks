package net.ict.wjbooks.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook_Info is a Querydsl query type for Book_Info
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook_Info extends EntityPathBase<Book_Info> {

    private static final long serialVersionUID = -1607125898L;

    public static final QBook_Info book_Info = new QBook_Info("book_Info");

    public final NumberPath<Integer> b_isbn = createNumber("b_isbn", Integer.class);

    public final NumberPath<Long> b_num = createNumber("b_num", Long.class);

    public final NumberPath<Integer> b_price = createNumber("b_price", Integer.class);

    public final StringPath b_publisher = createString("b_publisher");

    public final StringPath b_title = createString("b_title");

    public final StringPath b_writer = createString("b_writer");

    public QBook_Info(String variable) {
        super(Book_Info.class, forVariable(variable));
    }

    public QBook_Info(Path<? extends Book_Info> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook_Info(PathMetadata metadata) {
        super(Book_Info.class, metadata);
    }

}

