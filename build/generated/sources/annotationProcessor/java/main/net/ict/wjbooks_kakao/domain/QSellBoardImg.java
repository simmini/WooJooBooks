package net.ict.wjbooks_kakao.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSellBoardImg is a Querydsl query type for SellBoardImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSellBoardImg extends EntityPathBase<SellBoardImg> {

    private static final long serialVersionUID = 1456285537L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSellBoardImg sellBoardImg = new QSellBoardImg("sellBoardImg");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QBoard board;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgName = createString("imgName");

    public final StringPath imgUrl = createString("imgUrl");

    public final StringPath oriImgName = createString("oriImgName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final StringPath repimgYn = createString("repimgYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QSellBoardImg(String variable) {
        this(SellBoardImg.class, forVariable(variable), INITS);
    }

    public QSellBoardImg(Path<? extends SellBoardImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSellBoardImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSellBoardImg(PathMetadata metadata, PathInits inits) {
        this(SellBoardImg.class, metadata, inits);
    }

    public QSellBoardImg(Class<? extends SellBoardImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board")) : null;
    }

}

