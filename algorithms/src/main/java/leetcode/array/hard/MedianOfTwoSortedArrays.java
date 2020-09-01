package leetcode.array.hard;

import leetcode.linkedlist.easy.MergeSortedLists;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1,length == m
 * nums2,length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length, y = nums2.length, partition = (x+y+1)/2, l = 0, h = x;
        while(l<=h){
            int partitionX = (l+h)/2;
            int partitionY = partition - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX<=minRightY && maxLeftY <= minRightX){
                //partition found
                if((x+y) % 2 != 0){
                    return Math.max(maxLeftX, maxLeftY);
                }else{
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }
            }else if (maxLeftX>minRightY){
                h = partitionX - 1;
            }else{
                l = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();

    }

    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {

        int m = (nums1.length + nums2.length)/2;
        int l = 0, r = 0, z = 0;
        int[] res = new int[nums1.length+nums2.length];
        while(z<=m){

            if(r>= nums2.length || (l<nums1.length && nums1[l] <= nums2[r])){
                res[z++] = nums1[l++];
            }else{
                res[z++] = nums2[r++];
            }
        }
        if(res.length % 2 != 0){
            return res[m];
        }else{
            return (float) (res[m-1] + res[m]) / 2;
        }
    }

    public static void main(String[] args){
        int[] a = {1,3}, b = {2};
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArraysBruteForce(a, b));
        System.out.println(m.findMedianSortedArrays(a, b));//TODO - Review this approach again. Very interesting.

    }


}
