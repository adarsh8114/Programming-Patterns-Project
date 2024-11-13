package org.vanier.factory;


import org.vanier.model.*;

import java.util.List;

public class PersonFactory {

    /**
     * Creates a certain type of person with all its atributes
     * @param personType the type of person (Admin, Student, Teacher)
     * @param firstName persons first name
     * @param lastName persons last name
     * @param phoneNumber persons phone number
     * @param emailAddress persons email address
     * @param password persons password
     * @return the person which is an admin, student or teacher
     */
    public static PersonModel createPerson(String personType, String firstName, String lastName, String phoneNumber,
                                           String emailAddress, String password, List<CourseModel> coursesTeaching) {
         if (personType.equalsIgnoreCase("Student")) {
            return new StudentModel(firstName, lastName, phoneNumber, emailAddress, password);
        } else if (personType.equalsIgnoreCase("Teacher")) {
            return new TeacherModel(firstName, lastName, phoneNumber, emailAddress, password, coursesTeaching);
        }
        throw new IllegalArgumentException("Invalid person type provided");
    }
}
