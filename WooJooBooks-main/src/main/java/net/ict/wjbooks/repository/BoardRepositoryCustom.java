package net.ict.wjbooks.repository;

import net.ict.wjbooks.domain.Board;
import net.ict.wjbooks.dto.BoardMainDto;
import net.ict.wjbooks.dto.BoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
    Page<Board> getAdminBoardPage(BoardSearchDto boardSearchDto, Pageable pageable);
    Page<BoardMainDto> getBoardMainPage(BoardSearchDto boardSearchDto, Pageable pageable);
}
