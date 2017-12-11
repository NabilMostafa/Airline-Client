/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Mohamed Ibrahem
 */
public class AirLine_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // My remote object [Skeleton]
            UserInterFace c = new User();
            adminInterFace a =  admin.getinstance();
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(2100);
            //Add my object to the RMI Registry
            registry.bind("Log", c);
            registry.bind("admin", a );
            System.out.println("Server is ready...");   
        } catch (Exception ex) {
           System.out.println(ex);
        }   
    }
    
}
