import java.util.LinkedList; 
import java.util.Queue; 

public class Stack {
    
    Queue<Integer> s = new LinkedList<Integer>();

    void push(int val){
        int range = s.size();

        s.add(val);

        for(int i = 0; i < range; i++){
            int temp = s.remove();
            s.add(temp);
        }
    }

    int pop(){
        if(s.isEmpty()){
            return -1;
        }else{
            return s.remove();
        }
    }

    public static void main(String[] args){
        
        Stack test = new Stack();
        test.push(1);
        test.push(2);
        

    }
}
