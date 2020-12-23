package java_classes.main_task;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    /**
     *
     * @param author - given author
     * @param books  - list of books
     * @return result
     */
    public static List<Book> booksByAuthor(String author, Book[] books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            for (String authorBook : book.getAuthors()) {
                if (author.equals(authorBook)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param publisher - given publisher
     * @param books - list of books
     * @return bookList
     */
    public static List<Book> booksByPublisher(String publisher, Book[] books) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : books) {
            if (publisher.equals(book.getPublisher())) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    /**
     *
     * @param year - year of search
     * @param books - list of books
     * @return bookList
     */
    public static List<Book> booksAfterYear(int year, Book[] books) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : books) {
            if (year < book.getPublicationYear()) {
                bookList.add(book);
            }
        }
        return bookList;
    }
}
