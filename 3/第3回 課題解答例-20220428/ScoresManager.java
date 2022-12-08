import java.util.Scanner;

public class ScoresManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Score s = new Score();

        System.out.println("出席番号を入力してください:");
        s.id = Integer.parseInt(sc.nextLine());
        System.out.println("氏名を入力してください:");
        s.name = sc.nextLine();
        System.out.println("国語の点数を入力してください:");
        s.setJapanese(Integer.parseInt(sc.nextLine()));
        System.out.println("数学の点数を入力してください:");
        s.setMathmatics(Integer.parseInt(sc.nextLine()));
        System.out.println("理科の点数を入力してください:");
        s.setScience(Integer.parseInt(sc.nextLine()));
        System.out.println("社会の点数を入力してください:");
        s.setSocialStudies(Integer.parseInt(sc.nextLine()));
        System.out.println("英語の点数を入力してください:");
        s.setEnglish(Integer.parseInt(sc.nextLine()));

        s.printInfo();

    }
}
