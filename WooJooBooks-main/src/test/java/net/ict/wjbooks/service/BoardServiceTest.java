package net.ict.wjbooks.service;

import net.ict.wjbooks.domain.Board;
import net.ict.wjbooks.domain.File;
import net.ict.wjbooks.dto.BoardFormDto;
import net.ict.wjbooks.repository.BoardRepository;
import net.ict.wjbooks.repository.FileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    FileRepository fileRepository;
    LocalDateTime localDateTime;
    List<MultipartFile> createMultipartFiles() throws Exception{
        List<MultipartFile> multipartFileList = new ArrayList<>();

        for (int i = 0 ; i<5;i++){
            String path = "C:/wjbooks/bookimg";
            String imageName = "image"+i+".jpg";
            MockMultipartFile multipartFile = new MockMultipartFile(path, imageName,"image/jpg", new byte[]{1,2,3,4});
            multipartFileList.add(multipartFile);
        }
        return multipartFileList;
    }
    @Test
    @DisplayName("상품 등록 테스트")
    @WithMockUser(username = "admin")
    void saveItem() throws Exception{
        BoardFormDto boardFormDto = new BoardFormDto();
        boardFormDto.setBookPrice("19000");
        boardFormDto.setBookPublisher("우주출판사");
        boardFormDto.setBookTile("테스트");
        boardFormDto.setSellTitle("테스트용판매글");

        List<MultipartFile> multipartFileList = createMultipartFiles();
        Long s_num = boardService.saveItem(boardFormDto, multipartFileList);
        List<File> itemImgList = fileRepository.findBys_numOrderByIdAsc(s_num);

        Board board = boardRepository.findById(s_num).orElseThrow(EntityNotFoundException::new);

        assertEquals(boardFormDto.getId(), board.getId());
    }
}