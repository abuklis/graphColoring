package by.bsu.coloring.entity;

/**
 * Created by anyab on 07.05.2017.
 */
public class Graph {
    private int[][] adjacencyMatrix;

    Graph(){
        super();
    }

    public Graph(int [][] adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
