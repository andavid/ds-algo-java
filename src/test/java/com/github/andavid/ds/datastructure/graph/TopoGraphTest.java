package com.github.andavid.ds.datastructure.graph;

import org.junit.Test;

public class TopoGraphTest {

  @Test
  public void testTopoGraph() {
    TopoGraph graph = new TopoGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.kahn();
    System.out.println();

    graph = new TopoGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);
    graph.kahn();

  }
}
