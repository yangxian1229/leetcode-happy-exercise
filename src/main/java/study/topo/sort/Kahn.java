package study.topo.sort;

import java.util.LinkedList;

/**
 * @author yangxian007
 * @date 2023/10/6
 */
public class Kahn {
    public static void topoSortByKahn(Graph graph) {
        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();
        // 统计每个顶点的入度
        int[] inDegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // 边i->w
                int w = adj[i].get(j);
                inDegrees[w]++;
            }
        }

        // 入度为0的顶点，先进先出
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        // 将入度为0的顶点可达到的订单的入度-1
        while (queue.size() > 0) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                // 边i->j
                int w = adj[i].get(j);
                inDegrees[w]--;
                if (inDegrees[w] == 0) {
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        topoSortByKahn(graph);
    }
}
