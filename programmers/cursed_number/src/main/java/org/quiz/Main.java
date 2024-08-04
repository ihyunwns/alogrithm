package org.quiz;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(40));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        String s;
        for (int i = 0; i < n; i++) {
            answer++;
            s = Integer.toString(answer);
            while(answer % 3 == 0 || s.contains("3")) {
                answer++;
                s = Integer.toString(answer);
            }
        }
        return answer;
    }
}