package com.github.andavid.ds.basic.search;

public class BinarySearch {

  public int bsearch(int[] data, int value) {
    int low = 0;
    int high = data.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (data[mid] == value) {
        return mid;
      } else if (data[mid] < value) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  public int bsearchRecursion(int[] data, int value) {
    return bsearchRecursionHelper(data, 0, data.length - 1, value);
  }

  public int bsearchRecursionHelper(int[] data, int low, int high, int value) {
    if (low > high) return -1;

    int mid = low + ((high - low) >> 1);
    if (data[mid] == value) {
      return mid;
    } else if (data[mid] < value) {
      return bsearchRecursionHelper(data, mid + 1, high, value);
    } else {
      return bsearchRecursionHelper(data, low, mid - 1, value);
    }
  }
}