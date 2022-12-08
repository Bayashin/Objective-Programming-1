import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FuelExpenseCalcurator {
    public static void main(String[] args) {
        Random rand = new Random();
        car app = new car();
        double d=rand.nextDouble(35)+5;
        double scale = Math.pow(10, 2);
        double fuelEconomy =Math.round(d*scale)/scale;
        app.setFuelEfficiency(fuelEconomy);//5~40の燃費を作成
        System.out.println("燃費："+app.getFuelEfficiency());

        while (true){
            //走行距離を入力
            Scanner in = new Scanner(System.in);
            String inputLine = in.nextLine();

            if (Objects.equals(inputLine, "end")){//"end"を入力で終了
               return;
            }else {//走行距離を入力で計算、出力
                double mileage = Double.parseDouble(inputLine);//inputLineをdouble型に変換
                app.run(mileage);
                app.printInfo();
            }
        }
    }
}
