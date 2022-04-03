package stack;

import java.util.Stack;

public class MinStackWithOutExtraStorage {

    Stack<Integer> s = new Stack<>();
    int min;

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(val);
            min = val;
        } else {
            if (val >= min) {
                s.push(val);
            } else {//val<min
                s.push(2 * val - min);
                min = val;
            }
        }
    }

    public int pop() {
        int val;
        if (s.isEmpty()) {
            val = -1;
        } else {
            if (s.peek() >= min) {
                val = s.pop();
            } else {
                int tmp = min;
                min = 2 * min - s.peek();
                val = tmp;
            }
        }
        return val;
    }

    public int peek() {
        if (s.isEmpty()) {
            return -1;
        } else {
            if (s.peek() >= min) {
                return s.peek();
            } else {//s.peek < min
                return min;
            }
        }
    }

    public int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        MinStackWithOutExtraStorage minStackWithOutExtraStorage = new MinStackWithOutExtraStorage();
        minStackWithOutExtraStorage.push(10);
        System.out.println(minStackWithOutExtraStorage.getMin());
        minStackWithOutExtraStorage.push(5);
        System.out.println(minStackWithOutExtraStorage.getMin());
        minStackWithOutExtraStorage.pop();
        System.out.println(minStackWithOutExtraStorage.getMin());
    }

}
