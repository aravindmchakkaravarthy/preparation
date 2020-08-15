package algorithms.search;

public class LinearSearch {

    public static int search(int[] arr, int x){
        for (int i=0; i < arr.length;i++){
            if(x == arr[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String args[]){
        int[] arr = {2, 10, 3, 5, 7, 4};
        int x = 12;

        int result = search(arr, x);
        if(result != -1){
            System.out.println("Result found in the array = " + result);
        }else{
            System.out.println("Result not found in the array");
        }

    }
}
