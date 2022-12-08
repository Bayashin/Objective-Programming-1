package jp.ac.ait.k21099;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci implements IKadai07_1{
    @Override
    public List<Integer> get(int max_value) {
        List<Integer> ret = new ArrayList<>();
        int a = 0;
        int b = 1;

        if (max_value >= 0){ //引数が0以上の場合
            ret.add(a); //retに0を追加
            if (max_value > 0){ //引数が0より大きい場合
                ret.add(b); //retに1を追加
            }
        }

        int next = a+b; //次の値を計算
        while (next <= max_value){ //引数がnext以上である場合
            ret.add(next); //retにnextを追加
            //a,bを一つずらす
            a = b;
            b = next;
            next = a + b;
        }

        return ret;
    }

    public static void main(String[] args) {
        Fibonacci app = new Fibonacci();
        Scanner num = new Scanner(System.in);
        System.out.println("自然数を入力してください");
        System.out.println(app.get(num.nextInt())); //入力された数値以下のフィボナッチ数列を印字
        //入力：10000、3、0、1、-1

    }
}
