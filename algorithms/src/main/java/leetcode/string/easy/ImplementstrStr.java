package leetcode.string.easy;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        int j=0;
        int pos=-1;
        if(needle.length() == 0) return 0;
        if(haystack.length() ==0) return -1;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                if(pos== -1){
                    pos = i;
                }
                if(j == needle.length()){
                    return pos;
                }
            }else{
                if(pos != -1){
                    i = pos;
                    pos = -1;
                }
                j = 0;
            }
        }
        return -1;
    }

    public int strStrApproach2(String hayStack, String needle){
        int[] kmp = preprocess(needle);
        if(needle.length() == 0) return 0;
        int j =0, i=0;
        while(i<hayStack.length() && j <needle.length()){
            if(hayStack.charAt(i) == needle.charAt(j)){
                j++;i++;
            }else if (j>0){
                j = kmp[j-1];
            }else{
                i++;
            }
        }
        return j == needle.length()? i-j : -1;
    }




    public int[] preprocess(String pattern){
        int i = 0, j = 1;
        int[] kmp = new int[pattern.length()];
        while(j<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                kmp[j] = i+1;
                i++;j++;
            }else if (i == 0){
                j++;
            }else{
                i = kmp[i-1];
            }
        }
        return kmp;
    }

    public static void main(String[] args){
        ImplementstrStr str = new ImplementstrStr();
        System.out.println(str.strStr("mississipi", "issip"));
        System.out.println(str.strStrApproach2("mississipi", "issip"));
    }
}
