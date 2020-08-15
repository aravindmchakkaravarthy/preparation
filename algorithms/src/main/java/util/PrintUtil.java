package util;

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

    public static void print(char[][] nums){
        for (char[] num : nums) {
            StringBuffer sb = new StringBuffer("[");
            for (int j = 0; j < num.length; j++) {
                sb.append(num[j]);
                if (j != num.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
