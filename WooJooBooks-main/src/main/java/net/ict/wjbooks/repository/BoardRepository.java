package net.ict.wjbooks.repository;


import net.ict.wjbooks.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board>, BoardRepositoryCustom {
    List<Board> findByBookTitle(String bookTitle);
    List<Board> findByPriceLessThan(Integer price);
    List<Board> findByBookTitleOrSellTitle(String bookTitle, String sellTitle);
    @Query("select b from Board b where b.sellTitle like "+ "%:sellTitle% order by b.sellPrice desc")
    List<Board> findBySellTitle(@Param("sellTitle")String sellTitle);
}
