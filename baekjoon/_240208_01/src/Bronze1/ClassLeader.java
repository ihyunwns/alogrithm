package Bronze1;

import java.util.Scanner;

class Student{
    private int[] classNum = new int[5]; // 학생의 1~5학년 반 정보
    private int[] classmateNum = new int[5]; // 학생의 1~5학년 동안 같은 반 됐었던 친구의 수 정보
    public Student(int[] classNum) {
        this.classNum = classNum;
    }

    public void addClassmateNum(int grade) {
        classmateNum[grade]++;
    }
    public int getClassmateNum() {
        int size = 0;
        for (int i = 0; i < 5; i++) {
            size += classmateNum[i];
        }
        return size;
    }
    public int[] getClassNum() {
        return classNum;
    }

}
public class ClassLeader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalStudent = scanner.nextInt();
//        Student[] students = new Student[totalStudent];

        Student[] students = new Student[]{
                new Student( new int[]{2, 3, 1, 7, 3} ),
                new Student( new int[]{4, 1, 9, 6, 8} ),
                new Student( new int[]{5, 5, 2, 4, 4} ),
                new Student( new int[]{6, 5, 2, 6, 7} ),
                new Student( new int[]{8, 4, 2, 2, 2} )
        };


//        for (int i = 0; i < totalStudent; i++) {
//            int[] classN = new int[5];
//            for (int j = 0; j < 5; j++) {
//                classN[j] = scanner.nextInt();
//            }
//            students[i] = new Student(classN);
//        }

        int max = 0;
        int classLeader = 0;
        for (int student = 0; student < totalStudent; student++) {
            for (int grade = 0; grade < 5; grade++) {
                for (int otherStu = 0; otherStu < totalStudent; otherStu++) {
                    if (students[student].getClassNum()[grade] == students[otherStu].getClassNum()[grade]) {
                        students[student].addClassmateNum(grade);
                    }
                }
            }
            if (students[student].getClassmateNum() > max) {
                max = students[student].getClassmateNum();
                classLeader = student+1;
            }
        }
        System.out.println(classLeader);
    }
}
