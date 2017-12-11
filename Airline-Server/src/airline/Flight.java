/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

/**
 *
 * @author Mohamed Ibrahem
 */
public class Flight 
{
    String arrivaldate;
    String departuredate;
    int flight_id;
    boolean fight_ava;
    int plane_id;
    ////////////////////////////////////////////////////////////////////////////

    public Flight(String arrivaldate, String departuredate, int flight_id, boolean fight_ava, int plane_id) {
        this.arrivaldate = arrivaldate;
        this.departuredate = departuredate;
        this.flight_id = flight_id;
        this.fight_ava = fight_ava;
        this.plane_id = plane_id;
    }
    ////////////////////////////////////////////////////////////////////////////

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public boolean isFight_ava() {
        return fight_ava;
    }

    public void setFight_ava(boolean fight_ava) {
        this.fight_ava = fight_ava;
    }

    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }
    
}
