package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(13));
    }
}

class Solution {
    public boolean solution(int x) {
        boolean answer;

        String s = Integer.toString(x);
        int[] harshad = new int[s.length()];

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            harshad[i] = Integer.parseInt(s.split("")[i]);
            sum += harshad[i];
        }
        answer = x % sum == 0;

        return answer;
    }
}