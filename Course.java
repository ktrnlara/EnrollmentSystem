import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

// Course class
class Course {
    private String code;
    private String name;
    private int units;

    public Course(String code, String name, int units) {
        this.code = code;
        this.name = name;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    public String toString() {
        return code + " - " + name + " (" + units + " units)";
    }
}

// User class
class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

// EnrollmentSystem class
class EnrollmentSystem extends JFrame {
    private JTabbedPane tabbedPane;
    private JList<Course> courseList;
    private JButton enrollButton;

    private JList<Course> adminCourseList;
    private JButton addCourseButton;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JLabel statusLabel;

    private User currentUser;

    private File courseFile;
    private File userFile;

    public EnrollmentSystem() {
        super("Enrollment System");

        // Create the course list
        courseList = new JList<>();
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane courseListScrollPane = new JScrollPane(courseList);

        // Create the enroll button
        enrollButton = new JButton("Enroll");
        enrollButton.setEnabled(false);

        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enroll();
            }
        });
    }

        // Create the student panel
        JPanel studentPanel = new JPanel(new BorderLayout());

        studentPanel.add(courseListScrollPane, BorderLayout.CENTER);
        studentPanel.add(enrollButton, BorderLayout.SOUTH);

        // Create the admin course list
        adminCourseList = new JList<>();
        adminCourseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane adminCourseListScrollPane = new JScrollPane(adminCourseList);

        // Create the add course button
        addCourseButton = new JButton("Add Course");

        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCourse();
            }
        });

        // Create the admin panel
        JPanel adminPanel = new JPanel(new BorderLayout());

        adminPanel.add(adminCourseListScrollPane, BorderLayout.CENTER);
        adminPanel.add(addCourseButton, BorderLayout.SOUTH);

        // Create the login panel
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login

