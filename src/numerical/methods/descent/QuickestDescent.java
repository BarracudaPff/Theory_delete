package numerical.methods.descent;

import numerical.helpers.Matrix;

import static numerical.helpers.Matrix.*;

abstract public class QuickestDescent {
    private static final double EPS = 10e-4;
    Matrix A;
    Matrix B;
    Matrix X;

    protected QuickestDescent(Matrix a, Matrix b) {
        A = a;
        B = b;
        double[][] values = new double[b.getRows()][1];
        values[0][0] = 1;
        X = Matrix.Generator.getFromValue(values);
    }

    public Matrix solve() {
        Matrix XOld;

        do {
            XOld = X.clone();
            System.out.println("f(X) is: " + f(X));
            nextPoint();
        }
        while (Math.abs(f(X) - f(XOld)) > EPS);

        return X;
    }

    private void nextPoint() {
        X = add(X, mul(q(), nu()));
    }

    protected abstract Matrix q();

    private double f(Matrix X) {
        return add(mul(mul(mul(trans(X), A), X), 0.5), mul(trans(X), B)).getValue(0, 0);
    }

    private double nu() {
        double top = scalMul(trans(q()), trans(add(mul(A, X), B)));
        double bot = scalMul(trans(q()), trans(mul(A, q())));
        return -top / bot;
    }

}
