package study.topo.sort;

import java.util.LinkedList;

/**
 * @author yangxian007
 * @date 2023/10/6
 */
public class DFS {
    public static void topoSortByDFS(Graph graph) {
        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();

        // 先构建逆邻接表，边s->t表示，s依赖t，t先于s
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int k = 0; k < v; k++) {
            inverseAdj[k] = new LinkedList<>();
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // 边i->w
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }

        // 深度优先遍历图
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }

    }

    /**
     * @param vertex     顶点
     * @param inverseAdj 逆序邻接表
     * @param visited    顶点是否被访问过
     */
    public static void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int j = 0; j < inverseAdj[vertex].size(); j++) {
            // 边vertex->w
            int w = inverseAdj[vertex].get(j);
            if (visited[w] == false) {
                visited[w] = true;
                dfs(w, inverseAdj, visited);
            }
        }
        // 先把vertex这个顶点可达的顶点都打印出来，再打印自己
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(1, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(7, 5);
        graph.addEdge(7, 6);

        topoSortByDFS(graph);
    }
}
