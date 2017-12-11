/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author Omar Kotb
 */
public class admin  extends UnicastRemoteObject  implements adminInterFace
{
    data db=new data();
    public String username;
    public String password;
    static admin instance;
    
    private admin()throws RemoteException
    {
        username="AHMON";
        password="123";
    }


    public String getUsername()throws RemoteException {
        return username;
    }


    public String getPassword() throws RemoteException{
        return password;
    }
    
    private admin(String username, String password)throws RemoteException {
        this.username = username;
        this.password = password;
    }
    public static admin getinstance()throws RemoteException
    {
        if ( instance == null )
        {
            instance = new admin();
        }
        return instance;
    }
    @Override
    public void Add_staffmember(String address, int age, String mail, String name, String password, String telephone)throws RemoteException 
    {
        User u = new Staffmember(address, age, mail, name, password,telephone);
        db.adduser(u);
    }
    @Override
    public void Ban_User(String mymail)throws RemoteException
    {
        db.Removeuser(mymail);
    }
    
}
