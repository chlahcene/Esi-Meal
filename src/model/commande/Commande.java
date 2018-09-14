package model.commande;

import java.util.Date;
import java.util.Map;
import model.user.*;
import model.menu.*;

public abstract class Commande implements  Reduction
{

    private int nmCmd ;
    private int nbPers ;
    private int priorite ;
    private Date heureConsomation ;
    private Client client ;
    private Map <Integer,Menu> cmds ;
    private double tarif ;
    private double reduction ;

    public abstract double calculPrix () ;

    public abstract void valider (Restaurant a) ;



    public void modifier (int i , Menu m ) {
        for (Map.Entry<Integer, Menu> entry : cmds.entrySet())
            if (entry.getKey() == i) entry.setValue(m);
    }

    public int getNmCmd() {
        return nmCmd;
    }

    public void setNmCmd(int nmCmd) {
        this.nmCmd = nmCmd;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public Date getHeureConsomation() {
        return heureConsomation;
    }

    public void setHeureConsomation(Date heureConsomation) {
        this.heureConsomation = heureConsomation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<Integer, Menu> getCmds() {
        return cmds;
    }

    public void setCmds(Map<Integer, Menu> cmds) {
        this.cmds = cmds;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }
}
