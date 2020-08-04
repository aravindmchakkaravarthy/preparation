package com.amc.searching;

public class BinarySearch {

    static int binarySearch(int[] arr, int x){
        int l =0, r = arr.length - 1;
        while (l <=r){
            int mid = (l + r)/2;
            if (arr[mid] == x){
                return mid;
            }
            if(arr[mid] > x){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] arr = { 2,5,8,12,16,23,38,56,72,91 };
        System.out.println(binarySearch(arr,72));
        System.out.println(binarySearch(arr,2));
        System.out.println(binarySearch(arr,91));
        System.out.println(binarySearch(arr,100));
        System.out.println(binarySearch(arr,1));
    }
}
