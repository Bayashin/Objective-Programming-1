import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;
import java.util.Objects;

public class IntCollector {
    //フィールド
    //array private int[] 内部でデータを保持する配列
    private int[] array;

    //コンストラクタ
    //なし public フィールドarrayを要素数θの整数型配列で初期化
    public IntCollector(){
        this.array = new int[0];
    }

    //int[] values public 指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします(
    //同じ大きさの要素数で配列を初期化,値をすべてコピーする
    //　この動作をしないと、値の中身が参照でしか渡せないため
    // 　配列の初期化から値自体を代入する作業が必要になります
    public IntCollector(int[] values){
        this.setArray(values);
    }

    //getArray	public	int[]	なし	フィールドarrayを返します
    public int[] getArray(){
        return array;
    }

    //setArray	public	なし	int[] values 指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします(同じ大きさの要素数で配列を初期化、値をすべてコピーする)
    public void setArray(int[] array){
        //渡された引数の配列の要素数と同じ配列を作る
        this.array = new int[array.length];
        //作り直した配列に、引数の配列要素を1つづつコピーする
        for (int i = 0; i < array.length; i++){
            this.array[i] = array[i];
        }
    }

    //add	public	なし	int value	配列の要素数を1つ増やし、配列データの末尾に1件追加
    public void add(int value) {
        //もともとのarrayの要素数はどう変化しますか？
        // → 要素数は、＋1される
        // （配列の要素をどうやって増やすのか
        // → そのままでthis.array = new int[this.array.length + 1]　とするとどうなるか）
        //退路が必要
        int[] backup = this.array;
        //バックアップがあるので元のは消えてOK
        this.array = new int[this.array.length + 1];

        //元々あった配列の値は、新しい配列に追加する必要が出てきた
        for (int i = 0; i < backup.length; i++){
            this.array[i] = backup[i];
        }

        //渡されたvalueはどの配列のどの位置に追加しますか？
        this.array[this.array.length - 1] = value;
    }

    //countOf	public	int	int value	指定された値で要素を検索し、その要素数を返す
    public int countOf(int value){
        //valueで渡されたあたいが、arrayの中に幾つ存在しているかをカウントして返す
        int count = 0;
        for (int a : this.array){
            if (a == value) {
                count += 1;
            }
        }
        return count;
    }

    //indexOf	public	int	int value	配列の要素を検索して、指定された要素と同じ値のインデックスを返す(もし、指定された要素がなければ、-1が返される)
    public int indexOf(int calue){
        //for文でくるくる回して、valueと同じ値が見つかったらそのインデックスの値(i)をreturn
        for (int i = 0; i < array.length; i++){
            //TODO:なんかかけ
            if (calue == array[i]){
                return i;
            }
        }
        //for文が最後まで行っても見つからんかったら-1をreturn
        return -1;
    }

    //remove	public	なし	int index	指定されたインデックスの要素を削除し、配列自体の要素も切り詰める（指定されたインデックスが配列のインデックス外だった場合はなにもしない。）
    public void remove(int index) {
        //配列のインデックスと、引数のインデックスを比べて、範囲外だったらreturn
        if (index >= array.length) return;
        //元の配列をバックアップ
        int[] backup = this.array;
        //要素を一つ減らしたarrayを作成
        this.array = new int[backup.length - 1];
        //buckupをarrayに入れる(l=indexのとき、lを＋1することでずらす)
        for (int i=0,l=0; i < array.length; i++,l++){
            if (l == index) l++;
            array[i] = backup[l];
//            this.print();
        }
    }

    //print	public	なし	なし	フィールドarrayに生成されている要素を、下記「結果の表示例」を参考に標準出力に画面表示します
    public void print(){
        System.out.print("[");
        for (int i=0; i<this.array.length; i++){
            System.out.print(array[i]);
            if (i+1 != this.array.length){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //動作確認
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntCollector a1 = new IntCollector();
        System.out.println("値を入力（endで終了）");
        while (true) {
            //[242,54,353],[].[-1],[a]
            String inputLine = in.nextLine();
            if (Objects.equals(inputLine, "end")) {//"end"を入力で終了
                for (int a : a1.getArray()) {
                    System.out.print(a + ",");
                }
                System.out.println();
                System.out.println("length:"+a1.getArray().length);
                a1.print();
                return;
            } else {//走行距離を入力で計算、出力
                int num = Integer.parseInt(inputLine);//inputLineをdouble型に変換
                a1.add(num);
            }
        }
    }

}
