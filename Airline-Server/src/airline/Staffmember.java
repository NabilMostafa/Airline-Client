/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed Ibrahem
 */
public class Staffmember extends User
{
    
    public Staffmember()throws RemoteException 
    {
        
    }
    public Staffmember(String address, int age, String mail, String name, String password, String telephone) throws RemoteException 
    {
        super(address, age, mail, name, password, telephone, 's');
    }
    ////////////////////////////////////////////////////////////////////////////
    public void staffmemberregister(String myaddress, int myage, String mymail, String myname, String mypassword, String mytelephone)throws RemoteException 
    {
        User u = new Staffmember(myaddress, myage, mymail, myname, mypassword,mytelephone);
        db.adduser(u);
    }
    ////////////////////////////////////////////////////////////////////////////
     public void staffmemberlogin(String mymail,String mypassword)
    {
        db.login(mymail,mypassword);
    }
    ////////////////////////////////////////////////////////////////////////////
    public void addflight(String myarrivaldate,String mydeparturedate,int myflightid,int myplaneid)
    {
        
        if (db.check("ArrivalDate", db.coll1, myarrivaldate)&&db.check("DepartureDate", db.coll1, mydeparturedate)&&
                db.checkint("Plane_ID", db.coll1, myplaneid))
            db.addflight(myarrivaldate, mydeparturedate, myflightid, true, myplaneid);
        else 
            JOptionPane.showMessageDialog(null, "Input allready there", "Info", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    ////////////////////////////////////////////////////////////////////////////
    public void modifyflight(int myflightID,String choice,String x)
    {
        if(choice=="Arrivaldate")
        {
            db.modifyflight(myflightID, "Arrivaldate",x);
        }
        else if(choice=="DepartureDate")
        {
            db.modifyflight(myflightID, "DepartureDate",x);
        }
        else if(choice=="Flight_ID")
        {
            int d = Integer.parseInt(x);
            db.modifyflightint(myflightID, "FlightID",d);
        }
        else if(choice=="Flight_ava")
        {
            Boolean boolean1 = Boolean.valueOf(x);
            db.modifyflightboolean(myflightID, "Flight_ava",boolean1);
        }
        else if(choice=="myPlane_ID")
        {
            int d = Integer.parseInt(x);
            db.modifyflightint(myflightID, "Plane_ID",d);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void viewavaliableereservation(boolean isaccepted)
    {
        isaccepted=false;
        db.Viewavaliable(isaccepted);
    }
    ////////////////////////////////////////////////////////////////////////////
    public void approvereservation(int reservationid)
    {
        db.updateboolean(db.coll3,"Approved",true,"Reservation",reservationid);
    }  
}
