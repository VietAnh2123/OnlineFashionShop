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
import model.CustomerDTO;

/**
 *
 * @author AD
 */
public class CustomerDAO extends DBContext {

    public void insertCustomer(CustomerDTO c) {
        String sql = "INSERT INTO customers(username,password,fullname,email,phone_number,address,gender) "
                + "VALUES(N'" + c.getUsername() + "',N'" + c.getPassword() + "',N'" + c.getFullname() + "',N'" + c.getEmail() + "',N'" + c.getPhoneNumber() + "',N'" + c.getAddress() + "',N'" + c.getGender() + "')";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setNString(1, c.getUsername());
//            ps.setNString(2, c.getPassword());
//            ps.setNString(3, c.getFullname());
//            ps.setNString(4, c.getEmail());
//            ps.setNString(5, c.getPhoneNumber());
//            ps.setNString(6, c.getAddress());
//            ps.setNString(7, c.getGender());

            ps.executeUpdate();

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertCustomer(String username, String password, String fullName, String email, String phoneNumber, String address, String gender) {
        String sql = "INSERT INTO customers(username,password,fullname,email,phone_number,address,gender) "
                + "VALUES(N'" + username + "',N'" + password + "',N'" + fullName + "',N'" + email + "',N'" + phoneNumber + "',N'" + address + "',N'" + gender + "')";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkUsername(String username) {
        boolean result = false;
        String sql = "SELECT * FROM customers WHERE username=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public CustomerDTO checkUser(String username, String password) {
        String sql = "SELECT * FROM customers WHERE username=? AND password=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("gender")
                );
                return c;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkUserEmail(String email) {
        boolean result = false;
        String sql = "SELECT * FROM customers WHERE email=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public String checkEmailExist(String email){
       String sql = "SELECT * FROM customers WHERE email=?";
       Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return email;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getUserNameByEmail(String email){
        String sql = "SELECT TOP 1 username FROM customers WHERE email=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString(1);
                return name;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public CustomerDTO getCustomerByUsername(String username){
        String sql = "SELECT * FROM customers WHERE username=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("gender")
                );
                return c;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(CustomerDTO c) {
        String sql = "UPDATE customers "
                + " SET fullname=?, "
                + "email=?, "
                + "phone_number=?, "
                + "address=?, "
                + "gender=? "
                + " WHERE id=?";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getFullname());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhoneNumber());
            ps.setString(4, c.getAddress());
            ps.setString(5, c.getGender());
            ps.setInt(6, c.getId());

            ps.executeUpdate();

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public CustomerDTO findByID(int id) {

        String sql = "SELECT * FROM [customers] WHERE id=?";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("gender")
                );
                return c;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean changePassword(CustomerDTO c) {
        int result = 0;
        String sql = "UPDATE customers "
                + "SET password=? "
                + "WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getPassword());
            ps.setInt(2, c.getId());
            ResultSet rs = ps.executeQuery();

            result = ps.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }
    
    public void updatePassbyUsername(String pass, String username){
        String sql = "UPDATE customers SET password=? WHERE username=?";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, username);
            
            ps.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int countCustomers(){
        String sql = "SELECT count(*) FROM customers";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int number = rs.getInt(1);
                return number;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<CustomerDTO> getCustomers(){
        ArrayList<CustomerDTO> list = new ArrayList<>();
        
        String sql = "SELECT * FROM customers";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("gender")
                );
                list.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public void deleteCustomer(int id){
        String sql = "DELETE FROM [customers] WHERE id=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
