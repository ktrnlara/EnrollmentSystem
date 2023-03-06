import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class EnrollmentSystem extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JButton adminButton, studentButton, registerButton;
    private JPanel mainPanel;
    
    public EnrollmentSystem() {
        super("XYZ University Enrollment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set up GUI components
        titleLabel = new JLabel("Welcome to XYZ University Enrollment System");
        adminButton = new JButton("Admin/Faculty Module");
        studentButton = new JButton("Student Module");
        registerButton = new JButton("Registration Module 1");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(adminButton);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(studentButton);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(registerButton);
        mainPanel.add(Box.createVerticalGlue());
        add(mainPanel);
        
        // Add action listeners to buttons
        adminButton.addActionListener(this);
        studentButton.addActionListener(this);
        registerButton.addActionListener(this);
        
        // Set up window
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            AdminModule adminModule = new AdminModule();
            adminModule.showGUI();
        } else if (e.getSource() == studentButton) {
            StudentModule studentModule = new StudentModule();
            studentModule.showGUI();
        } else if (e.getSource() == registerButton) {
            RegistrationModule1 registrationModule1 = new RegistrationModule1();
            registrationModule1.showGUI();
        }
    }
    
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
    }
}

class AdminModule extends JFrame implements ActionListener {
    
    private JLabel titleLabel, courseCodeLabel, courseNameLabel, unitsLabel;
    private JTextField courseCodeField, courseNameField, unitsField;
    private JButton addButton, clearButton;
    private JPanel mainPanel, buttonPanel;
    
    public AdminModule() {
        super("Admin/Faculty Module");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Set up GUI components
        titleLabel = new JLabel("Admin/Faculty Module");
        courseCodeLabel = new JLabel("Course Code:");
        courseNameLabel = new JLabel("Course Name:");
        unitsLabel = new JLabel("Units:");
        courseCodeField = new JTextField(20);
        courseNameField = new JTextField(20);
        unitsField = new JTextField(20);
        addButton = new JButton("Add Course");
        clearButton = new JButton("Clear Fields");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(courseCodeLabel);
        mainPanel.add(courseCodeField);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(courseNameLabel);
        mainPanel.add(courseNameField);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(unitsLabel);
        mainPanel.add(unitsField);
        mainPanel.add(Box.createVerticalGlue());
        buttonPanel = new JPanel();
        buttonPanel.add(addButton);
       
