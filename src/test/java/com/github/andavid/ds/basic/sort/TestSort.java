package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestSort {

  @Test
  public void testSort() {
    int len = 32768;
    int[] a = new int[len];
    final int HASH_INCREMENT = 0x61c88647;
    int next = 0;

    // 生成均匀分布且不包含重复数字的数组
    for (int i = 0; i < len; i++) {
      a[i] = next & (len - 1);
      next += HASH_INCREMENT;
    }

    int[] a1 = Arrays.copyOf(a, len);
    InsertionSort insertionSort = new InsertionSort();
    long time = System.currentTimeMillis();
    insertionSort.sort(a1);
    System.out.println("insertion sort " + (System.currentTimeMillis() - time) + "ms");

    int[] a2 = Arrays.copyOf(a, len);
    BubbleSort bubbleSort = new BubbleSort();
    time = System.currentTimeMillis();
    bubbleSort.sort(a2);
    System.out.println("bubble sort " + (System.currentTimeMillis() - time) + "ms");

    int[] a3 = Arrays.copyOf(a, len);
    SelectionSort selectionSort = new SelectionSort();
    time = System.currentTimeMillis();
    selectionSort.sort(a3);
    System.out.println("selection sort " + (System.currentTimeMillis() - time) + "ms");

    int[] a4 = Arrays.copyOf(a, len);
    QuickSort quickSort = new QuickSort();
    time = System.currentTimeMillis();
    quickSort.sort(a4);
    System.out.println("quick sort " + (System.currentTimeMillis() - time) + "ms");

    int[] a5 = Arrays.copyOf(a, len);
    MergeSort mergeSort = new MergeSort();
    time = System.currentTimeMillis();
    mergeSort.sort(a5);
    System.out.println("merge sort " + (System.currentTimeMillis() - time) + "ms");

  }
}