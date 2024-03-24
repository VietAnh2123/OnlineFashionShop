/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AD
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersDTO {
    
    private int id;
    private int customer_id;
    private String address;
    private String note;
    private double totalPrice;
    private String status;
    private Date createDate;
    
}
