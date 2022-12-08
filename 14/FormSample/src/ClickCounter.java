import javax.swing.*;
import java.awt.*;

public class ClickCounter extends JFrame{
    private JPanel panel1;
    private JLabel ICounter;
    private JButton Decriment;
    private JButton Incriment;
    private JButton Reset;

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new ClickCounter().setVisible(true);
        });
    }
}
