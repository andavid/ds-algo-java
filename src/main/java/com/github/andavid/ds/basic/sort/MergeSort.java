package com.github.andavid.ds.basic.sort;

public class MergeSort {

  public void sort(int[] data) {
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
    int[] temp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= high) {
      if (data[i] < data[j]) {
        temp[k++] = data[i++];
      } else {
        temp[k++] = data[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = data[i++];
    }

    while (j <= high) {
      temp[k++] = data[j++];
    }

    for (int l = 0; l < temp.length; l++) {
      data[low + l] = temp[l];
    }
  }

  public void print(int[] data) {
    for (int item : data) {
      System.out.print("" + item + ",");
    }
    System.out.println();
  }
}