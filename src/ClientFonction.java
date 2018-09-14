import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button ;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ClientFonction {
    @FXML
    Button retcl;
    public void retourClientClique(){
        Stage stage=Main.stage;
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("noyeau.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Bienvenue");
            stage.show();
            root.requestFocus();
        }
        catch (IOException e) {}
    }

    @FXML
    Button inscl ;
    public void inscrirClientClique(){
        Stage stage=Main.stage;
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Client Fonctions");
            stage.show();
            root.requestFocus();
        }
        catch (IOException e) {}
    }

    @FXML
    Button cmdcl ;
    public void commanderClicque(){
        Stage stage=Main.stage;
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("ClientInterface.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Client Commander");
            stage.show();
            root.requestFocus();
        }
        catch (IOException e) {}
    }

}
