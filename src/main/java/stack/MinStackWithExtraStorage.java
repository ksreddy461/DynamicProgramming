package stack;

import java.util.Stack;

public class MinStackWithExtraStorage {

    Stack<Integer> s = new Stack<>();
    Stack<Integer> ss = new Stack<>();

    public void push(int val) {
        s.push(val);
        if (ss.isEmpty() || ss.peek() >= val) {
            ss.push(val);
        }
    }

    public int pop() {
        if (s.isEmpty()) {
            return -1;
        }
        int val = s.pop();
        if (val == ss.peek()) {
            ss.pop();
        }
        return val;
    }

    public int getMin() {
        if (ss.isEmpty()) {
            return -1;
        }
        return ss.peek();
    }

    public int peek() {
        if (s.isEmpty()) {
            return -1;
        }
        return s.peek();
    }

    public static void main(String[] args){
        MinStackWithExtraStorage minStackWithExtraStorage = new MinStackWithExtraStorage();
        minStackWithExtraStorage.push(10);
        System.out.println(minStackWithExtraStorage.getMin());
        minStackWithExtraStorage.push(5);
        System.out.println(minStackWithExtraStorage.getMin());
        minStackWithExtraStorage.pop();
        System.out.println(minStackWithExtraStorage.getMin());
    }
}
