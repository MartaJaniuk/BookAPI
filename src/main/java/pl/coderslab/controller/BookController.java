package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController //kontroller, i RespBody jednocześnie
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public String helloBook() {
        return "Jest ok"; //new Book(4L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable Long id) {
        return Optional.ofNullable(bookService.getBookById(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){  //@RequestBody - dzięki temu atrybuty z żądania dostaną automatycznie dopasowane do atrybutów obiektu
        bookService.add(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }


}
