package numerical.methods;

import numerical.helpers.Matrix;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static numerical.helpers.Matrix.MAX_RANDOM_VALUE;
import static numerical.helpers.Matrix.MIN_RANDOM_VALUE;

public class CoordinateDescent implements Method {
    private Matrix A, B;
    private Matrix X, XNew;
    private int size;

    public CoordinateDescent(Matrix a, Matrix b) {
        A = a;
        B = b;
        size = A.getRows();
    }

    /**
     * Minimize function AX-B=0
     *
     * @return // TODO: 05.11.2018
     */

    @Override
    public Matrix solve() {
        X = getRandomPoint();

        for (int j = 0; j < 10; j++) {
            if (Matrix.oneNorm(Matrix.minus(Matrix.mul(A, X), B)) < 0.01) {
                System.out.println("Pre stop");
                return X;
            }
            for (int i = 0; i < 2; i++) {
                double v = dix(i);
                X.setValue(i, 0, v);
            }
            System.out.println(X);
        }

        return X;
    }

    private double dix(int pos) {
        double a = -100d, b = 100d, c;
        while (b - a > EPSILON) {
            c = (a + b) / 2;
            if (fNorm(pos, c - EPSILON) * fNorm(pos, c + EPSILON)>0)
                b = c;
            else
                a = c;
        }
        return (a + b) / 2;
    }

    @Deprecated
    void f2() {
        X = Matrix.minus(X, Matrix.mul(Matrix.add(Matrix.mul(A, X), B), 0.1));
    }

    @Deprecated
    private double f(int pos, double j) {
        X.setValue(pos, 0, j);
        return Matrix.mul(Matrix.mul(Matrix.mul(Matrix.trans(X), A), X), 0.5d).getValue(0, 0)
                + Matrix.mul(Matrix.trans(B), X).getValue(0, 0);
    }

    private double fNorm(int pos, double j) {
        X.setValue(pos, 0, j);
        return Matrix.oneNorm(Matrix.minus(Matrix.mul(A, X), B));
    }

    private Matrix getRandomPoint() {
        double[] x = new double[size];
        for (int i = 0; i < x.length; i++) {
            x[i] = ThreadLocalRandom.current().nextDouble(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        }
        return Matrix.Generator.getFromValueCol(x);
    }

    public static class Builder implements javafx.util.Builder<CoordinateDescent> {
        private Matrix A, B;

        public CoordinateDescent.Builder setA(Matrix a) {
            A = a;
            return this;
        }

        public CoordinateDescent.Builder setB(Matrix b) {
            B = b;
            return this;
        }

        @Override
        public CoordinateDescent build() {
            return new CoordinateDescent(A, B);
        }
    }
}
