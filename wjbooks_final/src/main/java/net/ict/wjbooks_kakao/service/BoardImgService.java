//package net.ict.wjbooks_kakao.service;
//
//import lombok.RequiredArgsConstructor;
//import net.ict.wjbooks_kakao.domain.BoardImg;
//import net.ict.wjbooks_kakao.repository.BoardImgRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//import org.thymeleaf.util.StringUtils;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class BoardImgService {
//    @Value("${boardImgLocation}")
//    private String boardImgLocation;
//
//    private final BoardImgRepository boardImgRepository;
//
//    private final FileService fileService;

//
//    public void saveBoardImg(BoardImg boardImg, MultipartFile boardImgFile) throws Exception{
//        String oriImgName = boardImgFile.getOriginalFilename();
//        String imgName="";
//        String imgUrl="";
//
//        if(!StringUtils.isEmpty(oriImgName)){
//            imgName = fileService.uploadFile(boardImgLocation, oriImgName, boardImgFile.getBytes());
//            imgUrl="/images/item"+imgName;
//        }
//        boardImg.updateBoardImg(oriImgName,imgName,imgUrl);
//        boardImgRepository.save(boardImg);
//    }
//}
