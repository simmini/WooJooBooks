package net.ict.wjbooks_kakao.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSellBoardImage is a Querydsl query type for SellBoardImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSellBoardImage extends EntityPathBase<SellBoardImage> {

    private static final long serialVersionUID = -668939911L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSellBoardImage sellBoardImage = new QSellBoardImage("sellBoardImage");

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Integer> ord = createNumber("ord", Integer.class);

    public final QSellBoard sellBoard;

    public final StringPath uuid = createString("uuid");

    public QSellBoardImage(String variable) {
        this(SellBoardImage.class, forVariable(variable), INITS);
    }

    public QSellBoardImage(Path<? extends SellBoardImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSellBoardImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSellBoardImage(PathMetadata metadata, PathInits inits) {
        this(SellBoardImage.class, metadata, inits);
    }

    public QSellBoardImage(Class<? extends SellBoardImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sellBoard = inits.isInitialized("sellBoard") ? new QSellBoard(forProperty("sellBoard")) : null;
    }

}

