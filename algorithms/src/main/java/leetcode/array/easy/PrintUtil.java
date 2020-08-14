package leetcode.array.easy;

public class PrintUtil {

    public static void print(int[] nums){
        StringBuffer printString = new StringBuffer("[");
        for(int i=0;i<nums.length;i++){
            printString.append(nums[i]);
            if(i != nums.length-1){
                printString.append(",");
            }
        }
        printString.append("]");
        System.out.println(printString);
    }
}
