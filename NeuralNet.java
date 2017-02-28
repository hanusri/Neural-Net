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
        inputLayer.initializeInputLayer();
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

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}
