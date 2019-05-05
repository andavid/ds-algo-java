package com.github.andavid.ds.algorithm.backtracking;

public class Package {
  /** 背包中物品总重量的最大值 */
  public int maxWeight = Integer.MIN_VALUE;

  /**
   * 计算背包能装下物品总重量的最大值
   *
   * @param index 当前考察物品的索引
   * @param currentWeight 当前已经装进去的物品的总重量
   * @param items 每个物品的重量
   * @param n 物品个数
   * @param capacity 背包能够承受的重量
   */
  public void calMaxWeight(int index, int currentWeight, int[] items, int n, int capacity) {
    if (index == n || currentWeight == capacity) {
      // index == n 表示已经考察完所有的物品
      // currentWeight == capacity 表示背包已经装满了
      if (currentWeight > maxWeight) {
        maxWeight = currentWeight;
      }
      return;
    }

    // 选择将当前考察物品不装入背包，直接考察下一个物品
    calMaxWeight(index + 1, currentWeight, items, n, capacity);

    // 选择将当前考察物品装入背包
    // 这里使用了剪枝，如果将当前考察物品装入背包后超过背包能够承受的重量，就不装了
    if (currentWeight + items[index] <= capacity) {
      calMaxWeight(index + 1, currentWeight + items[index], items, n, capacity);
    }
  }
}