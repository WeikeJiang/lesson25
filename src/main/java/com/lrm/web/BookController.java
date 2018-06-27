package com.lrm.web;

import com.lrm.domain.Book;
import com.lrm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by limi on 2017/8/14.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获取书单列表
     * @param model
     * @return
     */
    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    /**
     * 获取书单详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {

        Book book = bookService.findOne(id);
        if (book == null ) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

    /**
     * 跳转input提交页面
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * 跳转到更新页面input
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    /**
     * 提交一个书单信息
     * @param book
     * @return
     */
    @PostMapping("/books")
    public String post(Book book) {
        bookService.save(book);
        return "redirect:/books";
    }
}
