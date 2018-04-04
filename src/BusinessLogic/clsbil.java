
package BusinessLogic;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class clsbil {
    CallableStatement stm;
    public int insert_bill(clsbilprp p) throws SQLException
    {  
        int bcod=0;
        try {
        clscon obj=clscon.getInstance();
        obj.connect();
        stm=obj.con.prepareCall("{call insert_bill(?,?,?,?)}");
        stm.setString(1, p.getBilcstnam());
        stm.setLong(2, p.getBilcstphn());
        Date d=new Date(p.getBildat().getTime());
        stm.setDate(3, d);
        stm.registerOutParameter(4, Types.INTEGER);
        stm.execute();
        bcod=stm.getInt(4);
        obj.disconnect();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        return bcod;    
    }
    
     public void update_bill(clsbilprp p) throws SQLException
    {
        try {
        clscon obj=clscon.getInstance();
        obj.connect();
        stm=obj.con.prepareCall("{call update_billtb(?,?,?,?)}");
        stm.setInt(1, p.getBilcod());
        stm.setString(2, p.getBilcstnam());
        stm.setLong(3, p.getBilcstphn());
        Date d=new Date(p.getBildat().getTime());
        stm.setDate(4, d);
        stm.execute();
        obj.disconnect();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        
    }
     
             public void delete_billtb(clsbilprp p) throws SQLException
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delete_billtb(?)}");
            stm.setInt(1,p.getBilcod());           
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
             
    public List<clsbilprp> disp_bill() throws SQLException
    {
        List<clsbilprp> arr=new ArrayList<clsbilprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call disp_billtb()}");          
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               clsbilprp p=new clsbilprp();
               p.setBilcod(rs.getInt("bilcod"));
               p.setBilcstnam(rs.getString("bilcstnam"));
               p.setBilcstphn(rs.getLong("bilcstphn"));
               p.setBildat(rs.getDate("bildat"));
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
              
      public clsbilprp find_bill(int bcod) throws SQLException
    {
        clsbilprp p=new clsbilprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call find_billtb(?)}");     
            stm.setInt(1,bcod);
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               p.setBilcod(rs.getInt("bilcod"));
               p.setBilcstnam(rs.getString("bilcstnam"));
               p.setBilcstphn(rs.getLong("bilcstphn"));
               p.setBildat(rs.getDate("bildat"));
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
