# Convert Infix and Postfix

CSCI 3200 (Data Structures and Algorithm Analysis), Project 3.

Converts math expressions between infix (`( 1 + 2 ) * 3`) and postfix (`1 2 + 3 *`) form, using a stack built from linked nodes.

**Group members:** Pramit Patel, Rohan Karve

## Files

| File | What it does |
| --- | --- |
| `src/CSCI3200/Node.java` | Node class for the linked stack |
| `src/CSCI3200/InfixAndPostfix.java` | Stack operations and the conversion logic |
| `src/CSCI3200/ConvertInfixAndPostfix.java` | Console menu program |
| `src/CSCI3200/InfixAndPostfixGUI.java` | JavaFX GUI version |

## How to run

From the project root:

```bash
javac -d bin src/CSCI3200/*.java
```

Console version:

```bash
java -cp bin CSCI3200.ConvertInfixAndPostfix
```

GUI version:

```bash
java -cp bin CSCI3200.InfixAndPostfixGUI
```

## Input format

Put a space between every number, operator, and parenthesis.

- Infix example: `( 1 + 2 ) * 3`
- Postfix example: `1 2 + 3 *`

Supported operators: `+ - * / %`
