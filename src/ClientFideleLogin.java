import classes.Client;
import classes.ClientFidele;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import classes.* ;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.* ;

public class ClientFideleLogin  {
    static int codefid  ;

    @FXML
    Button connecter,suivaclientinterf   ;
    @FXML
    TextField  contenuecodef ;
    @FXML
    Label errconexion;
    /*DatePicker dateConsom ;
    @FXML
    Label errcode,lnbper,ltc,ld,lh;



    public void surPlaceClique ()
    {
        this.typetable.setVisible(true);
        this.intertable.setVisible(true);
        this.extertable.setVisible(true);
        this.adr.setVisible(false);
        this.contenuadr.setVisible(false);
        this.distance.setVisible(false);
        this.contenudistance.setVisible(false);

    }
    public void domicileClique ()
    {
        this.typetable.setVisible(false);
        this.intertable.setVisible(false);
        this.extertable.setVisible(false);
        this.adr.setVisible(true);
        this.contenuadr.setVisible(true);
        this.distance.setVisible(true);
        this.contenudistance.setVisible(true);

    }
    public void evenementClique ()
    {
        this.typetable.setVisible(false);
        this.intertable.setVisible(false);
        this.extertable.setVisible(false);
        this.adr.setVisible(false);
        this.contenuadr.setVisible(false);
        this.distance.setVisible(false);
        this.contenudistance.setVisible(false);

    }

    public void eatClique(){
        Stage stage = Main.stage ;
        Parent root ;
        if(heureConsom.getText() !="")
              {
            try {
                root = FXMLLoader.load(getClass().getResource("EatInterface.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle(" Eat Interface  ");
                stage.show();
            }
            catch (IOException e){}

        }
        }
    */
    public void retourClique(){
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
                alert.setContentText("nom :"+cl.getNom()+"\n\n"+"prenom :"+cl.getPrenom()+"\n\n"+"numero de telephone :"+cl.getNum_tel()+"\n\n"+"nombre de commande :"+cl.getNbCmd());
                alert.showAndWait();
                if(alert.getResult().equals(ButtonType.OK)){
                    codefid = x.fromString(contenuecodef.getText()) ;
                    root = FXMLLoader.load(getClass().getResource("ClientFideleInterface.fxml"));
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
