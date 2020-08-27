package leetcode.hashtable.easy;

import leetcode.tree.easy.MinimumDepthOfATree;
import util.PrintUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * NOTE:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }
        int min = -1;
        String[] result = new String[list2.length];
        int count = 0;

        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int curr = map.get(list2[i]) + i;
                if(min == -1){
                    min = curr;
                    result[0] = list2[i];
                    count = 1;
                }else{
                    if(curr < min){
                        min = curr;
                        result[0] = list2[i];
                        count = 1;
                    }else if(curr == min){
                        result[count++] = list2[i];
                    }
                }

            }
        }
        return Arrays.copyOf(result, count);

    }

    public static void main(String[] args){
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        MinimumIndexSumOfTwoLists m = new MinimumIndexSumOfTwoLists();
        for(String x: m.findRestaurant(list1, list2)){
            System.out.println(x);
        }



    }
}
