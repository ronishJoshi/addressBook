package examples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SONY
 */
public class AddressBook {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Long telephoneNumber;
    private Long mobileNumber;
    private String email;

    public AddressBook(){
        
    }
    public AddressBook(String firstName, String lastName, String address, Long telephoneNumber, Long mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBook{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", telephoneNumber=" + telephoneNumber + ", mobileNumber=" + mobileNumber + ", email=" + email + '}';
    }
    
}
