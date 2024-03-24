package bg.softuni.books.service.Impl;

import bg.softuni.books.model.dto.AuthorDto;
import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
         return bookRepository.findAll()
                .stream()
                .map(this::asBook)
                 .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> getBookById(long id) {
        return bookRepository.findById(id)
                .map(this::asBook);
    }

    @Override
    public void deleteBook(long id) {
    bookRepository.deleteById(id);
    }

    @Override
    public long createBook(BookDto bookDto) {
        AuthorEntity author = authorRepository
                .findByName(bookDto.getAuthor().getName())
                .orElseGet( () -> new AuthorEntity().setName(bookDto.getAuthor().getName()));

        authorRepository.save(author);

        BookEntity newBook = new BookEntity()
                .setAuthor(author)
                .setIsbn(bookDto.getIsbn())
                .setTitle(bookDto.getTitle());
        return bookRepository.save(newBook).getId();
    }

    @Override
    public Page<BookDto> getBooks(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        return bookRepository.findAll(pageable)
                .map(this::asBook);

    }

    private  BookDto asBook(BookEntity book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        AuthorDto authorDto = modelMapper.map(book.getAuthor(), AuthorDto.class);
        bookDto.setAuthor(authorDto);
        return bookDto;
    }
}
