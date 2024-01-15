import java.util.Scanner;
import java.util.InputMismatchException;

public class PatikaStore {
    public static void printMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("PatikaStore Ürün Yönetim Paneli !");
                System.out.println("1 - Notebook İşlemleri");
                System.out.println("2 - Cep Telefonu İşlemleri");
                System.out.println("3 - Marka Listele");
                System.out.println("0 - Çıkış Yap");
                System.out.print("Tercihiniz: ");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        NoteBook.listNoteBookMenu();
                        break;
                    case 2:
                        Phone.listPhoneMenu();
                        break;
                    case 3:
                        Brand.listBrands();
                        break;
                    case 0:
                        System.out.println("Çıkış yaptınız.");
                        break;
                    default:
                        System.out.println("Yanlış bir işlem seçtiniz!");
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Hatalı giriş yaptınız. Lütfen doğru türde tekrar deneyiniz.");
                input.nextLine();
                choice = -1;
            }

        } while (choice != 0);

    }
}