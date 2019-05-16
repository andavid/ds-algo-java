package com.github.andavid.ds.basic.sort;

public class QuickSort {

  public void sort(int[] data) {
    quicksort(data, 0, data.length - 1);
  }

  public void quicksort(int[] data, int low, int high) {
    if (low >= high) return;
    int mid = partition(data, low, high);
    quicksort(data, low, mid - 1);
    quicksort(data, mid + 1, high);
  }

  public int partition(int[] data, int low, int high) {
    int pivot = data[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (data[j] < pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, high);
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