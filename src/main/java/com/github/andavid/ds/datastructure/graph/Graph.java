package com.github.andavid.ds.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 基于邻接表的无向图实现
 */
public class Graph {
  /** 顶点个数 */
  private int v;

  /** 邻接表 */
  private LinkedList<Integer>[] adj;

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  /**
   * 添加一条边
   */
  public void addEdge(int s, int t) {
    adj[s].add(t);
    adj[t].add(s);
  }

  /**
   * 广度优先搜索
   * @param s 搜索起始顶点
   * @param t 搜索终止顶点
   */
  public void bfs(int s, int t) {
    if (s == t) {
      return;
    }

    // 标识已经访问过的顶点，避免重复访问
    boolean[] visited = new boolean[v];
    visited[s] = true;

    // 记录已经被访问、但相邻的还没被访问的顶点
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(s);

    // 记录搜索路径
    int[] prev = new int[v];
    for (int i = 0; i < v; i++) {
      prev[i] = -1;
    }

    while (queue.size() != 0) {
      int w = queue.poll();
      // 遍历所有相邻的顶点
      for (int i = 0; i < adj[w].size(); i++) {
        int q = adj[w].get(i);
        // 如果相邻的顶点没有被访问
        if (!visited[q]) {
          // 记录访问路径
          prev[q] = w;
          if (q == t) {
            print(prev, s, t);
            return;
          }
          visited[q] = true;
          queue.offer(q);
        }
      }
    }
  }

  /**
   * 递归打印 s -> t 的路径
   * @param prev
   * @param s
   * @param t
   */
  public void print(int[] prev, int s, int t) {
    if (prev[t] != -1 && t != s) {
      print(prev, s, prev[t]);
      System.out.print(" -> " + t);
    } else {
      System.out.print(t);
    }
  }

  boolean found = false;

  public void dfs(int s, int t) {
    found = false;
    boolean[] visited = new boolean[v];
    int[] prev = new int[v];
    for (int i = 0; i < v; i++) {
      prev[i] = -1;
    }

    dfsHelper(s, t, visited, prev);
    print(prev, s, t);
  }

  private void dfsHelper(int w, int t, boolean[] visited, int[] prev) {
    if (found) {
      return;
    }

    visited[w] = true;
    if (w == t) {
      found = true;
      return;
    }

    for (int i = 0; i < adj[w].size(); i++) {
      if (found) return;
      int q = adj[w].get(i);
      if (!visited[q]) {
        prev[q] = w;
        dfsHelper(q, t, visited, prev);
      }
    }
  }

  /**
   * 返回某个顶点的 N 度顶点
   */
  public List<List<Integer>> getLevelByBfs(int s, int level) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < level; i++) {
      result.add(new ArrayList<>());
    }

    boolean[] visited = new boolean[v];
    visited[s] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(s);

    int count = 0;

    while (count < level && !queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int w = queue.poll();
        // 遍历所有相邻的顶点
        for (int j = 0; j < adj[w].size(); j++) {
          int q = adj[w].get(j);
          // 如果相邻的顶点没有被访问
          if (!visited[q]) {
            visited[q] = true;
            queue.offer(q);
            result.get(count).add(q);
          }
        }
      }
      count++;
    }

    return result;
  }

  /**
   * 返回某个顶点的 N 度顶点
   */
  public List<Integer> getLevelByDfs(int s, int level) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[v];
    dfsLevel(result, s, 0, level, visited);
    return result;
  }

  public void dfsLevel(List<Integer> result, int s, int current, int level, boolean[] visited) {
    visited[s] = true;
    if (current >= level) return;
    for (int i = 0; i < adj[s].size(); i++) {
      int q = adj[s].get(i);
      if (!visited[q]) {
        result.add(q);
      }
      dfsLevel(result, q, current + 1, level, visited);
    }
  }

}
