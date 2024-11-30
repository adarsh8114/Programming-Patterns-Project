package org.vanier.controller;

import org.vanier.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DatabaseController {
    private static final String DB_URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = LOCK.readLock();
    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = LOCK.writeLock();

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Creates the necessary tables
    public static void createTables() {
        String createStudentSQL = """
                    CREATE TABLE IF NOT EXISTS Student (
                        STUDENT_ID INTEGER PRIMARY KEY,
                        FIRST_NAME TEXT NOT NULL,
                        LAST_NAME TEXT NOT NULL,
                        PHONE_NUMBER TEXT,
                        EMAIL_ADDRESS TEXT,
                        PASSWORD TEXT,
                        NUMBER_COURSES_REGISTERED INTEGER,
                        IS_FULL_TIME INTEGER
                    )
                """;

        String createTeacherSQL = """
                    CREATE TABLE IF NOT EXISTS Teacher (
                        TEACHER_ID INTEGER PRIMARY KEY,
                        FIRST_NAME TEXT NOT NULL,
                        LAST_NAME TEXT NOT NULL,
                        PHONE_NUMBER TEXT,
                        EMAIL_ADDRESS TEXT,
                        PASSWORD TEXT
                    )
                """;
        String createAdminSQL = """
                    CREATE TABLE IF NOT EXISTS Admin (
                        ADMIN_ID INTEGER PRIMARY KEY,
                        FIRST_NAME TEXT NOT NULL,
                        LAST_NAME TEXT NOT NULL,
                        PHONE_NUMBER TEXT,
                        EMAIL_ADDRESS TEXT,
                        PASSWORD TEXT,
                        SECURITY_QUESTION TEXT,
                        SECURITY_ANSWER TEXT
                    )
                """;

        String createCourseSQL = """
                    CREATE TABLE IF NOT EXISTS Course (
                        COURSE_ID INTEGER PRIMARY KEY,
                        COURSE_NUMBER INTEGER,
                        COURSE_TYPE TEXT,
                        COURSE_SECTION INTEGER,
                        COURSE_CAPACITY INTEGER,
                        CURRENT_ENROLLMENT_NUMBER INTEGER,
                        COURSE_CREDITS INTEGER,
                        COURSE_TIME TEXT,
                        ONLINE_COURSE_LINK TEXT,
                        COURSE_ROOM_NUMBER TEXT,
                        TEACHER_ID INTEGER,
                        FOREIGN KEY (TEACHER_ID) REFERENCES Teacher(TEACHER_ID)
                    )
                """;

        String createRegisteredSQL = """
                    CREATE TABLE IF NOT EXISTS Registered (
                        STUDENT_ID INTEGER,
                        COURSE_NUMBER INTEGER,
                        PRIMARY KEY (STUDENT_ID, COURSE_NUMBER),
                        FOREIGN KEY (STUDENT_ID) REFERENCES Student(STUDENT_ID),
                        FOREIGN KEY (COURSE_NUMBER) REFERENCES Course(COURSE_NUMBER)
                    )
                """;


        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createStudentSQL);
            System.out.println("Student Table Created!");
            statement.execute(createTeacherSQL);
            System.out.println("Teacher Table Created!");
            statement.execute(createAdminSQL);
            System.out.println("Admin Table Created!");
            statement.execute(createCourseSQL);
            System.out.println("Course Table Created!");
            statement.execute(createRegisteredSQL);
            System.out.println("Registered Table Created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Add student to student Table
    public static void addStudent(int id, String firstName, String lastName, String phoneNumber, String email, String password, int coursesRegistered, boolean isFullTime) {
        String sql = """
                    INSERT INTO Student (STUDENT_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, PASSWORD, NUMBER_COURSES_REGISTERED, IS_FULL_TIME)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setInt(7, coursesRegistered);
            preparedStatement.setInt(8, isFullTime ? 1 : 0);
            preparedStatement.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Add Teacher
    public static void addTeacher(int id, String firstName, String lastName, String phoneNumber, String email, String password) {
        String sql = """
                    INSERT INTO Teacher (TEACHER_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, PASSWORD)
                    VALUES (?, ?, ?, ?, ?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();
            System.out.println("Teacher added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Add Admin
    public static void addAdmin(int id, String firstName, String lastName, String phoneNumber, String email, String password, String securityQuestion, String securityAnswer) {
        String sql = """
                    INSERT INTO Admin (ADMIN_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, PASSWORD, SECURITY_QUESTION, SECURITY_ANSWER)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, securityQuestion);
            preparedStatement.setString(8, securityAnswer);
            preparedStatement.executeUpdate();
            System.out.println("Admin added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Add Course
    public static void addCourse(int courseNumber, String type, int section, int capacity, int currentEnrollment, int credits, String time, String link, String roomNumber, int teacherId) {
        String sql = """
                    INSERT INTO Course (COURSE_NUMBER, COURSE_TYPE, COURSE_SECTION, COURSE_CAPACITY, CURRENT_ENROLLMENT_NUMBER, COURSE_CREDITS, COURSE_TIME, ONLINE_COURSE_LINK, COURSE_ROOM_NUMBER, TEACHER_ID)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, courseNumber);
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, section);
            preparedStatement.setInt(4, capacity);
            preparedStatement.setInt(5, currentEnrollment);
            preparedStatement.setInt(6, credits);
            preparedStatement.setString(7, time);
            preparedStatement.setString(8, link);
            preparedStatement.setString(9, roomNumber);
            preparedStatement.setInt(10, teacherId);
            preparedStatement.executeUpdate();
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Register Student to a Course
    public static void registerStudentToCourse(int studentId, int courseNumber) {
        String sql = """
                    INSERT INTO Registered (STUDENT_ID, COURSE_NUMBER)
                    VALUES (?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseNumber);
            preparedStatement.executeUpdate();
            System.out.println("Student registered to course successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Delete a Student
    public static void deleteStudent(int studentId) {
        String sql = "DELETE FROM Student WHERE STUDENT_ID = ?";

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Delete a Teacher
    public static void deleteTeacher(int teacherId) {
        String sql = "DELETE FROM Teacher WHERE TEACHER_ID = ?";

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teacherId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Teacher deleted successfully!");
            } else {
                System.out.println("No teacher found with ID: " + teacherId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Delete a Course
    public static void deleteCourse(int courseNumber) {
        String sql = "DELETE FROM Course WHERE COURSE_NUMBER = ?";

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, courseNumber);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("No course found with number: " + courseNumber);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Remove a Student from the Registered Table
    public static void removeStudentFromRegistered(int studentId, int courseNumber) {
        String sql = "DELETE FROM Registered WHERE STUDENT_ID = ? AND COURSE_NUMBER = ?";

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseNumber);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student removed from the course successfully!");
            } else {
                System.out.println("No registration found for Student ID: " + studentId + " in Course Number: " + courseNumber);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Read all Students
    public static List<StudentModel> readStudents() {
        String sql = "SELECT * FROM Student"; // Adjust this query to match your database schema.
        List<StudentModel> students = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                // Create a new StudentModel object
                StudentModel student = new StudentModel(
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL_ADDRESS"),
                        rs.getString("PASSWORD")
                );

                student.setId(rs.getInt("STUDENT_ID"));
                student.setNumberCoursesRegistered(rs.getInt("NUMBER_COURSES_REGISTERED"));
                student.setFullTime(rs.getBoolean("IS_FULL_TIME"));

                // Add the student to the list
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch students: " + e.getMessage());
        }

        return students;
    }

    // Read all Teachers
    public static List<TeacherModel> readTeachers() {
        String sql = "SELECT * FROM Teacher"; // Adjust this query to match your database schema.
        List<TeacherModel> teachers = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                // Create a TeacherModel object
                TeacherModel teacher = new TeacherModel(
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL_ADDRESS"),
                        rs.getString("PASSWORD"), // Assuming PASSWORD is a column in the database
                        new ArrayList<>() // Placeholder for coursesTeaching; you can populate this later
                );

                // Set additional fields if necessary
                teacher.setId(rs.getInt("TEACHER_ID")); // Assuming setId is inherited from PersonModel

                // Add the teacher to the list
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch teachers: " + e.getMessage());
        }

        return teachers;
    }


    // Read all Admins
    public static List<AdminModel> readAdmins() {
        String sql = "SELECT * FROM Admin"; // Adjust this query to match your database schema
        List<AdminModel> admins = new ArrayList<>();
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                // Create a new AdminModel instance
                AdminModel admin = new AdminModel();

                // Add the admin to the list
                admins.add(admin);
            }

            // Optionally update the RegistrationSystem's admin list
            registrationSystem.setAdminList(admins);
        } catch (SQLException e) {
            System.out.println("Failed to fetch admins: " + e.getMessage());
        }

        return admins;
    }
    // Read all Courses
    public static List<CourseModel> readCourses() {
        String sql = "SELECT * FROM Courses"; // Adjust to match your database schema
        List<CourseModel> courses = new ArrayList<>();
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                // Create a new CourseModel instance
                CourseModel course = new CourseModel(
                        rs.getString("COURSE_NUMBER"),    // Course number
                        rs.getInt("COURSE_SECTION"),     // Course section
                        rs.getInt("COURSE_CAPACITY"),    // Course capacity
                        rs.getInt("COURSE_CREDITS"),     // Course credits
                        rs.getInt("START_TIME"),         // Start time
                        rs.getInt("END_TIME"),           // End time
                        rs.getString("DAY_OF_WEEK")      // Day of the week
                );

                // Populate additional fields
                course.setCurrentEnrollementNumber(rs.getInt("CURRENT_ENROLLMENT"));

                // Add the course to the list
                courses.add(course);
            }

            // Optionally update the RegistrationSystem's course list
            registrationSystem.setCourseList(courses);
        } catch (SQLException e) {
            System.out.println("Failed to fetch courses: " + e.getMessage());
        }

        return courses;
    }

    // Read all Registered Records
    public static List<String> readRegistered() {
        String sql = "SELECT * FROM Registered";
        List<String> registrations = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                String registration = String.format("Student ID: %d, Course Number: %d",
                        rs.getInt("STUDENT_ID"),
                        rs.getInt("COURSE_NUMBER"));
                registrations.add(registration);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch registrations: " + e.getMessage());
        }

        return registrations;
    }
}
