package controller;

import model.user.*;
import model.commande.*;
import model.type.*;
import model.menu.*;
import controller.*;
import sample.Main;
import controller.client.*;
import controller.gerant.*;
import controller.compt.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.beans.EventHandler;


public class Resultat extends Stage{




    public Resultat(Client c,final String head){
        Label label1 = new Label() ;
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        label1.setAlignment(Pos.CENTER);
        label1.setFont(Font.font ("Verdana", 16));
        label1.setLineSpacing(20);
        label2.setAlignment(Pos.CENTER);
        label2.setFont(Font.font ("Verdana", 16));
        label2.setLineSpacing(20);
        label3.setAlignment(Pos.CENTER);
        label3.setFont(Font.font ("Verdana", 16));
        label3.setLineSpacing(20);
        label4.setAlignment(Pos.CENTER);
        label4.setFont(Font.font ("Verdana", 16));
        label4.setLineSpacing(20);
        VBox contenu = new VBox(50);
        contenu.setPadding(new Insets(20,20,20,20));
        contenu.setAlignment(Pos.CENTER);
        Button quitter = new Button("fermer");
        label1.setText("Le nom est    : "+c .getNom());
        label2.setText("Le prenom est :"+c .getPrenom());
        label3.setText("Le numero de telephone "+c.getNumTel());
        if (c instanceof ClientFidele){

            label4.setText("Le Client est fidele son code de fidlite est "+((ClientFidele)c).getCodeFidelite());
        }else{
            label4.setText("Le Client n'est pas fidele  ");
        }
        quitter.setOnAction(new javafx.event.EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                hide();
            }});
        contenu.getChildren().addAll(new Label(head),label1,label2,label3,label4,quitter);
        this.setTitle("Met Statistique");
        this.setScene(new Scene(contenu,350,400));

    }

    public Resultat(Met m,final String head) {
        Label label1 = new Label() ;
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        label1.setAlignment(Pos.CENTER);
        label1.setFont(Font.font ("Verdana", 16));
        label1.setLineSpacing(20);
        label2.setAlignment(Pos.CENTER);
        label2.setFont(Font.font ("Verdana", 16));
        label2.setLineSpacing(20);
        label3.setAlignment(Pos.CENTER);
        label3.setFont(Font.font ("Verdana", 16));
        label3.setLineSpacing(20);
        label4.setAlignment(Pos.CENTER);
        label4.setFont(Font.font ("Verdana", 16));
        label4.setLineSpacing(20);
        VBox contenu = new VBox(50);
        contenu.setPadding(new Insets(20,20,20,20));
        contenu.setAlignment(Pos.CENTER);
        Button quitter = new Button("fermer");
        if (m instanceof Repas){
            label1.setText("Le nom de ce Repas "+m.getNom());
            label2.setText("Le prix est "+m.getPrix());
            label3.setText("Le nombre de calories "+m.getNombreCalories());
            label4.setText("Le type est "+((Repas)m).getType().toString());
            }else{
                label1.setText("Le nom de ce boisson "+m.getNom());
                label2.setText("Le prix est "+m.getPrix());
                label3.setText("Le nombre de calories "+m.getNombreCalories());
                label4.setText("Le type est "+((Boisson)m).getType().toString());
            }
            quitter.setOnAction(new javafx.event.EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                hide();
            }});
            contenu.getChildren().addAll(new Label(head),label1,label2,label3,label4,quitter);
            this.setTitle("Met Statistique");
            this.setScene(new Scene(contenu,350,400));
    }

}
