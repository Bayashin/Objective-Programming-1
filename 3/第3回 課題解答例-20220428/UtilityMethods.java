class UtilityMethods {

    // 2-1. 浮動小数点型の数値を0.00形式でフォーマットして画面出力するメソッド
    void printCurrency(double d) {
        System.out.printf("%.2f\n", d);
    }

    // 2-2. 整数値加算メソッド
    int add(int value1, int value2) {
        return value1 + value2;
    }

    // 2-3. 整数値同士の除算メソッド
    double division(int value1, int value2) {
        return (double)value1 / (double)value2;
    }

    // 2-4. 生命、宇宙、そして万物についての究極の疑問の答えメソッド
    String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        try{
            Thread.sleep(750);
        }catch(InterruptedException e){}
        return "42";
    }

    // 動作確認
    public static void main(String[] args) {
        UtilityMethods app = new UtilityMethods();

        System.out.println("2-1");
        app.printCurrency(1.2345);
        app.printCurrency(123456789.0000001);
        app.printCurrency(1);
        app.printCurrency(Math.PI);

        System.out.println();
        System.out.println("2-2");
        System.out.println(app.add(1, 1));  //2
        System.out.println(app.add(1, -1)); //0
        System.out.println(app.add(99999999, 1));  //100000000

        System.out.println();
        System.out.println("2-3");
        System.out.println(app.division(10, 3));    //3.333333333.....
        System.out.println(app.division(1, 2));     //0.5
        System.out.println(app.division(3, 4));     //0.75

        System.out.println();
        System.out.println("2-4");
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());

    }

}
