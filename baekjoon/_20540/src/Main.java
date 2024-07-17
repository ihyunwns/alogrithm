import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> MBTI = new HashMap<>();

        MBTI.put("ISTJ", "ENFP"); MBTI.put("ISFJ", "ENTP"); MBTI.put("INFJ", "ESTP"); MBTI.put("INTJ", "ESFP");
        MBTI.put("ISTP", "ENFJ"); MBTI.put("ISFP", "ENTJ"); MBTI.put("INFP", "ESTJ"); MBTI.put("INTP", "ESFJ");
        MBTI.put("ESTP", "INFJ"); MBTI.put("ESFP", "INTJ"); MBTI.put("ENFP", "ISTJ"); MBTI.put("ENTP", "ISFJ");
        MBTI.put("ESTJ", "INFP"); MBTI.put("ESFJ", "INTP"); MBTI.put("ENFJ", "ISTP"); MBTI.put("ENTJ", "ISFP");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println( MBTI.get(input) );

    }
}