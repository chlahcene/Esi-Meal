package classes;

import java.util.Objects;

/**
 * Décrivez votre classe abstraite Met ici.
 *
 * @author  (votre Mouaci youcef)
 * @version (0)
 */
public abstract class Met implements Comparable<Met> 
{
    // variable d'instance - remplacez cet exemple par le vôtre
    private String nom ;
    private double prix;
    private int nombreCalories ;



    public Met(String nom, double prix, int nombreCalories) {
        this.nom = nom;
        this.prix = prix;
        this.nombreCalories = nombreCalories;
    }

    public void afficheMet(){
        System.out.println("Le Met :"+nom) ;
        System.out.println("Le Prix :"+prix) ;
        System.out.println("Le Nombre de callories :"+nombreCalories) ;;
    }

    public abstract void copier(Met m);

    public int getNombreCalories() {
        return nombreCalories;
    }


    public double getPrix(){
        return prix ;
    } 
    
    public String getNom(){
        return nom ;
    } 
   
    public int compareTo(Met m){
        return nom.compareTo(m.nom);
    }
    
    
    public void setNom(String s){
        nom =s;
    }
    
    public void setPrix(double s){
        prix =s;
    }

    public void setNombreCalories(int nombreCalories) {
        this.nombreCalories = nombreCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Met met = (Met) o;
        return Objects.equals(nom, met.nom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nom);
    }
}

