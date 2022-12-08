package jp.ac.ait.k21099;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CSVFileViewer {
    public static void main(String[] args) {
        String filepath = "src/jp/ac/ait/k21099/data.csv";
        Path path2 = Path.of(filepath);

        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, StandardCharsets.UTF_8))) {
            int linenum = 1;
            while (sc.hasNextLine()) {
                int colnum = 0;
                String[] cols = sc.nextLine().split(",", -1);
                System.out.printf("%d:\t",linenum);
                for (String datum : cols) {
                    colnum += 1; // 列番号は自分でインクリメントする
                    System.out.printf(colnum + ":" + datum + "\t");
                }
                System.out.print("\n");
                linenum ++;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
