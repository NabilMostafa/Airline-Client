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
public class Client extends User  {

    public Client(String Addres, int age, String mail, String name, String password, String tele) throws RemoteException  {
        super(Addres, age, mail, name, password, tele, 'c');
    }
    public Client() throws RemoteException   {
        super();
    }

    public boolean register(String Addres, int age, String mail, String name, String password, String tele) throws RemoteException {
        try {
            if (!db.check("mail", db.coll, mail)) {
                Client u = new Client(Addres, age, mail, name, password, tele);
                db.adduser(u);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "This Mail Already Entered", "information", JOptionPane.INFORMATION_MESSAGE);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void makeReservation(int myflightid , int myreservationid)  {
        db.Makereservation(myflightid, myreservationid, false);
    }

    public void CancelReservation(int myreservationid) {
        db.Cancelreservation(myreservationid);
    }
     public void viewflight() 
    {
        db.Viewflights();
    }
}
