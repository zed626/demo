package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;

@Controller
public class HelloController {  

	@ResponseBody
    @RequestMapping(value="/hello", method=RequestMethod.GET)  
    public String Hello() {  
        return "Hello Spring Boot!你好a";  
    }
    
    @RequestMapping(value="/index", method=RequestMethod.GET)  
    public String index(Model model) {
    	model.addAttribute("username","疯狂软件");
    	List<Book> books=new ArrayList<>();
    	books.add(new Book(1, "Spring", "fefef"));
    	books.add(new Book(1, "Spring", "fefef"));
    	books.add(new Book(1, "Spring", "fefef"));
    	model.addAttribute("books",books);
    	return "index";
    }

} 