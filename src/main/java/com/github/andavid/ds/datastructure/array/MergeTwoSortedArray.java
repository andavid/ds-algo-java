package com.github.andavid.ds.datastructure.array;

/**
 * 将两个有序数组合并为一个有序数组
 */
public class MergeTwoSortedArray {

  public int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    int n = n1 + n2;
    int[] arr = new int[n];

    int i = 0;
    int j = 0;

    for (int k = 0; k < n; k++) {
      if (i >= n1) {
        arr[k] = arr2[j++];
      } else if (j >= n2) {
        arr[k] = arr1[i++];
      } else if (arr1[i] > arr2[j]) {
        arr[k] = arr2[j++];
      } else {
        arr[k] = arr1[i++];
      }
    }

    return arr;
  }
}
