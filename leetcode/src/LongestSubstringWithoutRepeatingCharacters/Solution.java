package LongestSubstringWithoutRepeatingCharacters;
/*
* Longest Substring Without Repeating Characters
Description
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Tags: Hash Table, Two Pointers, String
* */
public class Solution {
    /*
    * 通过将字符与上一次显示的位置对应起来，遍历时进行计算上次显示位置
    * prex的作用是用于记录最大重复位置，l是通过减去最大重复位置之后的与上次比较的差值
    * 精髓在于这个prex的使用
    * */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        if (s == null || (length = s.length()) == 0){
            return 0;
        }
        int prex = 0, max = 0;
        int[] hash = new int[128];//字母最大是ASCII是128
        for (int i = 0; i < length ; i++){
            char c = s.charAt(i);
            if (hash[c]>prex){
                prex = hash[c];
            }
            int l = i - prex + 1;
            hash[c] = i+1;
            if (l>max)max = l;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] hash = new int[128];

        System.out.println(hash['a']);
    }
}
