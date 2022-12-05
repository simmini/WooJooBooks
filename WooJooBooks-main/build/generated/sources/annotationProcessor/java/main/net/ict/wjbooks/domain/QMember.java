package net.ict.wjbooks.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1793253320L;

    public static final QMember member = new QMember("member1");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath email = createString("email");

    public final StringPath m_address1 = createString("m_address1");

    public final StringPath m_address2 = createString("m_address2");

    public final StringPath m_address3 = createString("m_address3");

    public final StringPath m_name = createString("m_name");

    public final NumberPath<Long> m_num = createNumber("m_num", Long.class);

    public final StringPath m_pass = createString("m_pass");

    public final NumberPath<Long> m_score = createNumber("m_score", Long.class);

    public final StringPath m_tel = createString("m_tel");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final EnumPath<net.ict.wjbooks.constant.Role> role = createEnum("role", net.ict.wjbooks.constant.Role.class);

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

