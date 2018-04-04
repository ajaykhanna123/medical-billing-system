package BusinessLogic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clsbildet {
    CallableStatement stm;
    public void insert_billdet(clsbildetprp p) throws SQLException
    {
        try {
        clscon obj=clscon.getInstance();
        obj.connect();
        stm=obj.con.prepareCall("{call insert_billdet(?,?,?)}");
        stm.setInt(1, p.getBildetbilcod());
        stm.setInt(2, p.getBildetqty());
        stm.setInt(3, p.getBildetstkcod());
        stm.execute();
        obj.disconnect();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
    
     public void update_billdet(clsbildetprp p) throws SQLException
    {
        try {
        clscon obj=clscon.getInstance();
        obj.connect();
        stm=obj.con.prepareCall("{call update_billdet(?,?,?,?)}");
        stm.setInt(1, p.getBildetbilcod());
        stm.setInt(2, p.getBildetcod());
        stm.setInt(3, p.getBildetqty());
        stm.setInt(4, p.getBildetstkcod());
        stm.execute();
        obj.disconnect();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
     
      public void delete_billdet(clsbildetprp p) throws SQLException
    {
        try {
        clscon obj=clscon.getInstance();
        obj.connect();
        stm=obj.con.prepareCall("{call delete_billdet(?)}");
        stm.setInt(1, p.getBildetcod());
        stm.execute();
        obj.disconnect();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
      
       public List<clsbildetprp> disp_billdet(int bcod) throws SQLException
    {
        List<clsbildetprp> arr=new ArrayList<clsbildetprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call disp_billdet(?)}");    
            stm.setInt(1, bcod);
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               clsbildetprp p=new clsbildetprp();
              p.setBildetbilcod(rs.getInt("bildetbilcod"));
              p.setBildetcod(rs.getInt("bildetcod"));
              p.setBildetqty(rs.getInt("bildetqty"));
              p.setBildetstkcod(rs.getInt("bildetstkcod"));
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
    
       public clsbildetprp find_billdet(int bcod) throws SQLException
    {
        clsbildetprp p=new clsbildetprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call find_billdet(?)}");     
            stm.setInt(1,bcod);
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
              p.setBildetbilcod(rs.getInt("bildetbilcod"));
              p.setBildetcod(rs.getInt("bildetcod"));
              p.setBildetqty(rs.getInt("bildetqty"));
              p.setBildetstkcod(rs.getInt("bildetstkcod"));
           }
            obj.disconnect();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return p;
    }
}
