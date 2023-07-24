package com.ugo.bookstore.book.helpers;

import com.ugo.bookstore.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class BookNoAuthorMapper implements Function<Book, BookNoAuthorDto> {
    @Override
    public BookNoAuthorDto apply(Book book) {
        BookNoAuthorDto bookNoAuthorMapper = BookNoAuthorDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .build();

        return bookNoAuthorMapper;
    }
}