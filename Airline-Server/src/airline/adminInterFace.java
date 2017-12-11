/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mohamed Ibrahem
 */
public interface adminInterFace extends Remote {
    public void Add_staffmember(String address, int age, String mail, String name, String password, String telephone)throws RemoteException ;
    ////////////////////////////////////////////////////////////////////////////
    public void Ban_User(String mymail) throws RemoteException;
}
