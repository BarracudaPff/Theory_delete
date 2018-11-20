package numerical;

import numerical.helpers.Matrix;
import numerical.methods.descent.CoordinateDescent;
import numerical.methods.Method;
import numerical.methods.descent.GradientDescent;

import static numerical.helpers.Matrix.*;

public class Main {
    static int size = 2;

    public static void main(String[] args) {

        test3();

    }

    static void test3() {
        Matrix A = Matrix.Generator.getFromValue(new double[][]{
                new double[]{2, 1},
                new double[]{1, 2}
        });
        Matrix B = Matrix.Generator.getFromValue(new double[][]{
                new double[]{-2},
                new double[]{1},
        });

        GradientDescent descent = new GradientDescent(A, B);
        System.out.println(descent.solve());
    }

    static void test2() {
        Matrix A = Matrix.Generator.getFromValue(new double[][]{
                new double[]{13, 14, 0},
                new double[]{14, -13, 0},
                new double[]{0, 0, 15}
        });
        Matrix X = Matrix.Generator.getFromValue(new double[][]{
                new double[]{0.9671},
                new double[]{-0.1123},
                new double[]{1.2667}});
        Matrix B = mul(A, X);

        System.out.println(A);
        System.out.println(B);
        System.out.println(X);
    }

    static void test1() {
        Matrix A = Matrix.Generator.getRandomSymmetric(size);
        Matrix X = Matrix.Generator.getRandom(size, 1);
        Matrix B = mul(A, X);

        System.out.println(A);
        System.out.println(B);
        System.out.println(X);
    }
}
