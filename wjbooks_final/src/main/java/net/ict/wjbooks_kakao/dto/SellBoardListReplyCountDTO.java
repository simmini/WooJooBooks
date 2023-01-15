package net.ict.wjbooks_kakao.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SellBoardListReplyCountDTO {

    private Long bno;

    private String title;

    private String writer;

    private LocalDateTime regDate;

    private Long replyCount;

}
