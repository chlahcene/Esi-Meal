import classes.ClientFidele;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button ;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;

import static com.sun.javaws.ui.SplashScreen.hide;

public class ModifierAdresses extends Stage{


    public ModifierAdresses(ClientFidele cl){
        Stage stage = Main.stage;
        Label adresseNom = new Label("Adresse") ;
        TextField nouvelleAdresse = new TextField() ;
        nouvelleAdresse.setPromptText("adresse1,adresse2,...");
        Accordion accordion = new Accordion();
        VBox contenu = new VBox(10) ;
        CheckBox []tab = new CheckBox[cl.getAdresse().size()];
        Button valider1=new Button("Supprimer") ,valider2= new Button("Ajouter") , annuler1 =new Button("Annuler"),
                annuler2= new Button("Annuler") ;
        HBox boutons1 = new HBox(10) ;
        HBox boutons2 = new HBox(10) ;
        HBox champAdresse = new HBox(20,adresseNom,nouvelleAdresse) ;
        for (int i = 0; i<cl.getAdresse().size();i++){
            tab[i] = new CheckBox(cl.getAdresse().get(i));
            contenu.getChildren().add(tab[i]) ;
        }


        valider1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>(){
            public void handle(javafx.event.ActionEvent actionEvent)
            {
                for (int i = 0; i<cl.getAdresse().size();i++){
                    if (tab[i].isSelected()){
                        cl.supprimerAdresse(tab[i].getText());
                    }
                }
                hide();
            }} );
        annuler1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>(){
            public void handle(javafx.event.ActionEvent actionEvent)
            {
                hide();
            }} );
        valider2.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>(){
            public void handle(javafx.event.ActionEvent actionEvent)
            {
                boolean erreur = false ;
                if (nouvelleAdresse.getText().equals("")) erreur = true ;
                else{
                    if (nouvelleAdresse.getText().charAt(nouvelleAdresse.getText().length()-1)==',') erreur = true;
                    else if (nouvelleAdresse.getText().charAt(0)==',') erreur = true ;
                }

                if (erreur){
                    Alert alert =  new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Client Fidele");
                    alert.setHeaderText(null);
                    alert.setContentText("veuillez entrer entre chaque adresse une virgule !");
                    alert.showAndWait();
                }else {
                    String s = "";
                    for (int i = 0; i < nouvelleAdresse.getText().length(); i++) {
                        if (nouvelleAdresse.getText().charAt(i) == ',') {
                            cl.ajouterAdresse(s);
                            s = "";
                        } else {
                            s = s + nouvelleAdresse.getText().charAt(i);
                        }

                    }
                    cl.ajouterAdresse(s);
                    hide();
                }
            }} );
        annuler2.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>(){
            public void handle(javafx.event.ActionEvent actionEvent)
            {
                hide();
            }} );

        boutons1.getChildren().addAll(valider1 ,annuler1) ;
        Label message1 = new Label("veuillez selectionné les adresses a supprimer :");
        VBox contenu1 = new VBox(15,message1,contenu,boutons1) ;
        TitledPane t1 = new TitledPane("Suppression d'adresse",contenu1);

        boutons2.getChildren().addAll(valider2,annuler2) ;
        Label message2 = new Label("Faire entrer les adresses");
        VBox contenu2 =  new VBox(30,message2,champAdresse,boutons2) ;
        TitledPane t2 = new TitledPane("Ajouter Les adresses",contenu2);
        accordion.getPanes().addAll(t1,t2) ;

        this.setScene(new Scene(accordion,600,600));
    }


}
