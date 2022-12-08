package jp.ac.ait.k21099;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FizzBuzz implements IKadai07_2{

    @Override
    public List<String> getConverted(List<Integer> targetList) {
        List<String> ret = new ArrayList<>();
        for(int num : targetList){
            int judge3 = num%3, judge5 = num%5;

            if (judge3==0 && num != 0 ){ //数値が3の倍数かつ0でない時
                //数値が、5の倍数の時、「FizzBuzz」を追加
                if (judge5==0) {
                    ret.add("FizzBuzz");
                }else { //「Fizz」を追加
                    ret.add("Fizz");
                }
                //数値が、5の倍数かつ0でない時、「Buzz」を追加
            } else if (judge5==0 && num != 0){
                ret.add("Buzz");
            }else { //上記以外、数値をそのまま追加
                ret.add(String.valueOf(num));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> ret = new ArrayList<>();
        FizzBuzz app = new FizzBuzz();
        System.out.println("整数をリストに追加、endで終了");
        while (true){
            //整数またはendを入力
            Scanner in = new Scanner(System.in);
            String inputLine = in.nextLine();
            if (Objects.equals(inputLine, "end")){//"end"を入力で終了
                System.out.println(app.getConverted(ret));
                return;
            }else {//整数を入力でリストに追加
                ret.add(Integer.parseInt(inputLine));
            }
            //入力　0,0,1,1,1,3,5,15,end
            //     -1,-1,90,70,54,end
        }
    }
}
