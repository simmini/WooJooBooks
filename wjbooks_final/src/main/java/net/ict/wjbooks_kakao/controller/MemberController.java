package net.ict.wjbooks_kakao.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.wjbooks_kakao.dto.MemberFormDto;
import net.ict.wjbooks_kakao.dto.PageRequestDTO;
import net.ict.wjbooks_kakao.service.MemberService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/login" )
    public void loginGet(PageRequestDTO pageRequestDTO){

    }

    @PostMapping(value = "/login")
    public String loginPost(){

        return "/sellboard/main";
    }

    @GetMapping(value ="login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디또는 비밀번호를 확인해주세요");
        return "/member/login";
    }


    @GetMapping("/new")
    public String newMemberGet(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String newMemberPost(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model,RedirectAttributes ra)  {
        log.info("memberPost");

        if(bindingResult.hasErrors()) {
            log.info("bindingResult Error..");
            ra.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "member/memberForm";
        }
        try {
            memberService.join(memberFormDto);
        }catch(IllegalStateException e) {
            model.addAttribute("errorMessage",e.getMessage());//이메일 중복되면 생기는 에러
            return "member/memberForm";
        }
        return "redirect:/";
    }

    @PostMapping("/modify")
    public String updateMemberPost(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Principal principal){
//        log.info("binding : " +bindingResult);
        String mempass=memberFormDto.getMemPass();

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "member/modify";
        }
        memberService.modify(memberFormDto);

//        Authentication princi = new UsernamePasswordAuthenticationToken(memberFormDto.getMemEmail(),mempass);
//        SecurityContextHolder.getContext().setAuthentication(princi);

        return "redirect:/member/read";
    }


    @GetMapping(value = "/modify")
    public String modify(PageRequestDTO pageRequestDTO, Model model,Principal principal){

        String email=principal.getName();
        log.info(email);

        MemberFormDto memberFormDto=memberService.read(email);
        //
        log.info(memberFormDto.toString());
        model.addAttribute("memberFormDto",memberFormDto);

        return "member/modify";
    }

    @GetMapping(value = "/read")
    public void readGet(PageRequestDTO pageRequestDTO, Model model, Principal principal){
        String email = principal.getName();
        MemberFormDto memberFormDto=memberService.read(email);
//        Authentication princi = new UsernamePasswordAuthenticationToken(memberFormDto, memberFormDto.getMemEmail());
//        SecurityContextHolder.getContext().setAuthentication(princi);
        model.addAttribute("memberFormDto",memberFormDto);
    }

    @GetMapping(value = "/delete")
    public String deleteGet(PageRequestDTO pageRequestDTO, Principal principal,RedirectAttributes redirectAttributes){
        log.info("get...");

        String email=principal.getName();

        memberService.remove(email);
        return "redirect:/";
    }





}


