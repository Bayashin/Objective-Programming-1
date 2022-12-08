//import jdk.incubator.foreign.CLinker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter extends JFrame{
    private JButton Decriment;
    private JButton Incriment;
    private JButton Reset;
    private JLabel ICounter;
    private JPanel panel1;

    int count = 0;

    public ClickCounter() {
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 300, 200);

        // コンテンツパネル設定
        setContentPane(panel1);

        setTitle("ClickCounter");

        // ラベル設定
        ICounter.setText(String.valueOf(count));
        //マイナス
        Decriment.addActionListener(e -> {
            count--;
            ICounter.setText(String.valueOf(count));
        });
        //プラス
        Incriment.addActionListener(e -> {
            count++;
            ICounter.setText(String.valueOf(count));
        });
        //リセット
        Reset.addActionListener(e -> {
            count = 0;
            ICounter.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new ClickCounter().setVisible(true));
    }


}
