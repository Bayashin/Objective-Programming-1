import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class HttpGetter extends JFrame {
    private JPanel panel1;
    private JTextField txtURL;
    private JButton btnGet;
    private JTextArea txtHtml;
    private JButton btnSave;

    public HttpGetter() {
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 800, 600);

        // コンテンツパネル設定
        setContentPane(panel1);
        setTitle("HttpGetter");

        txtURL.setText("http://");

        //取得ボタン
        btnGet.addActionListener(e -> get());
        //保存ボタン
        btnSave.addActionListener(e -> saveTextFileActionPerformed());
    }

    //HTTPリクエストの発酵、レスポンスの表示
    void get() {
        String str = txtURL.getText();
        // デフォルト設定でHttpClientインスタンスを作成
        HttpClient client = HttpClient.newHttpClient();

        try {
            // ビルダーを使用してHttpRequestインスタンスを作成
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(str)).build();
            // リクエストを送信
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            // レスポンスボディを出力
            txtHtml.setText(response.body());
        } catch (NullPointerException | IllegalArgumentException | IOException | InterruptedException ex) {
            javax.swing.JOptionPane.showMessageDialog(
                    panel1,                                         // コンテンツを配置しているペインコントロール
                    "指定されたURLに接続できませんでした",                                  // メッセージ
                    "エラー",                                // タイトル
                    JOptionPane.ERROR_MESSAGE);   // ダイアログタイプ(ここは他にもエラーや警告表示などがある)
            ex.printStackTrace();
        }
    }

    /**
     * テキストファイル保存アクションイベント
     */
    private void saveTextFileActionPerformed() {

        JFileChooser jfc;
        // 画面上のファイルパスを取得
        String pathString = txtHtml.getText();
        if (pathString.isEmpty()) {
            // システムのホームディレクトリを初期パスとしてjavax.swing.JFileChooserを初期化
            jfc = new JFileChooser(System.getProperty("user.home"));
        } else {
            Path p = Path.of(pathString);
            // ファイルの親(ディレクトリ)を取得してその絶対パスを文字列化
            pathString = p.getParent().toAbsolutePath().toString();
            jfc = new JFileChooser(pathString);
        }

        // 開いたファイルを格納するオブジェクトを用意
        File f = null;

        // ダイアログを開き、戻り値を取得
        int selected = jfc.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION -> f = jfc.getSelectedFile();
            case JFileChooser.CANCEL_OPTION -> JOptionPane.showMessageDialog(this, "キャンセル");
            default -> // case JFileChooser.ERROR_OPTION: でも良い
                    JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
        }

        if (f != null) {
            // 書き込み対象をBufferedWriterで開く
            try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), Charset.defaultCharset())) {
                // テキスト領域から文字列を読み込み(Scannerを使用するパターン)
                Scanner sc = new Scanner(txtHtml.getText());
                while (sc.hasNextLine()) {
                    bw.append(sc.nextLine());
                    bw.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
            }
        }
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> new HttpGetter().setVisible(true));
    }

}
