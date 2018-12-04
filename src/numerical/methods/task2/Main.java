package numerical.methods.task2;

import javafx.util.Pair;
import numerical.methods.task2.first.InterpolErm;
import numerical.methods.task2.first.InterpolLagr;
import numerical.methods.task2.helpers.*;

import java.util.Arrays;

public class Main {
    static int n = 3;
    static double a = 5;
    static double st = -a;
    static double en = a;

    public static void main(String[] args) {
        //test2();

        //Function function = new Function3Point().setX(new double[]{-2, 0, 2}).setY(new double[]{-0.4, -0.5, -0.4});
        Function function = new Function10();
        InterpolErm interpolLagr = new InterpolErm(function, a, n);
        System.out.println(interpolLagr.com2());
    }

    private static void test2() {
        Function function = new Function10();
        InterpolErm interpolLagr = new InterpolErm(function, a, n);
        System.out.println(Arrays.toString(interpolLagr.getPoints()));
        System.out.println(interpolLagr.com());
        System.out.println(getMaxPairStr(interpolLagr.maximumDeviation()));
    }

    private static void test1() {
        Function10 function = new Function10();
        InterpolLagr interpolLagr = new InterpolLagr(function, n, a);
        System.out.println(interpolLagr.com());
        Pair pair = interpolLagr.maximumDeviation();
        System.out.println("Max value is: " + pair.getKey() + "; Point is: " + pair.getValue());

        /*InterpolLagr interpolCh = new InterpolLagr(function, n, a);
        interpolCh.setPoints(new double[]{-5.5, -2.3, 2.3, 5.5});
        System.out.println(interpolCh.com());*/

        System.out.println("################################################################################");

        Function10 function2 = new Function10();
        InterpolLagr interpolLagr2 = new InterpolLagr(function2, n, a);
        System.out.println(interpolLagr2.comh());
        Pair pair2 = interpolLagr2.maximumDeviation();
        System.out.println("Max value is: " + pair2.getKey() + "; Point is: " + pair2.getValue());

        /*InterpolLagr interpolCh2 = new InterpolLagr(function2, n, a);
        interpolCh2.setPoints(new double[]{-5.5, -2.3, 2.3, 5.5});
        System.out.println(interpolCh2.comh());*/
    }

    private static String getMaxPairStr(Pair pair) {
        return ("Max value is: " + pair.getKey() + "; Point is: " + pair.getValue());
    }
}
