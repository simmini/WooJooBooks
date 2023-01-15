package net.ict.wjbooks_kakao.service;


import net.ict.wjbooks_kakao.dto.PageRequestDTO;
import net.ict.wjbooks_kakao.dto.PageResponseDTO;
import net.ict.wjbooks_kakao.dto.ReplyDTO;

public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);

}
