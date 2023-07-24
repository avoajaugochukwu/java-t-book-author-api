package com.ugo.bookstore.author.helpers;

import com.ugo.bookstore.author.Author;
import com.ugo.bookstore.book.helpers.BookNoAuthorDto;
import com.ugo.bookstore.book.helpers.BookNoAuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorNoBookMapper implements Function<Author, AuthorNoBookDto> {
    private final BookNoAuthorMapper bookNoAuthorMapper;
    @Override
    public AuthorNoBookDto apply(Author author) {
        List<BookNoAuthorDto> bookNoAuthorDtoList = author
                .getBooks()
                .stream()
                .map(bookNoAuthorMapper)
                .collect(Collectors.toList());

        return AuthorNoBookDto.builder()
                .id(author.getId())
                .name(author.getName())
                .books(bookNoAuthorDtoList)
                .build();
    }
}

