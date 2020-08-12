package leetcode.array.medium;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int area = 0;
        while(l<r){
            int thisHeight = Math.min(height[l], height[r]);
            int width = r -l;
            area = Math.max(thisHeight*width, area);
            if(height[l] == thisHeight){
                l++;
            }else{
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
