package leetcode.design.medium;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> history;
    Stack<String> forward;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        history.push(homepage);
        forward = new Stack<>();

    }

    public void visit(String url) {
        history.push(url);
        forward = new Stack<>();

    }

    public String back(int steps) {
        while(steps>0 && history.size() > 1){
            forward.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while(steps>0 && forward.size()>0){
            history.push(forward.pop());
            steps--;
        }
        return history.peek();
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.back(1)); // return "facebook.com"
        System.out.println(bh.back(1)); // return "google.com"
        System.out.println(bh.forward(1)); // return "facebook.com"
        bh.visit("linkedin.com");
        System.out.println(bh.forward(2)); // return "linkedin.com"
        System.out.println(bh.back(2)); // return "google.com"
        System.out.println(bh.forward(7)); // return "leetcode.com"

    }
}
