package com.ugo.bookstore.book;

import com.ugo.bookstore.book.helpers.BookDto;
import com.ugo.bookstore.book.helpers.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping()
    public Page<BookDto> getAllBooks(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ) {
         return bookService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookRequest bookRequest) {
        bookService.create(bookRequest);
    }
}
