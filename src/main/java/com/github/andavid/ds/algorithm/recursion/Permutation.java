package com.github.andavid.ds.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    permute(nums, track, answer);
    return answer;
  }

  public void permute(int[] nums, List<Integer> track, List<List<Integer>> answer) {
    if (track.size() == nums.length) {
      answer.add(new ArrayList<>(track));
    } else {
      for (int num : nums) {
        if (track.contains(num)) continue;
        track.add(num);
        permute(nums, track, answer);
        track.remove(track.size() - 1);
      }
    }
  }
}
