public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            NestedInteger temp = stack.peek();
            if (temp.isInteger()){
                return true;
            }
            stack.pop();
            for(int i = temp.getList().size() - 1; i >= 0; i--) {
                stack.push(temp.getList().get(i));
            }
        }
        return false;
    }
}