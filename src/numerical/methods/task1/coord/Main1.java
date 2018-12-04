package numerical.methods.task1.coord;

import numerical.methods.task1.Main;
import numerical.methods.task1.Zeidel;
import numerical.methods.task1.helpers.Matrix;

import static numerical.methods.task1.helpers.Matrix.mul;
import static numerical.methods.task2.Hermite.getIter2;

public class Main1 {
    public static void main(String[] args) {

        Matrix A = Matrix.Generator.getRandomSymmetric(Main.size);
        Matrix X = Matrix.Generator.getRandom(Main.size, 1);
        Matrix B = mul(A, X);

        System.out.println("A: "+A);
        System.out.println("X: "+X);
        System.out.println("B: "+B);

        Matrix XZeid = new Zeidel.Builder().setA(A).setB(B).build().solve();
        System.out.println("Iter is "+getIter2());
        System.out.println(XZeid);
        System.out.println(Matrix.mul(A,XZeid));
    }
}
