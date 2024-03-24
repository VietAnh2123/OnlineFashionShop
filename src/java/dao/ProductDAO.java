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
import model.ProductsDTO;
import model.SizeDTO;

/**
 *
 * @author AD
 */
public class ProductDAO extends DBContext {

    public List<ProductsDTO> listProducts() {
        ArrayList<ProductsDTO> list = new ArrayList<>();

        String sql = "SELECT id "
                + "      ,product_name "
                + "      ,description"
                + "      ,price "
                + "      ,discount "
                + "      , category_id "
                + "      ,images "
                + "      ,color "
                + "  FROM products";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color")
                );

                list.add(p);

            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int countProducts() {
        ArrayList<ProductsDTO> list = new ArrayList<>();

        String sql = "SELECT count(*) FROM products";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<ProductsDTO> listProducts(String cId, String keyword, String sortBy, int index, int pageSize) {
        ArrayList<ProductsDTO> list = new ArrayList<>();

        String sql = "SELECT id "
                + "      ,product_name "
                + "      ,description"
                + "      ,price "
                + "      ,discount "
                + "      , category_id "
                + "      ,images "
                + "      ,color "
                + "  FROM products WHERE 1=1 ";

        Connection conn = connection;
        try {
            if (cId != "" || keyword != "") {
                sql += " AND category_id LIKE '%" + cId + "%' AND product_name LIKE N'%" + keyword + "%' ";
            }
//            if(sortBy.equals("desc") && sortBy != ""){
//                sql += " ORDER BY price DESC ";
//            }else if(sortBy.equals("asc") && sortBy != ""){
//                sql += " ORDER BY price ASC ";
//            }
//            
            int a = (index - 1) * pageSize;

            sql += " ORDER BY id OFFSET " + a + " ROWS FETCH NEXT " + pageSize + " ROWS ONLY ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color")
                );

                list.add(p);

            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<ProductsDTO> newArrivalList() {
        ArrayList<ProductsDTO> list = new ArrayList<>();

        String sql = "SELECT TOP 8 id "
                + "      ,product_name "
                + "      ,description"
                + "      ,price "
                + "      ,discount "
                + "      , category_id "
                + "      ,images "
                + "      ,color "
                + "  FROM products "
                + "  ORDER BY id DESC";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color")
                );

                list.add(p);

            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ProductsDTO getProductByID(int id) {

        String sql = "SELECT id "
                + "      ,product_name "
                + "      ,description"
                + "      ,price "
                + "      ,discount "
                + "      , category_id "
                + "      ,images "
                + "      ,color "
                + "  FROM products "
                + "  WHERE id=?";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color")
                );
                return p;
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ProductsDTO getProductBySizeID(int id) {

        String sql = "SELECT p.id "
                + "      ,p.product_name "
                + "      ,p.description"
                + "      ,p.price "
                + "      ,p.discount "
                + "      ,p.category_id "
                + "      ,p.images "
                + "      ,p.color"
                + "      ,s.id"
                + "      ,s.size_name"
                + "      ,s.stock "
                + "  FROM products p JOIN size s ON s.product_id = p.id "
                + "  WHERE s.id=?";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color"),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11)
                );
                return p;
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<SizeDTO> listSizeByProductID(int pId) {
        ArrayList<SizeDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM size WHERE product_id=? AND stock > 0";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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

    public int findStockBySizeId(String sizeId) {
        int result = 0;
        String sql = "SELECT * FROM size WHERE 1=1 ";
        if (sizeId != "") {
            sql += " AND id =" + sizeId;
        }
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getInt("stock");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public List<ProductsDTO> relatedList(int cId, int pId) {
        ArrayList<ProductsDTO> list = new ArrayList<>();

        String sql = "SELECT TOP 4 id "
                + "      ,product_name "
                + "      ,description"
                + "      ,price "
                + "      ,discount "
                + "      , category_id "
                + "      ,images "
                + "      ,color "
                + "  FROM products "
                + "  WHERE category_id = ? AND id != ? "
                + "  ORDER BY id DESC ";

        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cId);
            ps.setInt(2, pId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String image = rs.getString("images");
                String[] images = image.split(",");

                ProductsDTO p = new ProductsDTO(rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("discount"),
                        rs.getInt("category_id"),
                        images,
                        rs.getString("color")
                );

                list.add(p);

            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void updateValueProduct(ProductsDTO p, int sizeID, int value) {
        String sql = "UPDATE size SET stock = (stock - ?) WHERE id=? ";
        Connection conn = connection;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, sizeID);
            //ps.setInt(3, sizeID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int countProduct() {
        String sql = "SELECT sum(stock) FROM size ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<ProductsDTO> getProducts(int index, int pageSize) {
        ArrayList<ProductsDTO> list = new ArrayList<>();
        int a = (index-1)*pageSize;
        String sql = "SELECT * FROM products p JOIN size s ON s.product_id = p.id WHERE stock > 0 ";
        sql += " ORDER BY stock DESC OFFSET " + a + " ROWS FETCH NEXT " + pageSize + " ROWS ONLY ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String image = rs.getString("images");
                String[] images = image.split(",");
                ProductsDTO p = new ProductsDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        images,
                        rs.getString(8), 
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11)
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public int countAllProducts() {
        
        String sql = "SELECT COUNT(*) FROM products p JOIN size s ON s.product_id = p.id WHERE stock > 0 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
//    public static void main(String[] args) {
//        ProductDAO pDAO = new ProductDAO();
//        int count = pDAO.countAllProducts();
//        System.out.println(count);
//    }
    
    public List<ProductsDTO> getProductsOutOfStock() {
        ArrayList<ProductsDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM products p JOIN size s ON s.product_id = p.id WHERE stock < 0 ORDER BY stock DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String image = rs.getString("images");
                String[] images = image.split(",");
                ProductsDTO p = new ProductsDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        images,
                        rs.getString(8), 
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11)
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public void updateStock(int sizeId, int stock){
        String sql = "UPDATE size SET stock = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, sizeId);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
