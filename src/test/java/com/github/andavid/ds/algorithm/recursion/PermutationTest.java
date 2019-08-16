package com.github.andavid.ds.algorithm.recursion;

import org.junit.Test;

import java.util.List;

public class PermutationTest {

  @Test
  public void testPermutation() {
    Permutation instance = new Permutation();
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = instance.permute(nums);
    System.out.println(result);
  }
}
