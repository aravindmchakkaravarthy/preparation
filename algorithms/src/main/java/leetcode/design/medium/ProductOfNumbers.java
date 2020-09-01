package leetcode.design.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Implement the class ProductOfNumbers that supports two methods:
 *
 * 1. add(int num)
 *
 * Adds the number num to the back of the current list of numbers.
 * 2. getProduct(int k)
 *
 * Returns the product of the last k numbers in the current list.
 * You can assume that always the current list has at least k numbers.
 * At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 *
 *
 *
 * Example:
 *
 * Input
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * Output
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * Explanation
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
 * productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
 */
public class ProductOfNumbers {

    List<Integer> list;

    List<Integer> productList;

    TreeSet<Integer> zeros;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        productList = new ArrayList<>();
        zeros = new TreeSet<>();
    }

    public void addApproach2(int num){
        if (num == 0) productList.clear();
        if(productList.size()==0)
            productList.add(num);
        else
            productList.add(productList.get(productList.size()-1)*num);
    }

    public int getProductApproach2(int k){
        if(k>productList.size()) return 0;
        if(k==productList.size()) return productList.get(productList.size() -1);
        return productList.get(productList.size()-1) / productList.get(productList.size()-k-1);
    }

    public void add(int num) {
        list.add(num);
        if(num == 0){
            zeros.add(list.size()-1);
        }
        if(productList.size()>0){
            int last = productList.get(productList.size()-1);
            int p = last != 0 ? last * num : num;
            productList.add(p);
        }else{
            productList.add(num);
        }
    }

    public int getProduct(int k) {
        if(productList.size()==k){
            int kStart = productList.size() - k;
            if(null != zeros.ceiling(kStart)){
                return 0;
            }
            return productList.get(productList.size()-1);
        }else{
            // If there are zero in the last k numbers;
            int kStart = productList.size() - k;
            if(null != zeros.ceiling(kStart)){
                return 0;
            }
            int productUntilK = productList.get(productList.size()-k-1);
            int product = productList.get(productList.size()-1);
            return productUntilK > 0 ? product / productUntilK : product;
        }
    }

    public static void main(String[] args){
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(0);
        productOfNumbers.add(0);
        productOfNumbers.add(9);

        System.out.println(productOfNumbers.getProduct(3));

        //Interesting approach 2.
        ProductOfNumbers approach2 = new ProductOfNumbers();
        approach2.addApproach2(0);
        approach2.addApproach2(0);
        approach2.addApproach2(9);

        System.out.println(approach2.getProductApproach2(3));

    }
}
