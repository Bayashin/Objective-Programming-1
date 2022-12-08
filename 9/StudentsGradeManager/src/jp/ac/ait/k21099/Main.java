package jp.ac.ait.k21099;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.IStudentsSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IStudent student;
        IStudentsSorter studentsoter;
        Scanner in_str = new Scanner(System.in);
        Scanner in_num = new Scanner(System.in);
        Scanner in_char = new Scanner(System.in);
        List<IStudent> studentList = new ArrayList<>();
        List<Grade> gradeList = new ArrayList<>();


        while (true) {
            System.out.println("1、生徒リストの追加　2、単位取得できた成績リストを取得する　3、指定された評価の成績リストを取得する　それ以外、終了");
            int operation = in_num.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("学籍番号の入力");
                    String studentID = in_str.nextLine();
                    System.out.println("氏名の入力");
                    String studentName = in_str.nextLine();
                    while (true){
                        System.out.println("科目名の入力");
                        String subject = in_str.nextLine();
                        System.out.println("取得できる単位数を入力");
                        int credit = in_char.nextInt();
                        System.out.println("生徒の評定を入力");
                        char myRating = in_char.next().charAt(0);
                        gradeList.add(new Grade(subject, credit, myRating));
                        System.out.println("続ける場合は continue を入力");
                        String juge = in_str.nextLine();
                        if (Objects.equals(juge, "continue")){
                            continue;
                        }else {
                            studentList.add(new Student(studentID, studentName, gradeList));
                            break;
                        }
                    }
                    break;
                case 2:
                    if (Objects.equals(studentList.size(),0)){
                        System.out.println("studentリストが空です");
                        break;
                    }

                    for (String s:student)
            }
        }
    }
}

