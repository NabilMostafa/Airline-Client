/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

/**
 *
 * @author Omar Kotb
 */
public class Reservations 
{
    String flightnumber;
    boolean isaccepted;
    int reservationid;
    int Client_ID;

    public Reservations(String flightnumber, boolean isaccepted, int reservationid, int Client_ID) {
        this.flightnumber = flightnumber;
        this.isaccepted = isaccepted;
        this.reservationid = reservationid;
        this.Client_ID = Client_ID;
    }

    public Reservations() {
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public boolean isIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(boolean isaccepted) {
        this.isaccepted = isaccepted;
    }

    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int Client_ID) {
        this.Client_ID = Client_ID;
    }
    
  
}
