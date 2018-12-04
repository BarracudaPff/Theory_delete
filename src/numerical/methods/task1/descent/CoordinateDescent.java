package numerical.methods.task1.descent;

import numerical.methods.task1.helpers.Matrix;

import static numerical.methods.task1.helpers.Matrix.*;

public class CoordinateDescent {
    private static final double EPS = 10e-2;
    Matrix A;
    Matrix B;
    Matrix X;

    protected int iter;
    public int iCount;
    public CoordinateDescent(Matrix a, Matrix b) {
        A = a;
        B = b;
        double[][] values = new double[b.getRows()][1];
        values[0][0] = 1;
        X = Matrix.Generator.getFromValue(values);
    }



    public Matrix solve() {
        Matrix XOld;

        do {
            iCount++;
            XOld = X.clone();
            nextPoint();
            iter++;
            if (iter >= A.getRows())
                iter -= A.getRows();
        }
        while (Math.abs(f(X) - f(XOld)) > EPS);

        //System.out.println("f(X) is: " + f(X)+" for X="+X);
        return Matrix.mul(X,-1);
    }

    private void nextPoint() {
        X = add(X, mul(q(), nu()));
    }

    private double f(Matrix X) {
        return add(mul(mul(mul(trans(X), A), X), 0.5), mul(trans(X), B)).getValue(0, 0);
    }

    private double nu() {
        double top = scalMul(trans(q()), trans(add(mul(A, X), B)));
        double bot = scalMul(trans(q()), trans(mul(A, q())));
        return -top / bot;
    }

    private Matrix q() {
        double[][] values = new double[A.getCols()][1];
        values[iter][0] = 1;
        //System.out.println("q "+Generator.getFromValue(values));
        return Generator.getFromValue(values);
                //add(mul(A, Matrix.Generator.getFromValue(values)), B);
    }
}
