package numerical.methods.task1.ТолькоДляРыжих;

import java.util.Arrays;

import static numerical.methods.task1.helpers.Matrix.mul;

public class MNPS {
    private static final double EPS = 10e-4;
    double[][] A;
    double[][] B;
    double[][] X;

    protected int iter;

    public MNPS(double[][] a, double[][] b) {
        A = a;
        B = b;
    }

    public double[][] solve(double[][] A, double[][] B) {
        X = new double[B.length][1];
        X[0][0] = 1;
        double[][] XOld;
        System.out.println(Arrays.deepToString(q()));


        do {
            XOld = X.clone();
            System.out.println("f(X) is: " + f(X));
            nextPoint();
            iter++;
            if (iter >= A[0].length)
                iter -= A[0].length;
        }
        while (Math.abs(f(X) - f(XOld)) > EPS);

        return X;
    }

    private void nextPoint() {
        X = add(X, mul(q(), nu()));
    }

    private double[][] q() {
        double[][] values = new double[A[0].length][1];
        values[iter][0] = 1;
        return values;
    }

    private double f(double[][] X) {
        return add(mul(mul(mul(trans(X), A), X), 0.5), mul(trans(X), B))[0][0];
    }

    private double nu() {
        double top = scal(trans(q()), trans(add(mul(A, X), B)));
        double bot = scal(trans(q()), trans(mul(A, q())));
        return -top / bot;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    private double scal(double[][] a, double[][] b) {
        double value = 0;

        for (int i = 0; i < a[0].length; i++) {
            value += a[0][i] * b[0][i];
        }

        return value;
    }

    public static double[][] mul(double[][] a, double v) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] *= v;
            }
        }
        return a;
    }

    private double[][] mul(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                c[i][j] = 0;
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

    private double[][] add(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    private double norm(double[][] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum += a[i][j] * a[i][j]; // compute the column sum
            }
        }

        return Math.sqrt(sum);
    }

    public static double[][] trans(double[][] a) {
        double[][] temp = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                temp[j][i] = a[i][j];

        return temp;
    }
}
