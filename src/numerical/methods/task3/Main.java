package numerical.methods.task3;

import javafx.util.Pair;
import lib.com.polynom.polynom.Polynom;
import numerical.methods.task2.helpers.Function;
import numerical.methods.task3.helpers.*;
import numerical.methods.task3.method.LeastSquares;
import numerical.methods.task3.method.PolLegendre;

import static java.lang.Math.abs;

public class Main {

    private static final int COUNT = 5;
    private static final double A = 1;
    private static final double EPS = 10e-6;

    public static void main(String[] args) {
        Function function = new Function17();
        test1(function);
        test2(function);
    }

    private static void test1(Function f) {
        double[] x = comPoints();
        double[] y = new double[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = f.f(x[i]);
        }
        LeastSquares leastSquares = new LeastSquares(x, y);
        System.out.println("===========================================================================");
        System.out.println(leastSquares.getPol());
        System.out.println("Max is " + getMaxR(f, leastSquares.getPol()).getKey()
                + " in " + getMaxR(f, leastSquares.getPol()).getValue() + ".");
    }

    private static void test2(Function f) {
        PolLegendre legendre = new PolLegendre(f, A, -A);
        System.out.println("===========================================================================");
        System.out.println(legendre.getPol(3).round());
        System.out.println("Max is " + getMaxR(f, legendre.getPol(3)).getKey()
                + " in " + getMaxR(f, legendre.getPol(3)).getValue() + ".");
    }

    private static Pair<Double, Double> getMaxR(Function f, Polynom leastSquares) {
        double max = Double.MIN_VALUE;
        double point = -A;
        for (double i = -A; i <= A; i += EPS) {
            if (abs(leastSquares.valueOf(i) - f.f(i)) > max) {
                max = abs(leastSquares.valueOf(i) - f.f(i));
                point = i;
            }
        }

        return new Pair<>(max, point);
    }

    private static double[] comPoints() {
        int j = 0;
        double[] res = new double[COUNT];
        for (double i = -A; i <= A; i += 2 * A / (COUNT - 1)) {
            res[j] = i;
            j++;
        }

        return res;
    }
}
