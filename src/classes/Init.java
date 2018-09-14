package classes;

import java.util.*;

public class Init {
    private int nbChaise;
    private int nbTable;
    private Set<ClientFidele> clients;
    private Set<Commande> cmdEnAttente;
    private Set<Commande> cmdEffectue;
    private Menu menu;
    private boolean libre ;

    static public Restaurant initRestaurant(){
        int nbChaise = 40;
        int nbTable = 6;

        Set<String> ingrediants = new HashSet<>();
        Set<Supplement> supprpose = new HashSet<>();
        ArrayList<String> adresses = new ArrayList<String>();
        Map<Integer, Menu> menusoffic = new HashMap<>();
        Supplement s ;
        Set<ClientFidele> clients ;
        Set<Commande> cmdEnAttente;
        Set<Commande> cmdEffectue;

        Restaurant res = new Restaurant(nbChaise,nbTable);

        res.ajouterRepas(new Repas("repas1",30,100,ingrediants,true,supprpose,TypeRepas.PLAT));
        res.ajouterBoisson(new Boisson("poissant1",50,100,"fff","binine", true, TypeBoisson.JUS));
        res.ajouteClientFidele(new ClientFidele("areis","amine", "0555555555",false,res.getClients().size()+1,adresses));

        /*res.ajouterCmdEnAtt(
               // new CmdSurPlace(res.nbCmdTotal()+1,"ayoub", "bha","055555555",TypeTable.INTERIEUR,menusoffic,true);
        );*/
        return res;
    }
}
