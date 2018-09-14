package classes;
/**
 * Décrivez votre classe abstraite Commande ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.* ;
public abstract class Commande implements  Reduction
{
    // variable d'instance - remplacez cet exemple par le vôtre
    private int nmCmd ;
    private int nbPers ;
    private int priorite ;
    private Date heurCosom ;
    private Client client ;
    private Map <Integer,Menu> cmds ;
    private double tarif ;
    private double reduction ;

    public void setNmCmd(int nmCmd) {
        this.nmCmd = nmCmd;
    }

    public int getNmCmd() {
        return nmCmd;
    }

    public abstract double calculPrix () ;

    public abstract void valider (Restaurant a) ;

    public void modifier (int i , Menu m ) {
        for (Map.Entry<Integer, Menu> entry : cmds.entrySet())
            if (entry.getKey() == i) entry.setValue(m);
    }

    public void setTarif(double tarif ) {
        this.tarif = tarif;
    }

    public void  setNbPers (int n)
    {
        this.nbPers= n ;
    }

    public void setClient(Client cl) {
        this.client = client;
    }

    public void setHeurCosom(Date heurCosom) {
        this.heurCosom = heurCosom;
    }

    public Client getClient() {
        return client;
    }

    public Map<Integer, Menu> getCmds() {
        return cmds;
    }

    public int getNbpers() {
        return nbPers;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setNbpers(int nbpers) {
        this.nbPers = nbpers;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public void setCmds(Map<Integer, Menu> cmds) {
        this.cmds = cmds;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public double getTarif(){
        return tarif;
    }

    public Date getHeurCosom() {
        return heurCosom;
    }

    public double getReduction() {
        return reduction;
    }

    public int getNbPers() {
        return nbPers;
    }

}
