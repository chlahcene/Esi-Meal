package classes;
/**
 * Décrivez votre classe Supplement ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
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
