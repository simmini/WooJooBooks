package net.ict.wjbooks_kakao.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SellBoardImageDTO {

    private String uuid;

    private String fileName;

    private int ord;
}

