package by.bsu.coloring.algorithm;

import by.bsu.coloring.entity.Graph;
import by.bsu.coloring.util.GraphUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anyab on 07.05.2017.
 */
public class DSATUR implements IAlgorithm {

    @Override
    public void doAlgorithm(Graph graph) {
        int length = graph.getAdjacencyMatrix().length;
        Map<Integer, Integer> resultColoring = new LinkedHashMap<>();
        List<Integer> coloredVertexes = new ArrayList<>();
        int[] coloring = new int[length];
        for (int i = 0; i< length; i++){
            coloring[i] = -1;
        }
        List<Integer> withoutColor = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            withoutColor.add(i);
        }

        int highestDegreeVertex = GraphUtil.getVertexWithHighestDegree(graph);
        coloring[highestDegreeVertex] = 0;
        coloredVertexes.add(highestDegreeVertex);
        resultColoring.put(highestDegreeVertex, 0);
        withoutColor.remove((Object)highestDegreeVertex);

        while (withoutColor.size() > 0) {
            int vertex = GraphUtil.getHighestSaturation(graph, coloring);
            while (resultColoring.containsKey(vertex)){
                vertex = GraphUtil.getHighestSaturation(graph, coloring);
            }
            boolean[] availableColors = new boolean[length];
            for (int j = 0; j < length; j++){
                availableColors[j] = true;
            }

            int lastColor = 0;
            for (int k = 0; k < coloredVertexes.size(); k++){
                int currentVertex = coloredVertexes.get(k);
                if (GraphUtil.areAdjacent(graph, vertex, currentVertex)){
                    int color = resultColoring.get(currentVertex);
                    availableColors[color] = false;
                }
            }
            for (int j = 0; j < availableColors.length; j++){
                if (availableColors[j]){
                    lastColor = j;
                    break;
                }
            }
            resultColoring.put(vertex, lastColor);
            withoutColor.remove((Object)vertex);
            coloredVertexes.add(vertex);
            coloring[vertex] = lastColor;
        }
        System.out.println(resultColoring);
    }
}
