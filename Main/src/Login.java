
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.table.*;
import java.sql.*;
import java.io.IOException;

public class Login implements designs {
    JFrame login = new JFrame("Login");
    JTextField usernametf = new JTextField();
    JPasswordField passwordtf = new JPasswordField();
    JCheckBox showPasswordCheckbox = new JCheckBox("Show Password");
    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
    public static String usernamedb = "root";
    public static String passworddb = "";

    public void logins() {
        try {
            BufferedImage img = ImageIO.read(new File("C:/Users/Admin/Desktop/MusicReservation/Main/pictures/bg.png"));
            Image scaledImg = img.getScaledInstance(895, 570, Image.SCALE_SMOOTH);
            ImageIcon backgroundImage = new ImageIcon(scaledImg);
            JLabel backgroundLabel = new JLabel(backgroundImage);
            backgroundLabel.setBounds(0, 0, 900, 600);
            login.setContentPane(backgroundLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ADD COMPONENTS
        JLabel loginmusicroom = new JLabel("MUSIC ROOM");
        loginmusicroom.setFont(title);

        JLabel loginreservation = new JLabel("RESERVATION");
        loginreservation.setFont(title);

        JLabel loginreservenow = new JLabel("RESERVE YOUR ROOM NOW!");
        loginreservenow.setFont(subtitle);

        JLabel logintitle = new JLabel("LOGIN");
        logintitle.setFont(title);
        logintitle.setForeground(Color.WHITE);

        JLabel username = new JLabel("USERNAME");
        username.setFont(userpass);

        usernametf.setFont(subtitle);

        JLabel password = new JLabel("PASSWORD");
        password.setFont(userpass);
        passwordtf.setFont(subtitle);

        showPasswordCheckbox.setFont(subtitle);
        showPasswordCheckbox.setForeground(Color.BLACK);
        showPasswordCheckbox.setOpaque(false); // Set content area filled to false
        showPasswordCheckbox.setFocusable(false); // Set focusable to false
        showPasswordCheckbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    passwordtf.setEchoChar((char) 0); // Show the password
                } else {
                    passwordtf.setEchoChar('*'); // Hide the password
                }
            }
        });

        JButton loginbtn = new JButton("LOGIN");
        loginbtn.setFont(logbut);
        loginbtn.setBackground(Brown);
        loginbtn.setForeground(Color.WHITE);

        JButton loginbox = new JButton();
        loginbox.setBackground(Brown);
        loginbox.setEnabled(false);

        JButton loginbox1 = new JButton();
        loginbox1.setBackground(Color.WHITE);
        loginbox1.setEnabled(false);

        // actions
        loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameinput = usernametf.getText();
                String passwordinput = passwordtf.getText();

                checkunpw(usernameinput, passwordinput);
            }

        });

        // borders
        usernametf.setBorder(new LineBorder(Color.BLACK, 2));
        passwordtf.setBorder(new LineBorder(Color.BLACK, 2));
        loginbox.setBorder(new LineBorder(Color.BLACK, 2));
        loginbox1.setBorder(new LineBorder(Color.BLACK, 2));

        login.add(loginmusicroom);
        login.add(loginreservation);
        login.add(loginreservenow);
        login.add(logintitle);
        login.add(username);
        login.add(usernametf);
        login.add(password);
        login.add(passwordtf);
        login.add(showPasswordCheckbox);
        login.add(loginbtn);
        login.add(loginbox1);
        login.add(loginbox);

        // SETBOUNDS
        loginmusicroom.setBounds(65, -10, 500, 100);
        loginreservation.setBounds(60, 45, 500, 100);
        loginreservenow.setBounds(120, 105, 200, 50);
        logintitle.setBounds(570, 70, 200, 50);
        username.setBounds(485, 170, 200, 50);
        usernametf.setBounds(485, 215, 310, 30);
        password.setBounds(485, 275, 200, 50);
        passwordtf.setBounds(485, 320, 310, 30);
        loginbtn.setBounds(510, 410, 250, 50);
        loginbox1.setBounds(450, 145, 380, 350);
        loginbox.setBounds(450, 45, 380, 450);
        showPasswordCheckbox.setBounds(485, 355, 200, 30);

        login.setLayout(null);
        login.setBounds(225, 70, 900, 600);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }

    public void checkunpw(String usernameinput, String passwordinput){
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
	            Statement statement = connection.createStatement();

	            // Query to retrieve username, password, and access from the database based on input
	            String query = "SELECT username, password, access FROM login WHERE username = '" + usernameinput + "' AND password = '" + passwordinput + "'";
	            ResultSet resultSet = statement.executeQuery(query);

	            if (resultSet.next()) {
	                String dbAccess = resultSet.getString("access");

	                if ("admin".equals(dbAccess)) {
	                	JOptionPane.showMessageDialog(null, "WELCOME TO MUSIC ROOM RESERVATION", "Login successfully!", JOptionPane.INFORMATION_MESSAGE);
	                	mrdashboard dash = new mrdashboard();
        				dash.dashboard();
	                    login.setVisible(false);
	                } else if ("client".equals(dbAccess)) {
	                	JOptionPane.showMessageDialog(null, "WELCOME TO MUSIC ROOM RESERVATION", "Login successfully!", JOptionPane.INFORMATION_MESSAGE);
	                    login.setVisible(false);
	                    csdashboard csdash = new csdashboard();
        				csdash.clientdashboard();
	                }

	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid credentials", JOptionPane.ERROR_MESSAGE);
	            }

	            connection.close();
	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
	    }
}
