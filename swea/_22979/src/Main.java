import java.util.Scanner;

/*
* SWEA | 22979. 문자열 옮기기 | D3
* https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=3&contestProbId=AZPOBiaqNo8DFAWB&categoryId=AZPOBiaqNo8DFAWB&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
* */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=T; t++){
            String S = sc.nextLine();
            int K = sc.nextInt();
            sc.nextLine();
            int[] N = new int[K];
            String[] line = sc.nextLine().split(" ");
            for(int i=0; i<K; i++){
                N[i] = Integer.parseInt(line[i]);
            }

            int length = S.length();
            StringBuilder sb = new StringBuilder(S);
            for(int X : N){
                for( int i = 0; i < Math.abs(X) % length; i++ ){
                    if (X > 0) {
                        // 첫번째 글자를 마지막으로
                        char c = sb.charAt(0);
                        sb.append(c);
                        sb.deleteCharAt(0);

                    } else if (X < 0) {
                        // 마지막 글자를 첫번째로
                        char c = sb.charAt(length-1);
                        sb.deleteCharAt(length-1);
                        sb.insert(0, c);
                    }
                }
            }

            System.out.println(sb);

        }


    }
}