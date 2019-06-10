package com.github.andavid.ds.basic.sort;

public class BubbleSort {

  public void sort(int[] a) {
    if (a == null || a.length <= 1) {
      return;
    }
    bubbleSort(a, a.length);
  }

  public void bubbleSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n; i++) {
      boolean flag = false;
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j] > a[j+1]) {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
          flag = true;
        }
      }
      if (!flag) {
        // no data swap, exit the loop
        break;
      }
    }
  }

}