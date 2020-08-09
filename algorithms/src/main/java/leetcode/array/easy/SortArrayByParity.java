package leetcode.array.easy;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {
        int l =0, r = A.length -1;
        while(l<r){
            if(A[l]%2 !=0 && (A[r]%2 ==0)){//Do swap
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }else{
                if(A[l]%2==0) {
                    l++;
                }
                if(A[r]%2 !=0) {
                    r--;
                }
            }
        }
        return A;
    }

    public static void main(String[] args){
        int[] result = sortArrayByParity(new int[]{3,1,2,4});
        PrintUtil.print(result);
    }
}
