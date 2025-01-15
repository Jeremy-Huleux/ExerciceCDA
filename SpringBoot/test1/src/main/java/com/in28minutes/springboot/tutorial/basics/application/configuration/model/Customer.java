
package com.in28minutes.springboot.tutorial.basics.application.configuration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Customer\"")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "id_generator_customer", allocationSize = 1)
    @Column(name="\"CustomerId\"")
    private Long customerId;

    @Column(name="\"FirstName\"")
    private String firstName;

    @Column(name="\"LastName\"")
    private String lastName;

    @Column(name="\"Company\"")
    private String company;

    @Column(name="\"Address\"")
    private String address;

    @Column(name="\"City\"")
    private String city;

    @Column(name="\"State\"")
    private String state;

    @Column(name="\"Country\"")
    private String country;

    @Column(name="\"PostalCode\"")
    private String postalCode;

    @Column(name="\"Phone\"")
    private String phone;

    @Column(name="\"Fax\"")
    private String fax;

    @Column(name="\"Email\"")
    private String email;

    @Column(name="\"SupportRepId\"")
    private Long supportRepId;

    public Customer() {
        super();
    }

    public Customer(Long customerId, 
                    String lastName, 
                    String firstName, 
                    String company, 
                    String address, 
                    String city, 
                    String state, 
                    String country, 
                    String postalCode, 
                    String phone, 
                    String fax, 
                    String email, 
                    Long supportRepId) {
      this.customerId = customerId;
      this.lastName = lastName;
      this.firstName = firstName;
      this.company = company;
      this.address = address;
      this.city = city;
      this.state = state;
      this.country = country;
      this.postalCode = postalCode;
      this.phone = phone;
      this.fax = fax;
      this.email = email;
      this.supportRepId = supportRepId;
    }


    public Long getCustomerId() {
      return customerId;
    }

    public void setCustomerId(Long customerId) {
      this.customerId = customerId;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getCompany() {
      return company;
    }

    public void setCompany(String company) {
      this.company = company;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public String getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getFax() {
      return fax;
    }

    public void setFax(String fax) {
      this.fax = fax;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public Long getSupportRepId() {
      return supportRepId;
    }

    public void setSupportRepId(Long supportRepId) {
      this.supportRepId = supportRepId;
    }

    @Override
    public String toString() {
      return "Customer{" +
          "customerId=" + customerId +
          ", lastName='" + lastName + '\'' +
          ", firstName='" + firstName + '\'' +
          ", company='" + company + '\'' +
          ", address=" + address +
          ", city=" + city +
          ", state=" + state +
          ", country='" + country + '\'' +
          ", postalCode='" + postalCode + '\'' +
          ", phone='" + phone + '\'' +
          ", fax='" + fax + '\'' +
          ", email='" + email + '\'' +
          ", supportRepId='" + supportRepId + '\'' +
          '}';
    }

}