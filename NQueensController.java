package com.example.nqueens;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NQueensController {

    @GetMapping("/nqueens")
    public String index() {
        return "index";
    }
}
