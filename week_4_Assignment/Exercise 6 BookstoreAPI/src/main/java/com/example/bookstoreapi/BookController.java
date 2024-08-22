package com.example.bookstoreapi;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String author) {

        List<Book> filteredBooks = books;

        if (title != null) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        }

        if (author != null) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "HeaderValue");

        return new ResponseEntity<>(filteredBooks, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (book != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "HeaderValue");
            return new ResponseEntity<>(book, headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found.");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.setId((long) (books.size() + 1));  // Simple ID assignment
        books.add(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "HeaderValue");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "HeaderValue");

            return new ResponseEntity<>(book, headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "HeaderValue");

            return new ResponseEntity<>("Book with ID " + id + " has been deleted.", headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found.");
        }
    }
}