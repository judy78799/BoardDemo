package com.fastcampus.boarddemo.controller;

import com.fastcampus.boarddemo.dto.BookBoardDTO;
import com.fastcampus.boarddemo.entity.BookBoard;
import com.fastcampus.boarddemo.repository.BookRepository;
import com.fastcampus.boarddemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    /**
     * GET :
     * @param model
     * @return
     */
    @GetMapping("/board_list")
    public String board_get(Model model) {
        //책을 DB에서 읽어옴 리포지토리
        List<BookBoardDTO> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        //DB 디버깅
        System.out.println("bookList size: " + bookList.size());
        return "boardList";
    }

    /**
     * POST : DB 내부의 데이터베이스를 읽어오는 메서드
     * @param model
     * @return
     */
    @PostMapping("/board_list")
    public String board_post(Model model){
        //MySQL에 등록한 DB를 읽어오는 친구
        return "boardList";
    }

    /**
     * 버튼 클릭 시, 여기로 들어와서 화면 보여줌
     * @param model
     * @return
     */
    @GetMapping("/board_list/new")
    public String book_new(Model model){
        return "book_board_new";
    }

    /**
     * 사용자가 등록하기 버튼 클릭 -> 폼 내용 서버에 전달
     * @ModelAttribute는 사용자 폼 입력 값을 자바 객체에 자동 바인딩
     * @return
     */
    @PostMapping("/board_list/new")
    public String book_newPost( @ModelAttribute BookBoardDTO bookboardDTO){
        System.out.println("bookboardDTO ???= " + bookboardDTO);
        bookService.save(bookboardDTO);
        //사용자가 폼을 입력해서 POST 요청으로 보내면 해당 내용들을 DTO에 담아서
        // 서비스 로직을 통해 리포지토리로 메서드 처리해서 DB에 데이터 insert
        return "redirect:/board_list";
    }

    /**
     * 버튼이 눌렸다면 화면이 보임.
     * @return
     */
    @GetMapping("/board_list/edit")
    public String book_edit(Model model, @RequestParam("id") Long id){
        System.out.println("====수정 버튼눌림=====");
        BookBoardDTO bookboardDTOOne = bookService.findOneBookBoard(id);
        model.addAttribute("bookboardDTOOne", bookboardDTOOne);
        return "book_board_edit";
    }

    /**
     * 기존에 있는 id 하나 읽어와서 해당 정보 모두 가져온 후에,
     * 수정하면 해당 사항 반영.
     * @param model
     * @return
     */
    @PostMapping("/board_list/edit")
    public String book_edit_toServer(Model model, @ModelAttribute BookBoardDTO bookboardDTO){

        return "book_board_edit";
    }
}
