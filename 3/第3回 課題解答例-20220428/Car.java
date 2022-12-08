public class Car {

    double fuelEfficiency = 0.0;
    double totalMileage = 0.0;
    double expendedFuel = 0.0;

    double run(double mileage) {

        // 累計走行距離に加算
        totalMileage += mileage;

        // 消費燃料を計算
        double fuel = mileage / fuelEfficiency;

        // 累計消費燃料に加算
        expendedFuel += fuel;

        return fuel;
    }

    void printInfo() {
        System.out.println("走行距離:" + totalMileage + "km 消費燃料:" + expendedFuel + "L");
    }

}
