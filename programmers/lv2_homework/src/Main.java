import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] plans = new String[][]{{"korean", "11:40", "20"}, {"english", "12:10", "30"},
                                          {"math", "12:30", "40"}};

        // 이떄 null 값이 반환됨 왜 그럴까?
        // 현재는 과제 완료 시점에 현재 시각과 과제의 시작 시간이 같다면 다음 과제를 스택에 넣는데
        // 예를 들어서 과제 완료가 된 시점에도 아직 다음 과제 시작할 시간이 되지 않았다면 넣지 못함
        // 이 경우를 고려해야 하고
        // try-catch 문을 이용하지 않고 한번 만들어봤으면 좋겠음
        // 즉, 지금은 다음 과제에 대한 부분을 stack의 사이즈를 이용해서 찾고 있는데 제일 마지막 과제이거나 혼자 남은 과제일경우는 OutBounds 에러가 뜨기 때문에
        // 이를 어떻게 해결할 지 고민해야함 / 1. stack.size를 그대로 대입하지 말고 int next = stack.size() 로 하되 stack.size()가 plan의 size보다 클 경우 next를 보정하는 방법

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
        int n = 0;
        Stack<Plan> stack = new Stack<>();

        List<Plan> plan = new ArrayList<>();

        int i = 0;
        for (String[] p : plans) {
            plan.add(new Plan(p[0], p[1], Integer.parseInt(p[2])));
        }
        Collections.sort(plan);

        Plan top;
        stack.add(plan.get(0));
        int current_time = plan.get(0).getStart();

        while (!stack.isEmpty()) {
            top = stack.peek();

            try {
                if (plan.get(stack.size()).getStart() < current_time + top.getRemainTime()) {

                    top.addTaken_time(plan.get(stack.size()).getStart() - current_time);
                    current_time += plan.get(stack.size()).getStart() - current_time;

                    stack.add(plan.get(stack.size()));
                } else {
                    current_time += top.getRemainTime();
                    top.addTaken_time(top.getRemainTime());
                }
            } catch (IndexOutOfBoundsException ignored) {
                current_time += top.getRemainTime();
                top.addTaken_time(top.getRemainTime());
            }

            //현재 과제의 소요된 시간이 과제 소요 시간과 같아진다면 해당 과제는 과제 완료
            if (top.getTaken_time() >= top.getPlaytime()) {
                plan.remove(stack.size()-1);
                answer[n++] = stack.pop().getName();
                try {
                    //새로운 과제가 들어올 시간이면 새로운 과제를 stack에 넣어준다.
                    if (current_time == plan.get(stack.size()).getStart()) {
                        stack.push(plan.get(stack.size()));
                    }
                } catch (IndexOutOfBoundsException ignored) {}
            }

        }

        return answer;
    }
}