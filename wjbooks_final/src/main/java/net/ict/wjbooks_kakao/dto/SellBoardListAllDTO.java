package net.ict.wjbooks_kakao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ict.wjbooks_kakao.domain.BaseTimeEntity;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellBoardListAllDTO extends BaseTimeEntity {

    private Long id;
    private Integer sellPrice;

    private String sellTitle;

    private String sellWriter;
    private String sellCondition;
    private String sellContent;

    private List<SellBoardImageDTO> sellBoardImageDto;
}
