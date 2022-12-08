public class TrianglesCentroid {
    Point point1 = new Point();
    Point point2 = new Point();
    Point point3 = new Point();

    Point calc() {
        double dx = (point1.x + point2.x + point3.x) / 3.0;
        double dy = (point1.y + point2.y + point3.y) / 3.0;
        Point ret = new Point();
        ret.x = dx;
        ret.y = dy;
        return ret;
    }

}
