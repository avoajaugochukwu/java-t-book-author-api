package com.ugo.bookstore.book.helpers;

import com.ugo.bookstore.author.helpers.AuthorNoBookMapper;
import com.ugo.bookstore.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class BookMapper implements Function<Book, BookDto> {
    private final AuthorNoBookMapper authorNoBookMapper;

    @Override
    public BookDto apply(Book book) {

        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .build();
    }
}
