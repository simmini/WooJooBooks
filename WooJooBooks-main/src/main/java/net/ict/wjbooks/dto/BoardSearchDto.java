package net.ict.wjbooks.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchDto {
    private Boolean sellStatus;
    private String searchBy;
    private String searchQuery = "";
}
