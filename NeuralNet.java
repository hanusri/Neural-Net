import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srikanth on 2/27/2017.
 */
public class NeuralNet {
    private List<Layer> layers;

    public NeuralNet() {
        layers = new ArrayList<>();
    }

    public void initializeNetwork() {
        // create input layer
        Layer inputLayer = new Layer(null, LayerType.INPUT);
        boolean validity = inputLayer.initializeInputLayer();
        if (!validity) {
            System.out.println("Data is not loaded properly. Please load data for processing");
            return;
        }
        layers.add(inputLayer);

        // create hidden layer
        for (int i = 0; i < ApplicationRunner.getHiddenLayerCount(); i++) {
            Layer hiddenLayer = new Layer(layers.get(layers.size() - 1), LayerType.HIDDEN);
            hiddenLayer.initializeHiddenLayer();
            layers.add(hiddenLayer);
        }

        // create output layer
        Layer outputLayer = new Layer(layers.get(layers.size() - 1), LayerType.OUTPUT);
        outputLayer.initializeOutputLayer();
        layers.add(outputLayer);
    }

    public void train() {
        int errorCount = 0;
        for (int i = 0; i < ApplicationRunner.getTrainingSetLimit(); i++) {
            performForwardPass(i);
            errorCount += calculateError(i);
            performBackwardPass();
        }
        double trainingAccuracy = (errorCount * 100.0) /  (ApplicationRunner.getTrainingSetLimit());

        System.out.println("Training Percentage = " + trainingAccuracy);

    }

    public void test() {
        int errorCount = 0;
        for (int i = ApplicationRunner.getTrainingSetLimit(); i < ApplicationRunner.getData().dataValues.size(); i++) {
            performForwardPass(i);
            errorCount += calculateError(i);
        }
        double testingAccuracy = (errorCount * 100.0) /
                (ApplicationRunner.getData().dataValues.size() - ApplicationRunner.getTrainingSetLimit());

        System.out.println("Accuracy Percentage = " + testingAccuracy);
    }

    private int calculateError(int recordId) {
        return layers.get(layers.size() - 1).calculateError(recordId);
    }

    private void performForwardPass(int recordId) {
        // set the input values
        Layer inputLayer = layers.get(0);
        inputLayer.setInputLayerOutputValues(recordId);
        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).performForwardPassCalculation();
        }
    }

    private void performBackwardPass() {
        Layer outputLayer = layers.get(layers.size() - 1);
        //TODO: Here is where we need to integrate Expected/target output
        double targetValue = 1.0;
        outputLayer.setTargetValues(targetValue);
        // Calculate output layer gradients:
        outputLayer.calculateOutputGradientValue();

        // Calculate hidden layer gradients:
        for (int i = layers.size() - 2; i > 0; i--) {
            layers.get(i).calculateGradientValue();
        }

        // Update all connection weights:
        for (int i = layers.size() - 2; i >= 0; i--) {
            layers.get(i).updateEdgesWeight(i);
        }
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}
