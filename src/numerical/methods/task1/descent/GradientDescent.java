package numerical.methods.task1.descent;

import numerical.methods.task1.helpers.Matrix;

import static numerical.methods.task1.helpers.Matrix.*;

public class GradientDescent extends QuickestDescent {

    public GradientDescent(Matrix a, Matrix b) {
        super(a, b);
    }

    @Override
    protected Matrix q() {
        return add(mul(A, X), B);
    }
}
