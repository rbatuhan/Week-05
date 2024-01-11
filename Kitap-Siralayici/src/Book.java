import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String bookName;
    private int pageCount;

    public Book(String bookName, int pageCount) {
        this.bookName = bookName;
        this.pageCount = pageCount;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.bookName.compareTo(otherBook.bookName);
    }

    @Override
    public String toString() {
        return "Kitap İsmi => " + this.bookName + ", <Sayfa Sayısı> => " + this.pageCount;
    }
}