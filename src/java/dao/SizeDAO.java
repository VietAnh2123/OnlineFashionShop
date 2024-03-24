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
import model.SizeDTO;

/**
 *
 * @author AD
 */
public class SizeDAO extends DBContext {

    public List<SizeDTO> listSizeByProductID(int id) {
        ArrayList<SizeDTO> list = new ArrayList<>();
        String sql = "SELECT id"
                + "      ,size_name"
                + "      ,stock"
                + "      ,product_id"
                + "  FROM size "
                + "  WHERE product_id=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SizeDTO s = new SizeDTO(rs.getInt("id"), 
                        rs.getString("size_name"), 
                        rs.getInt("stock"), 
                        rs.getInt("product_id")
                );
                
                list.add(s);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
