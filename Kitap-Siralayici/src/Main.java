import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Denizler Altında 20.000 Fersah", 120);
        Book book2 = new Book("Suç ve Ceza", 687);
        Book book3 = new Book("Şeker Portakalı", 200);
        Book book4 = new Book("Kızıl Veba", 72);
        Book book5 = new Book("Fareler ve İnsanlar", 111);


        Set<Book> nameSorting = new TreeSet<>();
        nameSorting.add(book1);
        nameSorting.add(book2);
        nameSorting.add(book3);
        nameSorting.add(book4);
        nameSorting.add(book5);

        System.out.println("\n >>>İsme Göre Sıralama<<<");
        for (Book book : nameSorting) {
            System.out.println(book);
        }

        Comparator<Book> pageCountComparator = Comparator.comparingInt(Book::getPageCount);

        Set<Book> pageCountSorting = new TreeSet<>(pageCountComparator);
        pageCountSorting.addAll(nameSorting);

        System.out.println("\n >>>Sayfa Sayısına Göre Sıralama<<<");
        for (Book book : pageCountSorting) {
            System.out.println(book);
        }
    }
}