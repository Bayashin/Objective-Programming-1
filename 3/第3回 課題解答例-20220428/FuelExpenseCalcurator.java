import java.util.Scanner;

public class FuelExpenseCalcurator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Car mycar = new Car();
        mycar.fuelEfficiency = 20.0;  // 燃費を20.0に設定(ここは標準入力から入力させても良い)

        System.out.println("走行距離を続けて改行区切りで入力してください。(endを入力すると終了します。)");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("end")) return;

            mycar.run(Double.parseDouble(line));
            mycar.printInfo();
        }
    }
}
