package by.bsu.coloring.algorithm;

import by.bsu.coloring.entity.Graph;
import by.bsu.coloring.util.GraphUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anyab on 07.05.2017.
 */
public class Greedy implements IAlgorithm{
    @Override
    public void doAlgorithm(Graph graph) {
        int length = graph.getAdjacencyMatrix().length;

        List<Integer> resultColoring = new ArrayList<>();
        resultColoring.add(0);
        List<Integer> coloredVertexes = new ArrayList<>();
        coloredVertexes.add(1);

        for (int i = 1; i < length; i++){
            boolean[] availableColors = new boolean[length];
            for (int j = 0; j < length; j++){
                availableColors[j] = true;
            }
            int lastColor = 0;
            for (int k = 0; k < coloredVertexes.size(); k++){
                if (GraphUtil.areAdjacent(graph, i, k)){
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
            coloredVertexes.add(i);

        }

        for (int i = 0; i < length; i++)
            System.out.println("Vertex " + i + " --->  Color "
                    + resultColoring.get(i));
    }
}
