package com.github.andavid.ds.algorithm.sort;

public class FindKthLargest {

  public int findKthLargest(int[] data, int k) {
    return partition(data, k, 0, data.length - 1);
  }

  public int partition(int[] data, int k, int low, int high) {
    int pivot = data[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (data[j] > pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, high);

    if (i + 1 == k) {
      return data[i];
    } else if (i + 1 < k) {
      return partition(data, k, i + 1, high);
    } else {
      return partition(data, k, low, i - 1);
    }
  }

  public void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

}