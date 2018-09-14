import classes.Client;
import classes.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Scene;
import java.awt.*;
import classes.* ;

import javafx.collections.FXCollections ;

import javafx.scene.control.Button ;
import javafx.scene.control.TextField ;
import javafx.scene.control.Label ;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EatInterface  implements  Initializable {
    ObservableList list1 = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();
    ObservableList list3 = FXCollections.observableArrayList();
    String choirepas;
    List<String> choiboisson = new ArrayList<String>();
    List<String> choisupplem = new ArrayList<String>();
    Menu m = new Menu();
    Commande cmd;
    static Map<Integer, Menu> vol = new HashMap<>();
    @FXML
    ListView<String> listrepas, listeboisson, listsuppl;

    @FXML
    Button choi1, fer,vmodifcmd;
    @FXML
    Button choi2, fermsupl, fincommande;
    @FXML
    Text numenu;
    @FXML
    Text labsupplem;
    @FXML
    VBox vsupp;
    @FXML
    Button valide;
    Map<Integer, Menu> menusoffic = new HashMap<>();

    static int numcmd = 0;


    public void setlistRepas() {
        for (int i = 0; i < Noyeau.res.getMenu().taille(); i++) {
            if (Noyeau.res.getMenu().getMet(i) instanceof Repas && ((Repas) Noyeau.res.getMenu().getMet(i)).isDisponible()) {
                list1.add(Noyeau.res.getMenu().getMet(i).getNom()); // liste des repas du restaurant
            }

        }
    }

    public void setListsuppl(Repas a) {

        for (Supplement it : a.getSupplementsprpose()) {
            list3.add(it.getNom()); // liste supplements du repas a

        }

    }

    public void setlistboisson() {
        for (int i = 0; i < Noyeau.res.getMenu().taille(); i++) {
            if (Noyeau.res.getMenu().getMet(i) instanceof Boisson && ((Boisson) Noyeau.res.getMenu().getMet(i)).isDisponible()) {
                list2.add(Noyeau.res.getMenu().getMet(i).getNom()); // liste des boissons du restaurant

            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        setlistRepas();
        setlistboisson();
        listrepas.getItems().addAll(list1);
        listeboisson.getItems().addAll(list2);
        listeboisson.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listrepas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listsuppl.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void choicerepasclique() {
        choirepas = listrepas.getSelectionModel().getSelectedItem();


        for (int i = 0; i < Noyeau.res.getMenu().taille(); i++) {
            if ((Noyeau.res.getMenu().getMet(i) instanceof Repas) && choirepas == (Noyeau.res.getMenu().getMet(i).getNom())) {

                setListsuppl((Repas) Noyeau.res.getMenu().getMet(i));
            }

        }

        vsupp.setVisible(true);
        listsuppl.setVisible(true);
        labsupplem.setVisible(true);
        choi1.setVisible(false);
        listsuppl.getItems().addAll(list3);
        listsuppl.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void choiceboissonclique()
    {
        choiboisson.addAll(listeboisson.getSelectionModel().getSelectedItems());
    }

    public void choicesupplementclique() {
        choisupplem.addAll(listsuppl.getSelectionModel().getSelectedItems());

    }


    public void ajoutboissonmenu() {

        for (String strit : choiboisson) {
            for (int i = 0; i < Noyeau.res.getMenu().taille(); i++) {
                if (strit == Noyeau.res.getMenu().getMet(i).getNom()) {
                    Boisson b = (Boisson) Noyeau.res.getMenu().getMet(i);
                    m.ajouterMet(new Boisson(b.getNom(), b.getPrix(), b.getNombreCalories(), b.getMarque(), b.getGout(), b.getType()));
                }
            }
        }

    }

    public void fermersupllement() {

        Set<Supplement> temp = new HashSet<>();
        double nad =0 ;
        for (int i = 0; i < Noyeau.res.getMenu().taille(); i++) {
            if (choirepas == Noyeau.res.getMenu().getMet(i).getNom()) {
                Repas r = (Repas) Noyeau.res.getMenu().getMet(i);

                for (int j = 0; j < choisupplem.size(); j++) {

                    String sup = choisupplem.get(j);

                    for (Supplement it : r.getSupplementsprpose()) {
                        if (sup == it.getNom()) {
                            temp.add(it);
                            nad += it.getPrix() ;
                        }

                    }

                }
               nad+= r.getPrix() ;
                m.ajouterMet(new Repas(r.getNom(),nad, r.getNombreCalories(), temp, r.getType()));

            }
        }

        int nadjib = choisupplem.size() ;
        for (int i = 0 ; i< nadjib ; i++ )
            choisupplem.remove(i) ;
        list3.remove(0,list3.size());
        vsupp.setVisible(false);
        choi1.setVisible(true);
    }

    public void creercmd() {

        if (Noyeau.utilfid == false) // client normale
        {
            int n = Integer.parseInt(ClientInterface.nbper);

            if (ClientInterface.srplc) // commande surplace
            {
                if (ClientInterface.tablein)
                {
                    cmd = new CmdSurPlace(Noyeau.res.nbCmdTotal()+1,ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, n, TypeTable.INTERIEUR, menusoffic,ClientInterface.etudiant);
                } else {
                    cmd = new CmdSurPlace(Noyeau.res.nbCmdTotal()+1,ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, n, TypeTable.EXTERIEUR, menusoffic,ClientInterface.etudiant);
                }
                System.out.println("rani hana");
            }
            if (ClientInterface.dmcl) // commande a domicile
            {
                int d = Integer.parseInt(ClientInterface.dist);
                cmd = new CmdADomicile(Noyeau.res.nbCmdTotal()+1,n, ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, ClientInterface.adres, menusoffic, d,ClientInterface.etudiant);
                System.out.println("rani hana1");
            }
            if (ClientInterface.vnm) // commande evenement
            {
                if (ClientInterface.birth) {
                    cmd = new CmdEvenement(Noyeau.res.nbCmdTotal()+1,ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, menusoffic.get(1), n, TypeEvenement.ANNIVERSSAIRE,ClientInterface.etudiant);
                }
                if (ClientInterface.mar) {
                    cmd = new CmdEvenement(Noyeau.res.nbCmdTotal()+1,ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, menusoffic.get(1), n, TypeEvenement.MARIAGE,ClientInterface.etudiant);
                }
                if (ClientInterface.other) {
                    cmd = new CmdEvenement(Noyeau.res.nbCmdTotal()+1,ClientInterface.nomutilisateur, ClientInterface.prenomutilisateur, ClientInterface.numeroTelephone, menusoffic.get(1), n, TypeEvenement.AUTRE,ClientInterface.etudiant);
                }
                System.out.println("rani hana2");
            }
        } else // client fidele
        {

            if (ClientInterface.srplc) //
            {  // commande surplace


            }
            if (ClientInterface.dmcl) // commande a domicile
            {

            }
            if (ClientInterface.vnm) // commande evenement
            {

            }
        }
        Noyeau.res.ajouterCmdEnAtt(cmd);

    }

    public void validerclique() {
        int nombrcmd = Integer.parseInt(ClientInterface.nbper);
        if (ClientInterface.vnm) nombrcmd = 1;
        if (numcmd < nombrcmd) {
            ajoutboissonmenu();
            menusoffic.put(numcmd, m);
            numcmd++;

            numenu.setText("Menu : " + numcmd);
            listrepas.getSelectionModel().clearSelection();
            listeboisson.getSelectionModel().clearSelection();
            choiboisson.clear();
            list3.clear();
        } else {

            fincommande.setVisible(true);
            vmodifcmd.setVisible(true);
            valide.setVisible(false);
            numcmd = 1;
        }
    }

    public void mainclique() {
        Stage stage = Main.stage;
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("noyeau.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Main ");
            stage.show();
        } catch (IOException e) {
        }

    }

    public void visualiser()
    {
        Stage stage = Main.stage;
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("infointerface.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        } catch (IOException e) {
        }

    }
}