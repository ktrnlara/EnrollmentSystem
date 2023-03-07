
/* topic 10 kay kat

*/

package enrollmentsystemten;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;


public class AdminFrame extends JFrame implements ActionListener {
    
    private Derbyconnection derby;
    private Connection = null;
    private Statement = null;
    
    public actionFrame(){
        try{
            connectToUU)();
            javax.swing.SwingUtilities.invokeLater(Runnable (){
            
            public void run ();
                create GUI (500,500);
                addComponents();
            
        });
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createGUI (int width, int height){

        this.setTitle ("Login Admin");
        this.setResizeable (false);
        this.setSize (width,height);
        this.setLocationRelativeTo (null);
        this.setDefaultCloseOperation();
        this.setVisible(true);
    }
     
                
    private void connectToUU()throws Exception {
    
        String driver1 = UUInfo.driver1;
        String driver2 = UUInfo.driver2;
        String url = UUInfo.url;
        String user = UUInfo.user;
        String pass = UUInfo.pass;
        derby = new DerbyConnection ();
        conn = derby.connect (driver1,driver2,url,user,pass);
        stat = conn.createStatement();
    }
    
    private void createGUI (int width, int height){
    
        this.setTitle("Login Administrator User");
        this.setResizeable(false);
        this.setSize (width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation();
        this.setVisible (true);
    }
    
    JTextfield user;
    JPasswordField pass;
    
    private void addComponents (){
        JPanel mainpanel = new JPanel (new BorderLayout());
//--------------------------------------------------------breaker panel
        JPanel hp = new JPanel ();
        JLabel label1 = new JLabel ("La Conserio High School");
        label1.setFont (new font("Consolas", Font.BOLD, I2));
        label1.setbackground(Color.WHITE);
        hp.setbackground (Color.red);
        hp.add(label1);
    }
//--------------------------------------------------------center panel
        JPanel center = bew JPanel();
        centerP.setLayout(null);
        JLabel label7 = new JLabel("ADMINISTRATOR");
        label2.setFond(new font ("Times New Roman", Font.BOLD,20 ));
        label2.setBounds(130,10,250,30);
        centerP.add(label2);
//-----------------------------------------------commponents of center panel
        
        JLabel lblUname = new JLabel ("username: ");
        lblUname.setBounds(10,30,150,100);
        lblUname.setFont (new font ("Times New Roman", Font.BOLD,20));
        centerP.add(lblUname);

        JLabel lblPword = new JLabel ("password: ");
        lblPword.setBounds(10,30,150,100);
        lblPword.setFont (new font ("Times New Roman", Font.BOLD,20));
        centerP.add(lblPword);

        user = new JTextField();
        user.setBounds(140,75,250,25);
        centerP.add(user);
        
        pass = pass JPasswordField();
        user.setBounds(160,105,250,25);
        centerP.add(pass);
        
        JButton btnLogin = new JButton ("LOGIN");
        btnLogin.setFont ("Consolas", Font.BOLD,20));
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground (Color.red);
        btnLogin.setBounds(125,175,250,30);
        btnLogin.addActionListener (this);
        centerP.add(btnLogin);

        JButton btnBack = new JButton ("BACK");
        btnBack.setFont ("Consolas", Font.BOLD,20));
        btnBack.setForeground(Color.white);
        btnBack.setBackground (Color.red);
        btnBack.setBounds(125,210,250,30);
        btnBack.addActionListener (this);
        centerP.add(btnBack);

//-------------------------------------------add all panels together
        mainpanel.add(hp, BorderLayout.PAGE_START);
        mainpanel.add(centerP, BorderLayout.CENTER);
        this.add(mainpanel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
            
        String ac - ac.getActionCommand();
        switch (ac){
            case "LOGIN";
                this.dispose();
                String uname = uname.getText();
                String pword = pword.getText(); // hindi ko ma strikethrough kasi naka red pa
                login(uname,pword);
            
            case "BACK";
                this.dispose();
                new MainEnrollment();

        }

    }
    // all the algorithms for logging in will be placed in the logic method
    private void login (String ACCOUNTUSER, String ACCOUNTOASS){
        String aq1 = "HINDI KO MAINTINDIHAN NAKALGAY DITO" + " ' " 
                + ACCOUNTUSER + "AND ACCOUNTPASS LIKE " + ACCOUNTPASS+"";

        ResultSet rs;
        try {
            rs=derby.executeQuezy(atmm, aq1);
            if (rs.next()){
                String mag = "Login Sucsess";
                JOptionPane,showMessageDialog(null, mag);
                this.dispose();
                new AdminLogin();
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}    
