package leetcode.design.easy;

/**
 * Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 *
 * Implement the StringIterator class:
 *
 * next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
 * hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.
 *
 *
 * Example 1:
 *
 * Input
 * ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
 * [["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, "L", "e", "e", "t", "C", "o", true, "d", true]
 *
 * Explanation
 * StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
 * stringIterator.next(); // return "L"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "t"
 * stringIterator.next(); // return "C"
 * stringIterator.next(); // return "o"
 * stringIterator.hasNext(); // return True
 * stringIterator.next(); // return "d"
 * stringIterator.hasNext(); // return True
 */
public class StringIterator {

    int num;
    char ch = ' ';
    String res;
    int pos;

    public StringIterator(String compressedString) {
        res = compressedString;
        pos = 0;

    }

    public char next() {
        if(!hasNext()){
            return ' ';
        }
        if(num == 0){
            ch = res.charAt(pos++);
            while(pos<res.length() && Character.isDigit(res.charAt(pos))){
                num = num * 10 + res.charAt(pos++) - '0';
            }
        }
        num--;
        return ch;

    }

    public boolean hasNext() {
        return pos<res.length() || num > 0;
    }

    public static void main(String[] args){
        StringIterator si = new StringIterator("l1e2t1c1o1d1e1");
        System.out.println(si.hasNext());
        System.out.println(si.next());
    }

}
