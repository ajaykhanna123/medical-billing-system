package BusinessLogic;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class clsmed {
    CallableStatement stm;
     public void insert_med(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insert_med(?,?,?,?,?,?)}");
            stm.setString(1,p.getMednam());           
            stm.setString(2,p.getMedgennam());
            stm.setString(3,p.getMedcmp());
            stm.setString(4, p.getMedtyp());
            stm.setString(5, p.getMedpot());
            stm.setString(6,p.getMedpre());
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
    public void update_med(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call update_med(?,?,?,?,?,?,?)}");
            stm.setInt(1, p.getMedcod());
            stm.setString(2,p.getMednam());           
            stm.setString(3,p.getMedgennam());
            stm.setString(4,p.getMedcmp());
            stm.setString(5, p.getMedtyp());
            stm.setString(6, p.getMedpot());
            stm.setString(7,p.getMedpre());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }    
    public List<clsmedprp> disp_med()
    {
        List<clsmedprp> arr=new ArrayList<clsmedprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call disp_med()}");
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsmedprp p=new clsmedprp();
            p.setMedcod(rs.getInt("medcod"));
            p.setMednam(rs.getString("mednam"));
            p.setMedgennam(rs.getString("medgennam"));
            p.setMedcmp(rs.getString("medcmp"));
            p.setMedtyp(rs.getString("medtyp"));
            p.setMedpot(rs.getString("medpot"));
            p.setMedpre(rs.getString("medpre"));
                arr.add(p);
            }
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return arr;
    }
  public  clsmedprp find_med(int mcod)
    {
        clsmedprp p=new clsmedprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call find_med(?)}");
            stm.setInt(1, mcod);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
             p.setMedcod(rs.getInt("medcod"));
            p.setMednam(rs.getString("mednam"));
            p.setMedgennam(rs.getString("medgennam"));
            p.setMedcmp(rs.getString("medcmp"));
            p.setMedtyp(rs.getString("medtyp"));
            p.setMedpot(rs.getString("medpot"));
            p.setMedpre(rs.getString("medpre"));       
            }
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return p;
    }
   
 public void delete_med(clsmedprp p)
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delete_med(?)}");
            stm.setInt(1,p.getMedcod());
            stm.execute();
            obj.disconnect();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
