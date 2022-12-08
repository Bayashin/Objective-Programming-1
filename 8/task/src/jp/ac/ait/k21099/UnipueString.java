package jp.ac.ait.k21099;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UnipueString implements IKadai07_3{

    //countOf	public	int	int value	指定された値で要素を検索し、その要素数を返す
    public int countOf(String value, List<String> ret){
        //valueで渡されたあたいが、retの中に幾つ存在しているかをカウントして返す
        int count = 0;
        for (String a : ret){
            if (Objects.equals(a,value)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public List<String> getUniqueList(List<String> targetList) {
        List<String> ret = new ArrayList<>();
        for (String str : targetList) {
            //ユニークな値が見つかった時retに入れる
            if (Objects.equals(this.countOf( str,targetList ),1)) {
                ret.add(str);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> ret = new ArrayList<>();
        UnipueString app = new UnipueString();
        System.out.println("文字をリストに追加、endで終了");
        while (true) {
            //文字またはendを入力
            Scanner in = new Scanner(System.in);
            String inputLine = in.nextLine();
            if (Objects.equals(inputLine, "end")) {//"end"を入力で終了
                System.out.println(app.getUniqueList(ret));
                return;
            } else {//文字を入力でリストに追加
                ret.add(inputLine);
            }
        }
    }
}
