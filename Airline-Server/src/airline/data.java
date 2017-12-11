/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import com.mongodb.*;
import java.rmi.RemoteException;
/**
 *
 * @author Mohamed Ibrahem
 */
public class data 
{   
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("Airline");
        DBCollection coll = database.getCollection("User");
        DBCollection coll1 = database.getCollection("Flights");
        DBCollection coll2 = database.getCollection("Planes");
        public DBCollection coll3 = database.getCollection("Reservation");
        
      public static int cid;
      public static String ctype;
     public void adduser(User u ) throws RemoteException 
     {  
         
        BasicDBObject doc = new BasicDBObject("name", u.getName())
        .append("type", u.getType())
        .append("pass", u.getPassword())
        .append("age", u.getAge())
        .append("mail", u.getMail())
        .append("tele", u.getTele())
        .append("id", u.getId());

        coll.insert(doc);
     }
     
     public void Remove(String mail)
     {  
         
         BasicDBObject searchQuery = new BasicDBObject().append("mail", mail);
         coll.remove(searchQuery);
       
     }
     
     public boolean Update(DBCollection newColl , String f,String v, String sf)
     {  
         try
         {
       BasicDBObject newDocument = new BasicDBObject();
       newDocument.append("$set", new BasicDBObject().append(f, v));

       BasicDBObject searchQuery = new BasicDBObject().append(sf, cid);

       newColl.update(searchQuery, newDocument);
       return true;
         }catch(Exception e){return false;}
     }
     
      public void Viewusers()
     {  
  
         DBCursor cursor = coll.find();
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
       
     }
     
      public User Viewcusers()throws RemoteException 
     {  
  
         
         
         BasicDBObject query = new BasicDBObject("id",cid);
         User u = new User();
         DBCursor cursor = coll.find(query);
            try {
               while(cursor.hasNext()) {
                   cid = (int) cursor.next().get("id");
                   u.setAddres((String)cursor.next().get("address"));
                   u.setAge((int)cursor.next().get("age"));
                   u.setMail((String)cursor.next().get("mail"));
                   u.setName((String)cursor.next().get("name"));
                   u.setPassword(" ");
                   u.setTele((String)cursor.next().get("tele"));
                   u.setType(' ');
               }
            } finally {
               cursor.close();
            }
       return u;
     }
      
      boolean login(String mail,String pass)
      {
         
           BasicDBObject query = new BasicDBObject("mail",mail).append("pass",pass);
          DBCursor cursor = coll.find(query);
            try {do
            {
                cid = (int) cursor.next().get("id");
                ctype = GetType(mail,pass);
                System.out.println(ctype);
            }
               while(cursor.hasNext()) ;
            } finally {
               cursor.close();
            }
       return true;
      }
      String GetType(String mail,String pass)
      {
         String tt ; 
           BasicDBObject query = new BasicDBObject("mail",mail).append("pass",pass);
          DBCursor cursor = coll.find(query);
            try {do
            {
                tt =  cursor.next().get("type").toString();
            }
               while(cursor.hasNext()) ;
            } finally {
               cursor.close();
            }
       return tt;
      }
      
  //-------------------------------------------------------
       public void addflight (String Arrival,String departure,int flightid,boolean ava,int planeid)
     {  
        BasicDBObject doc = new BasicDBObject("ArrivalDate", Arrival)
        .append("DepartureDate", departure)
        .append("Flight_ID", flightid)
        .append("availability ", ava)
        .append("PlaneID", planeid);
    
        coll1.insert(doc);
     }
      
       public void modifyflight (int flightid,String s,String u)
     {  
         BasicDBObject newDocument = new BasicDBObject();
       newDocument.append("$set", new BasicDBObject().append(s, u));
       BasicDBObject searchQuery = new BasicDBObject().append("Flight", flightid);
       coll1.update(searchQuery, newDocument);
     }
       
        public void Remove(int flightid)
     {  
         
         BasicDBObject searchQuery = new BasicDBObject().append("FlightID", flightid);
         coll1.remove(searchQuery);
       
     }
        
        public void Viewflights()
     {  
  
         DBCursor cursor = coll1.find();
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
       
     }
    //------------------------------------------------------
        
         public void Makereserv (String Flightnom,int reservid,boolean isacce)
     {  
        BasicDBObject doc = new BasicDBObject("Flightnumbers", Flightnom)
        .append("reservationID", reservid)
        .append("IsAccepted", isacce);
    
        coll3.insert(doc);
     }
         
         public void Cancelreserv(int reservid)
     {  
         
         BasicDBObject searchQuery = new BasicDBObject().append("reservationID", reservid);
         coll3.remove(searchQuery);
       
     }
         public void Viewreserv()
     {  
  
         DBCursor cursor = coll3.find();
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
       
     }   
         
         public void Viewava()
     {  
          BasicDBObject query = new BasicDBObject("isAccepted", true);
         
          DBCursor cursor = coll3.find(query);
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
       
     }   
 
 //--------------------------------------------------------------
          boolean check(String field,DBCollection collnew,String value)
          {
        BasicDBObject query = new BasicDBObject(field, value);

           DBCursor cursor = collnew.find(query);

            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
                    return true;
               }
            } finally {
               cursor.close();
            }
            return false;
          }
          
           int GetLastID()
      {
          int x = 0 ;
          DBCursor cursor = coll.find();
            try {
               while(cursor.hasNext()) {
                   if (cursor.hasNext())
                       x =  (int)cursor.next().get("id");
               }
            } finally {
               cursor.close();
            }
            return x;
       
      }
      boolean checkint(String field, DBCollection collnew, int value) {
        BasicDBObject query = new BasicDBObject(field, value);

        DBCursor cursor = collnew.find(query);

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
                return true;
            }
        } finally {
            cursor.close();
        }
        return false;
    }
      public void modifyflightint(int flightid, String s, int u) 
    {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append(s, u));

        BasicDBObject searchQuery = new BasicDBObject().append("Flight", flightid);

        coll1.update(searchQuery, newDocument);
    }
    ////////////////////////////////////////////////////////////////////////////
    public void modifyflightboolean(int flightid, String s, boolean u) 
    {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append(s, u));

        BasicDBObject searchQuery = new BasicDBObject().append("Flight", flightid);

        coll1.update(searchQuery, newDocument);
    }
    public void Viewavaliable(boolean isaccepted) {
        BasicDBObject query = new BasicDBObject("isAccepted", isaccepted);

        DBCursor cursor = coll3.find(query);
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

    }
    public void updateboolean(DBCollection newColl , String f,boolean v, String table,int id)
     {  
       BasicDBObject newDocument = new BasicDBObject();
       newDocument.append("$set", new BasicDBObject().append(f, v));

       BasicDBObject searchQuery = new BasicDBObject().append(table, id);

       newColl.update(searchQuery, newDocument);
       
     }
    public void Makereservation(int Flightnom, int reservid, boolean isaccepted) 
    {
        BasicDBObject doc = new BasicDBObject("Flightnumbers", Flightnom)
                .append("reservationID", reservid)
                .append("IsAccepted", false);
        coll3.insert(doc);
    }
     public void Cancelreservation(int reservid) 
    {
        BasicDBObject searchQuery = new BasicDBObject().append("reservationID", reservid);
        coll3.remove(searchQuery);
    }
      public void Removeuser(String mail) 
    {

        BasicDBObject searchQuery = new BasicDBObject().append("mail", mail);
        coll.remove(searchQuery);

    }
}
//-----------------------------------------------------------------


