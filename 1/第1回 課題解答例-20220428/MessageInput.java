import java.util.Scanner;

public class MessageInput {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("こんにちは、メッセージをどうぞ");
    // 入力
    String inputLine = in.nextLine();
    // 出力
    System.out.println("メッセージを受信しました");
    System.out.println("----");
    System.out.println(inputLine);
    System.out.println("----");

  }
}
