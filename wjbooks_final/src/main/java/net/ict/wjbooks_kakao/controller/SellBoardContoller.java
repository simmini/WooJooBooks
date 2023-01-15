package net.ict.wjbooks_kakao.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import net.ict.wjbooks_kakao.dto.*;
import net.ict.wjbooks_kakao.service.SellBoardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Controller
@RequestMapping("/sellboard")
@Log4j2
@RequiredArgsConstructor
public class SellBoardContoller {
    @Value("${net.ict.upload.path}")// import 시에 springframework으로 시작하는 Value
    private String uploadPath;

    private final SellBoardService sellBoardService;


    @PreAuthorize("permitAll()")
    @GetMapping("/main")
    public void main(PageRequestDTO pageRequestDTO, Model model){

        //PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        PageResponseDTO<SellBoardListAllDTO> responseDTO =
                sellBoardService.listWithAll(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @PreAuthorize("permitAll()") //전체허용
    @GetMapping("/list")
    public void sellList(PageRequestDTO pageRequestDTO, Model model){

        //PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        PageResponseDTO<SellBoardListAllDTO> responseDTO =
                sellBoardService.listWithAll(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/register")
    public void sellRegisterGET(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<SellBoardListAllDTO> responseDTO =
                sellBoardService.listWithAll(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @PostMapping("/register")
    public String sellRegisterPost(@Valid SellBoardDTO sellBoardDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("sellboard POST register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/sellboard/register";
        }

        log.info(sellBoardDto);

        Long id  = sellBoardService.register(sellBoardDto);

        redirectAttributes.addFlashAttribute("result", id);

        return "redirect:/sellboard/list";
    }

    //    @PreAuthorize("isAuthenticated()")//로그인한 사용자만 글을 조회할 수 있도록 접근 권한(제한) 주기
    @GetMapping({"/read", "/modify"})
    public void sellRead(Long id, PageRequestDTO pageRequestDTO, Model model){

        SellBoardDTO sellBoardDto= sellBoardService.readOne(id);

        log.info(sellBoardDto);

        model.addAttribute("dto", sellBoardDto);

    }

    @PostMapping("/modify")
    public String sellModify( @Valid SellBoardDTO sellBoardDto,
                          BindingResult bindingResult,
                          PageRequestDTO pageRequestDTO,
                          RedirectAttributes redirectAttributes){

        log.info("board modify post......." + sellBoardDto);

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            log.info(bindingResult.getAllErrors());

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );

            redirectAttributes.addAttribute("id", sellBoardDto.getId());

            return "redirect:/sellboard/modify?"+link;
        }

       sellBoardService.modify(sellBoardDto);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("id", sellBoardDto.getId());

        return "redirect:/sellboard/read";
    }

    @PostMapping("/remove")
    public String remove(SellBoardDTO boardDTO, RedirectAttributes redirectAttributes) {

        Long id  = boardDTO.getId();
        log.info("remove post.. " + id);

        sellBoardService.remove(id);

        //게시물이 삭제되었다면 첨부 파일 삭제
        log.info(boardDTO.getFileNames());
        List<String> fileNames = boardDTO.getFileNames();
        if(fileNames != null && fileNames.size() > 0){
            removeFiles(fileNames);
        }

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/sellboard/list";

    }
    public void removeFiles(List<String> files){

        for (String fileName:files) {

            Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
            String resourceName = resource.getFilename();


            try {
                String contentType = Files.probeContentType(resource.getFile().toPath());
                resource.getFile().delete();

                //섬네일이 존재한다면
                if (contentType.startsWith("image")) {
                    File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);
                    thumbnailFile.delete();
                }

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }//end for
    }



}
