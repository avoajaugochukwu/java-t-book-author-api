package com.ugo.bookstore.author;

import com.ugo.bookstore.author.helpers.*;
import com.ugo.bookstore.book.helpers.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final AuthorNoBookMapper authorNoBookMapper;

    public void create(AuthorRequest authorRequest) {
        Author author = Author.builder()
                .name(authorRequest.getName())
                .build();

        authorRepository.save(author);
    }

    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .books(toBookDto(author))
                .build();
    }

    public Page<AuthorNoBookDto> getAll(Pageable pageable) {
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors.map(authorNoBookMapper);

//        return authors.map(author -> AuthorDto.builder()
//                .id(author.getId())
//                .name(author.getName())
//                .books(toBookDto(author))
//                .build());

    }

    public List<BookDto> toBookDto(Author author) {
        return author.getBooks().stream()
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
