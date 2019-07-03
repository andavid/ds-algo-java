package com.github.andavid.ds.datastructure.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

  /** 大顶堆，保存前半部分数据 */
  private PriorityQueue<Integer> maxHeap;

  /** 小顶堆，保存后半部分数据 */
  private PriorityQueue<Integer> minHeap;


  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    maxHeap.offer(num);
    minHeap.offer(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) * 0.5;
    } else {
      return maxHeap.peek();
    }
  }

}