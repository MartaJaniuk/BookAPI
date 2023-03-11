package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void add(Book book);

    void delete(Long id);

}
