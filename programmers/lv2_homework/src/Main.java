import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] plans = new String[][]{{"korean", "11:40", "20"}, {"english", "12:10", "20"},
                                          {"math", "12:30", "40"}};

        System.out.println(Arrays.toString(s.solution(plans)));
    }
}

class Plan implements Comparable<Plan>{
    private final String name;
    private final String start;
    private final int playtime;
    private int taken_time = 0;

    public Plan(String name, String start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }

    public int getRemainTime() {
        return playtime - taken_time;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return convertMinute(start);
    }

    public int getPlaytime() {
        return playtime;
    }

    public void addTaken_time(int taken_time) {
        this.taken_time += taken_time;
    }

    public int getTaken_time() {
        return taken_time;
    }

    @Override
    public int compareTo(Plan o) {
        int time = convertMinute(this.start);
        int otime = convertMinute(o.start);

        return time - otime;
    }

    private int convertMinute(String time) {
        String[] timeString = time.split(":");

        return (Integer.parseInt(timeString[0])*60) + Integer.parseInt(timeString[1]);
    }

}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Plan> stack = new Stack<>();
        List<Plan> plan = new ArrayList<>();

        //Plan 시작 시간 별로 정렬
        for (String[] p : plans) {
            plan.add(new Plan(p[0], p[1], Integer.parseInt(p[2])));
        }
        Collections.sort(plan);

        int n = 0;
        Plan current_plan = plan.get(0);
        stack.add(plan.get(0));
        int current_time = plan.get(0).getStart();

        while (!plan.isEmpty()) {

            int current_index = stack.size() -1;
            int next_index = stack.size();
            current_plan = stack.peek(); //현재 진행 중인 과제

            // 다음 진행할 과제가 있으면서 현재 시간 + 현재 과제 소요 시간이 다음 과제 시작 시간을 넘을 때
            if (next_index < plan.size() && current_time + current_plan.getRemainTime() > plan.get(next_index).getStart()) {

                int progress = plan.get(next_index).getStart() - current_time; //진행할 시간

                current_plan.addTaken_time(progress); // 현재 과제를 진행할 시간 만큼 진행 시켜줌
                current_time += progress; // 현재 시간을 진행한 시간 만큼 진행 시킴
                stack.push(plan.get(next_index)); // 두번째 과제를 stack에 넣어 줌

                // 다음 진행할 과제가 없거나 현재 시간 + 첫번째 과제 소요 시간이 두번째 과제 시작 시간을 넘지 않거나 같을 때
            } else {
                //현재 과제를 끝까지 진행 시켜야 함
                int remain_time = current_plan.getRemainTime(); //현재 과제의 남은 시간
                current_plan.addTaken_time(remain_time); // 남은 시간 만큼 현재 과제 진행

                current_time += remain_time; // 현재 시간을 남은 시간 만큼 진행

                // 스택에서 빼는 것과 동시에 answer에 해당 과제의 이름을 넣어줌
                answer[n++] = stack.pop().getName();
                plan.remove(current_index); // plan에서도 빼줌

                current_index = stack.size()-1;
                next_index = stack.size();

                // 다음 과제가 있다면
                if (next_index < plan.size()) {
                    // 진행중이던 과제가 없다면
                    if (stack.isEmpty()) {
                        // 그 과제가 진행 되는 시간으로 현재 시간을 바꿔주고 스택에 넣어줌
                        stack.push(plan.get(next_index));
                        int progress = plan.get(next_index).getStart() - current_time;
                        current_time += progress;
                    }
                }
            }
        }

        return answer;
    }
}