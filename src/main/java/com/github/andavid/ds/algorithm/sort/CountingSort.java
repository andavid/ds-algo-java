package com.github.andavid.ds.algorithm.sort;

public class CountingSort {

  public void sort(int[] a) {
    if (a == null || a.length <= 1) {
      return;
    }
    countingSort(a, a.length);
  }

  public void countingSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    // 找到数组最大值
    int max = a[0];
    for (int i = 1; i < n; ++i) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    // 申请一个计数数组 c，下标 [0, max]
    int[] c = new int[max + 1];
    for (int i = 0; i <= max; ++i) {
      c[i] = 0;
    }

    // 遍历数组，计算每个元素的个数
    for (int i = 0; i < n; ++i) {
      c[a[i]]++;
    }

    // 累加数组，c[i] 表示值小于等于 i 的元素数量
    for (int i = 1; i <= max; ++i) {
      c[i] = c[i - 1] + c[i];
    }

    // 申请一个临时数组 r，保存排序之后的结果
    int[] r = new int[n];
    for (int i = n - 1; i >= 0; --i) {
      // 从后往前扫描数组 a，取出元素 a[i]
      // 值小于等于 a[i] 的元素数量为 c[a[i]]
      // 直接把 a[i] 放到排序后的数组索引为 c[a[i]] - 1 的位置
      int index = c[a[i]] - 1;
      r[index] = a[i];
      c[a[i]]--; // 元素 a[i] 已经放到指定位置，计数数组相应值减一
    }

    // 将排序之后的结果拷贝回源数组
    for (int i = 0; i < n; ++i) {
      a[i] = r[i];
    }
  }

}