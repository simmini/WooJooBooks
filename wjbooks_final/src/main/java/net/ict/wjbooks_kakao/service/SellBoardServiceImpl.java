package net.ict.wjbooks_kakao.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.wjbooks_kakao.domain.Board;
import net.ict.wjbooks_kakao.domain.SellBoard;
import net.ict.wjbooks_kakao.dto.*;
import net.ict.wjbooks_kakao.repository.SellBoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class SellBoardServiceImpl implements SellBoardService{
    private final ModelMapper modelMapper;

    private final SellBoardRepository sellBoardRepository;

    @Override
    public Long register( SellBoardDTO boardFormDto){
        SellBoard board = modelMapper.map(boardFormDto, SellBoard.class);
        board.clearImages();
        if(boardFormDto.getFileNames() != null){
            for (String fileName : boardFormDto.getFileNames()) {
                String[] arr = fileName.split("_");
                board.addImage(arr[0], arr[1]);
            }
        }
        Long id = sellBoardRepository.save(board).getId();
        log.info(id);
        return id;
    }

    @Override
    public SellBoardDTO readOne(Long id) {
        Optional<SellBoard> result = sellBoardRepository.findByIdWithImages(id);
        SellBoard board = result.orElseThrow();
        SellBoardDTO boardDTO = entityToDTO(board);
        return boardDTO;
    }

    @Override
    public void modify(SellBoardDTO boardDTO) {
        Optional<SellBoard> result = sellBoardRepository.findById(boardDTO.getId());

        SellBoard board = result.orElseThrow();

        board.change(
                boardDTO.getTitle(),
                boardDTO.getBookTitle(),
                boardDTO.getBookPrice(),
                boardDTO.getSellPrice(),
                boardDTO.getBookDate(),
                boardDTO.getSellCondition(),
                boardDTO.getSellContent(),
                boardDTO.getBookWriter(),
                boardDTO.getBookPublisher()
        );

        //첨부파일의 처리
        board.clearImages();

        if(boardDTO.getFileNames() != null){
            for (String fileName : boardDTO.getFileNames()) {
                String[] arr = fileName.split("_");
                board.addImage(arr[0], arr[1]);
            }
        }

        sellBoardRepository.save(board);
    }


    @Override
    public void remove(Long id) {
        sellBoardRepository.deleteById(id);
    }

    @Override
    public PageResponseDTO<SellBoardFormDTO> list(PageRequestDTO pageRequestDto){
        String[] types = pageRequestDto.getTypes();
        String keyword = pageRequestDto.getKeyword();
        Pageable pageable = pageRequestDto.getPageable("id");
        //오류?? SellBoard가 안되서 일단 Board
     Page<SellBoard> result = sellBoardRepository.searchAll(types, keyword, pageable);

        List<SellBoardFormDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board, SellBoardFormDTO.class)).collect(Collectors.toList());


        return PageResponseDTO.<SellBoardFormDTO>withAll()
                .pageRequestDTO(pageRequestDto)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

    @Override
    public PageResponseDTO<SellBoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("id");

        Page<SellBoardListReplyCountDTO> result = sellBoardRepository.searchWithReplyCount(types, keyword, pageable);

        return PageResponseDTO.<SellBoardListReplyCountDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(result.getContent())
                .total((int)result.getTotalElements())
                .build();
    }

    @Override
    public PageResponseDTO<SellBoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("id");

        Page<SellBoardListAllDTO> result = sellBoardRepository.searchWithAll(types, keyword, pageable);

        return PageResponseDTO.<SellBoardListAllDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(result.getContent())
                .total((int) result.getTotalElements())
                .build();
    }
}
