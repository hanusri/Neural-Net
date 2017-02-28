/**
 * Created by Srikanth on 2/27/2017.
 */
public class ApplicationRunner {

    private static int hiddenLayerCount;
    private static int hiddenLayerNodeCount;
    private static float learningRate;
    private static int featuresCount;
    private static int expectedOutput;

    public static void main(String[] args) {
        //TODO Integrate with pre processing and construct neural network
        // 0.9 2 2 3 1
        learningRate = Float.parseFloat(args[0]);
        hiddenLayerCount = Integer.parseInt(args[1]);
        hiddenLayerNodeCount = Integer.parseInt(args[2]);
        featuresCount = Integer.parseInt(args[3]);
        expectedOutput = Integer.parseInt(args[4]);

        NeuralNet network = new NeuralNet();
        network.initializeNetwork();
        // calculate the forward propagation of each layer and calculate all parameters

        // calculate backward propagation of each layer and calculate all parameters

        // After weights are updated run the algorithm again
    }

    public static int getHiddenLayerCount() {
        return hiddenLayerCount;
    }

    public static int getHiddenLayerNodeCount() {
        return hiddenLayerNodeCount;
    }

    public static float getLearningRate() {
        return learningRate;
    }

    public static int getFeaturesCount() {
        return featuresCount;
    }

    public static int getExpectedOutput() {
        return expectedOutput;
    }
}
