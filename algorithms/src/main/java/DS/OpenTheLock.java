package DS;

import java.util.*;

public class OpenTheLock {



    private int[] stringToInt(String x){
        int[] r = new int[x.length()];
        for(int i=0;i<x.length();i++){
            r[i] = Integer.parseInt(x.substring(i,i+1));
        }
        return r;
    }

    private String intToString(int[] x){
        StringBuffer sb = new StringBuffer();
        for(int y:x)sb.append(y);
        return sb.toString();
    }


    public int openLock(String[] deadends, String target) {

        int[] t = stringToInt(target);
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        set.add("0000");
        int i = 0;
        while(i<=3){
            Set<String> temp = new HashSet<>();
            for(String s: set){
                int[] intA = stringToInt(s);
                int j = 0;
                while(j<=t[i]){
                    intA[i] = j;
                    String x = intToString(intA);
                    temp.add(x);
                    j++;
                }
            }
            set=temp;
            i++;
        }

        System.out.println("size - "+set.size());
        System.out.println(set);
        return 0;
    }

    public static void main(String[] args){
        OpenTheLock otl = new OpenTheLock();
        otl.openLock(new String[]{"aaa", "0000"}, "2102");
    }
}
