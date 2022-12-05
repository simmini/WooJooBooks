package net.ict.wjbooks.dto;

import lombok.Getter;
import lombok.Setter;
import net.ict.wjbooks.domain.File;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class FileDto {
    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static FileDto of (File file){
        return modelMapper.map(file, FileDto.class);
    }
}
