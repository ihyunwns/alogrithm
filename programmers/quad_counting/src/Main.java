import java.util.*;

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1,1,0,0},
                                                                         {1,0,0,0},
                                                                         {1,0,0,1},
                                                                         {1,1,1,1}})));
    }
}

class Solution {
    static int[] answer = new int[]{0, 0};

    public int[] solution(int[][] arr) {
        quad_divide(arr);
        return answer;
    }

    private void quad_divide(int[][] quad) {
        if (quad.length == 1) {
            if (quad[0][0] == 0) {
                answer[0]++;
                return;
            } else if (quad[0][0] == 1) {
                answer[1]++;
                return;
            }
        }
        if (isSameAsAll(quad)) return;

        int[][] NW = makeNW(quad);
        int[][] NE = makeNE(quad);
        int[][] SW = makeSW(quad);
        int[][] SE = makeSE(quad);

        quad_divide(NW); quad_divide(NE); quad_divide(SW); quad_divide(SE);

    }

    private static boolean isSameAsAll(int[][] quad) {
        int sum = 0;
        for (int[] value : quad) {
            sum += Arrays.stream(value).sum();
        }
        if (sum == 0) {
            answer[0]++;
            return true;
        } else if (sum == Math.pow(quad.length, 2)) {
            answer[1]++;
            return true;
        }
        return false;
    }

    private int[][] makeSE(int[][] quad) {
        int[][] SE = new int[quad.length/2][quad.length/2];
        for (int y = 0; y < quad.length / 2; y++) {
            for (int x = 0; x < quad.length / 2; x++) {
                int qy = quad.length / 2 + y;
                int qx = quad.length / 2 + x;
                SE[y][x] = quad[qy][qx];
            }
        }
        return SE;
    }

    private int[][] makeSW(int[][] quad) {
        int[][] SW = new int[quad.length/2][quad.length/2];
        for (int y = 0; y < quad.length / 2; y++) {
            for (int x = 0; x < quad.length / 2; x++) {
                int qy = quad.length / 2 + y;
                SW[y][x] = quad[qy][x];
            }
        }
        return SW;

    }

    private int[][] makeNE(int[][] quad) {
        int[][] NE = new int[quad.length/2][quad.length/2];
        for (int y = 0; y < quad.length / 2; y++) {
            for (int x = 0; x < quad.length / 2; x++) {
                int qx = quad.length / 2 + x;
                NE[y][x] = quad[y][qx];
            }
        }
        return NE;
    }

    private int[][] makeNW(int[][] quad) {
        int[][] NW = new int[quad.length/2][quad.length/2];
        for (int y = 0; y < quad.length / 2; y++) {
            for (int x = 0; x < quad.length / 2; x++) {
                NW[y][x] = quad[y][x];
            }
        }
        return NW;
    }
}