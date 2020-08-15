package algorithms.search;

public class JumpSearch {
    // Need to understand this little better
    private static int jumpSearch(int[] arr, int x){
        int prev = 0;
        int step = (int) Math.floor(Math.sqrt(arr.length));
        while(arr[Math.min(step, arr.length) -1] < x){
            prev = step;
            step += (int) Math.floor(Math.sqrt(arr.length));
            if(prev >=arr.length) {
                return -1;
            }
        }
        while(arr[prev] <x){
            prev ++;
            if(prev == Math.min(step, arr.length)){
                return -1;
            }
        }
        if(arr[prev] == x){
            return prev;
        }
        return -1;
    }


    public static void main(String args[]){
        int[] arr = { 2,5,8,12,16,23,38,56,72,91 };
        System.out.println(jumpSearch(arr,72));
        System.out.println(jumpSearch(arr,2));
        System.out.println(jumpSearch(arr,91));
        System.out.println(jumpSearch(arr,100));
        System.out.println(jumpSearch(arr,1));
    }
}
