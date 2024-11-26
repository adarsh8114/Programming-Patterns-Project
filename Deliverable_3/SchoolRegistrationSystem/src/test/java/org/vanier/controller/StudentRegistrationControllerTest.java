package org.vanier.controller;

import org.junit.Test;
import org.vanier.model.RegistrationSystem;
import org.vanier.model.StudentModel;

import java.util.List;

import static org.junit.Assert.*;

public class StudentRegistrationControllerTest {
    //verifyValidStudentLogin Method tests
    @Test
    public void testVerifyValidStudentLogin1() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        StudentModel student1 = new StudentModel("John", "Doe", "123-456-7890", "john.doe@example.com", "password123");
        student1.setId(1);
        registrationSystem.setStudentList(List.of(student1));


        StudentModel studentModel = new StudentRegistrationController().verifyStudentInputLogin(1, "password123");

        assertEquals(studentModel, student1);

    }

    @Test
    public void testVerifyValidStudentLogin2() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        StudentModel student1 = new StudentModel("John", "Doe", "123-456-7890", "john.doe@example.com", "password123");
        student1.setId(1);
        StudentModel student2 = new StudentModel("Math", "Ver", "123-456-7890", "ver@example.com", "pass");
        student2.setId(2);
        registrationSystem.setStudentList(List.of(student1, student2));


        StudentModel studentModel = new StudentRegistrationController().verifyStudentInputLogin(2, "pass");

        assertEquals(studentModel, student2);
    }

    @Test
    public void testVerifyValidStudentLogin3() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        StudentModel student1 = new StudentModel("John", "Doe", "123-456-7890", "john.doe@example.com", "password123");
        student1.setId(1);
        StudentModel student2 = new StudentModel("Math", "Ver", "123-456-7890", "ver@example.com", "pass");
        student2.setId(2);
        registrationSystem.setStudentList(List.of(student1, student2));


        StudentModel studentModel = new StudentRegistrationController().verifyStudentInputLogin(5, "pass");

        assertNull(studentModel);
    }

    @Test
    public void testVerifyValidStudentLogin4() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

        StudentModel studentModel = new StudentRegistrationController().verifyStudentInputLogin(22, "passs");

        assertNull(studentModel);
    }

    @Test
    public void testVerifyValidStudentLogin5() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        StudentModel student1 = new StudentModel("John", "Doe", "123-456-7890", "john.doe@example.com", "password123");
        student1.setId(1);
        StudentModel student2 = new StudentModel("Math", "Ver", "123-456-7890", "ver@example.com", "pass");
        student2.setId(2);
        registrationSystem.setStudentList(List.of(student1, student2));


        StudentModel studentModel = new StudentRegistrationController().verifyStudentInputLogin(2, "passssss");

        assertNull(studentModel);
    }
}
