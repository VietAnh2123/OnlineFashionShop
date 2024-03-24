/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminDTO;

/**
 *
 * @author AD
 */
public class AdminDAO extends DBContext{
    
    public AdminDTO getAdmin(String username, String password){
        String sql = "SELECT * FROM admin WHERE username=? AND password=? ";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                AdminDTO a = new AdminDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return a;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
