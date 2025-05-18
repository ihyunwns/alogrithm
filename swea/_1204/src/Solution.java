import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String t = br.readLine();
            String[] input = br.readLine().split(" ");

            Map<Integer, Integer> student = new HashMap<>();
            List<Integer> freq_stu = new ArrayList<>();
            for (String s : input) {
                if(student.containsKey(Integer.parseInt(s))){
                    student.put(Integer.parseInt(s), student.get(Integer.parseInt(s)) + 1);
                }else{
                    student.put(Integer.parseInt(s), 1);
                }
            }

            int max = 0;
            for(int value : student.values()){
                if (max < value) {
                    max = value;
                }
            }

            for(int key : student.keySet()){
                if(student.get(key) == max){
                    freq_stu.add(key);
                }
            }

            Collections.sort(freq_stu);

            System.out.println("#" + t + " " + freq_stu.get(freq_stu.size() - 1));


        }


    }
}
