package classes;
/**
 * Décrivez votre classe Client ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Client
{
    private String nom ;
    private String prenom ;
    private String num_tel ;
    private boolean etudiant ;
    private double reduction ;


    public Client(String nom,String prenom,String num_tel,boolean etudiant){
        this.nom = nom;
        this.prenom = prenom ;
        this.num_tel =num_tel ;
        this.etudiant=etudiant ;
        reduction =0 ;
    }

    public void afficheClient(){
        System.out.println("LE nom "+nom);
        System.out.println("LE nom "+prenom);
        System.out.println("LE nom "+num_tel);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getEtudiant() {
        return etudiant;
    }

    public  boolean equals(Object o){
        Client c = (Client)o ;
        if (this.nom.equals(c.nom)){
            if (this.prenom.equals(c.prenom)) {
                return this.num_tel.equals(c.num_tel);
            }
            else return false ;
        }
        else return false;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public void setEtudiant(boolean etudiant) {
        this.etudiant = etudiant;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public boolean isEtudiant() {
        return etudiant;
    }

    public double getReduction() {
        return reduction;
    }

}
