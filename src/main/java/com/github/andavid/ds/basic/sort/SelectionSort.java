package com.github.andavid.ds.basic.sort;

public class SelectionSort {

  public void sort(int[] a) {
    if (a == null || a.length <= 1) {
      return;
    }
    selectionSort(a, a.length);
  }

  public void selectionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
      }
    }
  }
}