public class car {

    double fuelEfficiency=0;//燃費効率[km/L]
    double totalMileage=0;//累積走行距離[km]
    double expendedFuel=0;//消費燃料の累計[L]

    void setFuelEfficiency(double value){//fuelEfficiencyに引数のvalueを代入します
        fuelEfficiency = value;
    }
    double getFuelEfficiency(){//fuelEfficiencyを返す
        return fuelEfficiency;
    }

    double run(double mileage){//走行距離を引数で渡し、累計走行距離に加算、走行距離 / 燃費を消費燃料として消費燃料の累計に加算、今回の走行で消費した燃料を返します
        totalMileage += mileage;
        expendedFuel += mileage/fuelEfficiency;
        return mileage/fuelEfficiency;
    }

    void printInfo(){//標準出力に「走行距離:00.00km 消費燃料:00.00L」のように情報出力してください。
        System.out.println("走行距離："+totalMileage+"km 消費燃料："+expendedFuel+"L");
    }
}

