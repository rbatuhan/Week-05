import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NoteBook extends Product{
    private int ram;
    private int storage;
    private double screenSize;

    public NoteBook(int id, String name, double price, int discount, int stock, String brand, int storage, double screenSize, int ram) {
        super(id, name, price, discount, stock, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }


    public int getRam() {return ram;}

    public void setRam(int ram) {this.ram = ram;
    }

    public int getStorage() {return storage;}

    public void setStorage(int storage) {this.storage = storage;}

    public double getScreenSize() {return screenSize;}

    public void setScreenSize(double screenSize) {this.screenSize = screenSize;}


    public static void listNoteBookMenu() {
        notebooks();

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            try {
                System.out.println("1 - Notebook Listele");
                System.out.println("2 - Notebook Ekle");
                System.out.println("3 - Notebook Sil");
                System.out.println("4 - Markaya Göre Listele");
                System.out.println("5 - ID'ye Göre Telefon Listele");
                System.out.println("0 - Önceki Menü ");
                System.out.print("Tercihiniz: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        listNoteBooks();
                        break;
                    case 2:
                        addNoteBook(notebooks);
                        break;
                    case 3:
                        deleteNoteBook(notebooks);
                        break;
                    case 4:
                        listNoteBooksByBrand("brand");
                        break;
                    case 5:
                        listNoteBooksById(0);
                        break;
                    case 0:
                        System.out.println("Önceki menüye dönülüyor...");
                        break;
                    default:
                        System.out.println("Yanlış bir işlem seçtiniz!");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                input.nextLine();
                choice = -1;
            }

        } while (choice != 0);

    }

    static ArrayList<NoteBook> notebooks = new ArrayList<>();
    public static void notebooks() {

        notebooks.add(new NoteBook(1, "HUAWEI Matebook 14 ", 7000, 10, 50, "Huawei", 512, 14, 16));
        notebooks.add(new NoteBook(2, "LENOVO V14 IGL", 3699, 10, 50, "Lenovo", 1024, 14, 8));
        notebooks.add(new NoteBook(3, "ASUS Tuf Gaming", 8199, 10, 50, "Asus", 2048, 15.6, 32));

    }

    public static void listNoteBooks() {
        System.out.println(" \nNotebook Listesi\n ");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (NoteBook notebook : notebooks){
            System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d |\n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());

        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public static void addNoteBook(ArrayList<NoteBook> notebooks) {

        Scanner input = new Scanner(System.in);
        ArrayList<NoteBook> newNoteBooks = new ArrayList<>();

        try {
            System.out.print("Bir ID giriniz: ");
            int id = input.nextInt();
            input.nextLine();

            boolean isIdFound = false;
            for (NoteBook notebook : notebooks) {
                if (notebook.getId() == id) {
                    isIdFound = true;
                    break;
                }
            }
            if (isIdFound) {
                System.out.println("Bu id ile kayıtlı bir notebook bulunmaktadır.");
            } else {

                System.out.print("Eklemek istediğiniz Notebook ismini giriniz: ");
                String name = input.nextLine();

                System.out.print("Eklemek istediğiniz Notebook fiyatını giriniz: ");
                double price = input.nextDouble();

                System.out.print("Eklemek istediğiniz Notebook markasını giriniz: ");
                String brand;
                do {
                    brand = input.next();
                    brand = brand.substring(0, 1).toUpperCase() + brand.substring(1).toLowerCase();

                    if (Brand.isValidBrand(brand)) {
                        System.out.println("Marka başarıyla eklendi !");
                    }else {
                        System.out.println("Marka yanlış girildi. Lütfen listedeki bir markayı seçiniz:");
                        Brand.listBrands();
                    }
                } while (!Brand.isValidBrand(brand));

                System.out.print("Eklemek istediğiniz Notebook depolama miktarını giriniz: ");
                int storage = input.nextInt();

                System.out.print("Eklemek istediğiniz Notebook ekran boyutunu giriniz: ");
                double screenSize = input.nextDouble();

                System.out.print("Eklemek istediğiniz Notebook RAM miktarını giriniz: ");
                int ram = input.nextInt();

                int discount = 10;
                int stock = 50;

                newNoteBooks.add(new NoteBook(id, name, price, discount, stock, brand, storage, screenSize, ram));
                notebooks.addAll(newNoteBooks);
                System.out.println("Notebook Eklendi !");
                listNoteBooks();

            }
        }catch(InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("Hatalı giriş yaptınız. Lütfen doğru türde tekrar deneyiniz.");
            input.nextLine();
        }
    }


    public static void deleteNoteBook(ArrayList<NoteBook> notebooks) {
        Scanner input = new Scanner(System.in);
        System.out.print("Silmek istediğiniz notebook id'sini giriniz: ");
        int id = input.nextInt();

        ArrayList<Integer> removeNoteBook = new ArrayList<>();
        for (int i = 0; i < notebooks.size(); i++) {
            if (notebooks.get(i).getId() == id) {
                removeNoteBook.add(i);
                break;
            }
        }
        if (!removeNoteBook.isEmpty()) {
            for (int i : removeNoteBook) {
                notebooks.remove(i);
            }
            System.out.println("Notebook silindi !");
            listNoteBooks();
        } else {
            System.out.println("Bu id ile kayıtlı bir notebook bulunmamaktadır.");
        }
    }

    public static void listNoteBooksByBrand(String brand) {
        System.out.print("Marka giriniz: ");
        Scanner input = new Scanner(System.in);
        brand = input.nextLine();

        boolean isBrandFound = false;

        for (NoteBook notebook : notebooks) {
            if (notebook.getBrand().equalsIgnoreCase(brand)) {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
        }
        if (!isBrandFound) {
            System.out.println("Bu markaya ait notebook bulunmamaktadır.");
        }
    }


    public static void listNoteBooksById(int id) {
        System.out.print("ID giriniz: ");
        Scanner input = new Scanner(System.in);
        id = input.nextInt();

        boolean isIdFound = false;
        for (NoteBook notebook : notebooks) {
            if (notebook.getId() == id) {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
        }
        if (!isIdFound) {
            System.out.println("Bu id ile kayıtlı bir notebook bulunmamaktadır.");
        }
    }

}