package numerical.methods.descent;

import numerical.helpers.Matrix;

import static numerical.helpers.Matrix.*;

public class CoordinateDescent extends QuickestDescent {
    public CoordinateDescent(Matrix a, Matrix b) {
        super(a, b);
    }

    @Override
    protected Matrix q() {
        double[][] values = new double[A.getCols()][1];
        values[iter][0] = 1;
        //System.out.println("q "+Generator.getFromValue(values));
        return Generator.getFromValue(values);
                //add(mul(A, Matrix.Generator.getFromValue(values)), B);
    }
}
