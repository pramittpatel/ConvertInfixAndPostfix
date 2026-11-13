package CSCI3200;

import javafx.application.Application;
/*
    The reason we made this class in addition to the JavaFx java class is because after Java 9, JavaFx 
    platform modules were seperated from the main Java platform. So any external library, like JavaFx, are not
    seen gloablly by the JVM. To fix this, we found a workaround where you create a seperate lanch class that does
    not extend Application but uses it to launch the GUI. There was another method where you create a module-info.java
    file that explictly allows the modules to be declared and used by the project. However, this needs a managed
    environment, like Maven, so we decided to just use a new launch class. 
*/
public class VisualLauncher {
    public static void main(String[] args) {
        Application.launch(InfixAndPostfixGUI.class, args);
    }
}