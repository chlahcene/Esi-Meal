package controller.compt;

import sample.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;

public class Login {


    @FXML
    Button log ;
    @FXML
    Button ret;
    @FXML
    TextField psw ;
    @FXML
    Label err;

    public void loginClique() throws Exception{
        Stage stage= Main.stage;
        Parent root;
        if (!psw.getText().equals("admin")){
            err.setVisible(true);
            psw.setText("");
        }
        else{
            try{

                root = FXMLLoader.load(getClass().getResource("/view/GerantFonction.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle(" Gerant Fonctions");
                stage.show();
                root.requestFocus();
            }
            catch (IOException e) { }
        }
    }

    public void retoureClique(){
        Stage stage= Main.stage;
        Parent root;
        try {

            root = FXMLLoader.load(getClass().getResource("/view/noyeau.fxml"));
            stage.setScene(new Scene(root));

            stage.setTitle("Restaurant ESImeal");

            stage.show();
            root.requestFocus();

        }
        catch (IOException e)
        {

        }
    }
}
