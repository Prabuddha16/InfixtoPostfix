package infix.postfix;

import java.util.Stack;

public class InfixToPostfix {
    public String infixToPostfix(String infixString) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        //step-1
        stack.push('(');
        infixString = infixString.concat(")");
        for (int i = 0; i < infixString.length(); i++) {
            //step-2
            char character = infixString.charAt(i);
            //step-3
            if (Character.isAlphabetic(character)) {
                postfix = postfix.concat("" + character);
            }
            //step-4
            else if (character == '(') {
                stack.push(character);
            }
            //step-5
            else if (isOperator(character)) {
                if (stack.peek() != '(') {
                    while (!stack.empty()) {
                        if (precedence(stack.peek()) >= precedence(character)) {
                            postfix = postfix.concat("" + stack.pop());
                        } else {
                            stack.push(character);
                            break;
                        }
                    }
                } else {
                    stack.push(character);
                }
            }
            //step-6
            else if (character == ')') {
                while (!stack.empty()) {
                    if (stack.peek() != '(') {
                        postfix = postfix.concat("" + stack.pop());
                    } else {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        return postfix;
    }
    private int precedence(char operator){
        int response = 0;
        switch (operator){
            case '^':
                response =3;
                break;
            case '/','*':
                response =2;
                break;
            case '-','+':
                response =1;

        }
        return response;
    }
    private boolean isOperator(char operator){
        boolean response = false;
        switch (operator){
            case '^':
            case '/':
            case '*':
            case '+':
            case '-':
                response = true;
        }
        return response;
    }
}
