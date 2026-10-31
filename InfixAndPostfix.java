package CSCI3200;

import java.util.StringTokenizer;

// class containing stack operations and conversion logic
public class InfixAndPostfix {
    private Node<String> top;

    // default constructor initializes top to null
    public InfixAndPostfix() {
        top = null;
    }

    // pushes a value to the top of the stack
    public void pushToStack(String value) {
        Node<String> newNode = new Node<>(value, top);
        top = newNode;
    }

    // pops and returns the top node from the stack
    public Node<String> popToStack() {
        if (isEmptyStack()) {
            return null;
        }
        Node<String> temp = top;
        top = top.getNext();
        temp.setNext(null); // removes the link as required
        return temp;
    }

    // checks if the stack is currently empty
    public boolean isEmptyStack() {
        return top == null;
    }

    // checks if the given token is an open parenthesis '('
    public boolean isOpenParentheses(String token) {
        return token.equals("(");
    }

    // checks if the given token is a closed parenthesis ')'
    public boolean isClosedParentheses(String token) {
        return token.equals(")");
    }

    // checks if the given character is a valid operator
    public boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%';
    }

    // checks if the given token represents an integer
    public boolean isInteger(String token) {
        if (token == null || token.isEmpty()) return false;
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // helper method to determine operator precedence
    private int getPrecedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/' || op == '%') return 2;
        return 0;
    }

    // converts an infix expression string to postfix
    public String convertToPostfix(String exp) {
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(exp);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isInteger(token)) {
                output.append(token).append(" ");
            } else {
                char symbol = token.charAt(0);
                if (isOpenParentheses(token)) {
                    pushToStack(token);
                } else if (isOperator(symbol)) {
                    while (!isEmptyStack() && !isOpenParentheses(top.getData()) &&
                           getPrecedence(top.getData().charAt(0)) >= getPrecedence(symbol)) {
                        output.append(popToStack().getData()).append(" ");
                    }
                    pushToStack(String.valueOf(symbol));
                } else if (isClosedParentheses(token)) {
                    while (!isEmptyStack() && !isOpenParentheses(top.getData())) {
                        output.append(popToStack().getData()).append(" ");
                    }
                    if (!isEmptyStack() && isOpenParentheses(top.getData())) {
                        popToStack(); // discard '('
                    }
                }
            }
        }

        while (!isEmptyStack()) {
            output.append(popToStack().getData()).append(" ");
        }

        return output.toString().trim();
    }

    // converts a postfix expression string to infix
    public String convertToInfix(String exp) {
        StringTokenizer tokenizer = new StringTokenizer(exp);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isInteger(token)) {
                pushToStack(token);
            } else if (isOperator(token.charAt(0))) {
                if (isEmptyStack()) return "Invalid Expression";
                Node<String> op2Node = popToStack();
                if (isEmptyStack()) return "Invalid Expression";
                Node<String> op1Node = popToStack();

                String operand2 = op2Node.getData();
                String operand1 = op1Node.getData();
                char operator = token.charAt(0);

                String newExpr = "(" + operand1 + " " + operator + " " + operand2 + ")";
                pushToStack(newExpr);
            }
        }

        Node<String> resultNode = popToStack();
        if (resultNode == null || !isEmptyStack()) {
            return "Invalid Expression";
        }
        return resultNode.getData();
    }
}