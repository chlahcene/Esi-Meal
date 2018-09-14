package model.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<Met> menu ;
    
    public Menu(){
        menu = new ArrayList<Met>() ;
    }
    public void afficheMenu(){
        for (Met m:menu
                ) {
            m.afficheMet();
        }
    }

    public boolean ajouterMet(Met met){
        if (isExiste(met)){
            boolean ajout = false ;
            for (Met m:menu
                    ) {
                if (m.getNom().equals(met.getNom())){
                    if (m instanceof Repas ) {
                        if (!((Repas) m).isDisponible()){
                            ((Repas) m).setDisponible(true);
                            m.setPrix(met.getPrix());
                            ajout = true;
                        }
                    }
                    if (m instanceof Boisson ) {
                        if (!((Boisson) m).isDisponible()){
                            ((Boisson) m).setDisponible(true);
                            ajout = true;
                        }
                    }
                    break;
                }
            }
            return ajout ;
        }else
        {
            return menu.add(met);
        }

    }
    
    public void removeMet(Met met)
    {
        menu.remove(met);
    }

    public Met getMet(int i){
        return menu.get(i);
    }

    public int sizeMenu(){

        return menu.size();
    }

    public double calculPrix() {
        double result = 0;
        for (Met e : this.menu) {
            result += e.getPrix();
        }

        return (result);
    }


    public boolean removeRepas(String r){
        boolean sup = false ;
        for (Met m:menu
             ) {
            if (m.getNom().equals(r)){
                if (m instanceof Repas){
                    ((Repas) m).setDisponible(false);
                    sup = true;
                }
                break;
            }
        }

        return  sup;
    }

    public boolean removeBoisson(String r){
        boolean sup = false ;
        for (Met m:menu
                ) {
            if (m.getNom().equals(r)) {
                if (m instanceof Boisson) {
                    ((Boisson) m).setDisponible(false);
                    sup = true;
                }
            }
                break;
            }
        return  sup;
}

    public boolean isExiste(Met met){
        boolean existe =  false ;
        for (Met m:menu
                ) {
            if (m.getNom().equals(met.getNom())){
                existe= true ;
                break;
            }
        }
        return existe ;
    }

}
