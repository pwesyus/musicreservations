import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.LineBorder;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.border.LineBorder;


public class mrsettings implements designs {
		JFrame settingsFrame = new JFrame("Settings");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	public void settings(){
		 //SETTINGS

        char passwordEchoChar = '*';

        // LABELS
        JLabel Settingstitletext = new JLabel("MUSIC ROOM RESERVATION");
        Settingstitletext.setFont(title);

        JLabel settingsChangePassLbl = new JLabel("CHANGE PASSWORD SETTINGS");
        settingsChangePassLbl.setFont(addequip);

        JLabel settingsLblForCurrentPassword = new JLabel("ENTER CURRENT PASSWORD");
        settingsLblForCurrentPassword.setFont(list);
        JPasswordField setttingTxtCurrentPassword = new JPasswordField();
        setttingTxtCurrentPassword.setFont(list);
        setttingTxtCurrentPassword.setEchoChar(passwordEchoChar);

        JLabel settingsLblForNewPassword = new JLabel("ENTER NEW PASSWORD");
        settingsLblForNewPassword.setFont(list);
        JPasswordField setttingTxtNewPassword = new JPasswordField();
        setttingTxtNewPassword.setFont(list);
        setttingTxtNewPassword.setEchoChar(passwordEchoChar);

        JLabel settingsLblForConfirmPassword = new JLabel("ENTER CONFIRM PASSWORD");
        settingsLblForConfirmPassword.setFont(list);
        JPasswordField setttingTxtConfirmPassword = new JPasswordField();
        setttingTxtConfirmPassword.setFont(list);
        setttingTxtConfirmPassword.setEchoChar(passwordEchoChar);


		JCheckBox showpw = new JCheckBox("SHOW PASSWORD");
        showpw.setFont(list);
        showpw.setBackground(Color.WHITE);

        JLabel notmatchpw = new JLabel("New & Confirm Password do not match");
        notmatchpw.setFont(subtitle);
        notmatchpw.setBackground(Color.WHITE);
        notmatchpw.setVisible(false);

        JLabel matchpw = new JLabel("New & Confirm Password match");
        matchpw.setFont(subtitle);
        matchpw.setBackground(Color.WHITE);
        matchpw.setVisible(false);


        // BUTTONS

        JButton settingsSaveBtn = new JButton("SAVE");
        settingsSaveBtn.setFont(listbtn);
        settingsSaveBtn.setForeground(Color.WHITE);
        settingsSaveBtn.setBackground(cgreen);

        // dashboard buttons

        ImageIcon Settingsdashboardimg = new ImageIcon("../pictures/dashboard.png");
        JButton Settingsdashboardbtn = new JButton(Settingsdashboardimg);

        ImageIcon Settingsreservationimg = new ImageIcon("../pictures/reservation.png");
        JButton Settingsreservationbtn = new JButton(Settingsreservationimg);

        ImageIcon Settingsroomsimg = new ImageIcon("../pictures/rooms.png");
        JButton Settingsroomsbtn = new JButton(Settingsroomsimg);

        ImageIcon Settingequipmentsimg = new ImageIcon("../pictures/equipment.png");
        JButton Settingsequipmentsbtn = new JButton(Settingequipmentsimg);

        ImageIcon Settingssettingsimg = new ImageIcon("../pictures/settingsactive.png");
        JButton Settingssettingsbtn = new JButton(Settingssettingsimg);

        ImageIcon Settingslogoutimg = new ImageIcon("../pictures/logout.png");
        JButton Settingslogoutbtn = new JButton(Settingslogoutimg);

        showpw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Toggle visibility of password characters based on checkbox state
                if (showpw.isSelected()) {
                    setttingTxtCurrentPassword.setEchoChar((char) 0);
                    setttingTxtNewPassword.setEchoChar((char) 0);
                    setttingTxtConfirmPassword.setEchoChar((char) 0);
                } else {
                    setttingTxtCurrentPassword.setEchoChar(passwordEchoChar);
                    setttingTxtNewPassword.setEchoChar(passwordEchoChar);
                    setttingTxtConfirmPassword.setEchoChar(passwordEchoChar);
                }
            }
        });

		setttingTxtConfirmPassword.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent k) {
		        // Check if new and confirm passwords match (case-insensitive)
		        String newPassword = new String(setttingTxtNewPassword.getPassword());
		        String confirmPwd = new String(setttingTxtConfirmPassword.getPassword());

		        if (confirmPwd.equalsIgnoreCase(newPassword)) {
		            matchpw.setVisible(true);
		            notmatchpw.setVisible(false);
		        } else {
		            matchpw.setVisible(false);
		            notmatchpw.setVisible(true);
		        }
		    }
		});
		setttingTxtNewPassword.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent k) {
		        // Check if new and confirm passwords match (case-insensitive)
		        String newPassword = new String(setttingTxtNewPassword.getPassword());
		        String confirmPwd = new String(setttingTxtConfirmPassword.getPassword());

		        if (confirmPwd.equalsIgnoreCase(newPassword)) {
		            matchpw.setVisible(true);
		            notmatchpw.setVisible(false);
		        } else {
		            matchpw.setVisible(false);
		            notmatchpw.setVisible(true);
		        }
		    }
		});

		Settingslogoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });

		Settingsdashboardbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                mrdashboard dash = new mrdashboard();
        		dash.dashboard();

            }
        });

		Settingsreservationbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
        });
        Settingsroomsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                mrroom room = new mrroom();
        		room.rooms();

            }
        });

        Settingsequipmentsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();

            }
        });
        Settingssettingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	settingsFrame.setVisible(false);
                mrsettings setting = new mrsettings();
        		setting.settings();

            }
        });



        // SETTING BORDERS

        Settingsdashboardbtn.setBorder(new LineBorder(Color.BLACK, 3));
        Settingsreservationbtn.setBorder(new LineBorder(Color.BLACK, 3));
        Settingsroomsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        Settingsequipmentsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        Settingssettingsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        Settingslogoutbtn.setBorder(new LineBorder(Color.BLACK, 3));
        setttingTxtCurrentPassword.setBorder(new LineBorder(Color.BLACK, 1));
        setttingTxtNewPassword.setBorder(new LineBorder(Color.BLACK, 1));
        setttingTxtConfirmPassword.setBorder(new LineBorder(Color.BLACK, 1));

        // SETTING BOUNDS

        // labels bounds
        settingsChangePassLbl.setBounds(240, 10, 600, 200);
        settingsLblForCurrentPassword.setBounds(240, 20, 400, 300);
        settingsLblForNewPassword.setBounds(240, 100, 400, 300);
        settingsLblForConfirmPassword.setBounds(240, 190, 400, 300);

        // textbox bounds

        setttingTxtCurrentPassword.setBounds(240, 190, 550, 30);
        setttingTxtNewPassword.setBounds(240, 270, 550, 30);
        setttingTxtConfirmPassword.setBounds(240, 360, 550, 30);

        showpw.setBounds(240, 400, 250, 40);
        notmatchpw.setBounds(510, 400, 300, 40);
        matchpw.setBounds(510, 400, 300, 40);

        // dashboard btns
        Settingstitletext.setBounds(110, 0, 800, 70);
        Settingsdashboardbtn.setBounds(30, 86, 150, 65);
        Settingsreservationbtn.setBounds(30, 161, 150, 65);
        Settingsroomsbtn.setBounds(30, 236, 150, 65);
        Settingsequipmentsbtn.setBounds(30, 311, 150, 65);
        Settingssettingsbtn.setBounds(30, 386, 150, 65);
        Settingslogoutbtn.setBounds(30, 461, 150, 65);

        // SAVE BUTTON

        settingsSaveBtn.setBounds(350, 470, 300, 50);

        // ADDING COMPONENT

        // ADDING DASHBOARD COMPONENTS
        settingsFrame.add(Settingstitletext);
        settingsFrame.add(Settingsdashboardbtn);
        settingsFrame.add(Settingsreservationbtn);
        settingsFrame.add(Settingsroomsbtn);
        settingsFrame.add(Settingsequipmentsbtn);
        settingsFrame.add(Settingssettingsbtn);
        settingsFrame.add(Settingslogoutbtn);

        // ADDINGLABELS

        settingsFrame.add(settingsLblForCurrentPassword);
        settingsFrame.add(settingsLblForNewPassword);
        settingsFrame.add(settingsLblForConfirmPassword);
        settingsFrame.add(settingsChangePassLbl);
        settingsFrame.add(notmatchpw);
        settingsFrame.add(matchpw);


        // ADDING TEXTBOX
        settingsFrame.add(setttingTxtCurrentPassword);
        settingsFrame.add(setttingTxtNewPassword);
        settingsFrame.add(setttingTxtConfirmPassword);

		settingsFrame.add(showpw);


        // ADDING SAVE BTN

        settingsFrame.add(settingsSaveBtn);
		settingsFrame.getContentPane().setBackground(Color.WHITE);
        settingsFrame.setBounds(100, 50, 900, 600);
        settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);
	}
}