import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Bir Kelime Giriniz : ");
        String words = input.nextLine();
        String[] word = words.split(" ");

        HashMap<String,Integer> mostWord = new HashMap<>();

        for (String count : word) {
            if (mostWord.containsKey(count)) {
                mostWord.put(count, mostWord.get(count) + 1);
            } else {
                mostWord.put(count, +1);
            }
        }

        int maxCount = 0;
        String mostFrequentWord = "";

        for (Map.Entry<String, Integer> entry : mostWord.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        System.out.println("En çok kullanılan kelime => " + mostFrequentWord + " <=> " + maxCount + " kez kullanıldı! ");
    }
}