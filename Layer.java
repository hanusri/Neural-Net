import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srikanth on 2/27/2017.
 */
public class Layer {
    private List<Node> nodes;
    private LayerType layerType;

    public Layer()
    {
        nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public LayerType getLayerType() {
        return layerType;
    }

    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
    }
}
