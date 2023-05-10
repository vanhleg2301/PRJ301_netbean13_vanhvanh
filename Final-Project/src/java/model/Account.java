/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    private String userID;
    private String email;
    private String password;
    private String customerID, employeeID;
    private int role;

    public Account() {
    }

    public Account(String userID, String email, String password, int role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Account(String email, String password, String customerID, String employeeID, int role) {
        this.email = email;
        this.password = password;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.role = role;
    }

    public Account(String email, String customerID, String employeeID) {
        this.email = email;
        this.customerID = customerID;
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", email=" + email + ", password=" + password + ", customerID=" + customerID + ", employeeID=" + employeeID + ", role=" + role + '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
