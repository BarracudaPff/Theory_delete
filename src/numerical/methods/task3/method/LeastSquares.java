package numerical.methods.task3.method;

import lib.com.polynom.polynom.Polynom;
import numerical.methods.task1.Gauss;
import numerical.methods.task1.helpers.Matrix;

public class LeastSquares {
    private double[] x;
    private double[] y;

    private int n;

    public LeastSquares(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        n = x.length;
    }

    public Polynom getPol() {
        Matrix matrixCoef = getCoef();

        double[] coef = new double[matrixCoef.getRows()];
        for (int i = 0; i < coef.length; i++) {
            coef[i] = matrixCoef.getValue(i, 0);
        }
        reverse(coef);

        return new Polynom(coef);
    }

    private void reverse(double[] validData) {
        for (int i = 0; i < validData.length / 2; i++) {
            double temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
    }

    private Matrix getCoef() {
        Matrix A = Matrix.Generator.getFromValue(new double[][]{
                new double[]{getXXXXXX(), getXXXXX(), getXXXX(), getXXX()},
                new double[]{getXXXXX(), getXXXX(), getXXX(), getXX()},
                new double[]{getXXXX(), getXXX(), getXX(), getX()},
                new double[]{getXXX(), getXX(), getX(), n}
        });

        Matrix B = Matrix.Generator
                .getFromValueCol(new double[]{getYXXX(), getYXX(), getYX(), getY()});

        return new Gauss.Builder().setA(A).setB(B).build().solve();
    }

    private double getX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i];
        }
        return sum;
    }

    private double getXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * x[i];
        }
        return sum;
    }

    private double getXXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * x[i] * x[i];
        }
        return sum;
    }

    private double getXXXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * x[i] * x[i] * x[i];
        }
        return sum;
    }

    private double getXXXXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * x[i] * x[i] * x[i] * x[i];
        }
        return sum;
    }

    private double getXXXXXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * x[i] * x[i] * x[i] * x[i] * x[i];
        }
        return sum;
    }

    private double getY() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += y[i];
        }
        return sum;
    }

    private double getYX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += y[i] * x[i];
        }
        return sum;
    }

    private double getYXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += y[i] * x[i] * x[i];
        }
        return sum;
    }

    private double getYXXX() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += y[i] * x[i] * x[i] * x[i];
        }
        return sum;
    }
}
