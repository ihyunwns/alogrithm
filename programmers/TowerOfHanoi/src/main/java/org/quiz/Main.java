package org.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(3)));
    }
}

class Solution {
    private static final List<int[]> arr = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return arr.toArray(int[][]::new);
    }

    private void hanoi(int cnt, int start, int mid, int end) {
        if (cnt == 1) {
            move(start, end, cnt);
            return;
        }

        hanoi(cnt - 1, start, end, mid);
        move(start, end, cnt);
        hanoi(cnt - 1, mid, start, end);
    }

    private void move(int start, int end, int cnt) {
        arr.add(new int[]{start, end});
    }
}