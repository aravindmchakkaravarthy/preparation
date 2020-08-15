package DS;

import java.util.*;

public class MyQueue<T> {

    private List<T> data;
    private int start = 0;

    public MyQueue(){
        data = new ArrayList<>();
    }

    public boolean enQueue(T element){
        data.add(element);
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        start++;
        return true;
    }

    public T first(){
        return data.get(start);
    }

    public boolean isEmpty(){
        return start>=data.size();
    }

    public int size(){
        return data.size() - start;
    }
}
