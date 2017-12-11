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
public class Plane 
{
    boolean avaliabe;
    int numberofseat;
    int planeid;
    String planename;
    int reservedseats;
    ////////////////////////////////////////////////////////////////////////////

    public Plane(boolean avaliabe, int numberofseat, int planeid, String planename, int reservedseats) {
        this.avaliabe = avaliabe;
        this.numberofseat = numberofseat;
        this.planeid = planeid;
        this.planename = planename;
        this.reservedseats = reservedseats;
    }
    ////////////////////////////////////////////////////////////////////////////

    public boolean isAvaliabe() {
        return avaliabe;
    }

    public void setAvaliabe(boolean avaliabe) {
        this.avaliabe = avaliabe;
    }

    public int getNumberofseat() {
        return numberofseat;
    }

    public void setNumberofseat(int numberofseat) {
        this.numberofseat = numberofseat;
    }

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    public String getPlanename() {
        return planename;
    }

    public void setPlanename(String planename) {
        this.planename = planename;
    }

    public int getReservedseats() {
        return reservedseats;
    }

    public void setReservedseats(int reservedseats) {
        this.reservedseats = reservedseats;
    }
    
}
