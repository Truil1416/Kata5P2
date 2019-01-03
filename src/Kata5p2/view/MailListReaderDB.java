package Kata5p2.view;

import Kata5p2.model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderDB {
    
    public List<Mail> read(){
        
        List<Mail> list = new ArrayList();
        String url = "jdbc:sqlite:KATA5.db";
        String sql = "SELECT * FROM MAIL";
        try (Connection conn = DriverManager.getConnection(url); 
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Mail(rs.getString("direccion")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
