import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new int[]{1,2,3,2,3})));
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i > -1; i--) {

            // 스택이 비어 있지 않고 stack.peek()의 가격보다 현재 가격이 작으면
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            } else {
                answer[i] = prices.length - i -1;
            }

            stack.push(i);
        }

        return answer;
    }
}