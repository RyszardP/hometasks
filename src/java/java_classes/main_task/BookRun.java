package java_classes.main_task;

public class BookRun {
    public static void main(String[] args) {

        new BookList();

        String[] AuthorFSFitzgerald = {"Francis Scott Key Fitzgerald"};
        String[] AuthorHemingway = {"Ernest Miller Hemingway"};
        String[] AuthorFaulkner = {"William Cuthbert Faulkner"};
        String[] AuthorTwain = {"Mark Twain"};

        Book bookParadise = new Book("This Side of Paradise", AuthorFSFitzgerald, "Signet",
                1920, 288, 17.01, "paperback");
        Book bookButton = new Book("The Curious Case of Benjamin Button", AuthorFSFitzgerald, "Signet",
                1921, 375, 9.94, "hardcover");
        Book bookBandD = new Book("The Beautiful and Damned", AuthorFSFitzgerald,
                "Independently published", 1992, 222, 12.18, "hardcover");
        Book bookGatsby = new Book("The Great Gatsby", AuthorFSFitzgerald, "Scribner Book Company",
                1925, 180, 10.17, "paperback");
        Book bookBowl = new Book("For Whom the Bell Tolls", AuthorHemingway,
                "Scribner", 1940, 480, 16.99, "paperback");
        Book bookGildedAge = new Book("The Gilded Age: A Tale of Today", AuthorTwain,
                "Liveright", 1926, 320, 7.31, "paperback");
        Book bookSoldiersPay = new Book("Soldiers' Pay", AuthorFaulkner,
                "Penguin Classics", 1873, 512, 16.00, "paperback");

        Book[] books = {bookParadise, bookButton, bookBandD, bookGatsby, bookGildedAge, bookBowl, bookSoldiersPay};
        System.out.println("Book after year" + BookList.booksAfterYear(1922, books));
        System.out.println("Books by publisher" + BookList.booksByPublisher("Signet", books));
        System.out.println("Books by author " + BookList.booksByAuthor("Francis Scott Key Fitzgerald", books));

    }
}
