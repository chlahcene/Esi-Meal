package controller.client;


import model.user.*;
import controller.*;
import sample.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

public class ClientFideleLogin  {
    static int codefid  ;

    @FXML
    Button connecter,suivaclientinterf   ;
    @FXML
    TextField  contenuecodef ;
    @FXML
    Label errconexion;
    public void retourClique(){
        Stage stage= Main.stage;
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/noyeau.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Bienvenue");
            stage.show();
            root.requestFocus();
        }
        catch (IOException e) {}
    }

    public void connecterClique () {
        IntegerStringConverter x = new IntegerStringConverter();
        ClientFidele cl = Noyeau.res.avoirClientFidele(x.fromString(contenuecodef.getText())) ;
        if (cl == null) {
            errconexion.setVisible(true);
        } else {
            Stage stage = Main.stage;
            Parent root;
            try {
                errconexion.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Client Fidele Informations");
                alert.setHeaderText(null);
                alert.setContentText("nom :"+cl.getNom()+"\n\n"+"prenom :"+cl.getPrenom()+"\n\n"+"numero de telephone :"+cl.getNumTel()+"\n\n"+"nombre de commande :"+cl.getNbCmd());
                alert.showAndWait();
                if(alert.getResult().equals(ButtonType.OK)){
                    codefid = x.fromString(contenuecodef.getText()) ;
                    root = FXMLLoader.load(getClass().getResource("/view/ClientFideleInterface.fxml"));
                    stage.setScene(new Scene(root));
                    stage.setTitle(" Bienvenue Client Fidele");
                    stage.show();
                    root.requestFocus();
                }

            }catch (IOException e) {
            }
        }

    }



}
