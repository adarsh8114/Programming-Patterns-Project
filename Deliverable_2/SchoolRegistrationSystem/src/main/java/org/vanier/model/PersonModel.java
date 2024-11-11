package org.vanier.model;

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
}
