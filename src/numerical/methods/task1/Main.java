package numerical.methods.task1;

import numerical.methods.task1.helpers.Matrix;
import numerical.methods.task1.descent.CoordinateDescent;
import numerical.methods.task1.descent.GradientDescent;

import static numerical.methods.task1.helpers.Matrix.*;

public class Main {
    static int size = 4;

    public static void main(String[] args) {

        Matrix A = Matrix.Generator.getRandomSymmetric(size);
        Matrix X = Matrix.Generator.getRandom(size, 1);
        Matrix B = mul(A, X);

        System.out.println("A: "+A);
        System.out.println("X: "+X);
        System.out.println("B: "+B);
        System.out.println("\n###############################################################################\nXGauss");
        Matrix XGaus = new Gauss.Builder().setA(A).setB(B).build().solve();
        System.out.println(XGaus);
        System.out.println(Matrix.mul(A,XGaus));

        System.out.println("\n###############################################################################\nXZeidel");
        Matrix XZeid = new Zeidel.Builder().setA(A).setB(B).build().solve();
        System.out.println(XZeid);
        System.out.println(Matrix.mul(A,XZeid));

        System.out.println("\n###############################################################################\nXGRAD");
        GradientDescent descentG = new GradientDescent(A,B);
        Matrix XGrad = descentG.solve();
        System.out.println("Iter is "+descentG.iCount);
        System.out.println(XGrad);
        System.out.println(Matrix.mul(A,XGrad));

        System.out.println("\n###############################################################################\nXCOORD");
        CoordinateDescent descentC = new CoordinateDescent(A,B);
        Matrix XCoord = descentC.solve();
        System.out.println("Iter is "+descentC.iCount);
        System.out.println(XCoord);
        System.out.println(Matrix.mul(A,XCoord));

        //test3();
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
        System.out.println(A);
        System.out.println(B);

        System.out.println();
        System.out.println();

        CoordinateDescent coordinateDescent = new CoordinateDescent(A,B);
        System.out.println(coordinateDescent.solve());
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
        System.out.println("B"+B);

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
        System.out.println(new Zeidel.Builder().setA(A).setB(B).build().solve());
    }
}
