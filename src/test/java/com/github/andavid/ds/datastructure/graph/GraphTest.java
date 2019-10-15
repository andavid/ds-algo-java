package com.github.andavid.ds.datastructure.graph;

import org.junit.Test;

public class GraphTest {

  @Test
  public void testGraph() {
    // 0 -- 1 -- 2
    // |    |    |
    // 3 -- 4 -- 5
    //      |    |
    //      6 -- 7
    Graph graph = new Graph(8);
    graph.addEdge(0, 1);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 7);
    graph.addEdge(6, 7);

    graph.bfs(0, 6);
    System.out.println();
    graph.dfs(0, 6);
    System.out.println();
    System.out.println(graph.getLevelByBfs(0, 3));
    System.out.println(graph.getLevelByDfs(0, 3));
  }
}
