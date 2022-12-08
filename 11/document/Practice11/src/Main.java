import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // データをPersonのインスタンスでリスト化したもの
        var people = new ArrayList<Person>();

        // 読み込み処理
        try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of("dummy-data.csv")))) {
            if (sc.hasNextLine()) sc.nextLine(); // ①行目は列の情報が入るので読んで捨てる
            while (sc.hasNextLine()) { // ②行目以降が入ります
                String line = sc.nextLine(); // 変数に1行読み込んでおく
                String[] cols = line.split(",", -1);
                int colNo = 1;
                Person p = new Person();

                for (String cell : cols) {
                    // 1行のデータの中から、各列のデータを１つづつ取り出している
                    // System.out.println(cell);
                    switch (colNo) {
                        case 1: p.setLname(cell); break;
                        case 2: p.setFname(cell); break;
                        case 3: p.setLname_kana(cell); break;
                        case 4: p.setFname_kana(cell); break;
                        case 5: p.setSeibetsu(cell); break;
                        case 6: p.setPostal_code(cell); break;
                        case 7: p.setJuusho1(cell); break;
                        case 8: p.setJuusho2(cell); break;
                        case 9: p.setTel_no(cell); break;
                        default: p.setKetsuekigata(cell); break;
                    }
                    // 次の列番号にする
                    colNo += 1;
                }
                people.add(p);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        // データの読み取りが完了したかを確認
        // people.stream().forEach(System.out::println);

        // 書き込み処理

        // 出力データは男でかつO型のみ
        var output = people.stream()
                .filter(person -> ( person.getSeibetsu().equals("男")
                                     && person.getKetsuekigata().equals("O"))
        ).collect(Collectors.toList()); // リスト化の処理を噛ます

        // ソート
        output.sort(Comparator.comparing(Person::getNameKana));

        output.stream().forEach(System.out::println);

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("out.csv"))) {
            for (Person p : output) {
                System.out.println(p.getCSVLine());
                bw.write(p.getCSVLine());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
