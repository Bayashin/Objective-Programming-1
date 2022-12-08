import java.nio.channels.SelectableChannel;
import java.util.Random;
import java.util.Scanner;

public class Atodashijanken {
    public static void main(String[] args) {

        //ランダムな数値を生成して、変数に退避しておきます。
        Random rand = new Random();
        int num = rand.nextInt(3);

        //生成されたランダムな値を元に、「0:グー,1:チョキ,2:パー」を画面表示します。
        if (num==0){
           System.out.println("グー");
        } else if (num==1) {
        System.out.println("チョキ");
        } else {
        System.out.println("パー");
        }

        //「何を出しますか？ (0:グー,1:チョキ,2:パー)」のように画面表示し、数値を入力させます
        System.out.println("何を出しますか？ (0:グー,1:チョキ,2:パー)");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        int atodashi=Integer.parseInt(inputLine);


        //入力された数値と、1.で生成されたランダムな数値で、勝敗を判定します
        if (num==0 && atodashi==0 || num==1 && atodashi==1 || num==2 && atodashi==2){
            System.out.println("あいこです");
        } else if (num==0 && atodashi==1 || num==1 && atodashi==2 || num==2 && atodashi==0) {
            System.out.println("あなたの負けです");
        } else if (num==0 && atodashi==2 || num==1 && atodashi==0 || num==2 && atodashi==1) {
            System.out.println("あなたの勝ちです");
        }
        //入力された値が0,1,2のどれでもない場合は、「あなたの出した手が判断できません。勝負はしません。」というメッセージを出力し、プログラムを終了してください。
        else {
            System.out.println("あなたの出した手が判断できません。勝負はしません。");
        }

        in.close();
    }
}
