package controller.gerant;

import model.user.*;
import model.commande.*;
import model.type.*;
import model.menu.*;
import controller.*;
import sample.Main;
import controller.client.*;
import controller.gerant.*;
import controller.compt.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton ;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ModifierMenu {
    @FXML
    Button ajoutRep;
    @FXML
    Button resrep1;
    @FXML
    TextField nomrep;
    @FXML
    TextField prixrep;
    @FXML
    TextField nbrep;
    @FXML
    TextField ingrep;
    @FXML
    TextField nomssup;
    @FXML
    TextField prisupp;
    @FXML
    TextField nbsup;
    @FXML
    RadioButton entrer;
    @FXML
    RadioButton plat;
    @FXML
    RadioButton dessert ;
    @FXML
    Label erreur ;

    public void ajouterRepasClique(){

        IntegerStringConverter x = new IntegerStringConverter();
        DoubleStringConverter d = new DoubleStringConverter();
        Set<String> ingrediants = new HashSet<>();
        Set<Supplement> supprpose = new HashSet<>();
        Supplement s ;

        erreur.setStyle("-fx-text-fill: #fd001e");
        if (nomrep.getText().equals("")) {
            erreur.setVisible(true);
        }
        else{ if (prixrep.getText().equals("")) {
            erreur.setVisible(true);
        }else{ if (nbrep.getText().equals("")) {
            erreur.setVisible(true);
        }else {if (ingrep.getText().equals("")) {
            erreur.setVisible(true);
        }else {if (!entrer.isSelected() && !plat.isSelected() && !dessert.isSelected()) {
            erreur.setText("veuillez choisir le type");
            erreur.setVisible(true);
        }else {if(this.verifierSupp()==-1){
            erreur.setText("verifier les supplements");
            erreur.setVisible(true);
        }else{try {

            int i, i1 = 0, i2 = 0, i3 = 0;
            String nom;
            String prix;
            String nbCalories;
            for (i = 0; i < this.verifierSupp() + 1; i++) {
                nom = "";
                prix = "";
                nbCalories = "";
                while (i1 < nomssup.getText().length()) {
                    if (nomssup.getText().charAt(i1) != ',') {
                        nom = nom + nomssup.getText().charAt(i1);
                        i1++;
                    } else {
                        i1++;
                        break;
                    }

                }

                while (i2 < prisupp.getText().length()) {
                    if (prisupp.getText().charAt(i2) != ',') {
                        prix = prix + prisupp.getText().charAt(i2);
                        i2++;

                    } else {
                        i2++;
                        break;
                    }

                }

                while (i3 < nbsup.getText().length()) {
                    if (nbsup.getText().charAt(i3) != ',') {
                        nbCalories = nbCalories + nbsup.getText().charAt(i3);
                        i3++;
                    } else {
                        i3++;
                        break;
                    }

                }

                s = new Supplement(nom, d.fromString(prix), x.fromString(nbCalories));
                supprpose.add(s);
            }

            String ingrediant = "";
            for (i = 0; i < ingrep.getText().length(); i++) {
                if (ingrep.getText().charAt(i) == ',') {
                    ingrediants.add(ingrediant);
                    ingrediant = "";
                } else {
                    if (ingrep.getText().length() - 1 == i) {
                        ingrediant = ingrediant + ingrep.getText().charAt(i);
                        ingrediants.add(ingrediant);
                        ingrediant = "";
                    } else ingrediant = ingrediant + ingrep.getText().charAt(i);
                }
            }
            if (entrer.isSelected())
                Noyeau.res.ajouterRepas(new Repas(nomrep.getText(), x.fromString(prixrep.getText()), x.fromString(nbrep.getText()), ingrediants
                        , true, supprpose, TypeRepas.ENTREE));
            if (dessert.isSelected())
                Noyeau.res.ajouterRepas(new Repas(nomrep.getText(), x.fromString(prixrep.getText()), x.fromString(nbrep.getText()), ingrediants
                        , true, supprpose, TypeRepas.DESSERT));
            if (plat.isSelected())
                Noyeau.res.ajouterRepas(new Repas(nomrep.getText(), x.fromString(prixrep.getText()), x.fromString(nbrep.getText()), ingrediants
                        , true, supprpose, TypeRepas.PLAT));
            erreur.setText("l'ajout réussi");
            erreur.setStyle("-fx-text-fill: #1b8325");
            erreur.setVisible(true);
            nomrep.clear();
            prixrep.clear();
            nbrep.clear();
            ingrep.clear();
            nomssup.clear();
            prisupp.clear();
            nbsup.clear();
            entrer.setSelected(false);
            plat.setSelected(false);
            dessert.setSelected(false);

        }catch (NumberFormatException e){
            erreur.setText("verifier les chifres");
            erreur.setVisible(true);
        }
        }}}}}}
        Noyeau.res.getMenu().afficheMenu();

    }

    private Integer verifierSupp(){
        char c =',';
        int etat = 0;
        int cpt1=0,cpt2=0,cpt3=0,i ;

        if (nomssup.getText().charAt(nomssup.getText().length()-1)==',') return -1 ;
        if (prisupp.getText().charAt(prisupp.getText().length()-1)==',') return -1 ;
        if (nbsup.getText().charAt(nbsup.getText().length()-1)==',') return -1 ;

        for  (i =0 ;i<nomssup.getText().length();i++){
            if(nomssup.getText().charAt(i)==c) cpt1++ ;
        }
        for  (i =0 ;i<prisupp.getText().length();i++){
            if(prisupp.getText().charAt(i)==c) cpt2++ ;
        }
        for  (i =0 ;i<nbsup.getText().length();i++){
            if(nbsup.getText().charAt(i)==c) cpt3++ ;
        }

        if (nomssup.getText().equals("") || prisupp.getText().equals("") || nbsup.getText().equals("")) etat = -1 ;
        else {
            if (cpt1 != cpt2 || cpt2 != cpt3) etat = -1;
            else etat = cpt1 ;
        }

        return etat;
    }

    public void resetRepasAjClique(){
        nomrep.clear();
        prixrep.clear();
        nbrep.clear();
        ingrep.clear();
        nomssup.clear();
        prisupp.clear();
        nbsup.clear();
        entrer.setSelected(false);
        plat.setSelected(false);
        dessert.setSelected(false);
        erreur.setVisible(false);
    }

    @FXML
    Button ajoutboi;
    @FXML
    Button resboi1;
    @FXML
    TextField nomboi;
    @FXML
    TextField priboi;
    @FXML
    TextField nbboi;
    @FXML
    TextField marqboi;
    @FXML
    TextField goutboi;
    @FXML
    RadioButton jus;
    @FXML
    RadioButton eau;
    @FXML
    RadioButton gaz;
    @FXML
    RadioButton caf;
    @FXML
    RadioButton the;
    @FXML
    Label errboi ;

    public void ajouterBoissonClique() {
        IntegerStringConverter x = new IntegerStringConverter();
        DoubleStringConverter d = new DoubleStringConverter();
        errboi.setStyle("-fx-text-fill: #fd001e");
        if (nomboi.getText().equals("")) {
            errboi.setVisible(true);
        } else {
            if (priboi.getText().equals("")) {
                errboi.setVisible(true);
            } else {
                if (nbboi.getText().equals("")) {
                    errboi.setVisible(true);
                } else {
                    if (marqboi.getText().equals("")) {
                        errboi.setVisible(true);
                    } else {
                        if (goutboi.getText().equals("")) {
                            errboi.setVisible(true);
                        } else {
                            if (!jus.isSelected() && !eau.isSelected() && !gaz.isSelected() && !caf.isSelected() && !the.isSelected()) {
                                errboi.setText("veuillez selectionne un type");
                                errboi.setVisible(true);
                            }else {
                                try {

                                    if (jus.isSelected())
                                        Noyeau.res.ajouterBoisson(new Boisson(nomboi.getText(), d.fromString(priboi.getText())
                                                , x.fromString(nbboi.getText()), marqboi.getText(), goutboi.getText(), true, TypeBoisson.JUS));
                                    if (eau.isSelected())
                                        Noyeau.res.ajouterBoisson(new Boisson(nomboi.getText(), d.fromString(priboi.getText())
                                                , x.fromString(nbboi.getText()), marqboi.getText(), goutboi.getText(), true, TypeBoisson.EAU_MINERALE));
                                    if (gaz.isSelected())
                                        Noyeau.res.ajouterBoisson(new Boisson(nomboi.getText(), d.fromString(priboi.getText())
                                                , x.fromString(nbboi.getText()), marqboi.getText(), goutboi.getText(), true, TypeBoisson.GAZEUSE));
                                    if (caf.isSelected())
                                        Noyeau.res.ajouterBoisson(new Boisson(nomboi.getText(), d.fromString(priboi.getText())
                                                , x.fromString(nbboi.getText()), marqboi.getText(), goutboi.getText(), true, TypeBoisson.CAFE));
                                    if (the.isSelected())
                                        Noyeau.res.ajouterBoisson(new Boisson(nomboi.getText(), d.fromString(priboi.getText())
                                                , x.fromString(nbboi.getText()), marqboi.getText(), goutboi.getText(), true, TypeBoisson.THE));
                                    errboi.setText("l'ajout est réussi");
                                    errboi.setStyle("-fx-text-fill: #1b8325");
                                    errboi.setVisible(true);
                                    nomboi.clear();
                                    priboi.clear();
                                    nbboi.clear();
                                    marqboi.clear();
                                    goutboi.clear();
                                    jus.setSelected(false);
                                    eau.setSelected(false);
                                    caf.setSelected(false);
                                    the.setSelected(false);
                                    gaz.setSelected(false);

                                }catch (NumberFormatException e){
                                    errboi.setText("verifier votre chifre");
                                    errboi.setVisible(true);
                                }
                            }
                        }
                    }
                }
            }

        }
        Noyeau.res.getMenu().afficheMenu();
    }

    public void resetBoissonAjClique(){
        nomboi.clear();
        priboi.clear();
        nbboi.clear();
        marqboi.clear();
        goutboi.clear();
        jus.setSelected(false);
        eau.setSelected(false);
        caf.setSelected(false);
        the.setSelected(false);
        gaz.setSelected(false);
        errboi.setVisible(false);

    }

    @FXML
    Button suprep ;
    @FXML
    Button resrep2 ;
    @FXML
    TextField repasup ;
    @FXML
    Label erreursuprep ;
    public void supprimerRepasClique(){
        if (Noyeau.res.supprimerRepas(repasup.getText())) {
            erreursuprep.setStyle("-fx-text-fill: #1b8325"); ;
            erreursuprep.setText("suppression réussite");
            repasup.clear();
            erreursuprep.setVisible(true);
        }else
        {
            erreursuprep.setStyle("-fx-text-fill: #fd001e"); ;
            erreursuprep.setText("le repas n'existe pas");
            erreursuprep.setVisible(true);
        }
        Noyeau.res.getMenu().afficheMenu();
    }

    public void resetRepasSupClique(){
        repasup.clear();
        erreursuprep.setVisible(false);
    }
    @FXML
    Button supboi ;
    @FXML
    Button resboi2 ;
    @FXML
    TextField boisup ;
    @FXML
    Label erreursupboi ;

    public void supprimerBoissonClique(){
        if (Noyeau.res.supprimerBoisson(boisup.getText())) {
            erreursupboi.setStyle("-fx-text-fill: #1b8325"); ;
            erreursupboi.setText("suppression réussite");
            boisup.clear();
            erreursupboi.setVisible(true);
        }else
        {
            erreursupboi.setStyle("-fx-text-fill: #fd001e"); ;
            erreursupboi.setText("le repas n'existe pas");
            erreursupboi.setVisible(true);
        }
        Noyeau.res.getMenu().afficheMenu();
    }

    public void resetBoissonSupClique(){
        boisup.clear();
        erreursupboi.setVisible(false);
    }

    @FXML
    Button retrep1;
    @FXML
    Button retrep2;
    @FXML
    Button retboi1;
    @FXML
    Button retboi2;
    public void retourClique(){
        Stage stage= Main.stage;
        Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("view/GerantFonction.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle(" Gerant Fonctions");
                stage.show();
                root.requestFocus();
            }
            catch (IOException e) {}

    }
}

