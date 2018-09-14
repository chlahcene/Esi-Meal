package model.menu;

import java.util.HashSet;
import java.util.Set;
import model.type.*;

public class Repas extends Met
{

    private Set<String> ingredients ;
    private boolean disponible ;
    private Set<Supplement> supplementsPrpose ;
    private Set<Supplement> supplementsChoisi ;
    private TypeRepas type ;

    public Repas(String nom, double prix, int nombreCalories, Set<String> ingredients, Set<Supplement> supplementsPrpose, Set<Supplement> supplementsChoisi, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.disponible = true;
        this.supplementsPrpose = supplementsPrpose;
        this.supplementsChoisi = supplementsChoisi;
        this.type = type;
    }

    public Repas(String nom, double prix, int nombreCalories, Set<String> ingredients, Set<Supplement> supplementsPrpose, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.disponible = true;
        this.supplementsPrpose = supplementsPrpose;
        this.type = type;
    }

    public Repas(String nom, double prix, int nombreCalories, Set<String> ingredients, TypeRepas type, Set<Supplement> supplementsChoisi) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.disponible = true;
        this.supplementsChoisi = supplementsChoisi;
        this.type = type;
    }

    public Repas(String nom, double prix, int nombreCalories, Set<String> ingredients, boolean disponible, Set<Supplement> supplementsPrpose, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.ingredients = ingredients;
        this.disponible = disponible;
        this.supplementsPrpose = supplementsPrpose;
        this.type = type;
    }

    public Repas(String nom, double prix, int nombreCalories, Set<Supplement> supplementsChoisi, TypeRepas type) {
        super(nom, prix, nombreCalories);
        this.supplementsChoisi = supplementsChoisi;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Repas{" +
                super.toString() +
                "ingredients=" + ingredients.toString() +
                ", disponible=" + disponible +
                ", supplementsPrpose=" + supplementsPrpose.toString() +
                ", supplementsChoisi=" + supplementsChoisi.toString() +
                ", type=" + type.toString() +
                '}';
    }

    @Override
    public void copier(Met m) {
        Repas r =(Repas)m;
        setNom(r.getNom());
        setNombreCalories(r.getNombreCalories());
        setPrix(r.getPrix());
        ingredients = new HashSet<String> (r.ingredients);
        disponible = r.disponible;
        supplementsPrpose = new HashSet<Supplement> (r.supplementsPrpose);
        supplementsChoisi = new HashSet<Supplement> (r.supplementsChoisi);
        type = r.type;
    }


    public boolean addIngredients(String i){
        return ingredients.add(i);
    }
    
    public boolean addSupplementsPrpose(Supplement s){
        return supplementsPrpose.add(s);
    }

    public boolean addSupplementsChoisi(Supplement s){
        return supplementsChoisi.add(s);
    }
    public boolean removeIngredients(String i){
        return ingredients.remove(i);
    }

    public boolean removeSupplementsPrpose(Supplement s){
        return supplementsPrpose.remove(s);
    }

    public boolean removeSupplementsChoisi(Supplement s){
        return supplementsChoisi.remove(s);
    }

    public boolean isDisponible() {

        return disponible;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<Supplement> getSupplementsPrpose() {
        return supplementsPrpose;
    }

    public void setSupplementsPrpose(Set<Supplement> supplementsPrpose) {
        this.supplementsPrpose = supplementsPrpose;
    }

    public Set<Supplement> getSupplementsChoisi() {
        return supplementsChoisi;
    }

    public void setSupplementsChoisi(Set<Supplement> supplementsChoisi) {
        this.supplementsChoisi = supplementsChoisi;
    }

    public TypeRepas getType() {
        return type;
    }

    public void setType(TypeRepas type) {
        this.type = type;
    }
}
