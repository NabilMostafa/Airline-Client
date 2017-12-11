/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *

 */
public interface UserInterFace extends Remote {
    
     public boolean RestPassword(String x) throws RemoteException;
     public void Login(String x, String y) throws RemoteException;
     public String ReturnType() throws RemoteException;
     public ArrayList returnuser()throws RemoteException;
}

