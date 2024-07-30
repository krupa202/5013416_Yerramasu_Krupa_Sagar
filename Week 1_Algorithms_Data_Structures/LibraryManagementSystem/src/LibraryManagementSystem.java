import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Book{
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
public class LibraryManagementSystem {
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter bookId:");
            String bookId = sc.nextLine();
            System.out.println("Enter title:");
            String title = sc.nextLine();
            System.out.println("Enter author:");
            String author = sc.nextLine();
            books[i] = new Book(bookId, title, author);
        }

        System.out.println("Linear Search:");
        System.out.println("Enter title:");
        String searchTitle = sc.nextLine();
        Book foundBook = linearSearch(books, searchTitle);
        System.out.println("Found: " + (foundBook != null ? foundBook.getAuthor() : "null"));

        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        
        System.out.println("Binary Search:");
        System.out.println("Enter title:");
        searchTitle = sc.nextLine();
        foundBook = binarySearch(books, searchTitle);
        System.out.println("Found: " + (foundBook != null ? foundBook.getAuthor() : "null"));

        sc.close(); // Close the scanner
    }
}
