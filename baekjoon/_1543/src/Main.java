import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String Document = scanner.nextLine();
        String word = scanner.nextLine();

        ArrayList<Character> array_D = new ArrayList<>();
        for (int i = 0; i < Document.length(); i++) {
            array_D.add(Document.charAt(i));
        }
        int count = 0, i = 0;
        boolean FLAG;
        while (i <= array_D.size() - word.length()) {
            FLAG = true;
            for (int j = 0; j < word.length(); j++) {
                Character c = array_D.get(i + j);
                Character w = word.charAt(j);
                if (!c.equals(w)) {
                    FLAG = false;
                    break;
                }
            }
            if (FLAG) {
                for (int j = 0; j < word.length(); j++) {
                    array_D.remove(i);
                }
                i--;
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}