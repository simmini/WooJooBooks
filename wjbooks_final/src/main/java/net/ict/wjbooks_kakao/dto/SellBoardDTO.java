package net.ict.wjbooks_kakao.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellBoardDTO {
    private Long id;
    private String title;
    private Integer sellPrice;
    private String sellContent;
    private String sellCondition;
    private String sellStatus;
    private String bookTitle;
    private String bookPublisher;
    private Integer bookPrice;
    private String bookWriter;
    private String bookDate;
    private List<String> fileNames;
}
