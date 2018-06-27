package com.lrm.web;

import com.lrm.domain.Book;
import com.lrm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by limi on 2017/8/14.
 */
@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookService;

    /**
     * 获取读书清单列表
     * @return
     */
    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.findAll();
    }

    /**
     * 新增一个书单
     * @return
     */
    @PostMapping("/books")
    public Book post(Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);

        return bookService.save(book);
    }


    /**
     * 获取一条书单
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    /**
     * 更新一个书单
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.save(book);
    }

    /**
     * 删除一个书单
     * @param id
     */
    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {

        bookService.delete(id);
    }


    @PostMapping("/books/by")
    public int findBy(@RequestParam long id,@RequestParam int status,@RequestParam long uid) {
//        return bookService.findByAuthor(author);
//        return bookService.findByAuthorAndStatus(author, status);
        //return bookService.findByDescriptionEndsWith(description);

        //return bookService.findByJPQL(len);

//        return bookService.updateByJPQL(status, id);
//        return bookService.deleteByJPQL(id);
        return bookService.deleteAndUpdate(id, status, uid);
    }

}
