package com.github.andavid.ds.basic.sort;

public class QuickSort {

  public void sort(int[] data) {
    quicksort(data, 0, data.length - 1);
  }

  public void quicksort(int[] data, int start, int end) {
    if (start >= end) return;
    int partition = partition(data, start, end);
    quicksort(data, start, partition - 1);
    quicksort(data, partition + 1, end);
  }

  public int partition(int[] data, int start, int end) {
    int pivot = data[end];
    int i = start;
    for (int j = start; j < end; j++) {
      if (data[j] < pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, end);
    return i;
  }

  public void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public void print(int[] data) {
    for (int item : data) {
      System.out.print("" + item + ",");
    }
    System.out.println();
  }
}