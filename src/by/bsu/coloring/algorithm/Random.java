package by.bsu.coloring.algorithm;

import by.bsu.coloring.entity.Graph;
import by.bsu.coloring.util.GraphUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anyab on 07.05.2017.
 */
public class Random implements IAlgorithm {

    @Override
    public void doAlgorithm(Graph graph) {
        int length = graph.getAdjacencyMatrix().length;
        List<Integer> vertexes = GraphUtil.generateRandomWay(length);
        System.out.println(vertexes);

        List<Integer> resultColoring = new ArrayList<>();
        resultColoring.add(0);
        List<Integer> coloredVertexes = new ArrayList<>();
        coloredVertexes.add(vertexes.get(0));

        for (int i = 1; i < length; i++){
            int currentVertex = vertexes.get(i);

            boolean[] availableColors = new boolean[length];
            for (int j = 0; j < length; j++){
                availableColors[j] = true;
            }

            int lastColor = 0;
            for (int k = 0; k < coloredVertexes.size(); k++){
                if (GraphUtil.areAdjacent(graph, currentVertex, coloredVertexes.get(k))){
                    int color = resultColoring.get(k);
                    availableColors[color] = false;
                }
            }

            for (int j = 0; j < availableColors.length; j++){
                if (availableColors[j]){
                    lastColor = j;
                    break;
                }
            }
            resultColoring.add(lastColor);
            coloredVertexes.add(currentVertex);
        }

        for (int i = 0; i < length; i++)
            System.out.println("Vertex " + vertexes.get(i) + " --->  Color "
                    + resultColoring.get(i));

    }

}
