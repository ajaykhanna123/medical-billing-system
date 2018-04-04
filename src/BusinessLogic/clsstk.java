package BusinessLogic;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Aman
 */
public class clsstk {
    CallableStatement stm;
         public void insert_stock(clsstkprp p) throws SQLException
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call insert_stock(?,?,?,?,?,?)}");
            stm.setInt(1,p.getStkmedcod()); 
            Date s=new Date(p.getStkdat().getTime());
            stm.setDate(2,s);
            stm.setInt(3,p.getStkqty());
            Date s1=new Date(p.getStkmnfdat().getTime());
            Date s2=new Date(p.getStkexpdat().getTime());
            stm.setDate(4, s1);
            stm.setDate(5, s2);
            stm.setFloat(6,p.getStkprc());
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
         
          public void update_stock(clsstkprp p) throws SQLException
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call update_stock(?,?,?,?,?,?,?)}");
            stm.setInt(1, p.getStkcod());
            stm.setInt(2,p.getStkmedcod());   
             Date s=new Date(p.getStkdat().getTime());
            stm.setDate(3,s);
            stm.setInt(4,p.getStkqty());
             Date s1=new Date(p.getStkmnfdat().getTime());
            Date s2=new Date(p.getStkexpdat().getTime());
            stm.setDate(5, s1);
            stm.setDate(6, s2);
            stm.setFloat(7,p.getStkprc());
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
          
          
           public void delete_stock(clsstkprp p) throws SQLException
    {
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call delete_stock(?)}");
            stm.setInt(1,p.getStkcod());           
            stm.execute();
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
    }
              public List<clsstkprp> disp_stock() throws SQLException
    {
        List<clsstkprp> arr=new ArrayList<clsstkprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call disp_stock()}");          
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               clsstkprp p=new clsstkprp();
               p.setStkcod(rs.getInt("stkcod"));
               p.setStkmedcod(rs.getInt("stkmedcod"));
               p.setStkdat(rs.getDate("stkdat"));
               p.setStkqty(rs.getInt("stkqty"));
               p.setStkmnfdat(rs.getDate("stkmnfdat"));
               p.setStkexpdat(rs.getDate("stkexpdat"));
               p.setStkprc(rs.getFloat("stkprc"));
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
              
        public List<clsstkprp> dispmedstk(int mcod)
    {
        List<clsstkprp> arr=new ArrayList<clsstkprp>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call dispmedstk(?)}");
             stm.setInt(1,mcod);
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                clsstkprp p=new clsstkprp();
               p.setStkcod(rs.getInt("stkcod"));
               p.setStkqty(rs.getInt("qtylft"));
               p.setStkmnfdat(rs.getDate("stkmnfdat"));
               p.setStkexpdat(rs.getDate("stkexpdat"));
               p.setStkprc(rs.getFloat("stkprc"));
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
              
                 public clsstkprp find_stock(int scod) throws SQLException
    {
        clsstkprp p=new clsstkprp();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call find_stock(?)}");     
            stm.setInt(1,scod);
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               p.setStkcod(rs.getInt("stkcod"));
                p.setStkmedcod(rs.getInt("stkmedcod"));
               p.setStkdat(rs.getDate("stkdat"));
               p.setStkqty(rs.getInt("stkqty"));
               p.setStkmnfdat(rs.getDate("stkmnfdat"));
               p.setStkexpdat(rs.getDate("stkexpdat"));
               p.setStkprc(rs.getFloat("stkprc"));
           }
            obj.disconnect();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
        return p;
    }
                 
                  public List<clsstkprp> find_stock_med(int smc) throws SQLException
    {
        List<clsstkprp> arr=new ArrayList<>();
        try
        {
            clscon obj=clscon.getInstance();
            obj.connect();
            stm=obj.con.prepareCall("{call find_stock_med(?)}");     
            stm.setInt(1,smc);
            ResultSet rs=stm.executeQuery();
           while(rs.next())
           {
               clsstkprp p=new clsstkprp();
               p.setStkcod(rs.getInt("stkcod"));
               p.setStkmedcod(rs.getInt("stkmedcod"));
               p.setStkdat(rs.getDate("stkdat"));
               p.setStkqty(rs.getInt("stkqty"));
               p.setStkmnfdat(rs.getDate("stkmnfdat"));
               p.setStkexpdat(rs.getDate("stkexpdat"));
               p.setStkprc(rs.getFloat("stkprc"));
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
    
}
