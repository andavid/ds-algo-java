package com.github.andavid.ds.algorithm.sort;

public class MergeSort {
  private int[] aux;

  public void sort(int[] data) {
    if (data == null || data.length <= 1) {
      return;
    }
    aux = new int[data.length];
    mergeSort(data, 0, data.length - 1);
  }

  public void mergeSort(int[] data, int low, int high) {
    if (low >= high) return;
    int mid = low + (high - low) / 2;
    mergeSort(data, low, mid);
    mergeSort(data, mid + 1, high);
    merge(data, low, mid, high);
  }

  public void merge(int[] data, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;

    System.arraycopy(data, low, aux, low, high - low + 1);

    for (int k = low; k <= high; k++) {
      if (i > mid) {
        data[k] = aux[j++];
      } else if (j > high) {
        data[k] = aux[i++];
      } else if (aux[i] > aux[j]) {
        data[k] = aux[j++];
      } else {
        data[k] = aux[i++];
      }
    }
  }
}