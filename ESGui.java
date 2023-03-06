package enrollmentsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class EnrollmentSystem extends JFrame implements ActionListener {

    // Constants
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    // UI components
    private JPanel loginPanel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    private JPanel studentPanel;
    private JList<Course> courseList;
    private JButton enrollButton;

    private JPanel adminPanel;
    private JList<Course> adminCourseList;
    private JButton addCourseButton;
    private JComboBox<Integer> creditHoursComboBox;
    private JTextField courseCodeField;
    private JTextField courseNameField;

    // Data
    private User currentUser;
    private ArrayList<Course> courses;

    public EnrollmentSystem() {
        super("Enrollment System");

        // Load data
        loadCourses();

        // Create the login panel
        titleLabel = new JLabel("Enrollment System");
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        usernameLabel = new JLabel("Email:");
        usernameField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        statusLabel = new JLabel(" ");

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);

        loginPanel.add(titleLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(buttonPanel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        loginPanel.add(statusLabel);

        // Create the student panel
        courseList = new JList<>(courses.toArray(new Course[courses.size()]));
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane courseListScrollPane = new JScrollPane(courseList);

        enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(this);

        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.PAGE_AXIS));
        studentPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel courseListPanel = new JPanel(new BorderLayout());
        courseListPanel.add(new JLabel("Available Courses:"
