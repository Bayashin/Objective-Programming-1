package jp.ac.ait.k21099;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class JpegCrasher {
    public static void main(String[] args) throws IOException {
        crash("Baboon.jpg", "Baboon_out.jpg", 15);
    }
    /**
     * 入力されたファイルのランダムな1Byteをランダムな1bit加算で置き換えることでファイルをクラッシュさせる
     */
    public static void crash(String input_filePath, String output_filePath, int challenge) throws IOException {
        byte[] input;
        try {
            input = Files.readAllBytes(Path.of(input_filePath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }


        byte[] out = input.clone();

        byte[] bits = {
                (byte)0b00000001,
                (byte)0b00000010,
                (byte)0b00000100,
                (byte)0b00001000,
                (byte)0b00010000,
                (byte)0b00100000,
                (byte)0b01000000,
                (byte)0b10000000
        };

        for (int i=0; i<challenge; i++) {
            // ランダムな1ビットだけのデータを取得する
            byte value = bits[new Random().nextInt(bits.length)];
            // 1bitの値を加算して0xFFでAND演算することで1bitの変化を加える
            int randomIndex = new Random().nextInt(out.length);
            out[randomIndex] = (byte)((int)out[randomIndex] + (int)value & 0xFF);
        }

        Files.write( Path.of(output_filePath), out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}
