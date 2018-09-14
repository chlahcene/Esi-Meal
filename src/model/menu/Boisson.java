package model.menu;

import model.type.*;
public class Boisson extends Met
{

   private String marque ;
   private String gout ;
   private boolean disponible ;
   private TypeBoisson type ;


    public Boisson(String nom, double prix, int nombreCalories, String marque, String gout, boolean disponible, TypeBoisson type) {
        super(nom, prix, nombreCalories);
        this.marque = marque;
        this.gout = gout;
        this.disponible = disponible;
        this.type = type;
    }

    public Boisson(String nom, double prix, int nombreCalories, String marque, String gout, TypeBoisson type) {
        super(nom, prix, nombreCalories);
        this.marque = marque;
        this.gout = gout;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Boisson{" +
                super.toString() +
                "marque='" + marque + '\'' +
                ", gout='" + gout + '\'' +
                ", disponible=" + disponible +
                ", type=" + type +
                '}';
    }

    public void copier(Met m) {
        Boisson b =(Boisson) m;
        setNom(b.getNom());
        setNombreCalories(b.getNombreCalories());
        setPrix(b.getPrix());
        this.marque = b.marque ;
        this.gout =b.gout;
        this.disponible = b.disponible ;
        this.type = b.type;
   }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getGout() {
        return gout;
    }

    public void setGout(String gout) {
        this.gout = gout;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public TypeBoisson getType() {
        return type;
    }

    public void setType(TypeBoisson type) {
        this.type = type;
    }
}
