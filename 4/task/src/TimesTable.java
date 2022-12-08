/*
可変長な九九表クラスの作成
*/
public class TimesTable {
    //フィールド

    //九九表の幅(→方向の数)
    private  int width;

    //九九表の高さ(↓方向の数)
    private  int height;

    //九九表(コンストラクタにて配列の要素数及び内容を初期化します)
    private  int[][] array;

    //コンストラクタ

    //引数なし　このクラスは、初期化に高さデータと幅データが必要なため引数なしコンストラクタは外部から呼ばれないようにします
    private TimesTable(){

    }


    //引数あり　引数をそれぞれのフィールドに代入するとともに、フィールドarrayに値を設定します。値の設定内容については以下の解説を参考にしてください。
    public TimesTable(int width, int height){
        //引数をフィールドに代入
        this.width = width;
        this.height  =height;

        //フィールドarrayの初期化について
        //生成した配列の値には、(heightのindex + 1) × (widthのindex + 1) を代入
        this.array = new int[height][width];

        //生成した配列の値には、(heightのindex + 1) × (widthのindex + 1) を代入
        for (int h=0; h<height; h++){
            for (int w=0; w<width; w++){
                this.array[h][w] = (h+1) * (w+1);
            }
        }
    }
    //メソッド
    //getWidth	public	int	なし	フィールドwidthを返します
    public int getWidth(){
        return width;
    }

    //getHeight	public	int	なし	フィールドheightを返します
    public int getHeight() {
        return height;
    }

    //getArray	public	int[][]	なし	フィールドarrayを返します
    public int[][] getArray(){
        return array;
    }

    //print	public	なし	なし	フィールドarrayに生成されている九九表を、下記「結果の表示例」を参考に標準出力に画面表示します
    public void print(){
        for (int h=0; h<height; h++){
            System.out.print("|");
            for (int w=0; w<width; w++){
                System.out.print(this.getArray()[h][w]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        TimesTable tt1 = new TimesTable(4,3);
//        tt1.print();
//        System.out.println();
//        TimesTable tt2 = new TimesTable(9,9);
//        tt2.print();
//        System.out.println();
//        TimesTable tt3 = new TimesTable(0,0);
//        tt3.print();
//        System.out.println();
//        System.out.println();
//        TimesTable tt5 = new TimesTable(1,2);
//        tt5.print();
//        TimesTable tt4 = new TimesTable(-9,9);
//        tt4.print();
//
//    }

}

