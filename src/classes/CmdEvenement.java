package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/**
 * Décrivez votre classe CmdEvenement ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CmdEvenement extends Commande
{
    private TypeEvenement type ;
    // private String thematique ;
    private Menu menu ;

    public CmdEvenement(int nmCmd,String nm ,String p,String tel, Menu m , int n ,TypeEvenement t)
    {
        super.getClient().setNom(nm);
        super.getClient().setPrenom(p);
        super.getClient().setNum_tel(tel);
        super.setNbPers(n) ;
        super.setNmCmd(nmCmd);
        type=t ;
        menu=m ;

    }

    public CmdEvenement (int nmCmd,String nm ,String p,String tel, Menu m , int n ,TypeEvenement t,boolean stud)
    {
        super.setClient(new Client(nm,p,tel,stud)) ;
        super.setNmCmd(nmCmd);
        super.setNbPers(n) ;
        type=t ;
        menu=m ;

    }

    public CmdEvenement (Client cl , Menu m , int n ,TypeEvenement t,int nmCmd)
    {
        super.setClient(cl);
        super.setNbPers(n) ;
        super.setNmCmd(nmCmd) ;
        type=t ;
        menu=m ;

    }

    public void valider (Restaurant resto)
    {

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        String naw =format.format(date);
        String after = format.format(super.getHeurCosom()) ;
        Date d1=null,d2=null ;
        try
        {
            d1 = format.parse(naw);
            d2 = format.parse(after );
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }
        long a = d2.getTime() - d1.getTime()  ;
        long b = a/(1000*60*60*24) ;
        if ( b<15)  System.out.print("il faut reserver 15 jours avant");
        if (super.getNbPers()<30 || super.getNbPers() > 80)
            System.out.print("nombre de personnes invalable");
        if (resto.isLibre() == false ) System.out.print("");


    }

    public double gererReduction ()
    {
        double reduc= 0 ;
        if ( super.getClient().isEtudiant())
            reduc+= 0.08 ;
        if (super.getClient() instanceof  ClientFidele )
        {   ClientFidele f = ( ClientFidele ) this.getClient() ;
            if(f.getNbCmd()> 1 )
                reduc +=0.05 ;
        }

        if (super.getNbpers()>50)
            reduc+=0.1 ;
        return reduc ;
    }
    public double calculPrix ()
    {
        return menu.calculPrix() ;
    }

    public TypeEvenement getType() {
        return type;
    }

    public Menu getMenu() {
        return menu;
    }
}