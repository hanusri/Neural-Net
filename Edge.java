/**
 * Created by Srikanth on 2/27/2017.
 */
public class Edge {
    private float weight;
    private Node source;
    private Node destination;
    private float weightDelta;

    public Edge(float weight, Node source, Node destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public float getWeightDelta() {
        return weightDelta;
    }

    public void setWeightDelta(float weightDelta) {
        this.weightDelta = weightDelta;
    }
}
