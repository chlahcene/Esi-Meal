package classes;
/**
 * Décrivez votre classe Menu ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.* ;
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
    
    public void suprimerMet(Met met){
        menu.remove(met);
    }

    public Met getMet(int i){
        return menu.get(i);
    }

    public int taille(){
        return menu.size();
    }

/*    public boolean isExiste(Repas r){
        boolean existe = false ;
        for (Met met:menu
                ) {
            if(met.getNom().equals(r.getNom()) && met instanceof Repas) {
                if (((Repas) met).isDisponible()){
                    existe=true ;
                }
            }
        }

        return existe;
    }

    public boolean isExiste(Boisson r) {
        boolean existe = false;
        for (Met met : menu
                ) {
            if (met.getNom().equals(r.getNom()) && met instanceof Boisson) {
                if (((Boisson) met).isDisponible()) {
                    existe = true;
                }
            }
        }

        return existe;
    }
*/
    public double calculPrix() {
        double result = 0;
        for (Met e : this.menu) {
            result += e.getPrix();
        }

        return (result);
    }


    public boolean suprimerRepas(String r){
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

    public boolean suprimerBoisson(String r){
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
