package jp.ac.ait.k21099;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NonUnipueElements implements IKadai07_4{

    List<Integer> ret = new ArrayList<>();

    public int countOf(int value, List<Integer> ret){
        //valueで渡されたあたいが、retの中に幾つ存在しているかをカウントして返す
        int count = 0;
        for (int a : ret){
            if (Objects.equals(a,value)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public void convert(List<Integer> targetList) {
        var itr = targetList.iterator();
        while (itr.hasNext()) {
            int num = itr.next();
            //ユニークな値が見つかった時remove
            if (Objects.equals(this.countOf(num, targetList), 1)) {
                itr.remove();
            }
        }
//        System.out.println(targetList);
    }

    public static void main(String[] args) {
        NonUnipueElements app = new NonUnipueElements();
        System.out.println("整数をリストに追加、endで終了");
        while (true) {
            //整数またはendを入力
            Scanner in = new Scanner(System.in);
            String inputLine = in.nextLine();
            if (Objects.equals(inputLine, "end")) {//"end"を入力で終了
                app.convert(app.ret);
                System.out.println(app.ret);
                return;
            } else {//整数を入力でリストに追加
                app.ret.add(Integer.parseInt(inputLine));
                //入力　-2,-1,-1,6,3,6
                //     1,2,3,2,3
                //     1,2,3,4,5
            }
        }
    }
}
