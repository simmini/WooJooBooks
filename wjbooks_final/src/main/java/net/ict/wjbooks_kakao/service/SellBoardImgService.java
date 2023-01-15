package net.ict.wjbooks_kakao.service;

import lombok.RequiredArgsConstructor;
import net.ict.wjbooks_kakao.domain.SellBoardImg;
import net.ict.wjbooks_kakao.repository.BoardImgRepository;
import net.ict.wjbooks_kakao.repository.SellBoardImgRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class SellBoardImgService {
    @Value("${boardImgLocation}")
    private String boardImgLocation;

    private final SellBoardImgRepository boardImgRepository;

    private final FileService fileService;


    public void saveBoardImg(SellBoardImg sellBoardImg, MultipartFile boardImgFile) throws Exception{
        String oriImgName = boardImgFile.getOriginalFilename();
        String imgName="";
        String imgUrl="";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(boardImgLocation, oriImgName, boardImgFile.getBytes());
            imgUrl="/images/item"+imgName;
        }
        sellBoardImg.updateBoardImg(oriImgName,imgName,imgUrl);
        boardImgRepository.save(sellBoardImg);
    }
}
