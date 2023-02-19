import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class User {
    private String name;
    private String password;
    private boolean isAdmin;
    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public String toString() {
        return name + "," + password + "," + isAdmin;
    }
}

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
        return code + "," + name + "," + units;
    }
}

class AdminModule extends JFrame implements ActionListener {
    private JTextField codeField, nameField, unitsField;
    private JButton addButton, saveButton;
    private JTextArea courseList;
    private ArrayList<Course> courses;
    public AdminModule() {
        courses = new ArrayList<Course>();
        setTitle("Admin Module");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Course Code:"));
        codeField = new JTextField();
        inputPanel.add(codeField);
        inputPanel.add(new JLabel("Course Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Units:"));
        unitsField = new JTextField();
        inputPanel.add(unitsField);
        c.add(inputPanel, BorderLayout.NORTH);
        addButton = new JButton("Add Course");
        addButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        saveButton = new JButton("Save Courses");
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);
        c.add(buttonPanel, BorderLayout.SOUTH);
        courseList = new JTextArea();
        c.add(new JScrollPane(courseList), BorderLayout.CENTER);
        loadCourses();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String code = codeField.getText();
            String name = nameField.getText();
            int units = Integer.parseInt(unitsField.getText());
            courses.add(new Course(code, name, units));
            codeField.setText("");
            nameField.setText("");
            unitsField.setText("");
            updateCourseList();
        } else if (e.getSource() == saveButton) {
            saveCourses();
        }
    }
    private void updateCourseList() {
        courseList.setText("");
        for (Course c : courses) {
            courseList.append(c.getCode() + " " + c.getName() + " (" + c.getUnits() + " units)\n");
        }
    }
    private void loadCourses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("courses.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String code =
