package net.ict.wjbooks_kakao.repository;

import net.ict.wjbooks_kakao.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.memEmail = :email and m.social = false")
    Optional<Member> getWithRole(@Param("email") String email);

    @EntityGraph(attributePaths = "roleSet")
    Optional<Member> findByMemEmail(String email);

    Optional<Member> deleteByMemEmail(String email);
    

}
