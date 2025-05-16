import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine(); // 개행 문자 소비
 
        int[][] box = new int[T][5];
        for(int i=0 ; i < T; i++)
        {
         
            String s = sc.nextLine();
            for(int j = 0; j < 5; j++) {
                box[i][j] = Integer.parseInt(s.split(" ")[j]);
            }
            int B = box[i][0]; int W = box[i][1];
            int X  = box[i][2]; int Y = box[i][3]; int Z = box[i][4];
 
            // 각자의 상자에 한개씩 넣은 경우
            int sum1 = B*X + W*Y;
 
            // 다른 상자에 넣은 경우
            int sum2;
            if (B > W) {
                sum2 = (W * 2 * Z) + (B - W) * X;
            } else {
                sum2 = (B * 2 * Z) + (W - B) * Y;
            }
 
            int max = Math.max(sum1, sum2);
            System.out.println(max);
 
        }
    }
}