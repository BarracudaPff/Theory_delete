package numerical.methods;

import numerical.helpers.Matrix;

public class Zeidel implements Method {
    private Matrix A, B;

    public Zeidel(Matrix a, Matrix b) {
        A = a;
        B = b;
    }

    @Override
    public Matrix solve() {
        if (A == null || B == null || !Matrix.isMulable(A, B))
            throw new IllegalArgumentException("Error in matrix A and B");
        if (B.getCols() != 1)
            throw new IllegalArgumentException("B cols count must be 1");

        int size = A.getRows();
        double[] x = new double[size];
        double[] p = new double[size];
        do {
            for (int i = 0; i < size; i++) {
                double var = 0;
                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        var += (A.getValue(i,j) * x[j]);
                    }
                }
                p[i] = x[i];
                x[i] = (B.getValue(i,0) - var) / A.getValue(i,i);
            }
        } while (!converge(x, p));

        return Matrix.Generator.getFromValueCol(x);
    }

    private boolean converge(double[] xk, double[] xkp) {
        for (int i = 0; i < xk.length; i++) {
            if (Math.abs(xk[i] - xkp[i]) >= EPSILON) {
                return false;
            }
        }
        return true;
    }

    public static class Builder implements javafx.util.Builder<Zeidel> {
        private  Matrix A, B;

        public Zeidel.Builder setA(Matrix a) {
            A = a;
            return this;
        }

        public Zeidel.Builder setB(Matrix b) {
            B = b;
            return this;
        }

        @Override
        public Zeidel build() {
            return new Zeidel(A,B);
        }
    }
}
