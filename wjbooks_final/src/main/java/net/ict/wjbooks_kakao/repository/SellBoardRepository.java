package net.ict.wjbooks_kakao.repository;

import net.ict.wjbooks_kakao.domain.Board;
import net.ict.wjbooks_kakao.domain.SellBoard;
import net.ict.wjbooks_kakao.repository.search.SellBoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SellBoardRepository extends JpaRepository<SellBoard, Long>, QuerydslPredicateExecutor, SellBoardSearch {
    List<SellBoard> findBySellTitle(String sellTitle);
    List<SellBoard> findBySellTitleOrBookTitle(String sellTitle, String bookTitle);
    List<SellBoard> findBySellPriceLessThan(Integer sellPrice);
    List<SellBoard> findBySellPriceLessThanOrderBySellPriceDesc(Integer sellPrice);

    @Query("select b from Board b where 'b.bookTitle' like %:bookTitle% order by 'b.sellPrice' desc")
    List<SellBoard> findByBookTitle(@Param("bookTitle") String bookTitle);

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from SellBoard b where b.id =:id")
    Optional<SellBoard> findByIdWithImages(Long id);
}
