package net.ict.wjbooks.repository;

import net.ict.wjbooks.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //중복회원검사 email로 확인
    Member findByEmail(String email);
}
