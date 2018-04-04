/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author Aman
 */
public interface intmed {
     public void setMedcod(int mcod);
    public void setMednam(String mn);
    public void setMedgennam(String mg);
    public void setMedcmp(String mc);
    public void setMedtyp(String mt);
    public void setMedpot(String mp);
    public void setMedpre(String mpr);
   
    
    public int getMedcod();
    public String getMednam();
    public String getMedgennam();
    public String getMedcmp(); 
    public String getMedtyp();
    public String getMedpot();
    public String getMedpre();
}
