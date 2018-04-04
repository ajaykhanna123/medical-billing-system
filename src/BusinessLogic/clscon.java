package BusinessLogic;
import java.sql.Connection;
import java.sql.DriverManager;
public class clscon {
    Connection con;
    static clscon db;
    
    public static clscon getInstance()
    {
        if(db==null)
        {
            db=new clscon();
        }
        return db;
    }
    void connect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/medbillsys","root","azyxter");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    void disconnect()
    {
        try {
            con.close();
            }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
