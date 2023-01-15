package net.ict.wjbooks_kakao.repository.search;


import net.ict.wjbooks_kakao.domain.SellBoard;
import net.ict.wjbooks_kakao.dto.SellBoardListAllDTO;
import net.ict.wjbooks_kakao.dto.SellBoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellBoardSearch {

    Page<SellBoard> search1(Pageable pageable);

    Page<SellBoard> searchAll(String[] types, String keyword, Pageable pageable);

    Page<SellBoardListReplyCountDTO> searchWithReplyCount(String[] types,
                                                      String keyword,
                                                      Pageable pageable);

    Page<SellBoardListAllDTO> searchWithAll(String[] types,
                                        String keyword,
                                        Pageable pageable);
}
