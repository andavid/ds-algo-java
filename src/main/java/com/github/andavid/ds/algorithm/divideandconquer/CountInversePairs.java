package com.github.andavid.ds.algorithm.divideandconquer;

public class CountInversePairs {
  private int num = 0;

  /**
   * 输入一个数组，求出这个数组中的逆序对总数。
   * 采用分治算法，利用二路归并排序实现。
   */
  public int count(int[] data) {
    if (data == null || data.length < 2) {
      return 0;
    }

    num = 0;
    mergeSort(data, 0, data.length - 1);
    return num;
  }

  public void mergeSort(int[] data, int low, int high) {
    if (low >= high) return;
    int mid = low + (high - low) / 2;
    mergeSort(data, low, mid);
    mergeSort(data, mid + 1, high);
    merge(data, low, mid, high);
  }

  public void merge(int[] data, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int left = low;
    int right = mid + 1;
    int index = 0;

    while (left <= mid && right <= high) {
      if (data[left] > data[right]) {
        // 合并两个有序数组过程中，right 存在逆序对数量为 left 到 mid 的元素数量
        num += mid - left + 1;
        temp[index++] = data[right++];
      } else {
        temp[index++] = data[left++];
      }
    }

    while (left <= mid) {
      temp[index++] = data[left++];
    }

    while (right <= high) {
      temp[index++] = data[right++];
    }

    for (int i = low; i <= high; i++) {
      data[i] = temp[i - low];
    }
  }

}
