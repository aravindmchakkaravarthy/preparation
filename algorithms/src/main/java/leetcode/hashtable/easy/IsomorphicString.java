package leetcode.hashtable.easy;

import java.time.chrono.IsoChronology;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphicApproach2(String s, String t){
        int[] m = new int[256], n = new int[256];
        for(int i = 0;i<t.length();i++){
            if(m[s.charAt(i)] != n[t.charAt(i)]){
                return false;
            }
            m[s.charAt(i)] = i + 1;
            n[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character source = s.charAt(i);
            Character target = t.charAt(i);
            if(map.containsKey(target)){
                Character x = map.get(target);
                if(x != source){
                    return false;
                }
            }else{
                if(map.containsValue(source)){
                    return false;
                }
                map.put(target, source);
            }
        }
        return true;
    }

    public static void main(String[] args){
        IsomorphicString ims = new IsomorphicString();
        System.out.println(ims.isIsomorphic("egg", "add"));
        System.out.println(ims.isIsomorphicApproach2("egg", "add"));
    }
}
