package view;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    
    public static List<Mail> read() throws FileNotFoundException{
        List<Mail> list = new ArrayList<>();
        
        try(Connection conn = connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM EMAIL")){
            
            while (rs.next()){
                Mail mail = new Mail(rs.getString("Mail"));
                list.add(mail);
            }
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}