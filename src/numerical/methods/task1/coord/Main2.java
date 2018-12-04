package numerical.methods.task1.coord;

import numerical.methods.task1.Main;
import numerical.methods.task1.Zeidel;
import numerical.methods.task1.descent.CoordinateDescent;
import numerical.methods.task1.helpers.Matrix;

import static numerical.methods.task1.helpers.Matrix.mul;
import static numerical.methods.task2.Hermite.getIter2;

public class Main2 {
    public static void main(String[] args) {

        Matrix A = Matrix.Generator.getRandomSymmetric(Main.size);
        Matrix X = Matrix.Generator.getRandom(Main.size, 1);
        Matrix B = mul(A, X);

        System.out.println("A: "+A);
        System.out.println("X: "+X);
        System.out.println("B: "+B);

        CoordinateDescent descentC = new CoordinateDescent(A,B);
        Matrix XCoord = descentC.solve();
        System.out.println("Iter is "+getIter2());
        System.out.println(XCoord);
        System.out.println(Matrix.mul(A,XCoord));
    }
}
