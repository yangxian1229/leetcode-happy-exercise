package study.dijsktra;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

/**
 * @author yangxian007
 * @date 2023/10/30
 */
@Data
public class Graph {
    // 有向有权链接表
    private LinkedList<Edge>[] adj;
    // 顶点个数
    private int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s,t,w));
    }


    @Data
    @AllArgsConstructor
    private class Edge {
        // 边的起始顶点编号
        private int sid;
        // 边的终止顶点编号
        private int tid;
        // 权重
        private int w;
    }

    @Data
    private class Vertex {
        // 顶点编号ID
        private int id;
        // 从起始位置到这个订单的举例
        private int dist;
    }
}
