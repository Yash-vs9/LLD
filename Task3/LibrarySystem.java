package Task3;
import java.util.*;

class Book {
    private int id;
    private String title;
    private boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returned() { isIssued = false; }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title +   ", issued=" + isIssued + '}';
    }
}

class User {
    private int id;
    private String name;
    private List<Book> issuedBooks = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void issueBook(Book book) {
        if (!book.isIssued()) {
            book.issue();
            issuedBooks.add(book);
            System.out.println(name + " issued book: " + book.getTitle());
        } else {
            System.out.println("Book already issued: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        if (issuedBooks.contains(book)) {
            book.returned();
            issuedBooks.remove(book);
            System.out.println(name + " returned book: " + book.getTitle());
        } else {
            System.out.println(name + " doesn't have this book issued: " + book.getTitle());
        }
    }

    public void showIssuedBooks() {
        System.out.println("Books issued to " + name + ":");
        for (Book book : issuedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added to library: " + book.getTitle());
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void showAllBooks() {
        System.out.println("Library Book List:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();

    }
}