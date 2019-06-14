package com.github.andavid.ds.basic.heap;

public class Heap {

  /**
   * 为了方便获取左右孩子节点以及父亲节点，从下标 1 开始存储数据。
   * 数组下标为 i 的节点，左孩子节点下标为 i * 2，右孩子节点下标为 i * 2 + 1，父亲节点下标为 i / 2
   */
  private int[] array;

  /** 堆存储的最大数据个数 */
  private int n;

  /** 堆中已经存储的数据个数 */
  private int count;

  public Heap(int capacity) {
    array = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  /**
   * 往大顶堆中插入一个元素。
   * 把新插入的元素放到堆的最后，然后采用从下往上的堆化方法进行堆化
   */
  public void insert(int data) {
    if (count >= n) {
      return;
    }

    count++;
    array[count] = data;

    int i = count;
    while (i / 2 > 0 && array[i] > array[i / 2]) {
      swap(array, i, i / 2);
      i = i / 2;
    }
  }

  /**
   * 删除大顶堆的堆顶元素。
   * 把最后一个节点放到堆顶，然后采用从上往下的堆化方法进行堆化
   */
  public void removeMax() {
    if (count == 0) {
      return;
    }

    array[1] = array[count];
    count--;

    heapify(array, count, 1);
  }

  /**
   * 大顶堆，从上往下堆化
   */
  private void heapify(int[] array, int n, int i) {
    while (true) {
      int maxPos = i;
      if (i * 2 <= n && array[i] < array[i * 2]) {
        maxPos = i * 2;
      }
      if (i * 2 + 1 <= n && array[maxPos] < array[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }
      if (maxPos == i) {
        break;
      }
      swap(array, i, maxPos);
      i = maxPos;
    }
  }

  /**
   * 建大顶堆。
   * 由于叶子节点不需要堆化，所以从第一个非叶子节点（下标为 n / 2）开始，从后往前处理数组元素。
   * 从后往前处理的原因是保证排序是稳定的。
   * 建堆的时间复杂度是 O(n)，因为每个节点堆化的过程中，需要比较和交换的节点个数和节点的高度成正比。
   * 将每个非叶子节点的高度求和就可以得到建堆的时间复杂度。
   */
  private void buildHeap(int[] array, int n) {
    for (int i = n / 2; i >= 1; --i) {
      heapify(array, n, i);
    }
  }

  /**
   * 排序。
   * 先构建大顶堆，每次从堆顶取出一个元素放到末尾，重新构建堆，直到堆中只剩下一个元素。
   */
  public void sort(int[] array, int n) {
    buildHeap(array, n);
    int k = n;
    while (k > 1) {
      swap(array, 1, k);
      --k;
      heapify(array, k, 1);
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}