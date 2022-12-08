package jp.ac.ait.k21099;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AichiTouristSpot {

    public static List<Datum> getList(Path path, int option){ //option:c200328.csvの時1
        double ait_latitude = 35.1834122, ait_longitude = 137.1130419; //愛工大の緯度経度
        List<Datum> data = new ArrayList<>();
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("ms932")))) {
            int linenum = 1; //現在見ている行
            while (sc.hasNextLine()) {
                String[] cols = sc.nextLine().split(",", -1);
            if (linenum != 1) { //偉業目ではない時
                String str;
                double latitude, longitude, distance; //緯度、経度、愛工大からの距離
                int index1 = cols[1].indexOf('('), index2 = cols[1].indexOf(' '),index3 = cols[1].indexOf(')'); //緯度、経度を区切る文字が何文字目かを判定
                str = cols[1].substring(index1 + 1, index2); //経度を示すstring取得
                longitude = Double.parseDouble(str); //経度
                str = cols[1].substring(index2 + 1, index3); //緯度を示すstring取得
                latitude = Double.parseDouble(str); //緯度
                distance = Math.sqrt(Math.pow(latitude - ait_latitude, 2) + Math.pow(longitude - ait_longitude, 2)); //愛工大からの距離を求める
                if (option == 1) str = cols[2]; //c200328.csvの時だけデータ名の場所が違う
                else str = cols[3];
                data.add(new Datum(latitude, longitude, distance, str)); //listに追加
            }

            linenum++;

            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return data;
    }

    public static void main(String[] args) {
        String filepath1 = "src/jp/ac/ait/k21099/c200326.csv";
        String filepath2 = "src/jp/ac/ait/k21099/c200328.csv";
        String filepath3 = "src/jp/ac/ait/k21099/c200329.csv";
        String filepath4 = "src/jp/ac/ait/k21099/c200330.csv";
        Path path1 = Path.of(filepath1);
        Path path2 = Path.of(filepath2);
        Path path3 = Path.of(filepath3);
        Path path4 = Path.of(filepath4);
        List<Datum> data = new ArrayList<>();
        data.addAll(getList(path1,0));
        data.addAll(getList(path2,1));
        data.addAll(getList(path3,0));
        data.addAll(getList(path4,0));

        List<Datum> dataV1 = new ArrayList<>(data);
        dataV1.sort(Comparator.comparingDouble(Datum::getDistance));

        List<Datum> dataV2 = new ArrayList<>(dataV1);
        for (Datum d:dataV2){
            dataV1.removeIf(d_target -> d.getName().equals(d_target.getName()) && d.getDistance()<d_target.getDistance());
            }

        dataV2 = new ArrayList<>(dataV1);

        for (int i=0; i< dataV2.size()-1; i++){
            if( dataV2.get(i).getName().equals(dataV2.get(i+1).getName())){
                dataV1.remove(dataV2.get(i+1));
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/jp/ac/ait/k21099/TouristSpot.csv"), Charset.defaultCharset())) {
            bw.write("緯度情報,経度情報,愛工大からの距離,データ名");
            bw.newLine();
            for (Datum d: dataV1) { //csvファイルにデータを格納
                bw.write(String.format("%.10f",d.getLatitude())+","+String.format("%.10f",d.getLongitude())+","+String.format("%.10f",d.getDistance())+","+d.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
