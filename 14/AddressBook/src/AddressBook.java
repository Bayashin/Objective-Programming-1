import javax.swing.*;
import java.awt.*;

public class AddressBook extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JList<String> list1;
    private JButton saveButton;

    ListModel<String> model = list1.getModel();

    public AddressBook(){
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 400, 300);

        // コンテンツパネル設定
        setContentPane(panel1);
        setTitle("AddressBook ");
        addButton.addActionListener(e -> addList());
    }

    void addList(){
        String name = textField1.getText();
        String phone = textField2.getText();
        model.addListDataListener(name + ":" + phone);
        list1.ensureIndexIsVisible(model.getSize());
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new AddressBook().setVisible(true));
    }

}
