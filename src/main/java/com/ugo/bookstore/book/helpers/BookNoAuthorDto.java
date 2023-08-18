package com.ugo.bookstore.book.helpers;

import com.ugo.bookstore.author.helpers.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookNoAuthorDto {
    private Long id;
    private String title;
    private String author;
    private Double price;
}
