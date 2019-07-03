package com.github.andavid.ds.datastructure.heap;

import java.util.PriorityQueue;

public class Topk {

  public int[] topk(int[] data, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k);

    for (int i = 0; i < data.length; i++) {
      if (queue.size() < k) {
        queue.offer(data[i]);
      } else {
        int value = queue.peek();
        if (value < data[i]) {
          queue.poll();
          queue.offer(data[i]);
        }
      }
    }

    int[] result = new int[k];
    int index = 0;
    while (!queue.isEmpty()) {
      result[index++] = queue.poll();
    }

    return result;
  }

}