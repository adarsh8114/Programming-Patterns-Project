package org.vanier.controller;

import org.junit.Test;
import org.vanier.model.RegistrationSystem;
import org.vanier.model.TeacherModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherControllerTest {


    @Test
    public void testVerifyValidTeacherLogin1() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        TeacherModel teacher1 = new TeacherModel("John", "Smith", "123-456-7890", "john.smith@example.com", "password123", new ArrayList<>());
        teacher1.setId(1);
        TeacherModel teacher2 = new TeacherModel("Alice", "Brown", "987-654-3210", "alice.brown@example.com", "securePass", new ArrayList<>());
        teacher2.setId(2);
        registrationSystem.setTeacherList(List.of(teacher1, teacher2));

        TeacherModel teacherModel = new TeacherController().verifyTeacherInputLogin(5, "securePass");

        assertNull(teacherModel);
    }

    @Test
    public void testVerifyValidTeacherLogin2() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

        TeacherModel teacherModel = new TeacherController().verifyTeacherInputLogin(10, "randomPass");

        assertNull(teacherModel);
    }

    @Test
    public void testVerifyValidTeacherLogin3() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        TeacherModel teacher1 = new TeacherModel("John", "Smith", "123-456-7890", "john.smith@example.com", "password123", new ArrayList<>());
        teacher1.setId(1);
        TeacherModel teacher2 = new TeacherModel("Alice", "Brown", "987-654-3210", "alice.brown@example.com", "securePass", new ArrayList<>());
        teacher2.setId(2);
        registrationSystem.setTeacherList(List.of(teacher1, teacher2));

        TeacherModel teacherModel = new TeacherController().verifyTeacherInputLogin(2, "wrongPass");

        assertNull(teacherModel);
    }
}
