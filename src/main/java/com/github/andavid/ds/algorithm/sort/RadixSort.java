package com.github.andavid.ds.algorithm.sort;

import java.util.ArrayList;

public class RadixSort {

  public void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    radixSort(array, array.length);
  }

  public void radixSort(int[] array, int n) {
    if (n <= 1) {
      return;
    }

    int max = array[0];
    for (int i = 0; i < n; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }

    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      bucketList.add(new ArrayList<>());
    }

    int d = 1;
    while (true) {
      if (max < d) {
        break;
      }

      for (int i = 0; i < n; i++) {
        int number = (array[i] / d) % 10;
        bucketList.get(number).add(array[i]);
      }

      int index = 0;
      for (int i = 0; i < 10; i++) {
        int size = bucketList.get(i).size();
        for (int j = 0; j < size; j++) {
          array[index++] = bucketList.get(i).get(j);
        }
        bucketList.get(i).clear();
      }

      d *= 10;
    }
  }
}