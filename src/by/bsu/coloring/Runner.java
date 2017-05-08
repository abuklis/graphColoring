package by.bsu.coloring;

import by.bsu.coloring.algorithm.*;
import by.bsu.coloring.entity.Graph;

/**
 * Created by anyab on 07.05.2017.
 */
public class Runner {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};

        Graph graph = new Graph(matrix);
        //IAlgorithm algorithm = new Greedy();
        //IAlgorithm algorithm = new Random();
        IAlgorithm algorithm = new LargestFirst();
        //IAlgorithm algorithm = new GIS();
        //IAlgorithm algorithm = new DSATUR();
        algorithm.doAlgorithm(graph);
    }
}
