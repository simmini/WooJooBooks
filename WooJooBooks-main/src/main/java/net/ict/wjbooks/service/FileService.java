package net.ict.wjbooks.service;

import lombok.RequiredArgsConstructor;
import net.ict.wjbooks.domain.File;
import net.ict.wjbooks.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class FileService {
    @Value("${itemImgLocation}")
    private String itemImgLocation;

    private final FileRepository fileRepository;

    private final FIleUploadService fIleUploadService;

    public void saveFile(File file, MultipartFile itemImgFile) throws Exception{
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName="";
        String imgUrl="";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName=fIleUploadService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl="/images/item"+imgName;
        }
        file.uploadFileImg(oriImgName,imgName,imgUrl);
        fileRepository.save(file);
    }
}
