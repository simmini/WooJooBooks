package net.ict.wjbooks_kakao.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSellBoard is a Querydsl query type for SellBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSellBoard extends EntityPathBase<SellBoard> {

    private static final long serialVersionUID = 1730232578L;

    public static final QSellBoard sellBoard = new QSellBoard("sellBoard");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath bookDate = createString("bookDate");

    public final NumberPath<Integer> bookPrice = createNumber("bookPrice", Integer.class);

    public final StringPath bookPublisher = createString("bookPublisher");

    public final StringPath bookTitle = createString("bookTitle");

    public final StringPath bookWriter = createString("bookWriter");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<SellBoardImage, QSellBoardImage> imageSet = this.<SellBoardImage, QSellBoardImage>createSet("imageSet", SellBoardImage.class, QSellBoardImage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final EnumPath<net.ict.wjbooks_kakao.constant.SellCondition> sellCondition = createEnum("sellCondition", net.ict.wjbooks_kakao.constant.SellCondition.class);

    public final StringPath sellContent = createString("sellContent");

    public final NumberPath<Integer> sellPrice = createNumber("sellPrice", Integer.class);

    public final EnumPath<net.ict.wjbooks_kakao.constant.SellStatus> sellStatus = createEnum("sellStatus", net.ict.wjbooks_kakao.constant.SellStatus.class);

    public final StringPath sellTitle = createString("sellTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QSellBoard(String variable) {
        super(SellBoard.class, forVariable(variable));
    }

    public QSellBoard(Path<? extends SellBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSellBoard(PathMetadata metadata) {
        super(SellBoard.class, metadata);
    }

}

