package study.topo.sort;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import lombok.Data;

import java.util.LinkedList;

/**
 * 图，临界矩阵表示法
 * @author yangxian007
 * @date 2023/10/6
 */
@Data
public class Graph {
    /**
     * 顶点个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * s先于t，边s->t
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }
}
