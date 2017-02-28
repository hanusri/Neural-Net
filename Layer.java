import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Srikanth on 2/27/2017.
 */
public class Layer {
    private List<Node> nodes;
    private LayerType layerType;
    private Layer previousLayer;

    public Layer(Layer previousLayer, LayerType layerType) {
        nodes = new ArrayList<>();
        this.previousLayer = previousLayer;
        this.layerType = layerType;
    }

    public void initializeInputLayer() {
        for (int i = 0; i < ApplicationRunner.getFeaturesCount(); i++) {
            Node node = new Node(this, 1);
            nodes.add(node);
        }
    }

    public void initializeHiddenLayer() {
        for (int i = 0; i < ApplicationRunner.getHiddenLayerNodeCount(); i++) {
            Node node = new Node(this);
            Random rand = new Random();
            // create edges from previous node
            List<Node> previousNodes = previousLayer.getNodes();
            for (Node prevNode : previousNodes) {
                float value = rand.nextFloat() * 2 - 1;
                Edge edge = new Edge(value, prevNode, node);
                Edge revEdge = new Edge(value, node, prevNode);
                prevNode.addEdge(edge);
                node.addRevEdge(revEdge);
            }

            nodes.add(node);
        }
    }

    public void initializeOutputLayer() {
        Node outputNode = new Node(this);
        Random rand = new Random();
        List<Node> previousNodes = previousLayer.getNodes();
        for (Node prevNode : previousNodes) {
            float value = rand.nextFloat() * 2 - 1;
            Edge edge = new Edge(value, prevNode, outputNode);
            Edge revEdge = new Edge(value, outputNode, prevNode);
            prevNode.addEdge(edge);
            outputNode.addRevEdge(revEdge);
        }

        nodes.add(outputNode);
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
