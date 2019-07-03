package com.github.andavid.ds.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedArray {

  public int[] mergeSortedArray(int[][] array) {
    if (array == null) {
      return new int[0];
    }

    Comparator<Element> comparator = new Comparator<Element>() {
      @Override
      public int compare(Element o1, Element o2) {
        return o1.value - o2.value;
      }
    };

    Queue<Element> queue = new PriorityQueue<Element>(array.length, comparator);

    int len = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i].length > 0) {
        queue.offer(new Element(i, 0, array[i][0]));
        len += array[i].length;
      }
    }

    int[] result = new int[len];
    int index = 0;
    while (!queue.isEmpty()) {
      Element element = queue.poll();
      result[index++] = element.value;
      if (element.col + 1 < array[element.row].length) {
        queue.add(new Element(element.row, element.col + 1, array[element.row][element.col + 1]));
      }
    }

    return result;
  }

  public class Element {
    public int row, col, value;
    public Element(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }
}