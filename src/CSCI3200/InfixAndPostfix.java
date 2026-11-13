package CSCI3200;

import java.util.StringTokenizer; // used to split a given String into tokens

// class containing stack operations and conversion logic
public class InfixAndPostfix {
    private Node<String> top; //reference to top of the stack

    // default constructor initializes top to null
    public InfixAndPostfix() {
        top = null;
    }

    // pushes a value to the top of the stack
    // this value can be a number, operator, or parentheses
    public void pushToStack(String value) {
        Node<String> newNode = new Node<>(value, top);
        top = newNode;
    }

    // pops and returns the top node from the stack
    public Node<String> popToStack() {
        if (isEmptyStack()) {
            return null;
        }
        Node<String> temp = top; // uses a temp variable to readjust the stack
        top = top.getNext();
        temp.setNext(null); // removes the link
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
        return token.equals(")"); // A String method that returns true or false
    }

    // checks if the given token is a valid operator (+, -, *, /, %)
    public boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*")
                || operator.equals("/") || operator.equals("%");
    }

    // checks if the given token represents an integer
    public boolean isInteger(String token) {
        if (token == null || token.isEmpty()) return false;
        try {
            Integer.parseInt(token); // alters the string to a int to determine if its a int
            return true;
        } catch (NumberFormatException e) { //exception handling, the case the String is something other than a integer
            return false;
        }
    }

    // helper method to determine operator precedence, to be used in the convertToPostfix() method
    private int getPrecedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/' || op == '%') return 2;
        return 0;
    }

    // converts an infix expression string to postfix
    public String convertToPostfix(String exp) {
        StringBuilder output = new StringBuilder(); // This class replaces the need to append new chars to a string
                                                    // with the + , and just does it with a .append()
        /*
            For the below StringTokenizer, we choose to use this instead of a traditional split()
            method, splitting the given String by spaces, since we would need to create an array to store
            all the split tokens and loop the array to actually use the tokens to push and pop

            The StringTokenizer class automatically splits a given string by a set of whitepaces: spaces,
            tabs, new lines, etc. However, it does this dynamically, meaning that as you call the nextToken() 
            method, it looks for the next whitespace and splits a new token from there. The first call of hasMoreTokens()
            does a similar thing as the nextToken(), however it does not split off a new token.
        */
        StringTokenizer tokenizer = new StringTokenizer(exp);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isInteger(token)) {
                output.append(token).append(" ");
            } else {
                char symbol = token.charAt(0); // this is used if the infix expression has parentheses that are not 
                                               // seperated by a space from other numbers
                if (isOpenParentheses(token)) {
                    pushToStack(token);
                } else if (isOperator(token)) {
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

        return output.toString().trim(); // .toString() for converting a StringBuilder object to a String object
                                         // .trim() for trimming excess whitespace, either leading or trailing
    }

    // converts a postfix expression string to infix
    public String convertToInfix(String exp) {
        StringTokenizer tokenizer = new StringTokenizer(exp); // same use of StringTokenizer used before

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isInteger(token)) {
                pushToStack(token);
            } else if (isOperator(token)) {
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