package com.github.andavid.ds.basic.sort;

public class InsertionSort {

  public void sort(int[] a) {
    if (a == null || a.length <= 1) {
      return;
    }
    insertionSort(a, a.length);
  }

  /**
   * 插入排序核心思想：
   * 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入。
   * 移动元素的次数等于逆序度。
   */
  public void insertionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 1; i < n; i++) {
      int value = a[i];
      int j = i - 1;

      // 查找插入的位置
      for (; j >= 0; j--) {
        if (a[j] > value) {
          a[j+1] = a[j]; // 移动数据
        } else {
          break;
        }
      }

      a[j+1] = value; // 插入数据
    }
  }

}