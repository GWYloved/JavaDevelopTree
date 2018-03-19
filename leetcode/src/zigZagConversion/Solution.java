package zigZagConversion;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i ++){
            sbs[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len){
            for (int j = 0; j < numRows && i < len; ++j){
                sbs[j].append(chars[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < len; --j){
                sbs[j].append(chars[i++]);
            }
        }
        for (i = 1; i < numRows; i ++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
