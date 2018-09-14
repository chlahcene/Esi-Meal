package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Décrivez votre classe CmdADomicile ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CmdADomicile extends Commande
{
    private String adressLivraison ;
    private int distance ;

    public  CmdADomicile (int nmCmd,int nbPersonnes ,String n , String p ,String tel  , String adr, Map <Integer,Menu> cmd , int nbk,boolean stud)
    {
        super.setClient(new Client(n,p,tel,stud)) ;
        super.setCmds(cmd) ;
        super.setNbPers(nbPersonnes);
        super.setNmCmd(nmCmd);
        distance =nbk ;
        adressLivraison=adr ;
        //heure livraison
    }

    public  CmdADomicile (int nmCmd ,int nbPersonnes ,String n , String p ,String tel  , String adr, Map <Integer,Menu> cmd , int nbk)
    {
        super.getClient().setNom(n);
        super.getClient().setPrenom(p);
        super.getClient().setNum_tel(tel);
        super.setCmds(cmd) ;
        super.setNbPers(nbPersonnes);
        super.setNmCmd(nmCmd) ;
        distance =nbk ;
        adressLivraison=adr ;
        //heure livraison
    }
    public  CmdADomicile (int nmCmd,int nbPersonnes ,Client cl ,  String adr, Map <Integer,Menu> cmd , int nbk)
    {
        super.setClient(cl);
        super.setCmds(cmd) ;
        super.setNbPers(nbPersonnes);
        super.setNmCmd(nmCmd) ;
        distance = nbk ;
        adressLivraison=adr ;
        //heure livraison
    }
    public double calculPrix ( )
    {

        double result=0 ;
        for (Map.Entry<Integer,Menu > entry : super.getCmds().entrySet())  result+= entry.getValue().calculPrix();
        return this.distance*20 ;
    }
    public void valider (Restaurant resto)
    {

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        String naw =format.format(date);
        String after = format.format(super.getHeurCosom()) ;
        Date d1=null,d2=null,d3=null ;
        SimpleDateFormat format1= new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal1 = Calendar.getInstance();
        Date date1=cal1.getTime();
        String naw1 =format1.format(date1)+" 00:00";
        try
        {
            d1 = format.parse(naw);
            d2 = format.parse(after );
            d3 = format.parse(naw1);
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }
        long a = d2.getTime() - d1.getTime()  ;

        long b = a /(1000*60) ;
        if (b<30)  System.out.println("il faut reserver au moins 30 mn avant") ;
        if ( d2.after(d3))  System.out.println("no man9droch njo") ; // heure consom < 12 h
        else System.out.println("yes na9dro njo ") ;

        if (distance > 20) System.out.println("distance trop loin , il faut moins de 20 klm");

    }
    public double gererReduction () {
        double reduc = 0;

        if (super.getClient().isEtudiant())
            reduc += 0.08;

        if (super.getClient() instanceof  ClientFidele )
        {   ClientFidele f = (ClientFidele) this.getClient() ;
            if(f.getNbCmd()> 1 )
                reduc +=0.05 ;
        }
        if (super.getNbpers() > 3)
            reduc += 0.07;
        return reduc;
    }

    public String getAdressLivraison() {
        return adressLivraison;
    }

    public int getDistance() {
        return distance;
    }
}