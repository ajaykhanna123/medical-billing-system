package BusinessLogic;

import java.util.ArrayList;

public class clstmpbil 
{
    private int stkcod;
    private int medcod;
    private String mednam;
    private int qtypur;
    private float prc;
public static ArrayList<clstmpbil> arr;
static
{
    arr=new ArrayList<clstmpbil>();
}
    public int getStkcod() {
        return stkcod;
    }

    public void setStkcod(int stkcod) {
        this.stkcod = stkcod;
    }

    public int getMedcod() {
        return medcod;
    }

    public void setMedcod(int medcod) {
        this.medcod = medcod;
    }

    public String getMednam() {
        return mednam;
    }

    public void setMednam(String mednam) {
        this.mednam = mednam;
    }

    public int getQtypur() {
        return qtypur;
    }

    public void setQtypur(int qtypur) {
        this.qtypur = qtypur;
    }

    public float getPrc() {
        return prc;
    }

    public void setPrc(float prc) {
        this.prc = prc;
    }
    
}

