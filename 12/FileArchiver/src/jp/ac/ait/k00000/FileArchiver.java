package jp.ac.ait.k00000;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileArchiver {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        String zipFile;
//        String filepath = "12-01-バイナリファイルの入出力.html";
//        String filepath2 = "12-02-オブジェクトの直列化.html";
//        String filepath3 = "hogehoge.txt";
////        String filepath3 = "html"
//        list.add(filepath);
//        list.add(filepath2);
//        list.add(filepath3);
//        zipFile = "test.zip";

        Scanner in = new Scanner(System.in);
        System.out.println("圧縮するファイルの入力,endで完了");
        while(true){
            String fileName = in.nextLine();
            if (fileName.equals("end")) break;
            list.add(fileName);
        }
        if (list.size() == 1){
            zipFile = list.get(0)+".zip";
        }else {
            System.out.println("圧縮ファイル名の入力(〇〇〇.zip)");
            zipFile = in.nextLine();
        }
            FileArchiver.createZip(list, zipFile);
    }

    static void createZip(List<String> list, String zipFile){
        try(
                FileOutputStream fos = new FileOutputStream(zipFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ZipOutputStream zos = new ZipOutputStream(bos);
        ) {
            for (String str: list){
                Path path = Path.of(str);
                byte[] data1 = Files.readAllBytes(path);
                ZipEntry zip1 = new ZipEntry(str);
                zos.putNextEntry(zip1);
                zos.write(data1);
                System.out.println(str);
            }
        }catch (IOException e) {
            System.out.println("存在しないファイル、またはディレクトリです");
        }
    }
}
