package com.ugo.bookstore.author;

import com.ugo.bookstore.author.helpers.AuthorNoBookDto;
import com.ugo.bookstore.author.helpers.AuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping()
    public Page<AuthorNoBookDto> getAllAuthors(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable) {
        return authorService.getAll(pageable);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody AuthorRequest authorRequest) {
        authorService.create(authorRequest);
    }
}
