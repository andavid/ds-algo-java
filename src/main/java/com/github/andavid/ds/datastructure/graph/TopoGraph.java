package com.github.andavid.ds.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 */
public class TopoGraph {

  private int v;
  private LinkedList<Integer>[] adj;

  public TopoGraph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) {
    adj[s].add(t);
  }

  /**
   * Kahn 算法。 从有向图中找到一个入度为 0 的顶点，将其输出到拓扑排序的结果序列，然后将这个顶点从图中删除。
   * 重复以上过程，直到所有的顶点都被输出。
   * 如果最后输出的顶点个数，少于图中顶点个数，图中还有入度不为 0 的顶点，说明图中有环。
   */
  public void kahn() {
    int[] inDegree = new int[v];
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < adj[i].size(); j++) {
        inDegree[adj[i].get(j)]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < v; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int i = queue.poll();
      System.out.println(i + " ");
      for (int j = 0; j < adj[i].size(); j++) {
        int k = adj[i].get(j);
        inDegree[k]--;
        if (inDegree[k] == 0) {
          queue.offer(k);
        }
      }
    }

    for (int i = 0; i < v; i++) {
      if (inDegree[i] != 0) {
        System.out.println("exist circle");
        break;
      }
    }
  }


}
