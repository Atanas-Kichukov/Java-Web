package bg.softuni.books.service;


import bg.softuni.books.model.dto.BookDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAllBooks();

    Optional<BookDto> getBookById(long id);

    void deleteBook(long id);

    long createBook(BookDto bookDto);

    Page<BookDto> getBooks(int pageNo,int pageSize,String sortBy);
}
