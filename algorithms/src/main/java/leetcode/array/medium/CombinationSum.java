package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        addToList(new ArrayList<>(),0,candidates,target, result);
        return result;
    }
    public static void addToList(List<Integer> current,int index,int[] candidates,int sum, List<List<Integer>> result){
        if(index>=candidates.length || sum<0) return;
        if(sum==0) {
            result.add(current);
        }else{
            List<Integer> temp=new ArrayList<>(current);
//            addToList(temp,index+1,candidates,sum, result);
            temp.add(candidates[index]);
            addToList(temp,index+1,candidates,sum-candidates[index], result);
        }
    }


    public static void main(String[] args){
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(nums, 8));
    }
}
