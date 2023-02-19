import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnrollmentSystem {
    public static void main(String[] args) {
        // EnrollmentGUI gui = new EnrollmentGUI();
        // gui.showLoginScreen();
    }
}

// User class for inheritance and polymorphism
class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

// Admin module
class Admin extends User {
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public void addCourse(String courseCode, String courseName, int creditHours) {
        try {
            File file = new File("courses.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(courseCode + "," + courseName + "," + creditHours + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while adding the course.");
        }
    }
}

// Student module
class Student extends User {
    private ArrayList<String> enrolledCourses = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public void enrollCourse(String courseCode) {
        try {
            File file = new File("enrollment.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(this.email + "," + courseCode + "\n");
            writer.close();
            enrolledCourses.add(courseCode);
            JOptionPane.showMessageDialog(null, "You have successfully enrolled in " + courseCode + ".");
        } catch (IOException e) {
            System.out.println("An error occurred while enrolling in the course.");
        }
    }
}

// Registration module
class Registration {
    public boolean registerUser(String firstName, String lastName, String email, String password, String userType) {
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email address.");
            return false;
        }
        try {
            File file = new File("users.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(firstName + "," + lastName + "," + email + "," + password + "," + userType + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "You have successfully registered.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while registering.");
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

// GUI
// class EnrollmentGUI implements ActionListener {
//     private JFrame loginFrame, adminFrame, studentFrame, registrationFrame;
//     private JLabel usernameLabel, passwordLabel, firstNameLabel, lastNameLabel, emailLabel, passwordRegLabel,
//             userTypeLabel, courseCodeLabel, courseNameLabel, credit
//     public void showLoginScreen() {
//     }
// }

