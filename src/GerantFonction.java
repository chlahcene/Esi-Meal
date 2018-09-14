import classes.Client;
import classes.Commande;
import classes.Met;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import static com.sun.javaws.ui.SplashScreen.hide;

public class GerantFonction {
    @FXML
    Button modifier;

    public void modifierClique(){
        Stage stage = Main.stage ;
        Parent root ;
        try {
            root = FXMLLoader.load(getClass().getResource("ModifierMenu.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Modifier Menu ");
            stage.show();
        }
        catch (IOException e){}
    }

    @FXML
    Button listeatt;

    public void visionnerListeAttClique() {
        if (Noyeau.res.getCmdEnAttente().size()==0){
            erreurdate.setVisible(false);
            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(Main.stage);
            alert.setTitle("Gerant");
            alert.setHeaderText(null);
            alert.setContentText("aucune commande en attente !");
            alert.showAndWait();
        }else {
            ListeCmdAtt l = new ListeCmdAtt(Noyeau.res.getCmdEnAttente());
            l.show();
        }
    }



    @FXML
    Button nbcmdeff ;
    @FXML
    DatePicker date1 ;
    @FXML
    DatePicker date2 ;
    @FXML
    Label erreurdate ;

    public void nombreCmdEff() {

        IntegerStringConverter x = new IntegerStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Nombre du commande effectué :");
                alert.setContentText(x.toString(Noyeau.res.nbCmdEffectue(d1,d2)));
                alert.showAndWait();

            }
        }
    }

    @FXML
    Button nbcmdplace;
    public void nombreCmdEffSurPlace() {

        IntegerStringConverter x = new IntegerStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Nombre du commande effectué sur place :");
                alert.setContentText(x.toString(Noyeau.res.nbCmdSurPlace(d1,d2)));
                alert.showAndWait();

            }
        }
    }

    @FXML
    Button nbcmddomicile;
    public void nombreCmdEffADomicile() {

        IntegerStringConverter x = new IntegerStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Nombre du commande effectué à domicile :");
                alert.setContentText(x.toString(Noyeau.res.nbCmdADomicile(d1,d2)));
                alert.showAndWait();

            }
        }
    }

    @FXML
    Button nbcmdeven;
    public void nombreCmdEffEvenement() {

        IntegerStringConverter x = new IntegerStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Nombre du commande effectué evenement :");
                alert.setContentText(x.toString(Noyeau.res.nbCmdEvenement(d1,d2)));
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtcmdeff ;
    public void montantCmdEff() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du commande effectué totale :");
                alert.setContentText(x.toString(Noyeau.res.montantTtCmd(d1,d2)));
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtcmdspl ;
    public void montantCmdEffSurPlace() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du commande effectué totale Sur Place :");
                alert.setContentText(x.toString(Noyeau.res.montantTtCmdSurPlace(d1,d2)));
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtcmddomicile ;
    public void montantCmdEffADomicile() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du commande effectué totale a domicile :");
                alert.setContentText(x.toString(Noyeau.res.montantTtCmdADomicile(d1,d2)));
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtcmdeven ;
    public void montantCmdEffEvenement() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du commande effectué totale evenement:");
                alert.setContentText(x.toString(Noyeau.res.montantTtCmdEvenement(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }

    @FXML
    Button mtredtt;
    public void montantReductionOffert() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du Réductions offertes:");
                alert.setContentText(x.toString(Noyeau.res.montantTotalReduction(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtredfidel;
    public void montantReductionOFidelite() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du Réductions Fidelité :");
                alert.setContentText(x.toString(Noyeau.res.montantReducFidel(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtredetud;
    public void montantReductionEtud() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du Réductions Etudiant:");
                alert.setContentText(x.toString(Noyeau.res.montantReducEtudiant(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtreddomicil;
    public void montantReductionGDomicile() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du Réductions a domicile :");
                alert.setContentText(x.toString(Noyeau.res.montantReducGrDomicile(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }
    @FXML
    Button mtredeven;
    public void montantReductionEvenement() {

        DoubleStringConverter x = new DoubleStringConverter();

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                erreurdate.setVisible(false);
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(Main.stage);
                alert.setTitle("Gerant");
                alert.setHeaderText("Montant du Réductions evenement:");
                alert.setContentText(x.toString(Noyeau.res.montantReducEvenement(d1,d2))+" Da");
                alert.showAndWait();

            }
        }
    }

    @FXML
    Button metplcmd;
    public void metPlusCmd(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Met m = Noyeau.res.metPlusCmd(d1, d2);
                if (m == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("Le menu est vide ou il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(m, "le met le plus commander");
                    r.show();
                }
            }
        }
    }
    @FXML
    Button metmncmd;
    public void metMoinCmd(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Met m = Noyeau.res.metMoinCmd(d1, d2);
                if (m == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("Le menu est vide ou il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(m, "le met le moins commander");
                    r.show();
                }
            }
        }
    }
    @FXML
    Button clplcmd ;
    public void clientPlsCmd(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusCmd(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText(" il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client effectuant le plus commandes");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplcmdspl ;
    public void clientPlsCmdSurPlace(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusCmdSurPlace(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande sur place effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client effectuant le plus commandes sur place");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplscmddomicil ;
    public void clientPlsCmdADomicil(){


        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusCmdADomicil(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande a domiicile effectué!");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client effectuant le plus commandes a domicile");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplcmdeven ;
    public void clientPlsCmdEvenement(){


        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusCmdEvenement(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande evenement effectué ! ");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client effectuant le plus commandes Evenement");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplsred ;
    public void clientPlsReduction(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusReduction(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client benificier le plus de reduction ");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplsredfid ;
    public void clientPlsReductionFidelite(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusReductionFidele(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client benificier le plus de reduction fidelité");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplsreddom ;
    public void clientPlsReductionDomicile(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusReductionGrADomicil(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client benificier le plus de reduction domicile");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplsredetud ;
    public void clientPlsReductionEtudiant(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusReductionEtude(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client benificier le plus de reduction Etudiant");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button clplsredeven ;
    public void clientPlsReductionEvenement(){

        if (date1.getValue()==null|| date2.getValue()==null) {
            erreurdate.setText("veiller remplir les date");
            erreurdate.setVisible(true);
        } else {

            Date d1 = new Date(date1.getValue().getYear(), date1.getValue().getMonthValue(), date1.getValue().getDayOfMonth()),
                    d2 = new Date(date2.getValue().getYear(), date2.getValue().getMonthValue(), date2.getValue().getDayOfMonth());

            if (d1.after(d2)) {
                erreurdate.setText("veiller verifier l'ordre ");
                erreurdate.setVisible(true);
            } else {
                Client c = Noyeau.res.clientPlusReductionEvenement(d1,d2);
                if (c == null) {
                    Alert alert =  new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.stage);
                    alert.setTitle("Gerant");
                    alert.setHeaderText(null);
                    alert.setContentText("il n y a aucune commande effectué !");
                    alert.showAndWait();
                } else {
                    Resultat r = new Resultat(c, "le client benificier le plus de reduction evenement");
                    r.show();
                }
            }
        }
    }

    @FXML
    Button retg;
    public void retourgClique(){
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
}