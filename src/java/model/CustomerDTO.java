/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Setter
@Getter
public class CustomerDTO {
    
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;
    
}
