
package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Members;


public class ReadQuery {
   
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        
    }
    
    public void doRead(){
        
        try {
            String query = "Select * from Badminton_Club";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getHTMLtable(){
        
        String table = "";
        
        table += "<table border=1>";
        
        try {
            while(this.results.next()){
                
                Members member = new Members();
                member.setMemberID(this.results.getInt("member_ID"));
                member.setOfficialName(this.results.getString("official_name"));
                member.setPreferName(this.results.getString("prefer_name"));
                member.setEmail(this.results.getString("email"));
                member.setPhoneNumber(this.results.getInt("phone_number"));
                
                table += "<tr>";
                table += "<td>";
                table += member.getMemberID();
                table += "<td>";
                
                                
                table += "<td>";
                table += member.getOfficialName();
                table += "<td>";
                
                           
                table += "<td>";
                table += member.getPreferName();
                table += "<td>";
                
                                
                table += "<td>";
                table += member.getEmail();
                table += "<td>";
                
                                
                table += "<td>";
                table += member.getPhoneNumber();
                table += "<td>";
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table += "</table>";

                return table;
    }
            
    
    
}
