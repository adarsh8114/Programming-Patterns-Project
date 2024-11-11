package org.vanier.factory;


import org.vanier.model.AdminModel;
import org.vanier.model.PersonModel;
import org.vanier.model.StudentModel;
import org.vanier.model.TeacherModel;

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
    public static PersonModel createCourse(String personType, String firstName, String lastName, String phoneNumber,
                                           String emailAddress, String password) {
        if (personType.equalsIgnoreCase("Admin")) {
            //return new AdminModel();
        } else if (personType.equalsIgnoreCase("Student")){
            return new StudentModel(firstName, lastName, phoneNumber, emailAddress, password);
        } else {
            //return new TeacherModel();
        }
        return null;
    }
}
