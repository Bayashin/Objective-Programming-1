package jp.ac.ait.k21099;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Kadai1 {
    // Kadai1 の共通スキャナ
    private static final Scanner sc = new Scanner(System.in);

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
         * 配列の生成
         */

        // TODO: 【エラー処理】int型の整数値に変換可能な文字列が入力されるまで繰り返したい
        String input;
        while (true) {
            boolean judge = true; //例外判定用フィールド
            System.out.print("生成する配列の大きさを入力してください > ");
            input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) { //inputを上から異文字ずつ見ていき、数字ではない時
                    if (input.charAt(i) == '-' && i == 0) continue; //判定される文字が先頭かつ-のときは例外処理しない
                    System.out.println("int型に変換可能な整数ではありません");
                    judge = false;
                    break;
                }
            }
            if (!judge) continue; //例外が発生している時
            //inputがint型の最大値以上、または最低値以下の時
            if (new BigInteger(input).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0 || new BigInteger(input).compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
                System.out.println("int型に変換可能な整数ではありません");
                judge = false;
            }
            if (!judge) continue; //例外が発生している時
            break; //正常に動作している時ループ脱出
        }

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int size = Integer.parseInt(input);
        int[] arr = createRandomIntArray(size);

        // 生成された配列を画面表示
        System.out.print("生成された配列: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        /*
         * 配列の要素を取り出し
         */

        // TODO: 【エラー処理】int型の整数値に変換可能な文字列が入力されるまで繰り返したい
        while (true) {
            boolean judge = true; //例外判定用フィールド
            System.out.print("取り出す配列のインデックスを指定してください > ");
            input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) { //inputを上から異文字ずつ見ていき、数字ではない時
                    if (input.charAt(i) == '-' && i == 0) continue; //判定される文字が先頭かつ-のときは例外処理しない
                    System.out.println("int型に変換可能な整数ではありません");
                    judge = false;
                    break;
                }
            }
            if (!judge) continue; //例外が発生している時
            //inputがint型の最大値以上、または最低値以下の時
            if (new BigInteger(input).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0 || new BigInteger(input).compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0 && judge) {
                System.out.println("int型に変換可能な整数ではありません");
                judge = false;
            }
            if (!judge) continue; //例外が発生している時
            break; //正常に動作している時ループ脱出
        }

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int index = Integer.parseInt(input);
        System.out.println("値: " + getValueByIndex(arr, index));
    }


    /**
     * 指定された要素数で各要素がランダムな値を持つ配列を生成して返す
     *
     * @param size 要素数
     * @return 生成されたランダムな値を持つ配列オブジェクト
     */
    public static int[] createRandomIntArray(int size) {
        // TODO: 【例外処理】配列の要素数として正しくない値が渡された場合の例外を捕捉し、その場合は要素数0の配列を生成する
        //sizeがMAX-VALUEまたは負の値の時
        if (size == MAX_VALUE || size < 0) {
            size = 0;
        }
        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);   // 0〜999まででランダム
        }

        return arr;
    }

    /**
     * 配列とインデックスを渡し、その要素を取り出して返す
     *
     * @param arr   配列のオブジェクト
     * @param index インデックス
     * @return 取り出した要素
     */
    public static int getValueByIndex(int[] arr, int index) {
        // TODO: 【エラー処理】引数arrがnullだった場合、-1を返す
        // TODO: 【例外処理】配列のインデックスとして正しくない値が渡された場合の例外を捕捉し、その場合は-1を返す
        if (arr == null) return -1; //arrがnullの時
        if (arr.length <= index || index < 0) return -1; //indexが配列の要素数より大きい、または負の値の時
        return arr[index];
    }
}

