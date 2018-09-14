import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.*;

public class Noyeau implements Initializable {
    static Restaurant res = Init.initRestaurant();
    static Boolean utilfid=false ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    Button gerant;

    @FXML
    Button client;
    public void clientClique(){
        Stage stage = Main.stage ;
        Parent root ;
        try {
            root = FXMLLoader.load(getClass().getResource("ClientFonction.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Bienvenue client ");
            stage.show();
        }
        catch (IOException e){}

    }

    @FXML
    Button clientf ;
    public void clientFideleClique(){
        Stage stage = Main.stage ;
        Parent root ;
        try {
            utilfid=true ;
            root = FXMLLoader.load(getClass().getResource("ClientFideleLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Client Fidele  ");
            stage.show();
        }
        catch (IOException e){}

    }

    public void gerantClique(){
        Stage stage = Main.stage ;
        Parent root ;
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle(" Login  ");
                stage.show();
            }
            catch (IOException e){}

    }

    public void fermer(){
        Platform.exit();
    }


}

