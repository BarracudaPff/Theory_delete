package numerical.methods.ТолькоДляРыжих;

import numerical.helpers.Matrix;

public class Zeidel {
    double EPSILON = 10e-8;

    public double[] solve(double[][] A, double[][] B) {
        if (B[0].length != 1)
            throw new IllegalArgumentException("B cols count must be 1");

        int size = A.length;
        double[] x = new double[size];
        double[] p = new double[size];
        do {
            for (int i = 0; i < size; i++) {
                double var = 0;
                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        var += (A[i][j] * x[j]);
                    }
                }
                p[i] = x[i];
                x[i] = (B[i][0] - var) / A[i][i];
            }
        } while (!converge(x, p));

        return x;
    }

    private boolean converge(double[] xk, double[] xkp) {
        for (int i = 0; i < xk.length; i++) {
            if (Math.abs(xk[i] - xkp[i]) >= EPSILON) {
                return false;
            }
        }
        return true;
    }
}
