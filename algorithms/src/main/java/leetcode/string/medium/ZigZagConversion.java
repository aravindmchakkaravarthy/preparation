package leetcode.string.medium;

import java.util.ArrayList;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean reverse = false;
        for(int i=0;i<s.length();i++){
            rows.get(curRow).append(s.charAt(i));
            curRow += reverse ? -1 : 1;
            if(curRow == 0 || curRow == numRows-1) reverse = !reverse;

        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder row:rows){
            sb.append(row);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ZigZagConversion z = new ZigZagConversion();
        z.convert("PAHNAPLSIIGYIR", 3);
    }
}
