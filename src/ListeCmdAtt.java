import classes.Commande;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.Set;

public class ListeCmdAtt extends Stage{
    public ListeCmdAtt(Set<Commande> cmdEffectue){
        DoubleStringConverter d = new DoubleStringConverter();
        IntegerStringConverter x = new IntegerStringConverter();
        TabPane root= new TabPane();
        root.setPadding(new Insets(10,10,10,10));
        Button boutons[] = new Button[cmdEffectue.size()];
        Integer numCmd[] = new Integer[cmdEffectue.size()];

        int i=0;

        for (Commande c : cmdEffectue
             ) {
            VBox a = new VBox(15);
            Tab tab = new Tab();
            Label nbper = new Label();
            Label nom = new Label();
            Label prenom = new Label();
            Label date = new Label();
            Label tarif = new Label();
            Accordion accordion = new Accordion();
           for (int j = 0;j<c.getNbPers();j++){
                VBox conteneurs =  new VBox(12);
                for (int k = 0;k<c.getCmds().get(j).taille();k++){
                    Label label1 = new Label(c.getCmds().get(j).getMet(k).getNom());
                    conteneurs.getChildren().add(label1) ;
                }
                TitledPane t = new TitledPane("Perssone"+(j+1),conteneurs);
                accordion.getPanes().add(t);
            }

            nom.setText("Le nome de client "+c.getClient().getNom());
            prenom.setText("Le prenom de client "+c.getClient().getPrenom());
            date.setText("L'heure de consomation "+c.getHeurCosom().toString());
            tarif.setText("Le tarif "+( d.toString(c.getTarif())));
            nbper.setText(" nombre du perssone "+x.toString(c.getNbPers()));
            boutons[i]= new Button("Effectuée "+c.getNmCmd()) ;
            numCmd[i] = c.getNmCmd();
            int finalI = i;
            boutons[i].setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>(){
                public void handle(javafx.event.ActionEvent actionEvent)
                {
                    Noyeau.res.effectueCmdAtt(numCmd[finalI]);
                    hide();
                }} );
            a.getChildren().addAll(nom,prenom,date,tarif,nbper,accordion);
            tab.setText("Commande "+c.getNmCmd());
            tab.setContent(a);
            root.getTabs().add(tab);
            i++;
        }

        this.setScene(new Scene(root,400,600));
    }
}
