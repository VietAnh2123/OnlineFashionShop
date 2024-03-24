/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoryDTO;

/**
 *
 * @author AD
 */
public class CategoryDAO extends DBContext{
    
    public List<CategoryDTO> listCategory(){
        ArrayList<CategoryDTO> list = new ArrayList<>();
        
        String sql = "SELECT id, category_name, category_img FROM category";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CategoryDTO c = new CategoryDTO(rs.getInt("id"), rs.getString("category_name"), rs.getString("category_img"));
                
                list.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return list;
    }
    
}
