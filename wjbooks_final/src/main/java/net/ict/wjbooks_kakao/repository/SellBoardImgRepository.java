package net.ict.wjbooks_kakao.repository;

import net.ict.wjbooks_kakao.domain.BoardImg;
import net.ict.wjbooks_kakao.domain.SellBoardImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellBoardImgRepository extends JpaRepository<SellBoardImg, Long> {
}
