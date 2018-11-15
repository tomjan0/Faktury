package mypackage;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Faktury");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15,15,15,15));

        Text topTitle = new Text("Wybierz opcję: ");
        topTitle.setFont(Font.font("Tahoma", 20));
        topTitle.setTextAlignment(TextAlignment.CENTER);
        root.setAlignment(topTitle,Pos.CENTER);



        root.setTop(topTitle);

        Scene mainScene = new Scene(root, 300,300);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
}