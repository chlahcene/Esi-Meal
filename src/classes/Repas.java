package classes;
/**
 * Décrivez votre classe Repas ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.* ;

public class Repas extends Met
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Set<String> ingredients ;
    private boolean disponible ;
    private Set<Supplement> supplementsprpose ;
    private Set<Supplement> supplementschoisi ;
    private TypeRepas type ;

    public Repas(String nom, double prix, int nombreCalories, Set<String> ingredients, boolean disponible, Set<Supplement> supplementsprpose, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.disponible = disponible;
        this.supplementsprpose = supplementsprpose;
        this.type = type;
    }

    public Repas(String nom, double prix, int nombreCalories, Set<Supplement> supplementchoisi, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.supplementschoisi = supplementschoisi;
        this.type = type;
    }

    public void afficheMet(){
        super.afficheMet() ;
        System.out.println("Le Type "+type) ;
        System.out.println("disponible "+disponible) ;
        System.out.println("Les Ingrediants") ;
        for(String s:ingredients){
            System.out.println("    "+s);
        }
        System.out.println("Les Supplement ") ;
        for(Met m:supplementsprpose){
            m.afficheMet() ;
        }
        
        System.out.println("--------------------------------------------------------------");
    }


    @Override
    public void copier(Met m) {
        Repas r =(Repas)m;
        setNom(r.getNom());
        setNombreCalories(r.getNombreCalories());
        setPrix(r.getPrix());
        ingredients = new HashSet<String> (r.ingredients);
        disponible = r.disponible;
        supplementsprpose = new HashSet<Supplement> (r.supplementsprpose);
        supplementschoisi = new HashSet<Supplement> (r.supplementschoisi);
        type = r.type;
    }


    public boolean ajouterIng(String i){
        return ingredients.add(i);
    }
    
    public boolean ajouterSup(Supplement s){
        return supplementsprpose.add(s);
    }
    
    public void suprimerSup(Supplement s){
         supplementsprpose.remove(s);
    }
    
    public void suprimerIng(String i){
         ingredients.remove(i);
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<Supplement> getSupplementsprpose() {
        return supplementsprpose;
    }

    public boolean isDisponible() {

        return disponible;
    }

    public TypeRepas getType() {
        return type;
    }

    public Set<Supplement> getSupplementschoisi() {
        return supplementschoisi;
    }
}
