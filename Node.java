import java.util.List;

/**
 * Created by Srikanth on 2/27/2017.
 */
public class Node {
    private float inputActivation;
    private float deviation;
    private Layer layer;
    private boolean visited;
    private int actualOutput;
    private int expectedOutput;
    private List<Edge> adjList;
    private List<Edge> revAdjList;

    public Node(Layer layer) {
        this.layer = layer;
    }


    public float getInputActivation() {
        return inputActivation;
    }

    public void setInputActivation(float inputActivation) {
        this.inputActivation = inputActivation;
    }

    public float getDeviation() {
        return deviation;
    }

    public void setDeviation(float deviation) {
        this.deviation = deviation;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getActualOutput() {
        return actualOutput;
    }

    public void setActualOutput(int actualOutput) {
        this.actualOutput = actualOutput;
    }

    public int getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(int expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }

    public List<Edge> getRevAdjList() {
        return revAdjList;
    }

    public void setRevAdjList(List<Edge> revAdjList) {
        this.revAdjList = revAdjList;
    }
}
