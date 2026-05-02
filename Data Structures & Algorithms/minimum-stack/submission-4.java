class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.add(val);
        if(min.isEmpty()){
            min.add(val);
            return;
        }
        if(val <= min.peek()){
            min.add(val);
        }
    }
    
    public void pop() {
        int a = s.pop();

        if(min.peek() == a)
            min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek(); 
    }
}
