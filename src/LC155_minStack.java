import java.util.Stack;

public class LC155_minStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public LC155_minStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        LC155_minStack obj = new LC155_minStack();
        obj.push(1);
        System.out.println(obj.getMin());
        obj.push(2);
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.getMin());
    }
}
