package leetcode.array.easy;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            count++;
        }
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
            if (i != 0 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
            if (count >= n) return true;
        }
        if (flowerbed.length > 2 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0)
            count++;
        return count >= n;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1};
        System.out.print(canPlaceFlowers(nums, 1));
    }
}
