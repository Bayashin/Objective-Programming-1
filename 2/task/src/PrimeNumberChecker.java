import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {

        System.out.println("整数を入力してください");

        //任意の整数値をキーボードから入力させます。
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        //入力された文字列を整数値に変換します。
        int number=Integer.parseInt(inputLine);

        //入力された整数値が、素数かどうかを判定します。
        if (number>1) {
            for (int x=2; x<=number; x++) {
                if (number % x == 0 && x != number) {
                    //素数でない場合、「素数ではありません」と表示
                    System.out.println("素数ではありません");
                    return;
                }
            }
        }else { //0,1,負の整数は素数ではありません。
            System.out.println("素数ではありません");
            return;
        }
        //素数の場合、「素数です」と表示
        System.out.println("素数です");
    }
}
