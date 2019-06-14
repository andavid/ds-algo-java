package com.github.andavid.ds.basic.sort;

public class HeapSort {

  public void sort(int[] data) {
    if (data == null || data.length <= 1) {
      return;
    }
    heapSort(data, data.length);
  }

  public void heapSort(int[] data, int n) {
    if (n <= 1) {
      return;
    }

    buildHeap(data, n);

    int k = n;
    while (k > 1) {
      swap(data, 0, k - 1);
      --k;
      heapify(data, k, 0);
    }
  }

  private void buildHeap(int[] data, int n) {
    for (int i = (n - 1) / 2; i >= 0; --i) {
      heapify(data, n, i);
    }
  }

  private void heapify(int[] data, int n, int i) {
    while (true) {
      int maxPos = i;
      if (i * 2 + 1 < n && data[i] < data[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }
      if (i * 2 + 2 < n && data[maxPos] < data[i * 2 + 2]) {
        maxPos = i * 2 + 2;
      }
      if (maxPos == i) {
        break;
      }
      swap(data, i, maxPos);
      i = maxPos;
    }
  }

  private void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

}