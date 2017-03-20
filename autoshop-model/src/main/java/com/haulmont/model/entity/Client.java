package com.haulmont.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vlad on 05-Mar-17.
 */
@Entity
@Table(name ="CLIENT", schema = "autoshop")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "You have to specify first name")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull(message = "You have to specify last name")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "You have to specify phone number")
    @Column(name = "phone_number")
    private String phoneNumber;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
