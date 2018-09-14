package model.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientFidele extends Client implements Comparable<ClientFidele>
{

    private int codeFidelite ;
    private int nbCmd ;
    private List<String> adresse ;

    public ClientFidele(String nom, String prenom, String numTel, boolean etudiant, int codeFidelite, List<String> adresse) {
        super(nom, prenom, numTel, etudiant);
        this.codeFidelite = codeFidelite;
        this.nbCmd = 0;
        this.adresse = new ArrayList<String>();
        this.adresse.addAll(adresse);
    }

    @Override
    public String toString() {
        return "ClientFidele{" +
                super.toString() +
                "codeFidelite=" + codeFidelite +
                ", nbCmd=" + nbCmd +
                ", adresse=" + adresse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientFidele)) return false;
        if (!super.equals(o)) return false;
        ClientFidele that = (ClientFidele) o;
        return getCodeFidelite() == that.getCodeFidelite();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCodeFidelite(), getNbCmd(), getAdresse());
    }

    @Override
    public int compareTo(ClientFidele o) {
        if (o.getCodeFidelite()>this.getCodeFidelite()) return -1 ;
        else if (o.getCodeFidelite()<this.getCodeFidelite()) return 1 ;
        else return 0 ;
    }

    public void addAdresse(String s) {
        adresse.add(s);
    }
    public  void removeAdresse(String s){
        adresse.remove(s) ;
    }


    public int getCodeFidelite() {
        return codeFidelite;
    }

    public void setCodeFidelite(int codeFidelite) {
        this.codeFidelite = codeFidelite;
    }

    public int getNbCmd() {
        return nbCmd;
    }

    public void setNbCmd(int nbCmd) {
        this.nbCmd = nbCmd;
    }

    public List<String> getAdresse() {
        return adresse;
    }

    public void setAdresse(List<String> adresse) {
        this.adresse = adresse;
    }
}
