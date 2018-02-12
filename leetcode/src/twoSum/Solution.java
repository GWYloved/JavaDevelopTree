package twoSum;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
Tags: Array, Hash Table
* */
public class Solution {
    /*
    解法1：直接两边遍历，获取结果，相等的话就直接返回
    时间复杂度为O(n^2)
     */

    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    class NumIndex{
        int i, e;

        public NumIndex(int i, int e) {
            this.i = i;
            this.e = e;
        }
    }

    public int[] twoSum2(int[] nums, int target){
        List<NumIndex> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            NumIndex n = new NumIndex(i, nums[i]);
            list.add(n);
        }
        list.sort(((o1, o2) -> Integer.compare(o1.e, o2.e)));
        int[] ans = new int[2];
        for (int i = 0, j = nums.length-1; i < j;){
            NumIndex numI = list.get(i);
            NumIndex numJ = list.get(j);
            int sum = numI.e+ numJ.e;
            if (sum == target){
                ans[0] = numI.i;
                ans[1] = numJ.i;
                return ans;
            }else if (sum > target){
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }

}
