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

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}
