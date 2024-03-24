package bg.softuni.books.web;


import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){

        List<BookDto> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);

    }
    @GetMapping("/pageable")
    public ResponseEntity<Page<BookDto>> getBooks(@RequestParam( name = "pageNo",defaultValue = "0") Integer pageNo,
                                                     @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize,
                                                     @RequestParam(name = "sortBy",defaultValue = "id") String sortBy){
       return ResponseEntity.ok(bookService.getBooks(pageNo,pageSize,sortBy));
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id){
        Optional <BookDto> book = bookService.getBookById(id);
        if(book.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(book.get());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable("id") Long id){
    bookService.deleteBook(id);

    return ResponseEntity.noContent().build();

    }

    @PutMapping()
    public ResponseEntity <BookDto> create (
            @RequestBody BookDto bookDto,// it takes some data and Spring needs to serialize it to the given Object
            UriComponentsBuilder builder){
        long bookId = bookService.createBook(bookDto);

        URI location = builder.path("/books/{id}")
                .buildAndExpand(bookId).toUri();

        return ResponseEntity.created(location).build();//in the brackets we give the url
    }




}
