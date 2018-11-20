package numerical.methods.ТолькоДляРыжих;

import numerical.helpers.Matrix;

import java.util.Arrays;

public class Main {
    private static double[][] A, B, X;

    public static void main(String[] args) {
        A = new double[][]{
                new double[]{8508, -3393, 1042, -8264},
                new double[]{-3393, 10312, -5891, 9242},
                new double[]{1042, -5891, 3541, -4021},
                new double[]{-8264, 9242, -4021, 23011}
        };
        B = new double[][]{
                new double[]{-1813330},
                new double[]{2020092},
                new double[]{-961645},
                new double[]{3608176}
        };
        X = new double[][]{
                new double[]{0.9671},
                new double[]{-0.1123},
                new double[]{1.2667}
        };

        testMNPS();
        testZeidel();
    }

    public static void testZeidel() {
        Zeidel zeidel = new Zeidel();
        double[] results = zeidel.solve(A, B);
        System.out.println("A:");
        System.out.println(Arrays.deepToString(A));
        System.out.println("B:");
        System.out.println(Arrays.deepToString(B));
        System.out.println("X from Zeidel:");
        System.out.println(Arrays.toString(results));
    }

    public static void testMNGS() {
        MNGS mngs = new MNGS(A,B);

        double[][] results = mngs.solve(A, B);
        System.out.println("A:");
        System.out.println(Arrays.deepToString(A));
        System.out.println("B:");
        System.out.println(Arrays.deepToString(B));
        System.out.println("X from Zeidel:");
        System.out.println(Arrays.deepToString(results));
    }

    public static void testMNPS() {
        MNPS mnps = new MNPS(A,B);

        double[][] results = mnps.solve(A, B);
        System.out.println("A:");
        System.out.println(Arrays.deepToString(A));
        System.out.println("B:");
        System.out.println(Arrays.deepToString(B));
        System.out.println("X from Zeidel:");
        System.out.println(Arrays.deepToString(results));
    }
}
