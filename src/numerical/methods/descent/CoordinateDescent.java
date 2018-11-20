package numerical.methods.descent;

import numerical.helpers.Matrix;
import numerical.methods.Method;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;
import static numerical.helpers.Matrix.MAX_RANDOM_VALUE;
import static numerical.helpers.Matrix.MIN_RANDOM_VALUE;

public class CoordinateDescent extends QuickestDescent {
    protected CoordinateDescent(Matrix a, Matrix b) {
        super(a, b);
    }

    @Override
    protected Matrix q() {
        return null;
    }
}
