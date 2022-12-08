import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LightsOut extends JFrame{
    private JPanel panel1;
    private JLabel ITopCenter;
    private JLabel ITopLeft;
    private JLabel IBottomLeft;
    private JLabel IMiddleCenter;
    private JLabel IBottomCenter;
    private JLabel ITopRight;
    private JLabel IMiddleRight;
    private JLabel IBottomRight;
    private JLabel IMiddleLeft;

    public LightsOut() {
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 600, 600);

        // コンテンツパネル設定
        setContentPane(panel1);
        setTitle("LightsOut");

        ITopCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        ITopLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        ITopRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleRight.setText(String.valueOf(new java.util.Random().nextInt(2)));


        ITopCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(ITopCenter,ITopLeft,ITopRight,IMiddleCenter);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IBottomCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IBottomCenter,IMiddleCenter,IBottomRight,IBottomLeft);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IMiddleCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IMiddleCenter,IMiddleRight,IMiddleLeft,IBottomCenter,ITopCenter);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        ITopLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(ITopLeft,ITopCenter,IMiddleLeft);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IBottomLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IBottomLeft,IBottomCenter,IMiddleLeft);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IMiddleLeft.addMouseListener(new MouseAdapter()  {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IMiddleLeft,IMiddleCenter,ITopLeft,IBottomLeft);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });

        ITopRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(ITopRight,ITopCenter,IMiddleRight);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IBottomRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IBottomRight,IBottomCenter,IMiddleRight);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
        IMiddleRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                change(IMiddleRight,ITopRight,IBottomRight,IMiddleCenter);
                judgment(ITopCenter,IBottomCenter,IMiddleCenter,ITopLeft,IBottomLeft,IMiddleLeft,ITopRight,IBottomRight,IMiddleRight);
            }
        });
    }

    //頂点がクリックされた時
    void change(JLabel label1, JLabel label2, JLabel label3){
        JLabel[] label = {label1, label2 ,label3};
        for (JLabel la:label){
            if(la.getText().equals("1")) la.setText("0"); else la.setText("1");
        }
    }

    //各辺の真ん中がクリックされた時
    void change(JLabel label1, JLabel label2, JLabel label3, JLabel label4){
        JLabel[] label = {label1, label2 ,label3, label4};
        for (JLabel la:label){
            if(la.getText().equals("1")) la.setText("0"); else la.setText("1");
        }
    }

    //中央がクリックされた時
    void change(JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5){
        JLabel[] label = {label1, label2 ,label3, label4, label5};
        for (JLabel la:label){
            if(la.getText().equals("1")) la.setText("0"); else la.setText("1");
        }
    }

    //正解しているかどうかの判定
    void judgment(JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5, JLabel label6, JLabel label7,JLabel label8, JLabel label9) {
        JLabel[] label = {label1, label2 ,label3, label4, label5, label6, label7, label8, label9};
        for (JLabel la:label){
            //一つでも0があれば正解ではない
            if(la.getText().equals("0")) return;
        }
        //正解時（いちどもifの処理が発生しなかった時）
        javax.swing.JOptionPane.showMessageDialog(
                panel1,                                         // コンテンツを配置しているペインコントロール
                "GameClear!!",                                  // メッセージ
                "3x3 LightsOut",                                // タイトル
                javax.swing.JOptionPane.INFORMATION_MESSAGE);   // ダイアログタイプ(ここは他にもエラーや警告表示などがある)
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new LightsOut().setVisible(true));
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new LightsOut().setVisible(true));
    }


}
