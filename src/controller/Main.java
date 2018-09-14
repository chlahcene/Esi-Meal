package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.awt.*;
import java.util.* ;

public class Main extends Application {


    public  static  Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/noyeau.fxml"));
        primaryStage.setTitle("Restaurant ESImeal");
        stage=primaryStage;
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.requestFocus();

    }
}