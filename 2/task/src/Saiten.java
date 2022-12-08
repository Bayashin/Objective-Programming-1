import java.util.Scanner;

public class Saiten {
    public static void main(String[] args) {
        System.out.println("テストの点数を入力してください。");

        //テストの点数を入力させる。
        Scanner in = new Scanner(System.in);

        //入力された文字列を整数値に変換する。
        String inputLine = in.nextLine();
        int sucore=Integer.parseInt(inputLine);

        //変換した整数値が、0〜100の範囲外だった場合、「入力された値は点数として正しくありません。」と表示して処理終了します。
        if (sucore<0 || sucore>100){
            System.out.println("入力された値は点数として正しくありません。");
            return;
        }

        //以下の条件に応じてそれぞれ画面にメッセージを表示させてプログラムを終了してください。
        if (sucore>=60){
            //100〜60:「合格です。おめでとう！」
            System.out.println("合格です。おめでとう！");
        } else if (sucore>=20) {
            //59〜20:「不合格です。再テストを行いましょう！」
            System.out.println("不合格です。再テストを行いましょう！");
        } else {
            //19〜0:「不合格です。来年もう一年頑張りましょう。」
            System.out.println("不合格です。来年もう一年頑張りましょう。");
        }

        in.close();
    }
}

