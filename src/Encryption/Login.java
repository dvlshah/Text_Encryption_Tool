
package Encryption;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Login {
    
    DatabaseConnect dobj = new DatabaseConnect();
    
    Login(String user,String pass){
    
        try{
            
            dobj.st = dobj.cn.createStatement();
            String select = "select regid,username,password from UserData";
            dobj.rs = dobj.st.executeQuery(select);
            
            while(dobj.rs.next()){
                
                String user_data = dobj.rs.getString("username");
                String pass_data = dobj.rs.getString("password");
            
                if(user_data.equals(user) && pass_data.equals(pass)){
                    JOptionPane.showMessageDialog(new LoginFrame(), "Login Successful");
                }
            }
        }
        
        catch(SQLException se){
            JOptionPane.showMessageDialog(new LoginFrame(),"Database error"+se);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(new LoginFrame(), "Login Unsuccessful due to "+e);
        }
    }   
    
}
