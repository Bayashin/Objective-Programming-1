import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumerQuiz extends JFrame {
    private JTextField tNumberInput;
    private JButton JButton;
    private JPanel panel1;
    private JLabel IMessage;

    private final int number;

    int count=0;

    public NumerQuiz(){
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 325, 140);

        // コンテンツパネル設定
        setContentPane(panel1);
        setTitle("NumberQuiz");

        Random random = new Random();
        number = random.nextInt(100000);
        System.out.println(number);
        tNumberInput.setText("00000");
        JButton.addActionListener(e -> {
            String str = tNumberInput.getText();
            //ボタンのテキストがリセットになっている時初期化
            if (JButton.getText().equals("リセット")) {
                count =0;
                EventQueue.invokeLater(() -> new NumerQuiz().setVisible(true));
            }
            //入力が自然数でない時
            if (!str.matches("\\d+")) {
                IMessage.setText("入力された文字列は整数値として判断できません。");
                return;
            }
            count++;
            IMessage.setText(judgment(str, number) + "(試行回数:"+ count +")");
            if (judgment(str,number).equals("正解"))JButton.setText("リセット");
        });
    }

    //入力の判定
    String judgment (String str, int number){
        int num = Integer.parseInt(str);
        int difference = num - number;

        if (difference == 0){
            return "正解";
        }
        if (difference < 0){
            if (difference > -1000) return "それより大きい";
            if (difference > -10000) return "それよりもっと大きい";
            return "それよりもっともっと大きい";
        }
        if (difference < 1000) return "それより小さい";
        if (difference < 10000) return "それよりもっと小さい";
        return "それよりもっともっと小きい";
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new NumerQuiz().setVisible(true));
    }
}
