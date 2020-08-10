package leetcode.array.easy;

/**
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
 *
 * Return that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class ElementAppearingMore {
    public static int findSpecialInteger(int[] arr) {
        int ans = 1;
        int pre = arr[0];
        for(int i=1;i<arr.length;i++){
            if(pre == arr[i]){
                ans++;
                if(ans > arr.length / 4 ){
                    return arr[i];
                }
            }else{
                pre = arr[i];
                ans = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }
}
