package net.ict.wjbooks_kakao.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 211652364L;

    public static final QMember member = new QMember("member1");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final BooleanPath del = createBoolean("del");

    public final StringPath memAdr1 = createString("memAdr1");

    public final StringPath memAdr2 = createString("memAdr2");

    public final StringPath memAdr3 = createString("memAdr3");

    public final StringPath memEmail = createString("memEmail");

    public final StringPath memName = createString("memName");

    public final NumberPath<Long> memNum = createNumber("memNum", Long.class);

    public final StringPath memPass = createString("memPass");

    public final NumberPath<Long> memScore = createNumber("memScore", Long.class);

    public final StringPath memTel = createString("memTel");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final EnumPath<net.ict.wjbooks_kakao.constant.Role> role = createEnum("role", net.ict.wjbooks_kakao.constant.Role.class);

    public final SetPath<net.ict.wjbooks_kakao.constant.Role, EnumPath<net.ict.wjbooks_kakao.constant.Role>> roleSet = this.<net.ict.wjbooks_kakao.constant.Role, EnumPath<net.ict.wjbooks_kakao.constant.Role>>createSet("roleSet", net.ict.wjbooks_kakao.constant.Role.class, EnumPath.class, PathInits.DIRECT2);

    public final BooleanPath social = createBoolean("social");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

