package BusinessLogic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class clsrep {
    
    public ResultSet medexp()
    {
        ResultSet rs=null;
        try {
            clscon obj=clscon.getInstance();
            obj.connect();
            CallableStatement stm = obj.con.prepareCall("{call medexp()}");
            rs=stm.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
return rs;
    }
}
