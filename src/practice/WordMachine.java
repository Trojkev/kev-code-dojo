package practice;

import java.util.EmptyStackException;
import java.util.Stack;

public class WordMachine {
    public static void main(String[] args) {
        String input = "13 DUP 4 POP 5 DUP + DUP + -";
//        String input = "5 6 + -";
        System.out.println(solution(input));
    }

    private static int solution(String S) {
        // time O(n) | space O(n)
        Stack<Integer> stack = new Stack<>();
        String[] input = S.split(" ");

        for(String item: input){
            if(isValidInteger(item)){
                stack.push(Integer.parseInt(item));
            } else{
                int val;
                switch(item){
                    case "DUP":
                        duplicateItem(stack);
                        break;
                    case "POP":
                        removeItem(stack);
                        break;
                    case "+":
                        if (stack.size() > 1){
                            val = doAddition(stack);
                            if (val == -1)
                                return -1;
                            stack.push(val);
                        } else return -1;
                        break;
                    case "-":
                        if (stack.size() > 1){
                            val = doSubtraction(stack);
                            if (val == -1)
                                return -1;
                            stack.push(val);
                        } else
                            return -1;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(stack);
        }

        return stack.isEmpty() ? -1 : stack.peek();
    }

    private static boolean isValidInteger(String num){
        try{
            Integer.parseInt(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static void duplicateItem(Stack<Integer> stack){
        stack.push(stack.peek());
    }

    private static void removeItem(Stack<Integer> stack){
        stack.pop();
    }

    private static boolean canOperate(Stack<Integer> stack){
        return stack.size() > 1;
    }

    private static int doAddition(Stack<Integer> stack){
        if(!canOperate(stack)){
            return -1;
        }

        long result;
        try{
            result = (long)stack.pop() + (long)stack.pop();

            if(result > Integer.MAX_VALUE || result < 0){
                return -1;
            }
        }catch(EmptyStackException e){
            return -1;
        }
        return (int) result;
    }

    private static int doSubtraction(Stack<Integer> stack){
        int result = -1;
        try{
            result = stack.pop() - stack.pop();

            if(result < 0){
                return -1;
            }
        }catch(EmptyStackException e){
            return result;
        }
        return result;
    }
}
