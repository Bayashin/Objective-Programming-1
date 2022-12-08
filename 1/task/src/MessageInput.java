import java.util.Scanner;

public class MessageInput {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);

        //入力待受前のメッセージ表示
        System.out.println("こんにちは、メッセージをどうぞ");

        //(ユーザー操作)テキストを入力
        String inputLine = ms.nextLine();
        //入力後の応答
        System.out.println("メッセージを受信しました");
        System.out.println("ーーーー");
        System.out.println(inputLine);
        System.out.println("ーーーー");

        ms.close();
    }

}
