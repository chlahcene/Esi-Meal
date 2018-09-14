import classes.ClientFidele;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Inscription {
    @FXML
    Button ins ;
    @FXML
    Button retins ;
    @FXML
    Label errins ;
    @FXML
    TextField nom ;
    @FXML
    TextField prenom ;
    @FXML
    TextField numtel ;
    @FXML
    TextField adresse ;
    @FXML
    RadioButton ouietud ;
    @FXML
    RadioButton nonetud ;

    public void retourInscriptionClique(){
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

    public void inscrireInscriptionClique(){
        IntegerStringConverter x = new IntegerStringConverter() ;
        errins.setStyle("-fx-text-fill: #fd001e");
        if (nom.getText().equals("") || prenom.getText().equals("") || numtel.getText().equals("")){
            errins.setText("remplire les donnée completement");
            errins.setVisible(true);
        }else {
            if (!ouietud.isSelected() && !nonetud.isSelected()){
                errins.setText("Remplere le champs d'etudiant");
                errins.setVisible(true);
            }else{
                if(!this.verifierAdresse()){
                    errins.setText("Verifier la liste d'adresses ");
                    errins.setVisible(true);
                }else{
                    if (!this.verifierNumTel()){
                        errins.setText("Verifier le numero de telephone ");
                        errins.setVisible(true);
                    }else try {
                        x.fromString(numtel.getText());
                        ArrayList<String> adresses = new ArrayList<String>();
                        String a = "";
                        for (int i = 0; i < adresse.getText().length(); i++) {
                            if (adresse.getText().charAt(i) == ',') {
                                adresses.add(a);
                                a = "";
                            } else {
                                 a =a +adresse.getText().charAt(i);
                            }

                        }
                        adresses.add(a) ;
                        ClientFidele cl = new ClientFidele(nom.getText(), prenom.getText(), numtel.getText(),ouietud.isSelected(),
                                Noyeau.res.getClients().size()+1,adresses);
                        Noyeau.res.ajouteClientFidele(cl);
                        errins.setStyle("-fx-text-fill: #1b8325");
                        errins.setText("L'ajout reussie");
                        errins.setVisible(true);
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(Main.stage);
                        alert.setTitle("Client Fidele Inscription");
                        alert.setHeaderText(null);
                        alert.setContentText("votre code de fidelité est "+Noyeau.res.getClients().size());
                        alert.showAndWait();
                        errins.setVisible(false);
                        errins.setText("remplire les donnée completement");
                        nom.clear();
                        prenom.clear();
                        numtel.clear();
                        adresse.clear();
                        nonetud.setSelected(false);
                        ouietud.setSelected(false);
                    } catch (NumberFormatException e) {
                        errins.setStyle("-fx-text-fill: #fd001e");
                        errins.setText("Verifier le numero de telephone ");
                        errins.setVisible(true);
                    }

                }
            }
        }
    }

    private boolean verifierAdresse(){
        if (adresse.getText().equals("")) return false ;
        else{
            if (adresse.getText().charAt(adresse.getText().length()-1)==',') return  false;
            else if (adresse.getText().charAt(0)==',') return false ;
            else return true ;
        }
    }

    private boolean verifierNumTel(){
        if ( numtel.getText().charAt(0)!='0') return false ;
        else {
            if((numtel.getText().charAt(1)!='5') && (numtel.getText().charAt(1)!='6') && (numtel.getText().charAt(1)!='7') ) return  false ;
            else {
                if (numtel.getText().length()!= 10) return false;
                else return true ;
            }
        }
    }
}
