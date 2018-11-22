package mypackage;

import javafx.scene.control.Button;

public class Styles {

    //---STYLES---
    static String menu_button = "-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent; -fx-alignment: center;";
    static String menu_button_hover = "-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-background-color: rgba(255,255,255,0.1);-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;";
    static String narrow_text_field = "-fx-min-width: 250;-fx-min-height: 30;-fx-max-height: 30;-fx-font-weight: 500;" +
            "-fx-font-size: 18;-fx-text-fill: #000000;-fx-background-color: #ffffff; -fx-alignment: center;" +
            "-fx-text-alignment: left";
    static String text_field = "-fx-min-width: 600;-fx-min-height: 30;-fx-max-height: 30;-fx-font-weight: 500;" +
            "-fx-font-size: 18;-fx-text-fill: #000000;-fx-background-color: #ffffff; -fx-alignment: center;" +
            "-fx-text-alignment: left";
    static String menu__long_button_hover="-fx-min-width: 1030;-fx-min-height: 50;-fx-max-height: 50;-fx-background-color: rgba(255,255,255,0.1);-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff; -fx-alignment: center";
    static String menu_long_button = "-fx-min-width: 1030;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent; -fx-alignment: center;";
    static String label = "-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;-fx-font-size: 20;" +
            "-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;-fx-background-color: #ac383d";
    static String invShowlabel = "-fx-min-width: 780;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;-fx-font-size: 20;" +
            "-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;-fx-background-color: #ac383d";
    static String invShowlabel2 = "-fx-min-width: 195;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;-fx-font-size: 20;" +
            "-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;-fx-background-color: #ac383d";
    static String invShowlabel3 = "-fx-min-width: 195;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;-fx-font-size: 20;" +
            "-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;-fx-background-color: #91201c";
    static String menu_button_middle = "-fx-min-width: 780;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent; -fx-alignment: center;";
    static String menu_button_middle_hover = "-fx-min-width: 780;-fx-min-height: 50;-fx-max-height: 50;-fx-background-color: rgba(255,255,255,0.1);-fx-font-weight: 500;" +
            "-fx-font-size: 20;-fx-text-fill: #ffffff;";

    public static void set_Hover_Style(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle(menu_button_hover);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(menu_button);
            // button.setStyle(text_field);
        });
    }
    public static void set_Hover_Style2(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle(menu__long_button_hover);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(menu_long_button);
            // button.setStyle(text_field);
        });
    }
    public static void set_Hover_Style3(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle(menu_button_middle_hover);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(menu_button_middle);
            // button.setStyle(text_field);
        });
    }

}
