import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import java.awt.*;
import javafx.scene.control.TextField ;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.omg.CORBA.INITIALIZE;

public class ClientInterface   {
    @FXML
    RadioButton surplace,domicile,evenement ;
    @FXML
    Label typetable,codis  ;
    @FXML
    RadioButton intertable ,extertable ,married,anniversaire,autreevenm,yesstud,nostud;;
    @FXML
    TextField nombrePersonne,nom,prenom,tel ;
    @FXML
    TextField contenuadr ;
    @FXML
    TextField  contenudistance;
    @FXML
    Label adr,typevenmlab ;
    @FXML
    Label distance   ;

    static public String adres,nbper,prenomutilisateur,nomutilisateur,numeroTelephone,dist ;
    static public  boolean srplc=false , dmcl=false,vnm=false,tablein,tableout,mar,birth,other ,etudiant ;

    public void surPlaceClique ()
    {
        typetable.setVisible(true);
        intertable.setVisible(true);
        extertable.setVisible(true);
        this.adr.setVisible(false);
        this.contenuadr.setVisible(false);
        this.distance.setVisible(false);
        this.contenudistance.setVisible(false);
        surplace.setSelected(true);
        srplc=true;
        typevenmlab.setVisible(false);
        married.setVisible(false);
        anniversaire.setVisible(false);
        autreevenm.setVisible(false);

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
        domicile.setSelected(true);
        dmcl=true;
        typevenmlab.setVisible(false);
        married.setVisible(false);
        anniversaire.setVisible(false);
        autreevenm.setVisible(false);

    }
    public void evenementClique () {
        this.typetable.setVisible(false);
        this.intertable.setVisible(false);
        this.extertable.setVisible(false);
        this.adr.setVisible(false);
        this.contenuadr.setVisible(false);
        this.distance.setVisible(false);
        this.contenudistance.setVisible(false);
        vnm = true ;
        evenement.setSelected(true);
        typevenmlab.setVisible(true);
        married.setVisible(true);
        anniversaire.setVisible(true);
        autreevenm.setVisible(true);
    }

    public void yesetud()
    {
        yesstud.setSelected(true);
        etudiant=true ;
    }
    public void noetud()
    {
        nostud.setSelected(true);
        etudiant=false ;
    }
    public void typetablexter()
    {
        tableout=true ;
    }
    public void typetableinter()
    {
        tablein=true  ;
    }
    public void marrier()
    {
        mar = true ;
    }
    public void anniver()
    {
        birth = true ;
    }
    public void autrer()
    {
        other = true ;
    }


    public void eatClique(){
        Stage stage = Main.stage ;
        Parent root ;
        try {
            nbper = nombrePersonne.getText() ;
            adres = contenuadr.getText() ;
            prenomutilisateur = prenom.getText() ;
            nomutilisateur= nom.getText() ;
            dist= contenudistance.getText() ;
            numeroTelephone = tel.getText() ;
            root = FXMLLoader.load(getClass().getResource("EatInterface.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Eat Interface  ");
            stage.show();
        }
        catch (IOException e){}
    }


}
