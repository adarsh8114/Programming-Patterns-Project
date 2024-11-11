package org.vanier.model;

import java.util.Objects;

public class PersonModel {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private static int counter = 1;

    public PersonModel(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }


    /**
     * get the full name of the student by combining first and last name
     *
     * @return students full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonModel that = (PersonModel) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, emailAddress, password);
    }
}
