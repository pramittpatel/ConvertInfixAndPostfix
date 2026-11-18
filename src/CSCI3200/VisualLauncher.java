package CSCI3200;

import javafx.application.Application;
/*
    The reason we made this class in addition to the JavaFx java class is because after Java 9, JavaFx 
    platform modules were separated from the main Java platform. So any external library, like JavaFx, are not
    seen globally by the JVM. To fix this, we found a workaround where you create a separate launch class that does
    not extend Application but uses it to launch the GUI. There was another method where you create a module-info.java
    file that explicitly allows the modules to be declared and used by the project. However, this needs a managed
    environment, like Maven, so we decided to just use a new launch class. 
*/

/*
    Reference Github Repository: https://github.com/pramittpatel/ConvertInfixAndPostfix

    To run this class, you need to add a external library of JavaFX SDK for the project.
    You can download the JavaFX SDK from the official website: https://gluonhq.com/products/javafx/
        Pick the OS, the architecture, and the version of JavaFX you want to use, based on what java version you are using.
        I have Java 27 installed, and likewise I downloaded the JavaFX SDK 27.0.1.1.
    When you download the JavaFX SDK, you will get a zip file. Extract the zip file to a location on your computer.
    Then, in VS Code , under Java projects select the project, and under the referenced Libraries, click the plus sign and
    add the extracted jar files under path/to/javafx-sdk-27/.0.1.1/lib, for example.
        Also, you need to install the Java Extension Pack in VS Code to run JavaFx. 
        You can find it in the extensions tab on the left side of VS Code.
    If you use Eclipse, right click on the project, select Build Path, and then select Configure Build Path. 
        In the Libraries tab, highlight Classpath, click on Add External JARs and select the JavaFX SDK jar files.
        You also need to add VM arguments to run the JavaFX application. Right click on the project, select Run As, 
        and then select Run Configurations. Under the VisualLauncher class, select the Arguments tab and add the 
        following to the VM arguments:
            --module-path "Your JavaFX SDK Path, e.g. path/to/javafx-sdk-27/.0.1.1/lib" --add-modules javafx.controls,javafx.graphics --enable-native-access=ALL-UNNAMED
                for the above argument, we used --enable-native-access=ALL-UNNAMED instead of --enable-native-access=javafx.graphics 
                because we did not use Maven or Gradle when building the project, so the JavaFX modules are not named. 
                If you use Maven or Gradle, you can use --enable-native-access=javafx.graphics instead.
*/
public class VisualLauncher {
    public static void main(String[] args) {
        Application.launch(InfixAndPostfixGUI.class, args);
    }
}