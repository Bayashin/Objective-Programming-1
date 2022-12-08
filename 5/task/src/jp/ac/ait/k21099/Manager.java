package jp.ac.ait.k21099;

public class Manager {

    private int count;
    private Answer answer;

    /**
     * ゲームの初期化を行う
     */
    public Manager(){
        //countに初期値を代入
        this.count = 0;
        //answer にAnswerクラスをインスタンスして代入
        answer = new Answer();
    }

    public int getCount(){
        return count;
    }

    public Answer getAnswer(){
        return answer;
    }

    /**
     * 答えに対して試行するスレッド
     * @param in　3桁の整数値で構成された文字列
     * @return　HitとBlowの数をResponseに入れて返します
     */
    public Response solve(String in){

        //試行したい文字列in(3桁の整数値で構成された文字列)
        //エラーチェックは不要

        //入力された回答をint型配列で取得
        int num_str = Integer.parseInt(in);
        int[] num_ans = new int[in.length()];
        for (int i = in.length()-1; i>= 0; i--){
            num_ans[i] = num_str % 10;
            num_str /= 10;
        }

        //正解の答えをint型配列で取得
        num_str = Integer.parseInt(getAnswer().get());
        int[] answers_num = new int[getAnswer().get().length()];
        for (int i = getAnswer().get().length()-1; i >= 0; i--){
            answers_num[i] = num_str % 10;
            num_str /= 10;
        }

        //1. countに1を足し、試行回数をカウントアップ
        this.count ++;
        //2.Hit、Blowを計算し、Responseのインスタンスで返します
        int hit = 0;
        int blow = 0;

        //hitとblowを取得
        for (int i = 0; i<getAnswer().get().length(); i++){
            for (int j = 0; j<num_ans.length; j++){
                if (answers_num[i] == num_ans[j]){
                    if (i == j){
                        hit++;
                        break;
                    }
                    blow++;
                }
            }
        }

        Response response = new Response(hit,blow);

        //戻り値はResponseのインスタンス
        return response;
    }

}
