package com.github.andavid.ds.algorithm.sort;

public class ShellSort {

  public void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    shellSort(array, array.length);
  }

  public void shellSort(int[] array, int n) {
    int gap = n / 2;
    while (gap >= 1) {
      for (int i = gap; i < n; i++) {
        int temp = array[i];
        int j = i - gap;
        while (j >= 0 && array[j] > temp) {
          array[j + gap] = array[j];
          j = j - gap;
        }
        array[j + gap] = temp;
      }
      gap = gap / 2;
    }
  }
}