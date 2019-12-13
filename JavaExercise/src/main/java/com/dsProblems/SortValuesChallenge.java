package com.dsProblems;

import com.core.structure.Stack;

class SortValuesChallenge {

    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>(stack.getMaxSize());

        int c1 = 0;

        while(c1 < stack.getMaxSize()){


            int c2 = 0;
            int high = stack.pop();

            while(c2 < stack.getMaxSize() - 1 - c1){

                int val = stack.pop();

                if(val > high){
                    tempStack.push(high);
                    high = val;
                }
                else{
                    tempStack.push(val);
                }
                c2++;
            }

            c1++;
            stack.push(high);
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }

        }


    }

    public static void main(String args[]) {

        Stack<Integer> stack = new Stack<Integer>(7);
        //Character.isDigit();
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
