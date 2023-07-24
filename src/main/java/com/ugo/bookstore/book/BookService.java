package com.ugo.bookstore.book;

import com.ugo.bookstore.author.Author;
import com.ugo.bookstore.author.helpers.AuthorDto;
import com.ugo.bookstore.book.helpers.BookDto;
import com.ugo.bookstore.book.helpers.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void create(BookRequest bookRequest) {
        Author author = Author.builder()
                .id(bookRequest.getAuthor())
                .build();

        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .author(author)
                .build();

        bookRepository.save(book);
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(toAuthorDto(book))
                .build();
    }

    public Page<BookDto> getAll(Pageable pageable) {
        Page<Book> books =  bookRepository.findAll(pageable);
        return books.map(book -> BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(toAuthorDto(book))
                .build());
    }

    public AuthorDto toAuthorDto(Book book) {
        return AuthorDto.builder()
                .id(book.getAuthor().getId())
                .name(book.getAuthor().getName())
                .build();
    }
}
