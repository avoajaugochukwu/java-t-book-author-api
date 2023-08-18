package com.ugo.bookstore.author.helpers;

import com.ugo.bookstore.book.helpers.BookNoAuthorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorNoBookDto {
    private Long id;
    private String name;
    List<BookNoAuthorDto> books;
}
