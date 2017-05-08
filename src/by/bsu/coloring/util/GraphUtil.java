package by.bsu.coloring.util;

import by.bsu.coloring.entity.Graph;

import java.util.*;

/**
 * Created by anyab on 07.05.2017.
 */
public class GraphUtil {
    private static final Random rand = new Random();

    public static boolean areAdjacent(Graph graph, int vertex1, int vertex2) {
        return graph.getAdjacencyMatrix()[vertex1][vertex2] != 0;
    }

    public static List<Integer> generateRandomWay(int size) {
        List<Integer> vertexes = new ArrayList<>();
        while (vertexes.size()!=size) {
            int randomVertexNumber = rand.nextInt(size);
            if (vertexes.contains(randomVertexNumber)) {
                while (vertexes.contains(randomVertexNumber)) {
                    randomVertexNumber = rand.nextInt(size);
                }
            }
            vertexes.add(randomVertexNumber);
        }
        return vertexes;
    }

    public static int calculateDegree(int[][] matrix, int vertex){
        int degree = 0;
        for(int i = 0 ; i< matrix[vertex].length; i++){
            if (matrix[vertex][i]!=0){
                degree++;
            }
        }
        return degree;
    }

    public static List<Integer> findAdjacent(int[][] matrix, int vertex){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            if (matrix[vertex][i]!=0){
                list.add(i);
            }
        }
        return list;
    }

    public static int getHighestSaturation(Graph graph, int[] coloring)
    {
        int maxSaturation = 0;
        int vertexWithMaxSaturation = 0;
        int length = graph.getAdjacencyMatrix().length;

        for(int i = 0; i < length; i++) {
            if (coloring[i] == -1) {
                Set<Integer> colors = new TreeSet<>();
                for (int j = 0; j < length; j++) {
                    if (GraphUtil.areAdjacent(graph, i, j) && coloring[j] != -1) {
                        colors.add(coloring[j]);
                    }
                }
                int tempSaturation = colors.size();
                if (tempSaturation > maxSaturation) {
                    maxSaturation = tempSaturation;
                    vertexWithMaxSaturation = i;
                } else if (tempSaturation == maxSaturation && GraphUtil.calculateDegree(graph.getAdjacencyMatrix(), i)
                        >= GraphUtil.calculateDegree(graph.getAdjacencyMatrix(), vertexWithMaxSaturation)) {
                    vertexWithMaxSaturation = i;
                }
            }
        }
        System.out.println("Saturation = " + maxSaturation + ", vertex = " + vertexWithMaxSaturation);
        return vertexWithMaxSaturation;
    }

    public static int getVertexWithHighestDegree(Graph graph){
        int vertexWithHighestDegree = 0;
        int numberOfAdjacent = 0;
        int[][] matrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < matrix.length; i++){
            int tempNumberAdjacent = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]!=0) tempNumberAdjacent++;
            }
            if (tempNumberAdjacent > numberOfAdjacent){
                numberOfAdjacent = tempNumberAdjacent;
                vertexWithHighestDegree = i;
            }
        }
        return vertexWithHighestDegree;
    }
}
