
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
import model.Badminton;


public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    
    public ReadQuery(){
    Properties props = new Properties(); //MWC
    InputStream instr =getClass().getResourceAsStream("dbConn.properties");
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
            String query = "Select * from badminton_club";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
    public String getHTMLtable(){
    
        String table ="";
        
        table += "<table border=1>";
        
 
        try {
            while(this.results.next()){
                
                Badminton Members = new Badminton();
                Members.setMember_ID(this.results.getInt("member_id"));
                Members.setOfficial_Name(this.results.getString("official_name"));
                Members.setPrefer_Name(this.results.getString("prefer_name"));
                Members.setEmail(this.results.getString("email"));
                Members.setPhone_Number(this.results.getInt("phone_number"));
                
                table += "<tr>";
                
                table += "<td>";
                table += Members.getMember_ID();
                table += "</td>";
                
                table += "<td>";
                table += Members.getOfficial_Name();
                table += "</td>";
                
                table += "<td>";
                table += Members.getPrefer_Name();
                table += "</td>";
                
                
                table += "<td>";
                table += Members.getEmail();
                table += "</td>";
                
                
                table += "<td>";
                table += Members.getPhone_Number();
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";  
        
               return table;        
    }
}
