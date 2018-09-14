package model.user;


import java.util.Objects;

public class Client
{

    private String nom ;
    private String prenom ;
    private String numTel ;
    private boolean etudiant ;
    private double reduction ;

    public Client(String nom, String prenom, String numTel, boolean etudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.etudiant = etudiant;
        this.reduction = 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numTel='" + numTel + '\'' +
                ", etudiant=" + etudiant +
                ", reduction=" + reduction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return  Objects.equals(getNom(), client.getNom()) &&
                Objects.equals(getPrenom(), client.getPrenom()) &&
                Objects.equals(getNumTel(), client.getNumTel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNom(), getPrenom(), getNumTel(), isEtudiant(), getReduction());
    }


    public boolean isEtudiant() {

        return etudiant;
    }
    public boolean getEtudiant() {

        return etudiant;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setEtudiant(boolean etudiant) {
        this.etudiant = etudiant;
    }



    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

}
