package org.ruu.bootthymeleafjpa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ruu.bootthymeleafjpa.dto.board.BoardDTO;
import org.ruu.bootthymeleafjpa.dto.board.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Log4j2
@Tag(name = "BoardController")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    @Operation(summary = "리스트")
    public void list(
        PageRequestDTO pageRequestDTO,
        Model model) {

        log.info("List에 진입");
        //PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);
        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);

    }

    @GetMapping("/register")
    public String registerGet(){
        return "board/register";
    }

    @Operation(summary = "저장")
    @PostMapping("/register")
    public String registerPost(
        @Valid BoardDTO boardDTO,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

        log.info("board POST register......");
        if (bindingResult.hasErrors()) {
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);

        Long bno = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model){
        BoardDTO boardDTO = boardService.readOne(bno);

        log.info(boardDTO);
        model.addAttribute("dto",boardDTO);
    }
    @Operation(summary = "수정")
    @PostMapping("/modify")
    public String modify( PageRequestDTO pageRequestDTO,
        @Valid BoardDTO boardDTO,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes){

        log.info("modify ...." + boardDTO);
        if(bindingResult.hasErrors()){
            log.info("eroors....");

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("bno", boardDTO.getBno());

            return "redirect:/board/modify?"+ pageRequestDTO.getLink();

        }
        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("bno", boardDTO.getBno());

        return "redirect:/board/read";
    }
    @Operation(summary = "삭제")
    @PostMapping("/remove")
    public String remove(Long bno,
        RedirectAttributes redirectAttributes){
        log.info("delete....");
        boardService.remove(bno);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/board/list";
    }
}
