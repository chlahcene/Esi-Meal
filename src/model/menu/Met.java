package model.menu;

import java.util.Objects;

public abstract class Met implements Comparable<Met> 
{

    private String nom ;
    private double prix;
    private int nombreCalories ;

    public Met(String nom, double prix, int nombreCalories) {
        this.nom = nom;
        this.prix = prix;
        this.nombreCalories = nombreCalories;
    }

    @Override
    public String toString() {
        return "Met{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nombreCalories=" + nombreCalories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Met)) return false;
        Met met = (Met) o;
        return Objects.equals(getNom(), met.getNom());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNom());
    }

    public abstract void copier(Met m);

    public int compareTo(Met m){
        return nom.compareTo(m.nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNombreCalories() {
        return nombreCalories;
    }

    public void setNombreCalories(int nombreCalories) {
        this.nombreCalories = nombreCalories;
    }

    public void afficheMet(){
        //Le Met
        //Le Prix :"+prix) ;
        //Le Nombre de callories :"+nombreCalories) ;;
    }

}

