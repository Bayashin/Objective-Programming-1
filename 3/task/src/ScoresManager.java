import java.util.Scanner;

public class ScoresManager {
    public static void main(String[] args) {
        Score app = new Score();
        System.out.println("出席番号");
        Scanner in = new Scanner(System.in);
        app.setId(in.nextInt());
        System.out.println("氏名");
        Scanner inname = new Scanner(System.in);
        app.setName(inname.nextLine());
        System.out.println("国語");
        app.setJapanese(in.nextInt());
        System.out.println("数学");
        app.setMathmatics(in.nextInt());
        System.out.println("理科");
        app.setScience(in.nextInt());
        System.out.println("社会");
        app.setSocialStudies(in.nextInt());
        System.out.println("英語");
        app.setEnglish(in.nextInt());

        in.close();

        app.printInfo();
    }
}
