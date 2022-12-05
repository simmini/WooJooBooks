package net.ict.wjbooks.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 463617016L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final DateTimePath<java.util.Date> bookDate = createDateTime("bookDate", java.util.Date.class);

    public final NumberPath<Long> bookNum = createNumber("bookNum", Long.class);

    public final StringPath bookPrice = createString("bookPrice");

    public final StringPath bookPublisher = createString("bookPublisher");

    public final StringPath bookTitle = createString("bookTitle");

    public final StringPath bookWriter = createString("bookWriter");

    public final QFile file;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final NumberPath<Long> sellCondition = createNumber("sellCondition", Long.class);

    public final StringPath sellContent = createString("sellContent");

    public final NumberPath<Long> sellPrice = createNumber("sellPrice", Long.class);

    public final BooleanPath sellState = createBoolean("sellState");

    public final StringPath sellTitle = createString("sellTitle");

    public final NumberPath<Long> sellView = createNumber("sellView", Long.class);

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.file = inits.isInitialized("file") ? new QFile(forProperty("file"), inits.get("file")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

