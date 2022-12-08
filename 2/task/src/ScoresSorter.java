public class ScoresSorter {
    public static void main(String[] args) {

        //上記表の点数を、以下のようにmainメソッド内で保持します。
        String[] names = {"佐藤一郎", "鈴木次郎", "高橋三郎", "田中四郎", "伊藤五郎", "渡辺六郎", "山本七子", "中村八郎", "小林九", "加藤十子"};
        int[][] scores = {
                {100,30,50,40,50,60,70,80,95,10},
                {30,55,45,60,65,50,80,25,100,35},
                {90,75,35,90,65,60,80,25,0,20},
                {10,85,25,70,90,80,60,50,40,30},
                {60,40,30,50,70,70,70,70,15,55},
        };

        //個人の5教科合計を算出
        int[] sum_score = {0,0,0,0,0,0,0,0,0,0};
        for (int i=0; i<5; i++) {
            for (int j=0; j<10; j++) {
                sum_score[j] += scores[i][j];
            }
        }

        //合計点を降順で並び替え
        for (int i=0; i<10; i++) {
            for (int j=0; j<9-i; j++) {
                if (sum_score[i]<sum_score[i+j]) {
                    int tmp = sum_score[i];
                    sum_score[i]=sum_score[i+j];
                    sum_score[i+j]=tmp;
                    String tmp_n = names[i];
                    names[i]=names[i+j];
                    names[i+j]=tmp_n;0
                }
            }
        }

        //「名前:点数」の表記で、改行区切りで画面表示してください。
        for (int i=0; i<10; i++) {
            System.out.println(names[i] + ":" + sum_score[i]);
        }
    }
}
