import java.io.*;
import java.util.Stack;

public class Balanced_World{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> balance = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                balance.push('(');
            } else if (input.charAt(i) == '[') {
                balance.push('[');
            } else if (input.charAt(i) == ')' && balance.peek() == '(') {
                balance.pop();
            } else if (input.charAt(i) == ']' && balance.peek() == '[') {
                balance.pop();
            }
        }

        if (balance.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
