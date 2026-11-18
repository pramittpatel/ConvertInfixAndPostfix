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

## Prerequisites
* **Java Development Kit (JDK):** Java 17 or higher (tested with Java 26/27).
* **JavaFX SDK:** Downloaded and extracted locally (matching your major JDK version).

## How to run

## How to Run in Visual Studio Code (VS Code)

1. Open the project folder in VS Code.
2. Ensure the **Extension Pack for Java** is installed.
3. If running the GUI (`VisualLanucher.java`):
   * Open the project's **Java Projects** view in the sidebar.
   * Under **Reference Libraries**, click the **+** button and add all the `.jar` files located inside your JavaFX SDK `lib` folder.
4. Open `ConvertInfixAndPostfix.java` (for the CLI menu) or `VisualLanucher.java` (for the JavaFX GUI) and click the **Run** button above the `main` method.

## How to Run in Eclipse (VS Code)

1. To clone the repository in Eclipse:
        File > Import > Git > Projects from Git (with Smart import) > Clone URI > paste the repository link > Next > Next > Finish
2. Right click on the project, select Build Path, and then select Configure Build Path. 
        In the Libraries tab, highlight Classpath, click on Add External JARs and select the JavaFX SDK jar files.
        You also need to add VM arguments to run the JavaFX application. Right click on the project, select Run As, 
        and then select Run Configurations. Under the VisualLauncher class, select the Arguments tab and add the 
        following to the VM arguments:
            --module-path "Your JavaFX SDK Path, e.g. path/to/javafx-sdk-27/.0.1.1/lib" --add-modules javafx.controls,javafx.graphics --enable-native-access=ALL-UNNAMED
                for the above argument, we used --enable-native-access=ALL-UNNAMED instead of --enable-native-access=javafx.graphics 
                because we did not use Maven or Gradle when building the project, so the JavaFX modules are not named. 
                If you use Maven or Gradle, you can use --enable-native-access=javafx.graphics instead.

## Input format

Put a space between every number, operator, and parenthesis.

- Infix example: `( 1 + 2 ) * 3`
- Postfix example: `1 2 + 3 *`

Supported operators: `+ - * / %`
