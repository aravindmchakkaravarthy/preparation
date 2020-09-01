package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    private String getRow(int y, int n){
        char[] chars = new char[n];
        Arrays.fill(chars,'.');
        chars[y] = 'q';
        return String.valueOf(chars);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int y = 0;
        while(y<n){
            List<String> result = new ArrayList<>();
            List<String> visited = new ArrayList<>();
            visited.add("0,"+y);
            visited.addAll(getDiagonalElements(0,y,n));
            visited.addAll(getStraightElements(0,y,n));
            result.add(getRow(y, n));
            int x = 1;
            while(x<n){

            }

        }
        return null;
    }

    public List<String> getStraightElements(int i, int j, int n){
        List<String> straightElements = new ArrayList<>();
        int y = 0;
        while(y<n){
            if(y!=j){
                straightElements.add(i+","+y);
            }
            y++;
        }
        int x = 0;
        while(x<n){
            if(x!=i){
                straightElements.add(x+","+j);
            }
            x++;
        }
        return straightElements;
    }

    public List<String> getDiagonalElements(int i, int j, int n){
        List<String> diagonalElements = new ArrayList<>();
        int d = Math.min(i,j);

        int x = i-d, y = j-d;
        while(x<n && y<n){
            if(!(x == i && y == j)){
                diagonalElements.add(x+","+y);
            }
            x++; y++;
        }
        x = i-d; y = j + d;
        while(x<n && y>=0){
            if(!(x == i && y == j)){
                diagonalElements.add(x+","+y);
            }
            x++;y--;
        }
        return diagonalElements;
    }

    public static void main(String[] args){
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.getDiagonalElements(1,1,3));
        System.out.println(nQueens.getStraightElements(1,1,3));

    }
}
