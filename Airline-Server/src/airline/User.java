/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Mohamed Ibrahem
 */
public class User extends UnicastRemoteObject  implements UserInterFace{

    private String Addres;
    private int age;
    private static int id = 0;
    private String mail;
    private String name;
    private String password;
    private String tele;
    private char type;
    public static data db = new data();

    public void setAddres(String Addres) throws RemoteException{
        this.Addres = Addres;
    }

    public void setAge(int age) throws RemoteException{
        this.age = age;
    }

    public void setMail(String mail)throws RemoteException {
        this.mail = mail;
    }

    public void setName(String name) throws RemoteException{
        this.name = name;
    }

    public void setPassword(String password)throws RemoteException {
        this.password = password;
    }

    public void setTele(String tele) throws RemoteException{
        this.tele = tele;
    }

    public void setType(char type) throws RemoteException{
        this.type = type;
    }

    public String getAddres() throws RemoteException{
        return Addres;
    }

    public int getAge()throws RemoteException {
        return age;
    }

    public static int getId() throws RemoteException{
        return id;
    }

    public String getMail()throws RemoteException {
        return mail;
    }

    public String getName()throws RemoteException {
        return name;
    }

    public String getPassword() throws RemoteException{
        return password;
    }

    public String getTele()throws RemoteException {
        return tele;
    }

    public char getType()throws RemoteException {
        return type;
    }

    public User(String Addres, int age, String mail, String name, String password, String tele, char type)throws RemoteException {
        id =  db.GetLastID()+1;
        this.Addres = Addres;
        this.age = age;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.tele = tele;
        this.type = type;
    }
    public User()throws RemoteException {
    }

    @Override
    public String ReturnType() throws RemoteException
    {
        return db.ctype;
    }
    @Override
    public boolean RestPassword(String newPass) throws RemoteException {
        try {
            if (db.Update(db.coll, "pass", newPass, "id"))
            return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    @Override
    public void Login(String mail ,String password ) throws RemoteException{
       db.login( mail, password);
    }
    public ArrayList returnuser()throws RemoteException
    {
        ArrayList<User> u = new ArrayList<>();
        u.add(db.Viewcusers());
        return u;
    }
}
