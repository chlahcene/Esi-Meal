package classes;
import javafx.fxml.FXML;

import java.awt.*;

/**
 * Décrivez votre classe Boisson ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Boisson extends Met
{

   private String marque ;
   private String gout ;
   private boolean disponibilite ;
   private TypeBoisson type ;

    public void setDisponible(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public boolean isDisponible() {

        return disponibilite;
    }

    public Boisson(String nom, double prix, int nombreCalories, String marque, String gout, boolean disponibilite, TypeBoisson type) {
        super(nom, prix, nombreCalories);
        this.marque = marque;
        this.gout = gout;
        this.disponibilite = disponibilite;

        this.type = type;
    }

    public Boisson(String nom, double prix, int nombreCalories, String marque, String gout, TypeBoisson type) {
        super(nom, prix, nombreCalories);
        this.marque = marque;
        this.gout = gout;
        this.type = type;
    }

    public void afficheMet(){
       super.afficheMet() ;
       System.out.println("La marque "+marque);
       System.out.println("Le gout  "+gout);
       System.out.println("Le type "+ type);
        System.out.println("disponible "+disponibilite) ;

        System.out.println("---------------------------------------");;
   }
   public void copier(Met m) {
        Boisson b =(Boisson) m;
        setNom(b.getNom());
        setNombreCalories(b.getNombreCalories());
        setPrix(b.getPrix());
        this.marque = b.marque ;
        this.gout =b.gout;
        this.disponibilite = b.disponibilite ;
        this.type = b.type;
   }

    public TypeBoisson getType() {
        return type;
    }

    public String getMarque() {
        return marque;
    }

    public String getGout() {
        return gout;
    }
}
