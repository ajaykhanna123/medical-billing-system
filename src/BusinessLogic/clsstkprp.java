/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.Date;

/**
 *
 * @author Aman
 */
public class clsstkprp{
    private int stkcod,stkqty,stkmedcod;
    private Date stkdat,stkmnfdat,stkexpdat;
    private float stkprc;

    public int getStkcod() {
        return stkcod;
    }

    public void setStkcod(int stkcod) {
        this.stkcod = stkcod;
    }

    public int getStkqty() {
        return stkqty;
    }

    public void setStkqty(int stkqty) {
        this.stkqty = stkqty;
    }

    public int getStkmedcod() {
        return stkmedcod;
    }

    public void setStkmedcod(int stkmedcod) {
        this.stkmedcod = stkmedcod;
    }

    public Date getStkdat() {
        return stkdat;
    }

    public void setStkdat(Date stkdat) {
        this.stkdat = stkdat;
    }

    public Date getStkmnfdat() {
        return stkmnfdat;
    }

    public void setStkmnfdat(Date stkmnfdat) {
        this.stkmnfdat = stkmnfdat;
    }

    public Date getStkexpdat() {
        return stkexpdat;
    }

    public void setStkexpdat(Date stkexpdat) {
        this.stkexpdat = stkexpdat;
    }

    public float getStkprc() {
        return stkprc;
    }

    public void setStkprc(float stkprc) {
        this.stkprc = stkprc;
    }
}
   