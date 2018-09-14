package model.menu;

public class Supplement extends Met
{
    public Supplement(String nom, double prix, int nombreCalories) {

        super(nom, prix, nombreCalories);
    }

    public void copier(Met m) {
        Supplement s = (Supplement) m;
        setNom(s.getNom());
        setNombreCalories(s.getNombreCalories());
        setPrix(s.getPrix());
    }
}
