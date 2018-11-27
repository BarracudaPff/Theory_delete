package numerical.methods.task1.ТолькоДляРыжих;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static double[][] A, B, X;
    private static int MIN_RANDOM_VALUE = -100;
    private static int MAX_RANDOM_VALUE = 100;

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

        System.out.println(Arrays.deepToString(randomMatrix(3)));
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
        MNGS mngs = new MNGS(A, B);

        double[][] results = mngs.solve(A, B);
        System.out.println("A:");
        System.out.println(Arrays.deepToString(A));
        System.out.println("B:");
        System.out.println(Arrays.deepToString(B));
        System.out.println("X from Zeidel:");
        System.out.println(Arrays.deepToString(results));
    }

    public static void testMNPS() {
        MNPS mnps = new MNPS(A, B);

        double[][] results = mnps.solve(A, B);
        System.out.println("A:");
        System.out.println(Arrays.deepToString(A));
        System.out.println("B:");
        System.out.println(Arrays.deepToString(B));
        System.out.println("X from Zeidel:");
        System.out.println(Arrays.deepToString(results));
    }

    private static double[][] randomMatrix(int size) {
        double[][] generate = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                generate[i][j] = ThreadLocalRandom.current().nextDouble(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            }
        }

        return mul(generate, trans(generate));
    }

    private static double[][] mul(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                c[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < a.length; i++) { // aRow
            for (int j = 0; j < b[0].length; j++) { // bColumn
                for (int k = 0; k < a[0].length; k++) { // aColumn
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    public static double[][] trans(double[][] a) {
        double[][] temp = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                temp[j][i] = a[i][j];

        return temp;
    }
}
