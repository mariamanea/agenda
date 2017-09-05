/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mariamanea
 */

package finalproject;

public class Customer {
    private int ID;
    private String FirstName;
    private String LastName;
    private String CNP;
    private String PhoneNumber;
    private String MobileNumber;

    public Customer(int ID, String FirstName, String LastName, String CNP, String PhoneNumber, String MobileNumber) {
        this.ID=ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.CNP=CNP;
        this.PhoneNumber=PhoneNumber;
        this.MobileNumber=MobileNumber;
        
    }
    
    public int getID()
    {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

 
}
    


