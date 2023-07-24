package com.ugo.bookstore.author.helpers;

import com.ugo.bookstore.author.Author;
import com.ugo.bookstore.book.helpers.BookDto;
import com.ugo.bookstore.book.helpers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorMapper implements Function<Author, AuthorDto> {
    private final BookMapper bookMapper;

    @Override
    public AuthorDto apply(Author author) {
        List<BookDto> booksDto = author.getBooks().stream().map(bookMapper).collect(Collectors.toList());

        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .books(booksDto)
                .build();
    }
}

