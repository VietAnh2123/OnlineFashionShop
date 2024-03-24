/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CartDTO;
import model.CustomerDTO;
import model.Item;
import model.OrdersDTO;

/**
 *
 * @author AD
 */
public class OrderDAO extends DBContext {

    public void addOrder(CustomerDTO c, CartDTO cart, String note) {
        try {
            LocalDate curDate = java.time.LocalDate.now();
            Date date = Date.valueOf(curDate);
            ProductDAO pDAO = new ProductDAO();
            String sql1
                    = "INSERT INTO orders(customer_id, address, note, total_price, status, create_date) "
                    + " VALUES(?,?,?,?,?,?) ";
            Connection conn = connection;
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, c.getId());
            ps1.setNString(2, c.getAddress());
            ps1.setNString(3, note);
            ps1.setDouble(4, cart.getTotalMoney());
            ps1.setNString(5, "Đang chuẩn bị");
            ps1.setDate(6, date);

            ps1.executeUpdate();

            String sql2 = "SELECT Top 1 id FROM orders ORDER BY id DESC";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {
                int oId = rs.getInt(1);
                for (Item item : cart.getItems()) {
                    String sql3 = "INSERT INTO order_detail(product_id, order_id, quantity) "
                            + "VALUES(?,?,?)";
                    PreparedStatement ps3 = conn.prepareStatement(sql3);
                    ps3.setInt(1, item.getProduct().getId());
                    ps3.setInt(2, oId);
                    ps3.setInt(3, item.getQuantity());

                    ps3.executeUpdate();

                    pDAO.updateValueProduct(item.getProduct(), item.getSizeId(), item.getQuantity());
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getNumberOrders() {
        String sql = "SELECT COUNT(*) FROM orders";
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
        return 1;
    }

    public int countOrders() {
        String sql = "SELECT count(*) FROM orders";
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

    public double countTotalMoney() {
        String sql = "select sum(total_price) from orders";
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

    public List<OrdersDTO> deliveredOrders() {
        ArrayList<OrdersDTO> list = new ArrayList<>();
        String sql = "select * from orders where status = N'Đã giao'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrdersDTO o = new OrdersDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getDate(7));

                list.add(o);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<OrdersDTO> canceledOrders() {
        ArrayList<OrdersDTO> list = new ArrayList<>();
        String sql = "select * from orders where status = N'Đã hủy'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrdersDTO o = new OrdersDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getDate(7));

                list.add(o);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<OrdersDTO> deliveringOrders() {
        ArrayList<OrdersDTO> list = new ArrayList<>();
        String sql = "select * from orders where status = N'Đang chuẩn bị' ORDER BY id DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrdersDTO o = new OrdersDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getDate(7));

                list.add(o);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public void updateOrder(String oId){
        String sql = "update orders set status = N'Đã giao' WHERE id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, oId);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void cancelOrder(String oId){
        String sql = "update orders set status = N'Đã hủy' WHERE id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, oId);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
