import java.util.*;
import java.awt.geom.*;

public class BasicAssign3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        double y = scan.nextDouble();


        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        double dist = line.ptSegDist(x, y);

        if (dist == 0.0) {
            System.out.print("Yes\n");
        }
        else {
            System.out.print("No\n");
        }
    }
}