package classes;
/**
 * Décrivez votre classe ClientFidele ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.* ;
public class ClientFidele extends Client implements Comparable<ClientFidele>
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int codeFidelite ;
    private int nbCmd ;
    private List<String> adresse ;

    
    public ClientFidele(String nom,String prenom,String numTel,boolean etud,int code,List<String> adresse){
        super(nom,prenom,numTel,etud);
        this.codeFidelite = code ;
        nbCmd =0 ;
        this.adresse = new ArrayList<String>();
        for(String s : adresse){
            this.adresse.add(s) ;
        }
    }

    public int getNbCmd() {
        return nbCmd;
    }

    public  void afficheClient(){
        super.afficheClient();
        System.out.println("LE code "+codeFidelite);
        for (String s: adresse) {
            System.out.println("L'adresse " +s);
        }
    }

    public int getCodeFidelite() {
        return codeFidelite;
    }

    @Override
    public boolean equals(Object o) {
        ClientFidele cl = (ClientFidele) o;
        return cl.codeFidelite == this.codeFidelite;
    }

    @Override
    public int compareTo(ClientFidele o) {
        if (o.getCodeFidelite()>this.getCodeFidelite()) return -1 ;
        else if (o.getCodeFidelite()<this.getCodeFidelite()) return 1 ;
        else return 0 ;
    }

    public void ajouterAdresse(String s){
        adresse.add(s) ;
    }

    public  void supprimerAdresse(String s){
        adresse.remove(s) ;
    }
    public List<String> getAdresse() {
        return adresse;
    }
}
