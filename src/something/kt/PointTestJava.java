package something.kt;

/**
 * Author： fanyafeng
 * Data： 2020-02-26 09:51
 * Email: fanyafeng@live.cn
 */
public class PointTestJava {
    public static void main(String[] args) {
        Point point = new Point();
        Point point1 = new Point(3);
        Point point2 = new Point(4, 5);
        System.out.println(point.getX());
//        改为val类似于final
//        point.setY();
        point.setX(6);
    }
}
