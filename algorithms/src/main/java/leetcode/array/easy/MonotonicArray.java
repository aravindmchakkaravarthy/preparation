package leetcode.array.easy;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] A) {
        boolean increasing = false;
        boolean decreasing = false;
        int prev = A[0];
        for(int i=1;i<A.length;i++){
            if(A[i] > prev){
                increasing = true;
            }
            if(A[i] < prev){
                decreasing = true;
            }
            if(increasing && decreasing) return false;
            prev=A[i];
        }
        return true;
    }

    public static void main(String args[]){
        int[] nums = {1,2,4,5};
        System.out.println(isMonotonic(nums));
    }
}
