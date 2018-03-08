package LongestPalindromicSubstring;


/*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.


Example:

Input: "cbbd"

Output: "bb"
*
* */
public class Solution {
    public static String longestPalindrome(String s) {
        String t = "$#";
        for (int i = 0; i < s.length(); i++){
            t += s.charAt(i);
            t += "#";
        }
        t+="@";
        int[] p = new int[t.length()];
        System.out.println("length"+p.length);
        int mx = 0;//已找到的回文子串所能达到的最右端
        int id = 0;//id是最右端回文子串对应的中心
        int resLen = 0;
        int resCenter = 0;
        for (int i = 0; i < t.length() -1 ; i++){
            System.out.println(2*id - i);
            p[i] = mx > i ? Math.min(p[2*id - i], mx-i):1;
            while (((i - p[i]) >= 0) && ((i + p[i])< t.length()-1) && (t.charAt(i + p[i]) == t.charAt(i - p[i])))
                ++p[i];
            if (mx < i + p[i]){
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]){
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen)/2, (resCenter - resLen) / 2 + resLen - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("hehe"));
    }
}
