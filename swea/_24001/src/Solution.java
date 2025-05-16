import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
 
        for(int test_case = 1; test_case <= T; test_case++){
            int cntL = 0; int cntR = 0; int cntQ = 0;
 
            String[] line = sc.nextLine().split("");
 
            String[] Larr = new String[line.length];
            String[] Rarr = new String[line.length];
            for(int i = 0; i < line.length; i++){
                if (line[i].equals("?")) {
                    Larr[i] = "L";
                    Rarr[i] = "R";
                } else {
                    Larr[i] = line[i];
                    Rarr[i] = line[i];
                }
 
            }
 
            // L과 R의 개수로만 이동 방향을 정하면
            // LLLL??RRRRR 과 같은 경우는 L로 이미 4개씩 이동한 상태에서 좌측으로 2번 더 이동하면 6을 얻지만 R로 가면 3까지 밖에 못간다
            // 하지만 R의 개수가 더 많기 때문에 3으로 선택이 될 것 따라서 L의 개수가 아닌 현재 위치를 기준으로 더 나은 선택을 하도록 해야함
 
            // 어찌됐든 ?는 한쪽으로만 가야 최대한의 이득을 볼 수가 있음 따라서 L로 했을 때 R로 했을 때를 구해서 비교하는 방법으로 하자
            int cntLPos = 0; int cntRPos = 0;
            int maxL = 0; int maxR = 0;
            for(String L : Larr){
                if (L.equals("L")) {
                    cntLPos--;
                } else {
                    cntLPos++;
                }
 
                maxL = Math.max(maxL, Math.abs(cntLPos));
            }
 
            for(String R : Rarr){
                if (R.equals("L")) {
                    cntRPos--;
                } else {
                    cntRPos++;
                }
                maxR = Math.max(maxR, Math.abs(cntRPos));
            }
            System.out.println(Math.max(maxL, maxR));
 
        }
 
    }
}