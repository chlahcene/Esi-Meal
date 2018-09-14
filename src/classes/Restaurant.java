package classes;
/**
 * Décrivez votre classe Restaurant ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import javafx.fxml.FXML;

import java.awt.*;
import java.util.* ;
import java.util.List;
import java.util.Scanner ;


public class Restaurant {
    private Scanner sc = new Scanner(System.in);
    private int nbChaise;
    private int nbTable;
    private Set<ClientFidele> clients;
    private Set<Commande> cmdEnAttente;
    private Set<Commande> cmdEffectue;
    private Menu menu;
    private boolean libre ;




    public Restaurant(int nbChaise, int nbTable) {
        this.nbChaise = nbChaise;
        this.nbTable = nbTable;
        this.clients = new TreeSet<ClientFidele>();
        this.cmdEffectue = new HashSet<Commande>();
        this.cmdEnAttente = new HashSet<Commande>();
        this.menu = new Menu();
    }



    public int nbCmdEffectue(Date d1, Date d2) {
        int cpt = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    public double montantTtCmd(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    montant += c.getTarif();
                }
            }
        }
        return montant;
    }

    public int nbCmdSurPlace(Date d1, Date d2) {
        int cpt = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdSurPlace) cpt++;
                }
            }
        }
        return cpt;
    }

    public double montantTtCmdSurPlace(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdSurPlace) montant += c.getTarif();
                }
            }
        }
        return montant;
    }

    public int nbCmdADomicile(Date d1, Date d2) {
        int cpt = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdADomicile) cpt++;
                }
            }
        }
        return cpt;
    }

    public double montantTtCmdADomicile(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdADomicile) montant += c.getTarif();
                }
            }
        }
        return montant;
    }

    public int nbCmdEvenement(Date d1, Date d2) {
        int cpt = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdEvenement) cpt++;
                }
            }
        }
        return cpt;
    }

    public double montantTtCmdEvenement(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdEvenement) montant += c.getTarif();
                }
            }
        }
        return montant;
    }

    public double montantTotalReduction(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    montant += c.getTarif() * c.getReduction();
                }

            }
        }
        return montant;
    }

    public Set<Commande> getCmdEffectue() {
        return cmdEffectue;
    }

    public double montantReducFidel(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {

            for (Commande c : cmdEffectue
                    ) {
                if (c.getClient() instanceof ClientFidele) {
                    montant += c.getTarif() * 0.05;
                }
            }
        }
        return montant;
    }

    public double montantReducEvenement(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdEvenement && c.getNbPers() >= 50) {
                        montant += c.getTarif() * 0.1;
                    }
                }
            }
        }
        return montant;
    }

    public double montantReducEtudiant(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c.getClient().getEtudiant()) {
                        montant += c.getTarif() * 0.08;
                    }
                }
            }
        }
        return montant;
    }

    public double montantReducGrDomicile(Date d1, Date d2) {
        double montant = 0;
        if (d2.after(d1)) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (c instanceof CmdADomicile && c.getNbPers() >= 4) {
                        montant += c.getTarif() * 0.07;
                    }
                }
            }
        }
        return montant;
    }

    public Met metPlusCmd(Date d1, Date d2) {
        Met m1, m2 ;
        int nbCmd1 = 0, nbCmd2 = 0;
        boolean existAuMoinCmd =false ;
        if (d2.after(d1)) {
            if (menu.taille()==0) return null ;
            else m2 = menu.getMet(0);
            if (cmdEffectue.size() == 0) {
                return null;
            } else {
                for (int i = 0; i < menu.taille(); i++) {
                    m1 = menu.getMet(i);
                    nbCmd1 = 0;
                    for (Commande c : cmdEffectue
                            ) {
                        if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                            for (int j = 0; i < c.getCmds().size(); i++) {
                                if (c.getCmds().get(j).isExiste(m1)) nbCmd1++;
                            }
                            if (nbCmd1>0) existAuMoinCmd = true;
                        }
                    }
                    if (nbCmd1 > nbCmd2) {
                        nbCmd2 = nbCmd1;
                        m2.copier(m1);
                    }
                }
                if (!existAuMoinCmd) return null;
                else return m2;
            }
        }else return null;


    }

    public Met metMoinCmd(Date d1, Date d2) {
        Met m1, m2 ;
        int nbCmd1 = 0, nbCmd2 = Integer.MAX_VALUE;
        boolean existeAuMoinCommande = false ;
        if (d2.after(d1)) {
            if (menu.taille()==0) return null ;
            else m2 = menu.getMet(0);
            if (cmdEffectue.size()==0){
                return null ;
            }
            for (int i = 0; i < menu.taille(); i++) {
                m1 = menu.getMet(i);
                nbCmd1 = 0;
                for (Commande c : cmdEffectue
                        ) {
                    if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                        for (int j = 0; i < c.getCmds().size(); i++) {
                            if (c.getCmds().get(j).isExiste(m1)) nbCmd1++;
                        }
                        if (nbCmd1>0) existeAuMoinCommande = true ;
                    }
                }
                if (nbCmd1 < nbCmd2) {
                    nbCmd2 = nbCmd1;
                    m2.copier(m1);
                }
            }
            if (!existeAuMoinCommande) return null ;
            else  return m2;
        } else return null;
    }

    public Client clientPlusCmd(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int nbCmd1 = 0, nbCmd2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                cl1 = c.getClient();
                for (Commande d : cmdEffectue
                        ) {
                    if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2)) {
                        if (cl1.equals(d.getClient())) nbCmd1++;
                    }

                }
                if (nbCmd1!=0) existeAuMoinCommende=true ;
            }
            if (nbCmd1 > nbCmd2) {
                nbCmd2 = nbCmd1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusCmdSurPlace(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int nbCmd1 = 0, nbCmd2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2) && c instanceof CmdSurPlace) {
                cl1 = c.getClient();
                for (Commande d : cmdEffectue
                        ) {
                    if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2) && d instanceof CmdSurPlace) {
                        if (cl1.equals(d.getClient())) nbCmd1++;
                    }

                }
                if (nbCmd1!=0) existeAuMoinCommende =true ;
            }
            if (nbCmd1 > nbCmd2) {
                nbCmd2 = nbCmd1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusCmdADomicil(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int nbCmd1 = 0, nbCmd2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2) && c instanceof CmdADomicile) {
                cl1 = c.getClient();
                for (Commande d : cmdEffectue
                        ) {
                    if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2) && d instanceof CmdADomicile) {
                        if (cl1.equals(d.getClient())) nbCmd1++;
                    }

                }
                if(nbCmd1!=0) existeAuMoinCommende = true ;
            }
            if (nbCmd1 > nbCmd2) {
                nbCmd2 = nbCmd1;
                cl2 = cl1;
            }
        }
        if(!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusCmdEvenement(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int nbCmd1 = 0, nbCmd2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2) && c instanceof CmdEvenement) {
                cl1 = c.getClient();
                for (Commande d : cmdEffectue
                        ) {
                    if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2) && d instanceof CmdEvenement) {
                        if (cl1.equals(d.getClient())) nbCmd1++;
                    }
                }
                if (nbCmd1!=0) existeAuMoinCommende = true;
            }
            if (nbCmd1 > nbCmd2) {
                nbCmd2 = nbCmd1;
                cl2 = cl1;
            }
        }
        if(!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusReduction(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int reduction1 = 0, reduction2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                cl1 = c.getClient();
                for (Commande d : cmdEffectue
                        ) {
                    if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2)) {
                        if (cl1.equals(d.getClient())) {
                            reduction1 += d.getReduction();
                            existeAuMoinCommende = true ;
                        }
                    }
                }
            }
            if (reduction1 > reduction2) {
                reduction2 = reduction1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusReductionFidele(Date d1, Date d2) {
        Client cl2 = new Client("", "", "", false);
        int reduction1 = 0, reduction2 = 0;
        boolean existeAuMoinCommende = false ;
        for (ClientFidele cl1:
             clients) {
            for (Commande c : cmdEffectue
                    ) {
                if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                    if (cl1.equals(c.getClient()) && cl1.getNbCmd()>=2){
                        reduction1 +=0.05 ;
                        existeAuMoinCommende = true;
                    }
                }
            }
            if (reduction1 > reduction2) {
                reduction2 = reduction1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null;
        else return cl2;
    }

    public Client clientPlusReductionEtude(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int reduction1 = 0, reduction2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                cl1 = c.getClient();
                if (cl1.getEtudiant()) {
                    for (Commande d : cmdEffectue
                            ) {
                        if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2)) {
                            if (cl1.equals(d.getClient())){
                                reduction1 += 0.08;
                                existeAuMoinCommende = true ;
                            }
                        }
                    }
                }
            }
            if (reduction1 > reduction2) {
                reduction2 = reduction1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Client clientPlusReductionGrADomicil(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int reduction1 = 0, reduction2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                cl1 = c.getClient();
                if (cl1.getEtudiant()) {
                    for (Commande d : cmdEffectue
                            ) {
                        if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2) && d instanceof CmdADomicile) {
                            if (cl1.equals(d.getClient()) && d.getNbPers()>=4){
                                reduction1 += 0.07;
                                existeAuMoinCommende = true ;
                            }
                        }
                    }
                }
            }
            if (reduction1 > reduction2) {
                reduction2 = reduction1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null ;
        else return cl2;
    }

    public Set<Commande> getCmdEnAttente() {
        return cmdEnAttente;
    }

    public Client clientPlusReductionEvenement(Date d1, Date d2) {
        Client cl1 = new Client("", "", "", false), cl2 = new Client("", "", "", false);
        int reduction1 = 0, reduction2 = 0;
        boolean existeAuMoinCommende = false ;
        for (Commande c : cmdEffectue
                ) {
            if (c.getHeurCosom().after(d1) && c.getHeurCosom().before(d2)) {
                cl1 = c.getClient();
                if (cl1.getEtudiant()) {
                    for (Commande d : cmdEffectue
                            ) {
                        if (d.getHeurCosom().after(d1) && d.getHeurCosom().before(d2) && d instanceof CmdEvenement) {
                            if (cl1.equals(d.getClient()) && d.getNbPers()>=50) {
                                reduction1 += 0.1;
                                existeAuMoinCommende = true ;
                            }
                        }
                    }
                }
            }
            if (reduction1 > reduction2) {
                reduction2 = reduction1;
                cl2 = cl1;
            }
        }
        if (!existeAuMoinCommende) return null;
        else return cl2;

    }
    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getNbChaise() {
        return nbChaise;
    }

    public int getNbTable() {
        return nbTable;
    }

    public void ajouterRepas(Repas r){
        this.menu.ajouterMet(r);
    }

    public void ajouterBoisson(Boisson b){
        this.menu.ajouterMet(b);
    }

    public boolean supprimerRepas(String nomRepas){
        return this.menu.suprimerRepas(nomRepas);
    }
    public boolean supprimerBoisson(String nomBoisson){
        return this.menu.suprimerBoisson(nomBoisson);
    }

    public Menu getMenu() {
        return menu;
    }

    public Set<ClientFidele> getClients() {
        return clients;
    }

    public void ajouteClientFidele(ClientFidele c){
        this.clients.add(c);
    }

    public ClientFidele avoirClientFidele(int codef){
        ClientFidele cl = null ;
        if (clients.size()==0) {
            return null ;
        }
        else{
            for (ClientFidele client: clients
                 ) {
                if (client.getCodeFidelite() == codef) {
                    cl = client ;
                    break;
                }

            }
            return cl ;
        }
    }

    public int nbCmdTotal(){
        return (cmdEffectue.size()+cmdEnAttente.size()) ;
    }

    public void effectueCmdAtt(int nmCmd){
        Commande commande1= null  ;
        Commande commande2 =null ;

        for (Commande cmd:cmdEnAttente
             ) {
            if (cmd.getNmCmd()==nmCmd){
                if (cmd instanceof CmdSurPlace){
                    commande1 = new CmdSurPlace(nmCmd,cmd.getNbpers(),cmd.getClient(),((CmdSurPlace)cmd).getType(),cmd.getCmds()) ;
                    commande2 =cmd ;
                    break;
                }
                else{
                    if(cmd instanceof CmdADomicile){
                        commande1 = new CmdADomicile(nmCmd,cmd.getNbpers(),cmd.getClient(),((CmdADomicile)cmd).getAdressLivraison(),
                                cmd.getCmds(),((CmdADomicile)cmd).getDistance()) ;
                        commande2 = cmd ;
                        break;
                    }else {
                        commande1 = new CmdEvenement(cmd.getClient(),((CmdEvenement)cmd).getMenu(),cmd.getNbpers(),((CmdEvenement) cmd).getType(),cmd.getNmCmd());
                        commande2 = cmd ;
                        break;
                    }
                }
            }
        }
        cmdEffectue.add(commande1);
        cmdEnAttente.remove(commande2);
    }

    public void ajouterCmdEnAtt(Commande c){
        cmdEnAttente.add(c) ;
    }
}


