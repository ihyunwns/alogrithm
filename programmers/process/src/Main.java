import java.util.*;

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println("답:" + solution.solution(new int[]{1,1,9,1,1,1}, 0));
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        int index = 0;
        for(int priority : priorities){
            queue.offer(new Process(priority, index++));
        }

        List<Process> run = new ArrayList<>();

        Process current_process = queue.poll();
        boolean flag = false;
        while (run.size() <= priorities.length-1) {
            flag = true;
            for (Process process : queue) {
                // 만약 현재 진행 대기 중인 프로세스보다 큰 우선순위를 가진 값이 있다면
                if (process.getPriority() > current_process.getPriority()) {
                    queue.offer(current_process);
                    flag = false;
                    break;
                }
            }
            // queue를 순회해도 현재 진행 중인 프로세스보다 큰 우선 순위를 가진 값을 찾지 못했을 때
            if (flag) {
                // 실행
                run.add(current_process);
                if (queue.isEmpty()) {
                    break;
                }
            }
            current_process = queue.poll();
        }

        int answer = 0;
        int rank = 0;
        for (Process p : run) {
            rank++;
            if (p.getIndex() == location) {
                answer = rank;
                break;
            }
        }

        return answer;
    }
}

class Process {

    private final int priority;
    private final int index;

    public Process(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }

    public int getIndex() {
        return index;
    }

}