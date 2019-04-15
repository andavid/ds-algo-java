package com.github.andavid.ds.algorithm.backtracking;

public class EightQueen {
  private static final int QUEEN_SIZE = 8;

  /** 记录每一行的 Queen 存储在哪一列 */
  private int[] result = new int[QUEEN_SIZE];

  /** 记录可以摆放的数量 */
  private int count = 0;

  public void cal8queens(int row) {
    if (row == QUEEN_SIZE) {
      count++;
      System.out.println(count + ":");
      printQueens(result);
      return;
    }
    // 遍历每一行 Queen 可以放的列
    for (int column = 0; column < QUEEN_SIZE; column++) {
      if (isOk(row, column)) {
        result[row] = column;
        cal8queens(row + 1);
      }
    }
  }

  private boolean isOk(int row, int column) {
    int leftup = column - 1;
    int rightup = column + 1;
    // 遍历前面的 row - 1 行
    for (int i = row - 1; i >= 0; i--) {
      // 第 i 行的 column 列有 Queen
      if (result[i] == column) {
        return false;
      }
      // 左上对角线，第 i 行的 leftup 列有 Queen
      if (leftup >= 0 && result[i] == leftup) {
        return false;
      }
      // 右上对角线，第 i 行的 rightup 列有 Queen
      if (rightup < QUEEN_SIZE && result[i] == rightup) {
        return false;
      }
      leftup--;
      rightup++;
    }
    return true;
  }

  private void printQueens(int[] result) {
    for (int row = 0; row < QUEEN_SIZE; row++) {
      for (int column = 0; column < QUEEN_SIZE; column++) {
        if (result[row] == column) {
          System.out.print("Q ");
        } else {
          System.out.print("* ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}