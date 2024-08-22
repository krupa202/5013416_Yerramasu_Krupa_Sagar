package com.example.bookstoreapi;
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

    // GET all books or filter by title and/or author using query parameters
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

        return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
    }

    // GET a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.setId((long) (books.size() + 1));  // Simple ID assignment
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // PUT to update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>("Book with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
