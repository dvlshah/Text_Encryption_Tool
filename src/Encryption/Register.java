package Encryption;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Register {
    
    Register(String user,String pass,String cPass){
        
        DatabaseConnect obj = new DatabaseConnect();
        try{
            if(user !="" && pass!="" && cPass!=""){
                if(pass.equals(cPass)){
                    obj.st = obj.cn.createStatement();
                    String sql = "INSERT INTO UserData VALUES(EncSeq.nextval,'"+user+"','"+pass+"')";
                    obj.st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(new RegisterForm(), "Registered Successfully");
                }
                else 
                {
                    JOptionPane.showMessageDialog(new RegisterForm(), "Passowrds do not match");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(new RegisterForm(), "InvalidInfo");
            }
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(new RegisterForm(), "Database error"+se);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(new RegisterForm(),"Error:"+e);
        }
    }
}
