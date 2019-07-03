package com.github.andavid.ds.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

  public void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    bucketSort(array, array.length);
  }

  public void bucketSort(int[] array, int n) {
    if (n <= 1) {
      return;
    }

    int max = array[0];
    int min = array[0];

    for (int i = 1; i < n; i++) {
      if (array[i] > max) {
        max = array[i];
      } else if (array[i] < min) {
        min = array[i];
      }
    }

    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      bucketList.add(new ArrayList<>());
    }

    int diff = max - min;
    float section = (float) diff / (float) (n - 1);

    for (int i = 0; i < n; i++) {
      int num = (int) (array[i] / section) - 1;
      if (num < 0) {
        num = 0;
      }
      bucketList.get(num).add(array[i]);
    }

    for (int i = 0; i < bucketList.size(); i++) {
      Collections.sort(bucketList.get(i));
    }

    int index = 0;
    for (ArrayList<Integer> bucket : bucketList) {
      for (int value : bucket) {
        array[index] = value;
        index++;
      }
    }

  }

}