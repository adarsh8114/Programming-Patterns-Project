package org.vanier.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentModelTest {
    //verifyStudentLogin Method tests
    @Test
    public void testVerifyStudentLogin1() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password123");
        student.setId(1);

        assertTrue(student.verifyStudentLogin(1, "password123"));
    }

    @Test
    public void testVerifyStudentLogin2() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setId(5);

        assertTrue(student.verifyStudentLogin(5, "password"));
    }

    @Test
    public void testVerifyStudentLogin3() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "Hey123");
        student.setId(0);

        assertFalse(student.verifyStudentLogin(2, "hey"));
    }

    @Test
    public void testVerifyStudentLogin4() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setId(1);

        assertFalse(student.verifyStudentLogin(5, "password"));
    }

    @Test
    public void testVerifyStudentLogin5() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setId(5);

        assertFalse(student.verifyStudentLogin(5, "password555"));
    }

    //getStudentStatus Method Tests
    @Test
    public void testGetStudentStatus1() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setFullTime(true);

        String status = student.getStudentStatus();
        assertEquals("You are currently a full time student", status);
    }

    @Test
    public void testGetStudentStatus2() {
        StudentModel student = new StudentModel("joe", "cool", "1234567890", "john.doe@example.com", "pas");
        student.setFullTime(true);

        String status = student.getStudentStatus();
        assertEquals("You are currently a full time student", status);
    }

    @Test
    public void testGetStudentStatus3() {
        StudentModel student = new StudentModel("John", "Smith", "1234567890", "john.doe@example.com", "password");

        String status = student.getStudentStatus();
        assertEquals("You are currently a part time student!", status);
    }

    @Test
    public void testGetStudentStatus4() {
        StudentModel student = new StudentModel("Joe", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setFullTime(false);

        String status = student.getStudentStatus();
        assertEquals("You are currently a part time student!", status);
    }

    @Test
    public void testGetStudentStatus5() {
        StudentModel student = new StudentModel("John", "Doe", "1234567890", "john.doe@example.com", "password");
        student.setFullTime(false);

        String status = student.getStudentStatus();
        assertEquals("You are currently a part time student!", status);
    }
}
