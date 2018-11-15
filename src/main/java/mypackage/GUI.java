package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        //---MAIN MENU BUTTONS---
        Button addInv = new Button("Dodaj fakturę");
        Button addCus = new Button("Dodaj klienta");
        Button addArt = new Button("Dodaj artykuł");
        Button showInv = new Button("Wyświetl fakturę");
        Button view = new Button("Przeglądaj bazę");
        Button exit = new Button("ZAMKNIJ");
        Button invBack = new Button("←");
        Button cusBack = new Button("←");


        //---BUTTONS TO VBOX---
        VBox buttons = new VBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.TOP_CENTER);
        buttons.getChildren().addAll(addInv,addCus,addArt,showInv,view);
        //buttons.setStyle("-fx-background-color: #ac383d");

        //---BUTTONS STYLE---
        for (Node b : buttons.getChildren()){
            b.setStyle(Styles.menu_button);
            Styles.set_Hover_Style((Button) b);
        }
        exit.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(exit);
        invBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(invBack);
        cusBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(cusBack);

        //---MENU BORDER PANE---
        BorderPane left = new BorderPane();
        left.setPadding(new Insets(50, 0, 20, 0));
        left.setCenter(buttons);
        left.setBottom(exit);
        left.setStyle("-fx-background-color: #ac383d");
//        Label menu_title = new Label("MENU");
//        menu_title.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
//                "-fx-font-size: 25;-fx-text-fill: #000000;-fx-background-color: #970500;-fx-alignment: Center");
//        left.setTop(menu_title);

        //--CENTER PANES---
        //INVOICE CENTER
        BorderPane invoice_center = new BorderPane();
        //invoice_center.setPadding(new Insets(0,0,0,0));
        Label choose_customer_title = new Label("Wybierz klienta");
        choose_customer_title.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
                "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;" +
                "-fx-background-color: #ac383d");
        VBox choose_cust_menu = new VBox();
        choose_cust_menu.setPadding(new Insets(0,0,0,0));
        choose_cust_menu.getChildren().addAll(invBack,choose_customer_title);
        choose_cust_menu.setStyle("-fx-background-color: #9a2533");
        invoice_center.setLeft(choose_cust_menu);
        ArrayList<Button> buttonList = new ArrayList<>();
//        System.out.println(Database.customers.size());
        for (Customer cust : Database.customers){
//            System.out.println(cust.getName());
            Button temp = new Button(cust.getName());
            temp.setStyle(Styles.menu_button);
            Styles.set_Hover_Style(temp);
            buttonList.add(temp);
            choose_cust_menu.getChildren().addAll(temp);
        }
        //ADD CUSTOMER CENTER
        GridPane customer_center = new GridPane();
        customer_center.setStyle("-fx-background-color: #9a2533");
        Label add_customer_title = new Label("Wprowadź dane");
        add_customer_title.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
                "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;" +
                "-fx-background-color: #ac383d");
        customer_center.add(cusBack,0,0);
        customer_center.add(add_customer_title,0,1);

        //---ROOT BORDER PANE---
        BorderPane root = new BorderPane();
//        root.setPadding(new Insets(15,15,15,15));
//        root.setTop(topTitle);
//        root.setAlignment(topTitle,Pos.CENTER);
        root.setLeft(left);
        root.setMargin(buttons, root.getInsets());
        root.setStyle("-fx-background-image: url('mainbg.jpg')");
//        root.setStyle("-fx-background-color: #0b05c7");

        //---ACTIONS---
        exit.setOnAction(event -> {
            System.exit(0);
        });
        addInv.setOnMouseClicked(event -> {
            root.setCenter(invoice_center);
        });
        addCus.setOnMouseClicked(event -> {
            root.setCenter(customer_center);
        });
        invBack.setOnMouseClicked(event -> {
            root.setCenter(null);
        });
        cusBack.setOnMouseClicked(event -> {
            root.setCenter(null);
        });

        //---CREATE MAIN SCENE AND MANAGE STAGE---
        Scene mainScene = new Scene(root, 1280,720);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Faktury");
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }


}