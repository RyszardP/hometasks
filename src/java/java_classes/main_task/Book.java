package java_classes.main_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book {

    /*5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
    Создать массив объектов. Вывести:
    a) список книг заданного автора;
    b)   список книг, выпущенных заданным издательством;
    c)   список книг, выпущенных после заданного года.*/


    private long id;
    private String name;
    private String[] authors;
    private String publisher;
    private int publicationYear;
    private int numOfPages;
    private double price;
    private String coverType;

    public Book() {
    }

    public Book(String name, String[] authors, String publisher, int publicationYear, int numOfPages,
                double price, String coverType) {

        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.numOfPages = numOfPages;
        this.price = price;
        this.coverType = coverType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", Id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", coverType='" + coverType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (publicationYear != book.publicationYear) return false;
        if (numOfPages != book.numOfPages) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(authors, book.authors)) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        return coverType != null ? coverType.equals(book.coverType) : book.coverType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + publicationYear;
        result = 31 * result + numOfPages;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (coverType != null ? coverType.hashCode() : 0);
        return result;
    }
}
