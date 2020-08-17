package leetcode.stack.medium;

import util.PrintUtil;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        StringBuilder s = new StringBuilder();
        String[] dirs = path.split("/+");
        Stack<String> ans = new Stack<>();
        for(String dir:dirs){
            if(dir.equals(".") || dir.equals("")){
                continue;
            }
            if(dir.equals("..")){
                if(!ans.isEmpty())ans.pop();
            }else{
                ans.push(dir);
            }
        }
        return "/"+((ans.size()>0)?String.join("/",ans):"");
    }

    public static void main(String[] args){
        String test = "/a//b////c/d//././/..";
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(test));
    }
}
