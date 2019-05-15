package com.github.andavid.ds.basic.sort;

public class MergeSort {

  public void sort(int[] data) {
    mergeSort(data, 0, data.length - 1);
  }

  public void mergeSort(int[] data, int start, int end) {
    if (start >= end) return;
    int mid = start + (end - start) / 2;
    mergeSort(data, start, mid);
    mergeSort(data, mid+1, end);
    merge(data, start, mid, end);
  }

  public void merge(int[] data, int start, int mid, int end) {
    int[] tempData = new int[end - start + 1];
    int tempIndex = 0;
    int leftIndex = start;
    int rightIndex = mid + 1;

    while (leftIndex <= mid && rightIndex <= end) {
      if (data[leftIndex] < data[rightIndex]) {
        tempData[tempIndex++] = data[leftIndex++];
      } else {
        tempData[tempIndex++] = data[rightIndex++];
      }
    }

    int copyStartIndex = leftIndex;
    int copyEndIndex = mid;
    if (rightIndex <= end) {
      copyStartIndex = rightIndex;
      copyEndIndex = end;
    }

    while (copyStartIndex <= copyEndIndex) {
      tempData[tempIndex++] = data[copyStartIndex++];
    }

    for (int i = start; i <= end; i++) {
      data[i] = tempData[i-start];
    }
  }

  public void print(int[] data) {
    for (int item : data) {
      System.out.print("" + item + ",");
    }
    System.out.println();
  }
}