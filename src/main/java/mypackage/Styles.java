package mypackage;

import javafx.scene.control.Button;

public class Styles {

    //---STYLES---
    static String menu_button = "-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent;";
    static String menu_button_hover = "-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-background-color: rgba(255,255,255,0.1);-fx-font-weight: 500;" +
                        "-fx-font-size: 20;-fx-text-fill: #ffffff;";

    public static void set_Hover_Style(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle(menu_button_hover);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(menu_button);
        });
    }
}