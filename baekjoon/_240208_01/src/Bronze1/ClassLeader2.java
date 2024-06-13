package Bronze1;

import java.util.HashSet;
import java.util.Scanner;

class Student2{
    private int[] classNum = new int[5]; // 해당 학생의 1~5학년 반 정보
    private HashSet<Integer> friends = new HashSet<>(); // 해당 학생의 1~5학년 동안 같은 반 됐었던 친구들
    public Student2(int[] classNum) {
        this.classNum = classNum;
    }

    public void addFriend(Integer friend) {
        friends.add(friend);
    }
    public int getFriend() {
        return friends.size();
    }

    public int[] getClassNum() {
        return classNum;
    }

}
public class ClassLeader2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalStudent = scanner.nextInt();
        Student2[] students = new Student2[totalStudent];

        for (int i = 0; i < totalStudent; i++) {
            int[] classN = new int[5];
            for (int j = 0; j < 5; j++) {
                classN[j] = scanner.nextInt();
            }
            students[i] = new Student2(classN);
        }

        int max = 0;
        int classLeader = 0;
        for (int student = 0; student < totalStudent; student++) {
            for (int grade = 0; grade < 5; grade++) {
                for (int otherStu = 0; otherStu < totalStudent; otherStu++) {
                    if (students[student].getClassNum()[grade] == students[otherStu].getClassNum()[grade]) {
                        if (student != otherStu) { // 자신 제외
                            students[student].addFriend(otherStu+1);
                        }
                    }
                }
            }
            if (students[student].getFriend() > max) {
                max = students[student].getFriend();
                classLeader = student+1;
            }
        }
        System.out.println(classLeader != 0 ? classLeader : 1);
    }
}
