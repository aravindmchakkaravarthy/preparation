package DS;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue<E> {

    private int head = -1;

    private int tail = -1;

    private final int capacity;

    private List<E> data;

    CircularQueue(int c){
        data = new ArrayList<>(c);
        capacity = c;
    }

    public boolean queue(E element){
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        data.add(++tail, element);
        return true;
    }

    public boolean dequeue(){
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
        }
        else if(head == capacity - 1){
            head = 0;
        }else{
            head++;
        }
        return true;
    }

    public E rear(){
        if(tail<0) return null;
        return data.get(tail);
    }

    public E first(){
        if(head<0) return null;
        return data.get(head);
    }

   public int size(){
        if(head<0){
            return 0;
        }
        if(tail>=head){
            return tail - head + 1;
        }else{
            return (data.size() - head) + (tail +1);
        }
   }

   public boolean isEmpty(){
        return size() == 0;
   }

   public boolean isFull(){
        return size() == capacity;
   }

   public static void main(String[] args){
        List x = new ArrayList();

        CircularQueue<Integer> cq = new CircularQueue<>(3);
        for(int i=0;i<3;i++){
            cq.queue(i);
        }

       for(int i=0;i<3;i++){
           System.out.println(cq.first());
           System.out.println(cq.dequeue());
           System.out.println(cq.first());
       }
       System.out.println(cq.size());
       System.out.println(cq.first());
   }


}
