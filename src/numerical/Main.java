package numerical;

import numerical.helpers.Matrix;
import numerical.methods.CoordinateDescent;
import numerical.methods.Gauss;
import numerical.methods.Method;
import numerical.methods.Zeidel;
import numerical.methods.descent.GradientDescent;
import numerical.methods.descent.QuickestDescent;

import static numerical.helpers.Matrix.*;

public class Main {
    static int size = 2;

    public static void main(String[] args) {

        test3();

    }

    static void test3() {
        //Matrix A = Matrix.Generator.getRandomSymmetric(4);
        //Matrix X = Matrix.Generator.getRandom(4, 1);
        //Matrix B = mul(A, X);
        Matrix A = Matrix.Generator.getFromValue(new double[][]{
                new double[]{2, 1},
                new double[]{1, 2}
        });
        Matrix X = Matrix.Generator.getFromValue(new double[][]{
                new double[]{1},
                new double[]{0},
        });
        Matrix B = Matrix.Generator.getFromValue(new double[][]{
                new double[]{-2},
                new double[]{1},
        });

        GradientDescent descent = new GradientDescent(A, B, X);
        System.out.println(descent.q());
        System.out.println(descent.f(X));
        System.out.println();
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

        Method coord = new CoordinateDescent.Builder()
                .setA(A)
                .setB(B)
                .build();
        Matrix XXXNew = coord.solve();
        System.out.println(XXXNew);
    }

    static void test1() {
        Matrix A = Matrix.Generator.getRandomSymmetric(size);
        Matrix X = Matrix.Generator.getRandom(size, 1);
        Matrix B = mul(A, X);

        System.out.println(A);
        System.out.println(B);
        System.out.println(X);

        Method coord = new CoordinateDescent.Builder()
                .setA(A)
                .setB(B)
                .build();
        Matrix XXXNew = coord.solve();
        System.out.println(XXXNew);
        System.out.println(Matrix.oneNorm(Matrix.minus(mul(A, XXXNew), B)));
        System.out.println(Matrix.minus(mul(A, XXXNew), B));
    }
}
