package by.bsu.coloring.algorithm;

import by.bsu.coloring.entity.Graph;
import by.bsu.coloring.util.GraphUtil;

import java.util.*;

/**
 * Created by anyab on 07.05.2017.
 */
public class GIS implements IAlgorithm{
    @Override
    public void doAlgorithm(Graph graph) {
        int length = graph.getAdjacencyMatrix().length;
        Map<Integer, Integer> resultColoring = new LinkedHashMap<>();
        List<Integer> withoutColor = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            withoutColor.add(i);
        }
        int color = 0;
        List<Integer> available;
        while (withoutColor.size() > 0){
            available = new ArrayList<>(withoutColor);
            while (available.size() != 0) {
                available.sort((o1, o2) ->
                        GraphUtil.calculateDegree(graph.getAdjacencyMatrix(), o1) -
                                GraphUtil.calculateDegree(graph.getAdjacencyMatrix(), o2));
                int vertex = available.get(0);
                System.out.println("Min degree vertex  " + vertex);
                resultColoring.put(vertex, color);
                available.remove((Object)vertex);
                List<Integer> adjacentVertexes = GraphUtil.findAdjacent(graph.getAdjacencyMatrix(), vertex);
                adjacentVertexes.forEach(available::remove);
                withoutColor.remove((Object)vertex);
            }
            color = color + 1;
        }

        System.out.println(resultColoring);
    }
}
