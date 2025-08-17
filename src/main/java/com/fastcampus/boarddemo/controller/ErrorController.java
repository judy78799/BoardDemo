package com.fastcampus.boarddemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("error", ex.toString());  // 예외 메시지
        model.addAttribute("stacktrace", Arrays.toString(ex.getStackTrace()));  // 스택 트레이스
        return "error"; // templates/error/custom-error.html
    }
}
