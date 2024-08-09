package org.quiz;

import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));

        // 대문자는 소문자보다 작음

    }
}

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Character[] c = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }


        Arrays.sort(c, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int ASCII_o1 = (int)o1;
                int ASCII_o2 = (int)o2;

                return o2 - o1;
            }
        });

        for (Character ch : c) {
            answer.append(ch);
        }

        return answer.toString();
    }
}
