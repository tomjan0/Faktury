package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //---CREATE TITLE TEXT---
//        Text topTitle = new Text("Wybierz opcję: ");
//        topTitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
//        topTitle.setTextAlignment(TextAlignment.CENTER);

        //---CREATE BUTTONS---
        Button addInv = new Button("Dodaj Fakturę");
        Button addCus = new Button("Dodaj Klienta");
        Button addArt = new Button("Dodaj Artykuł");
        Button showInv = new Button("Wyświetl fakturę");
        Button view = new Button("Przeglądaj Bazę");
        Button exit = new Button("ZAMKNIJ");

        //---ACTIONS---
        exit.setOnAction(event -> {
            System.exit(0);
        });

        //---BUTTONS TO VBOX---
        VBox buttons = new VBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.TOP_CENTER);
        buttons.getChildren().addAll(addInv,addCus,addArt,showInv,view);
        //buttons.setStyle("-fx-background-color: #ac383d");

        //---BUTTONS STYLE---
        for (Node b : buttons.getChildren()){
            b.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
                    "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent;");
            Styles.set_Hover_Style((Button) b);
        }
        exit.setStyle(Styles.style_button);
        Styles.set_Hover_Style(exit);

        //---MENU BORDER PANE---
        BorderPane left = new BorderPane();
        left.setPadding(new Insets(20, 0, 20, 0));
        left.setTop(buttons);
        left.setBottom(exit);
        left.setStyle("-fx-background-color: #ac383d");


        //---ROOT BORDER PANE---
        BorderPane root = new BorderPane();
//        root.setPadding(new Insets(15,15,15,15));
//        root.setTop(topTitle);
//        root.setAlignment(topTitle,Pos.CENTER);
        root.setLeft(left);
        root.setMargin(buttons, root.getInsets());
        root.setStyle("-fx-background-image: url('mainbg.jpg')");

        //---CREATE MAIN SCENE---
        Scene mainScene = new Scene(root, 1280,720);

        //---MANAGING STAGE---
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Faktury");
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }


}