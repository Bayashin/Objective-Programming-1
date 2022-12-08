import java.util.Scanner;

public class Multiplication100 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        //入力待受前のメッセージ表示
        System.out.println("整数値を入力してください");

        //(ユーザー操作)テキストを入力
        String inputLine = num.nextLine();
        int number=Integer.parseInt(inputLine);

        System.out.println("計算結果: " + number * 100);
    }
}
