package com.ugo.bookstore.book;

import com.ugo.bookstore.author.Author;
import com.ugo.bookstore.author.helpers.AuthorDto;
import com.ugo.bookstore.book.helpers.BookDto;
import com.ugo.bookstore.book.helpers.BookNoAuthorDto;
import com.ugo.bookstore.book.helpers.BookNoAuthorMapper;
import com.ugo.bookstore.book.helpers.BookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookNoAuthorMapper bookNoAuthorMapper;

    public void create(BookRequest bookRequest) {
        Author author = Author.builder()
                .id(bookRequest.getAuthor())
                .build();

        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .author(author)
                .build();

        bookRepository.save(book);
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor().getName())
                .price(book.getPrice())
                .build();
    }

    public Page<BookNoAuthorDto> getAll(Pageable pageable) {
        Page<Book> books =  bookRepository.findAll(pageable);
        log.info("Books: {}", books.map(bookNoAuthorMapper));
        return books.map(bookNoAuthorMapper);
    }

    public AuthorDto toAuthorDto(Book book) {
        return AuthorDto.builder()
                .id(book.getAuthor().getId())
                .name(book.getAuthor().getName())
                .build();
    }
}
