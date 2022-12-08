public class Calculator {
    public static void main(String[] args) {
        TrianglesCentroid tc = new TrianglesCentroid();
        tc.point1.x = 0.0;
        tc.point1.y = 0.0;
        System.out.println("p1:" + tc.point1.getPrintString());
        tc.point2.x = 2.0;
        tc.point2.y = 2.0;
        System.out.println("p2:" + tc.point2.getPrintString());
        tc.point3.x = 2.0;
        tc.point3.y = -2.0;
        System.out.println("p3:" + tc.point3.getPrintString());
        
        Point answer = tc.calc();
        System.out.println("３点の重心点は" + answer.getPrintString());
    }
}
