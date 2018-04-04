package BusinessLogic;

import java.util.Date;

public class clsbilprp {
    private int bilcod;
    private long bilcstphn;
    private String bilcstnam;
    private Date bildat;
    {
        bilcstnam=new String();
    }

    public int getBilcod() {
        return bilcod;
    }

    public void setBilcod(int bilcod) {
        this.bilcod = bilcod;
    }

    public long getBilcstphn() {
        return bilcstphn;
    }

    public void setBilcstphn(long bilcstphn) {
        this.bilcstphn = bilcstphn;
    }

    public String getBilcstnam() {
        return bilcstnam;
    }

    public void setBilcstnam(String bilcstnam) {
        this.bilcstnam = bilcstnam;
    }

    public Date getBildat() {
        return bildat;
    }

    public void setBildat(Date bildat) {
        this.bildat = bildat;
    }
}
