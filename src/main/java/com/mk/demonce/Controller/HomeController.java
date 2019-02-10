package com.mk.demonce.Controller;


import com.mk.demonce.model.Book;
import com.mk.demonce.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;

@GetMapping
public String getIndex(Model model){
    model.addAttribute("books",bookRepository.findAll());
    model.addAttribute("newbook", new Book());
            return "index";
}
@PostMapping
    public String createBook(Book book){
    bookRepository.save(book);
    return "redirect:/";
}



}
