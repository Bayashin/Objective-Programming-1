public class Point {
    double x = 0.0;
    double y = 0.0;

    String getPrintString() {
        return "(" +
                String.format("%.2f", x) +
                "," +
                String.format("%.2f", y) +
                ")";
    }
}
