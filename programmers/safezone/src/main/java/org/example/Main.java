package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[][]{{1, 1, 1, 1, 1, 1},
                                                  {1, 1, 1, 1, 1, 1},
                                                  {1, 1, 1, 1, 1, 1},
                                                  {1, 1, 1, 1, 1, 1},
                                                  {1, 1, 1, 1, 1, 1},
                                                  {1, 1, 1, 1, 1, 1}
        }));

    }
}

class Solution {
    public int solution(int[][] board) {
        Set<String> set = new HashSet<>();
        int size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    set.add("(" + i + ", " + j + ")");

                    List<String> around = getAroundBomb(i, j, size);
                    set.addAll(around);
                }
            }
        }

        return size * size - set.size();
    }

    private List<String> getAroundBomb(int x, int y, int size) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        List<String> around = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && nx < size && ny > -1 && ny < size) {
                around.add("(" + nx + ", " + ny + ")");
            }
        }

        return around;
    }
}