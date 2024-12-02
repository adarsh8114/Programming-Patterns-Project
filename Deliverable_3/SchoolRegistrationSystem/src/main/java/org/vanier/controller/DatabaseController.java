package org.vanier.controller;

import org.vanier.factory.CourseFactory;
import org.vanier.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DatabaseController {
    private static final String DB_URL = "jdbc:sqlite:./SchoolRegistrationSystem/src/main/resources/database/data.db";
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
                        COURSE_START_TIME TEXT,
                        COURSE_END_TIME TEXT,
                        COURSE_DAY_OF_WEEK TEXT,
                        LOCATION TEXT,
                        TEACHER_ID INTEGER,
                        FOREIGN KEY (TEACHER_ID) REFERENCES Teacher(TEACHER_ID)
                    )
                """;

        String createRegisteredSQL = """
                    CREATE TABLE IF NOT EXISTS Registered (
                        STUDENT_ID INTEGER,
                        COURSE_ID INTEGER,
                        PRIMARY KEY (STUDENT_ID, COURSE_ID),
                        FOREIGN KEY (STUDENT_ID) REFERENCES Student(STUDENT_ID),
                        FOREIGN KEY (COURSE_ID) REFERENCES Course(COURSE_ID)
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

    public static void deleteTables() {
        String deleteRegisteredSQL = "DROP TABLE IF EXISTS Registered";
        String deleteCourseSQL = "DROP TABLE IF EXISTS Course";
        String deleteAdminSQL = "DROP TABLE IF EXISTS Admin";
        String deleteTeacherSQL = "DROP TABLE IF EXISTS Teacher";
        String deleteStudentSQL = "DROP TABLE IF EXISTS Student";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Drop each table
            statement.execute(deleteRegisteredSQL);
            System.out.println("Registered Table Deleted!");

            statement.execute(deleteCourseSQL);
            System.out.println("Course Table Deleted!");

            statement.execute(deleteAdminSQL);
            System.out.println("Admin Table Deleted!");

            statement.execute(deleteTeacherSQL);
            System.out.println("Teacher Table Deleted!");

            statement.execute(deleteStudentSQL);
            System.out.println("Student Table Deleted!");
        } catch (SQLException e) {
            System.out.println("Error while deleting tables: " + e.getMessage());
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
    public static void addCourse(int courseId, int courseNumber, String type, int section, int capacity, int currentEnrollment,
                                 int credits, String startTime, String endTime, String dayOfWeek,
                                 String location, int teacherId) {
        String sql = """
                INSERT INTO Course (
                    COURSE_ID, COURSE_NUMBER, COURSE_TYPE, COURSE_SECTION, COURSE_CAPACITY, 
                    CURRENT_ENROLLMENT_NUMBER, COURSE_CREDITS, COURSE_START_TIME, COURSE_END_TIME, 
                    COURSE_DAY_OF_WEEK, LOCATION, TEACHER_ID)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Map each parameter to the corresponding column
            preparedStatement.setInt(1, courseId);         // COURSE_ID
            preparedStatement.setInt(2, courseNumber);     // COURSE_NUMBER
            preparedStatement.setString(3, type);         // COURSE_TYPE
            preparedStatement.setInt(4, section);         // COURSE_SECTION
            preparedStatement.setInt(5, capacity);        // COURSE_CAPACITY
            preparedStatement.setInt(6, currentEnrollment); // CURRENT_ENROLLMENT_NUMBER
            preparedStatement.setInt(7, credits);         // COURSE_CREDITS
            preparedStatement.setString(8, startTime);    // COURSE_START_TIME
            preparedStatement.setString(9, endTime);      // COURSE_END_TIME
            preparedStatement.setString(10, dayOfWeek);   // COURSE_DAY_OF_WEEK
            preparedStatement.setString(11, location);    // LOCATION
            preparedStatement.setInt(12, teacherId);      // TEACHER_ID

            // Execute the query
            preparedStatement.executeUpdate();
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Register Student to a Course
    public static void registerStudentToCourse(int studentId, int courseID) {
        String sql = """
                    INSERT INTO Registered (STUDENT_ID, COURSE_ID)
                    VALUES (?, ?)
                """;

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseID);
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
    public static void deleteCourse(int courseID) {
        String sql = "DELETE FROM Course WHERE COURSE_ID = ?";

        WRITE_LOCK.lock();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, courseID);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("No course found with number: " + courseID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    // Remove a Student from the Registered Table
    public static void removeStudentFromRegistered(int studentId, int courseNumber) {
        String sql = "DELETE FROM Registered WHERE STUDENT_ID = ? AND COURSE_ID = ?";

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
        String query = """
            SELECT students.STUDENT_ID, students.FIRST_NAME, students.LAST_NAME, students.PHONE_NUMBER, 
                   students.EMAIL_ADDRESS, students.PASSWORD, students.NUMBER_COURSES_REGISTERED, students.IS_FULL_TIME,
                   courses.COURSE_ID, courses.COURSE_NUMBER, courses.COURSE_TYPE, courses.COURSE_SECTION,
                   courses.COURSE_CAPACITY, courses.CURRENT_ENROLLMENT_NUMBER, courses.COURSE_CREDITS,
                   courses.COURSE_START_TIME, courses.COURSE_END_TIME, courses.COURSE_DAY_OF_WEEK,
                   courses.ONLINE_LOCATION
            FROM Student students
            JOIN Registered registered ON students.STUDENT_ID = registered.STUDENT_ID
            JOIN Course courses ON registered.COURSE_NUMBER = courses.COURSE_NUMBER
            """;
        READ_LOCK.lock();
        List<StudentModel> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                int studentId = rs.getInt("STUDENT_ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String phoneNumber = rs.getString("PHONE_NUMBER");
                String emailAddress = rs.getString("EMAIL_ADDRESS");
                String password = rs.getString("PASSWORD");
                int numberCoursesRegistered = rs.getInt("NUMBER_COURSES_REGISTERED");
                boolean isFullTime = rs.getBoolean("IS_FULL_TIME");

                StudentModel student = null;
                for (StudentModel s : studentList) {
                    if (s.getId() == studentId) {
                        student = s;
                        break;
                    }
                }

                if (student == null) {
                    student = new StudentModel(firstName, lastName, phoneNumber, emailAddress, password);
                    student.setId(studentId);
                    student.setNumberCoursesRegistered(numberCoursesRegistered);
                    student.setFullTime(isFullTime);
                    studentList.add(student);
                }

                int courseId = rs.getInt("COURSE_ID");
                int courseNumber = rs.getInt("COURSE_NUMBER");
                String courseType = rs.getString("COURSE_TYPE");
                int courseSection = rs.getInt("COURSE_SECTION");
                int courseCapacity = rs.getInt("COURSE_CAPACITY");
                int courseCredits = rs.getInt("COURSE_CREDITS");
                int startTime = rs.getInt("COURSE_START_TIME");
                int endTime = rs.getInt("COURSE_END_TIME");
                String dayOfWeek = rs.getString("COURSE_DAY_OF_WEEK");
                String location = rs.getString("ONLINE_LOCATION");

                CourseModel course = CourseFactory.createCourse(
                        courseType, String.valueOf(courseNumber), courseSection, courseCapacity,
                        courseCredits, startTime, endTime, dayOfWeek, location
                );
                course.setCourseId(courseId);
                student.getRegisteredCourses().add(course);
            }
        } catch (SQLException e) {
            System.out.println("Error listing all students with courses: " + e.getMessage());
        } finally {
            READ_LOCK.unlock();
        }
        return studentList;
    }

    // Read all Teachers
    public static List<TeacherModel> readTeachers() {
        String query = """
            SELECT 
                t.TEACHER_ID, t.FIRST_NAME, t.LAST_NAME, t.PHONE_NUMBER, 
                t.EMAIL_ADDRESS, t.PASSWORD, 
                c.COURSE_ID, c.COURSE_NUMBER, c.COURSE_TYPE, c.COURSE_SECTION, 
                c.COURSE_CAPACITY, c.CURRENT_ENROLLMENT_NUMBER, c.COURSE_CREDITS, 
                c.COURSE_START_TIME, c.COURSE_END_TIME, c.COURSE_DAY_OF_WEEK, 
                c.LOCATION
            FROM Teacher t
            LEFT JOIN Course c ON t.TEACHER_ID = c.TEACHER_ID
            """;
        READ_LOCK.lock();
        Map<Integer, TeacherModel> teacherMap = new HashMap<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                // Fetch teacher information
                int teacherId = rs.getInt("TEACHER_ID");
                String teacherFirstName = rs.getString("FIRST_NAME");
                String teacherLastName = rs.getString("LAST_NAME");
                String teacherPhone = rs.getString("PHONE_NUMBER");
                String teacherEmail = rs.getString("EMAIL_ADDRESS");
                String teacherPassword = rs.getString("PASSWORD");

                // Check if the teacher already exists in the map
                TeacherModel teacher = teacherMap.get(teacherId);
                if (teacher == null) {
                    // Create a new TeacherModel if not already in the map
                    teacher = new TeacherModel(teacherFirstName, teacherLastName, teacherPhone, teacherEmail, teacherPassword, new ArrayList<CourseModel>());
                    teacher.setId(teacherId);
                    teacherMap.put(teacherId, teacher);
                }

                // Fetch course information, if available
                int courseId = rs.getInt("COURSE_ID");
                if (courseId > 0) { // Check if the course data exists
                    String courseNumber = rs.getString("COURSE_NUMBER");
                    String courseType = rs.getString("COURSE_TYPE");
                    int section = rs.getInt("COURSE_SECTION");
                    int capacity = rs.getInt("COURSE_CAPACITY");
                    int currentEnrollment = rs.getInt("CURRENT_ENROLLMENT_NUMBER");
                    int credits = rs.getInt("COURSE_CREDITS");
                    int startTime = rs.getInt("COURSE_START_TIME");
                    int endTime = rs.getInt("COURSE_END_TIME");
                    String dayOfWeek = rs.getString("COURSE_DAY_OF_WEEK");
                    String location = rs.getString("LOCATION");

                    // Create a CourseModel for the course
                    CourseModel course = CourseFactory.createCourse(
                            courseType, String.valueOf(courseNumber), section, capacity,
                            credits, startTime, endTime, dayOfWeek, location
                    );
                    course.setCourseId(courseId);
                    course.setCourseTeacher(teacher);

                    // Add the course to the teacher's list of coursesTeaching
                    teacher.getCoursesTeaching().add(course);
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to fetch teachers and their courses: " + e.getMessage());
        } finally {
            READ_LOCK.unlock();
        }

        return new ArrayList<>(teacherMap.values());
    }

    // Read all Admins
    public static List<AdminModel> readAdmins() {
        String sql = "SELECT * FROM Admin"; // Adjust this query to match your database schema
        READ_LOCK.lock();
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
        } finally {
            READ_LOCK.unlock();
        }

        return admins;
    }

    // Read all Courses
    public static List<CourseModel> readCourses() {
        String query = """
            SELECT 
                c.COURSE_ID, c.COURSE_NUMBER, c.COURSE_TYPE, c.COURSE_SECTION, 
                c.COURSE_CAPACITY, c.CURRENT_ENROLLMENT_NUMBER, c.COURSE_CREDITS, 
                c.COURSE_START_TIME, c.COURSE_END_TIME, c.COURSE_DAY_OF_WEEK, 
                c.LOCATION, 
                t.TEACHER_ID, t.FIRST_NAME AS TEACHER_FIRST_NAME, t.LAST_NAME AS TEACHER_LAST_NAME, 
                t.PHONE_NUMBER AS TEACHER_PHONE, t.EMAIL_ADDRESS AS TEACHER_EMAIL, t.PASSWORD AS TEACHER_PASSWORD,
                s.STUDENT_ID, s.FIRST_NAME AS STUDENT_FIRST_NAME, s.LAST_NAME AS STUDENT_LAST_NAME, 
                s.PHONE_NUMBER AS STUDENT_PHONE, s.EMAIL_ADDRESS AS STUDENT_EMAIL, s.PASSWORD AS STUDENT_PASSWORD,
                s.NUMBER_COURSES_REGISTERED, s.IS_FULL_TIME
            FROM Course c
            LEFT JOIN Teacher t ON c.TEACHER_ID = t.TEACHER_ID
            LEFT JOIN Registered r ON c.COURSE_ID = r.COURSE_ID
            LEFT JOIN Student s ON r.STUDENT_ID = s.STUDENT_ID
            """;
        READ_LOCK.lock();
        Map<Integer, CourseModel> courseMap = new HashMap<>(); // To store courses by their COURSE_ID
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Fetch course information
                int courseId = resultSet.getInt("COURSE_ID");
                String courseNumber = resultSet.getString("COURSE_NUMBER");
                String courseType = resultSet.getString("COURSE_TYPE");
                int section = resultSet.getInt("COURSE_SECTION");
                int capacity = resultSet.getInt("COURSE_CAPACITY");
                int currentEnrollment = resultSet.getInt("CURRENT_ENROLLMENT_NUMBER");
                int credits = resultSet.getInt("COURSE_CREDITS");
                int startTime = resultSet.getInt("COURSE_START_TIME");
                int endTime = resultSet.getInt("COURSE_END_TIME");
                String dayOfWeek = resultSet.getString("COURSE_DAY_OF_WEEK");
                String location = resultSet.getString("LOCATION");

                // Fetch teacher information
                int teacherId = resultSet.getInt("TEACHER_ID");
                String teacherFirstName = resultSet.getString("TEACHER_FIRST_NAME");
                String teacherLastName = resultSet.getString("TEACHER_LAST_NAME");
                String teacherPhone = resultSet.getString("TEACHER_PHONE");
                String teacherEmail = resultSet.getString("TEACHER_EMAIL");
                String teacherPassword = resultSet.getString("TEACHER_PASSWORD");

                // Fetch student information
                int studentId = resultSet.getInt("STUDENT_ID");
                String studentFirstName = resultSet.getString("STUDENT_FIRST_NAME");
                String studentLastName = resultSet.getString("STUDENT_LAST_NAME");
                String studentPhone = resultSet.getString("STUDENT_PHONE");
                String studentEmail = resultSet.getString("STUDENT_EMAIL");
                String studentPassword = resultSet.getString("STUDENT_PASSWORD");
                int numberCoursesRegistered = resultSet.getInt("NUMBER_COURSES_REGISTERED");
                int isFullTime = resultSet.getInt("IS_FULL_TIME");

                // Check if the course already exists in the map
                CourseModel course = courseMap.get(courseId);
                if (course == null) {
                    TeacherModel teacher = null;
                    if (teacherId > 0) { // Check if a teacher is associated
                        teacher = new TeacherModel(teacherFirstName, teacherLastName, teacherPhone, teacherEmail, teacherPassword, new ArrayList<CourseModel>());
                        teacher.setId(teacherId);
                    }

                    course = CourseFactory.createCourse(
                            courseType, String.valueOf(courseNumber), section, capacity,
                            credits, startTime, endTime, dayOfWeek, location
                    );
                    course.setCourseId(courseId);
                    courseMap.put(courseId, course);
                }

                // Add the student to the course's list of students
                if (studentId > 0) { // Check if a student is associated
                    StudentModel student = new StudentModel(studentFirstName, studentLastName, studentPhone, studentEmail, studentPassword);
                    student.setId(studentId);
                    course.getEnrolledStudents().add(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching courses: " + e.getMessage());
        } finally {
            READ_LOCK.unlock();
        }
        return new ArrayList<>(courseMap.values());
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


    public static void initSystem() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        registrationSystem.setAdminList(readAdmins());
        registrationSystem.setCourseList(readCourses());
        registrationSystem.setStudentList(readStudents());
        registrationSystem.setTeacherList(readTeachers());
    }

}
