package net.ict.wjbooks.service;

import lombok.RequiredArgsConstructor;
import net.ict.wjbooks.domain.Board;
import net.ict.wjbooks.domain.File;
import net.ict.wjbooks.dto.BoardFormDto;
import net.ict.wjbooks.repository.BoardRepository;
import net.ict.wjbooks.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final FileRepository fileRepository;
    private final BoardRepository boardRepository;
    private final FileService fileService;

    public Long saveItem(BoardFormDto boardFormDto, List<MultipartFile> itemImgFileList) throws Exception{
        Board board = boardFormDto.createBoard();
        boardRepository.save(board);

        for(int i = 0 ; i<itemImgFileList.size();i++){
            File file = new File();
            file.setBoard(board);

            if(i==0)
                file.setRepimgYn("Y");
            else
                file.setRepimgYn("N");

            fileService.saveFile(file, itemImgFileList.get(i));
        }
        return board.getId();
    }
}
