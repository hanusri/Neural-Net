/**
 * Created by Srikanth on 2/27/2017.
 */
public class Utility {

    public static double getSigmoidValue(double input) {
        return 1 / (1 + Math.pow(Math.E, -input));
    }
}

enum LayerType {
    HIDDEN,
    INPUT,
    OUTPUT
}
