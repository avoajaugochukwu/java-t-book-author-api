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
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
//                .author(authorNoBookMapper.apply(book.getAuthor()))
                .build();

        return bookDto;
    }
}
