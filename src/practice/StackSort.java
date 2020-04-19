package practice;

import java.util.ListIterator;
import java.util.Stack;

class StackSort {
    /**
     * This method will sort a stack in ascending order recursively
     *
     * @param stack The Stack that i being sorted
     * @param val   the integer value being added in the Stack
     */
    private void sortedInsert(Stack<Integer> stack, int val) {
        // Base case:
        // if the Stack is empty or the top value is less than the value being inserted,
        // we insert the value at hand and return
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
            return;
        }

        // else if the top value is bigger than our value at hand, we remove the top
        // and store it in a temporary variable and recur
        int temp = stack.pop();
        sortedInsert(stack, val);

        // push the value at hand back to the stack
        stack.push(temp);
    }

    /**
     * This function will take in a stack and sort it recursively
     *
     * @param stack The stack parsed for sorting
     */
    void sortStack(Stack<Integer> stack) {
        // we can only sort non-empty stacks
        if (!stack.isEmpty()) {
            // here we remove the top item
            int top = stack.pop();

            // next we sort the remaining Stack
            sortStack(stack);

            // finally we insert the top value into the sorted Stack
            sortedInsert(stack, top);
        }
    }

    /**
     * This method will print out the values in a stack to the console
     *
     * @param stack The stack to be printed out
     */
    void printStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            ListIterator<Integer> iter = stack.listIterator();

            // forwarding
            while (iter.hasNext())
                iter.next();

            // printing from top to bottom
            while (iter.hasPrevious())
                System.out.print(iter.previous() + " ");
        } else
            System.out.println("The stack is empty");
    }
}
