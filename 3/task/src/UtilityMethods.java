public class UtilityMethods {
    //1-1
    void printCurrency(double value) {
        System.out.printf("%.2f\n", value);
    }

    //1-2
    int add(int value, int value2) {
        return value + value2;
    }

    //1-3
    double division(int value, int value2) {
        return 1.0* value / value2;
    }

    //1-4
    String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
        }
        return "42";
    }

    public static void main(String[] args) {
        UtilityMethods app = new UtilityMethods();

        System.out.println("1-1 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        app.printCurrency(232323.345323);
        app.printCurrency(232323);
        app.printCurrency(-22.0961);

        System.out.println("1-2 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(app.add(3, 5));
        System.out.println(app.add(943, 87645));
        System.out.println(app.add(-56352, -534242));
        System.out.println(app.add(10000, 200));

        System.out.println("1-3 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(app.division(3, 5));
        System.out.println(app.division(943453, 87));
        System.out.println(app.division(-56352, -534242));
        System.out.println(app.division(933, 1));

        System.out.println("1-4 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());
    }
}