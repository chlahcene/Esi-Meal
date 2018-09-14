package model.commande;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import model.user.*;
import model.menu.*;
import model.type.*;


public class CmdSurPlace extends Commande {
    private TypeTable type;

        public CmdSurPlace(int nmCmd , String n, String p, String tel, int nbPersonnes, TypeTable t, Map<Integer, Menu> cmd) {
            this.type = t;
            super.getClient().setNom(n);
            super.getClient().setPrenom(p);
            super.getClient().setNumTel(tel);
            super.setCmds(cmd);
            super.setNbPers(nbPersonnes);
            super.setNmCmd(nmCmd) ;
        }

        public CmdSurPlace(int nmCmd ,String n, String p, String tel, int nbPersonnes, TypeTable t, Map<Integer, Menu> cmd,boolean stud) {

            this.type = t;
            super.setClient(new Client(n,p,tel,stud)) ;


            super.setCmds(cmd);
            super.setNbPers(nbPersonnes);
            super.setNmCmd(nmCmd) ;
        }

        public CmdSurPlace(int nmCmd ,int nbPersonnes , Client cl, TypeTable t, Map<Integer, Menu> cmd) {
            type = t;
            super.setClient(cl);
            super.setCmds(cmd);
            super.setNbPers(nbPersonnes);
            super.setNmCmd(nmCmd) ;
        }
    @Override
    public double calculPrix() {

        double result = 0;
        for (Map.Entry<Integer, Menu> entry : super.getCmds().entrySet()) result += entry.getValue().calculPrix();
        if (TypeTable.EXTERIEUR.equals(type)) return (result + result * 0.05) ;
        else return result;
    }

    @Override
    public void valider (Restaurant resto)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        String naw =format.format(date);
        String after = format.format(super.getHeureConsomation()) ;
        Date d1=null,d2=null,d3=null ;
        SimpleDateFormat format1= new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal1 = Calendar.getInstance();
        Date date1=cal1.getTime();
        String naw1 =format1.format(date1)+" 22:00";

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

        /*commander 1h avant
         transforme en heure
         */
        // heure consom < 22h

        //d2.after(d3)

        if (resto.getNbChaise()> 0 && resto.getNbTable()>0) {
            //
        }


    }

    @Override
    public double donnerReduction() {
        double reduc= 0 ;
        if (super.getClient().isEtudiant())
            reduc+= 0.08 ;
        if (super.getClient() instanceof  ClientFidele )
        {   ClientFidele f = (ClientFidele) this.getClient() ;
            if(f.getNbCmd()> 1 )
                reduc +=0.05 ;
        }
        return reduc ;
    }

    public TypeTable getType() {
        return type;
    }

    public void setType(TypeTable type) {
        this.type = type;
    }
}