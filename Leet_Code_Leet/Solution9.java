public class Solution9 {
    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            // Initialize the stack with the provided nested list.
            prepareStack(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null; // If there's no next element, return null.
            }
            return stack.pop().getInteger(); // Pop and return the next integer.
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                // While the stack is not empty and the top element is a nested list,
                // prepare the stack with the elements from that nested list.
                List<NestedInteger> list = stack.pop().getList();
                prepareStack(list);
            }
            return !stack.isEmpty(); // Check if there's more to iterate.
        }

        // Helper function to prepare the stack with a list of nested integers.
        private void prepareStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                // Push elements onto the stack in reverse order to process them in the correct
                // order.
                stack.push(nestedList.get(i));
            }
        }
    }
}
