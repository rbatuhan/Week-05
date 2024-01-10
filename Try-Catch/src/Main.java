import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Bir index giriniz : ");
        int index = input.nextInt();

        try {
            printArr(arr, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizinin boyutunu aştınız!!!");
            System.out.println(e.toString());
        }
    }

    public static void printArr(int[] arr, int index){
        try {
            if (index < 0 || index >= arr.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                System.out.println("Dizinin " + index + ". elemanı: " + arr[index]);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }
}