package numerical.methods.descent;

import numerical.helpers.Matrix;

import static numerical.helpers.Matrix.*;

abstract public class QuickestDescent {
    Matrix A;
    Matrix B;
    Matrix X;

    public QuickestDescent(Matrix a, Matrix b, Matrix x) {
        A = a;
        B = b;
        X = x;
    }

    public void nextPoint() {
        X = add(X, mul(q(), nu(0)));
    }

    protected abstract Matrix q();

    public double f(Matrix X) {
        return add(mul(mul(mul(trans(X), A), X), 0.5), mul(trans(X), B)).getValue(0, 0);
    }

    public double nu(int k) {
        double top = mul(trans(q()), add(mul(A, X), B)).getValue(0,0);
        //double bot =
        return 0;
    }

}
