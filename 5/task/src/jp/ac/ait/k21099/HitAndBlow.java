package jp.ac.ait.k21099;

import java.util.Scanner;

public class HitAndBlow {
    public static void main(String[] args) {
        //1.Managerクラスをappなどの名前の変数でインスタンス化する。
        //  答えの生成など、ゲームの準備が整います。
        Manager app = new Manager();

        //2.(デバッグ時のみ、1でインスタンス化したオブジェクトのapp.getAnswer().get()で答え取得し画面に出力してください。 提出時にはこの出力を消しておきましょう。 )
//        System.out.println("answer: " + app.getAnswer().get());

        //3.ユーザー(回答者)から入力を受け付けます。
        //  System.out.println("input " + Answer.DIGITS + " numbers :");などのメッセージを差し込んでおくと、丁寧です。
        while (true) {
            System.out.println("input " + Answer.DIGITS + " numbers :");
            Scanner in = new Scanner(System.in);
            String value = in.nextLine();

            //4.入力された文字列が、符号なし整数値のみで、かつ文字の長さがAnswer.DIGITSと等しいかをチェックし、合致しない場合はエラーとしてプログラムを終了します。
            if (!jp.ac.ait.k21099.StringUtilities.isUnsignedInteger(value)) {
                System.out.println("error");
                return;
            }
            if (Answer.DIGITS != value.length()) {
                System.out.println("error");
                return;
            }

            //入力された回答をint型配列で取得,同じ数字が入っていた場合エラー
            int num_str = Integer.parseInt(value);
            int[] num_ans = new int[value.length()];
            for (int i = value.length()-1; i>= 0; i--){
                num_ans[i] = num_str % 10;
                num_str /= 10;
            }

            for (int i=0; i<value.length()-1; i++){
                for (int j=i+1; j<value.length(); j++){
                    if (num_ans[i] == num_ans[j]){
                        System.out.println("Contains the same numbers");
                        System.out.println("Please try again");
                        continue;
                    }
                }
            }

            //5.Managerのインスタンスより、solve(String value)メソッドを呼び、Responseのインスタンスを受け取ります。
            //6.受け取ったResponseのインスタンスのgetHit()の戻り値が、Answer.DIGITSと等しい場合、正解のメッセージと、試行回数(Managerのインスタンス.getCount())を出力します。
            Response res = app.solve(value);
            if (res.getHit() == Answer.DIGITS) {
                System.out.println("Is the correct answer");
                System.out.println(app.getCount());
                return;
            }

            //7. 6.の条件に合致しない場合、ResponseのインスタンスのgetHit()とgetBlow()をHit,Blowの値として画面に出力し、3.に戻ります。
            System.out.println("Hit: "+res.getHit()+", Blow: "+res.getBlow());
        }
    }

}
