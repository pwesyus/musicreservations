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
import javax.swing.event.*;

import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.components.DatePicker.*;


public class csaddreservation implements designs {
	    JFrame clientaddreservation = new JFrame("Add Client Reservation");
	    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
	    private JTextField clientfulltf;
		private JTextField clientaddresstf;
		private JTextField clientcontactnumtf;
		private JComboBox clientroomtypecb;
		private DatePicker clientdatereservationtf;
		private JComboBox clientstarttimetf;
		private JComboBox clientendtimetf;
		private JTextField clientstatustf;
		private JTextField clientpaxtf;
		private JTextField clientaddpaxtf;
		private JTextField clientaddontotaltf;
		private JTextField clientdownpaymenttf;
		private JTextField clienttotaltf;
		private JTextField clientgrandtotaltf;
		private JCheckBox clientdrums;
		private JCheckBox clientflute;
		private JCheckBox clientpiano;
		private JCheckBox clientacoustic;
		private JCheckBox clientelectric;
		private JCheckBox clientampli;
		private JCheckBox clientmic;
		private JCheckBox clientstand;
		private JCheckBox clientheadphone;
		private JCheckBox clientmicstand;

		public int addontotal = 0;

	    public void clientreservation(){
	    	JLabel clienttitletextaddreserve = new JLabel("MUSIC ROOM RESERVATION");
        clienttitletextaddreserve.setFont(title);

        JButton clientaddback = new JButton("BACK");
		clientaddback.setBackground(cred);
		clientaddback.setFont(listbtn);
        clientaddback.setForeground(Color.WHITE);

        //declare component
        JLabel clientfullname = new JLabel("FULL NAME *");
        clientfullname.setFont(subtitle);
        clientfulltf = new JTextField();
        clientfulltf.setFont(subtitle);

        JLabel clientaddress = new JLabel("ADDRESS *");
        clientaddress.setFont(subtitle);
        clientaddresstf = new JTextField();
        clientaddresstf.setFont(subtitle);

        JLabel clientcontactnum = new JLabel("CONTACT NUMBER *");
        clientcontactnum.setFont(subtitle);
        clientcontactnumtf = new JTextField();
        clientcontactnumtf.setFont(subtitle);

        JLabel clientroomtype = new JLabel("TYPE OF ROOM *");
        clientroomtype.setFont(subtitle);
        String clientroomtypearr [] = {"MUSIC ROOM 1", "MUSIC ROOM 2", "MUSIC ROOM 3", "RECORDING ROOM 1", "RECORDING ROOM 2", "DELUXE ROOM 1","DELUXE ROOM 2"};
        clientroomtypecb = new JComboBox(clientroomtypearr);
        clientroomtypecb.setFont(subtitle);
        clientroomtypecb.setBackground(Color.WHITE);

        JLabel clientdatereservation = new JLabel("DATE OF RESERVATION *");
        clientdatereservation.setFont(subtitle);
        clientdatereservationtf = new DatePicker();
        clientdatereservationtf.setFont(subtitle);

        JLabel clientstarttime = new JLabel("START TIME OF RESERVATION *");
        clientstarttime.setFont(subtitle);
        String clientstarttimearr [] = {"10:01 AM", "11:01 AM", "12:01 PM", "01:01 PM", "02:01 PM", "03:01 PM", "04:01 PM", "05:01 PM"};
        clientstarttimetf = new JComboBox(clientstarttimearr);
        clientstarttimetf.setFont(subtitle);
        clientstarttimetf.setBackground(Color.WHITE);

        JLabel clientendtime = new JLabel("END TIME TIME OF RESERVATION *");
        clientendtime.setFont(subtitle);
        String clientendtimearr [] = {"11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM"};
        clientendtimetf = new JComboBox(clientendtimearr);
        clientendtimetf.setFont(subtitle);
        clientendtimetf.setBackground(Color.WHITE);

        JLabel clientstatus = new JLabel("STATUS");
        clientstatus.setFont(subtitle);
        clientstatustf = new JTextField("WAITING");
        clientstatustf.setFont(subtitle);
        clientstatustf.setBackground(lightgray);
        clientstatustf.setForeground(Color.BLACK);
        clientstatustf.setDisabledTextColor(Color.BLACK);
        clientstatustf.setEnabled(false);

        JLabel clientpax = new JLabel("PAX");
        clientpax.setFont(subtitle);
        clientpaxtf = new JTextField(" MAX NUMBER OF PERSON");
        clientpaxtf.setFont(subtitle);
        clientpaxtf.setBackground(lightgray);
        clientpaxtf.setForeground(Color.BLACK);
        clientpaxtf.setDisabledTextColor(Color.BLACK);
        clientpaxtf.setEnabled(false);

        JLabel clientaddpax = new JLabel("ADDITIONAL PAX *");
        clientaddpax.setFont(subtitle);
        clientaddpaxtf = new JTextField();
        clientaddpaxtf.setFont(subtitle);

        JCheckBox clienttermsagreementcb = new JCheckBox("I ACCEPT THE TERMS AND AGREEMENT");
        clienttermsagreementcb.setFont(subtitle);
        clienttermsagreementcb.setBackground(Color.WHITE);

        JLabel clientviewterms = new JLabel("CLICK HERE TO VIEW THE TERMS AND AGREEMENT");
        clientviewterms.setFont(terms);
		clientviewterms.setForeground(Color.BLUE);

		JLabel clientaddontotal = new JLabel("ADD-ON TOTAL");
        clientaddontotal.setFont(subtitle);
        clientaddontotaltf = new JTextField();
        clientaddontotaltf.setFont(subtitle);
        clientaddontotaltf.setBackground(lightgray);
        clientaddontotaltf.setForeground(Color.BLACK);
        clientaddontotaltf.setDisabledTextColor(Color.BLACK);
        clientaddontotaltf.setEnabled(false);

        clientdrums = new JCheckBox("DRUMS");
        clientdrums.setFont(subtitle);
        clientdrums.setBackground(Color.WHITE);

        clientflute = new JCheckBox("FLUTE");
        clientflute.setFont(subtitle);
        clientflute.setBackground(Color.WHITE);

        clientpiano = new JCheckBox("PIANO");
        clientpiano.setFont(subtitle);
        clientpiano.setBackground(Color.WHITE);

        clientacoustic = new JCheckBox("ACOUSTIC GUITAR");
        clientacoustic.setFont(subtitle);
        clientacoustic.setBackground(Color.WHITE);

        clientelectric = new JCheckBox("ELECTRIC GUITAR");
        clientelectric.setFont(subtitle);
        clientelectric.setBackground(Color.WHITE);

        clientampli = new JCheckBox("AMPLIFIER");
        clientampli.setFont(subtitle);
        clientampli.setBackground(Color.WHITE);

        clientmic = new JCheckBox("MICROPHONE");
        clientmic.setFont(subtitle);
        clientmic.setBackground(Color.WHITE);

        clientstand = new JCheckBox("MUSIC STAND");
        clientstand.setFont(subtitle);
        clientstand.setBackground(Color.WHITE);

        clientheadphone = new JCheckBox("HEADPHONE");
        clientheadphone.setFont(subtitle);
        clientheadphone.setBackground(Color.WHITE);

        clientmicstand = new JCheckBox("MIC STAND");
        clientmicstand.setFont(subtitle);
        clientmicstand.setBackground(Color.WHITE);

       	JButton clientaddonsbox = new JButton();
		clientaddonsbox.setBackground(Color.WHITE);
		clientaddonsbox.setEnabled(false);

		JLabel clientdownpayment = new JLabel("DOWN PAYMENT");
        clientdownpayment.setFont(subtitle);
        clientdownpaymenttf = new JTextField();
        clientdownpaymenttf.setFont(subtitle);
        clientdownpaymenttf.setBackground(lightgray);
        clientdownpaymenttf.setForeground(Color.BLACK);
        clientdownpaymenttf.setDisabledTextColor(Color.BLACK);
        clientdownpaymenttf.setEnabled(false);

        JLabel clienttotal = new JLabel("TOTAL");
        clienttotal.setFont(subtitle);
        clienttotaltf = new JTextField();
        clienttotaltf.setFont(subtitle);
        clienttotaltf.setBackground(lightgray);
        clienttotaltf.setForeground(Color.BLACK);
        clienttotaltf.setDisabledTextColor(Color.BLACK);
        clienttotaltf.setEnabled(false);

        JLabel clientgrandtotal = new JLabel("GRAND TOTAL");
        clientgrandtotal.setFont(subtitle);
        clientgrandtotaltf = new JTextField();
        clientgrandtotaltf.setFont(subtitle);
        clientgrandtotaltf.setBackground(lightgray);
        clientgrandtotaltf.setForeground(Color.BLACK);
        clientgrandtotaltf.setDisabledTextColor(Color.BLACK);
        clientgrandtotaltf.setEnabled(false);


		JLabel clientaddonequip = new JLabel("ADD-ON EQUIPMENTS");
		clientaddonequip.setFont(list);

		JButton clientcompute = new JButton("COMPUTE");
		clientcompute.setFont(comp);
		clientcompute.setBackground(cred);
        clientcompute.setForeground(Color.WHITE);

		JButton clientreserve = new JButton("RESERVE");
		clientreserve.setEnabled(false);
		clientreserve.setBackground(cgreen);
		clientreserve.setFont(comp);
        clientreserve.setForeground(Color.WHITE);


		//actions

		clientviewterms.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
				csterms csterm = new csterms();
	    		csterm.termsandagree();
		    }
		});

		clientaddback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		clientaddreservation.setVisible(false);
				csdashboard csdash = new csdashboard();
	    		csdash.clientdashboard();
	    	}
		});

		clientroomtypecb.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String roomtype = clientroomtypecb.getSelectedItem().toString();
			if (roomtype.equalsIgnoreCase("MUSIC ROOM 1") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 2") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 3")) {
					    clientpaxtf.setText("7");
					} else if (roomtype.equalsIgnoreCase("RECORDING ROOM 1") ||
					           roomtype.equalsIgnoreCase("RECORDING ROOM 2")) {
					     clientpaxtf.setText("7");
					} else {
					   	 clientpaxtf.setText("15");
					}
	    	}
		});

		clientcontactnumtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();

                // Check if the entered character is a digit
                if (!Character.isDigit(inputChar)) {
                    e.consume(); // Ignore the input if it's not a digit

                    // Display a JOptionPane to inform the user
                    JOptionPane.showMessageDialog(null, "Please enter number only.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clientaddpaxtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();

                // Check if the entered character is a digit
                if (!Character.isDigit(inputChar)) {
                    e.consume(); // Ignore the input if it's not a digit

                    // Display a JOptionPane to inform the user
                    JOptionPane.showMessageDialog(null, "Please enter number only.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

		clientcompute.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (clienttermsagreementcb.isSelected()) {
		        String fullname = clientfulltf.getText();
		        String address = clientaddresstf.getText();
		        String contactnum = clientcontactnumtf.getText();
		        String roomtype = clientroomtypecb.getSelectedItem().toString();
		        LocalDate dateString = clientdatereservationtf.getDate();
		        String starttime = clientstarttimetf.getSelectedItem().toString();
		        String endtime = clientendtimetf.getSelectedItem().toString();
		        String addonpax = clientaddpaxtf.getText();
		        String status = clientstatustf.getText();


		         try {
		            int addpax = 0;
		            if (!clientaddpaxtf.getText().isEmpty()) {
		                addpax = Integer.parseInt(clientaddpaxtf.getText());
		            }

		            if (fullname.isEmpty() || address.isEmpty() || contactnum.isEmpty() || starttime.isEmpty() || endtime.isEmpty() || addonpax.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
		                return;
		            }

					if (dateString == null) {
					    JOptionPane.showMessageDialog(null, "No date selected.");
					    return;
					}

		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String datereservation = dateString.format(formatter);

					if (!checkForTimeOverlap(datereservation, starttime, endtime, roomtype)) {
						clientreserve.setEnabled(true);
                	}

		            int pax = 0;
		            int roomrate = 0;
		            int addpaxrate = 0;
		            int totaladdpax = 0;

		            int downpayment = 0;
		            int total = 0;
		            int grandtotal = 0;

		            LocalTime beforestart = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("h:mm a"));
		            LocalTime start = beforestart.minusMinutes(1);
			        LocalTime end = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("h:mm a"));

			        // Calculate duration
			        Duration duration = Duration.between(start, end);
			        long hours = duration.toHours();
			        int totalhours = (int) hours;

		            if (roomtype.equalsIgnoreCase("MUSIC ROOM 1") ||
		                    roomtype.equalsIgnoreCase("MUSIC ROOM 2") ||
		                    roomtype.equalsIgnoreCase("MUSIC ROOM 3")) {
		                   	if (hours < 8){
								roomrate = 650 * totalhours;
		                   	}
		                   	else {
		                   		roomrate = 5000;
		                   	}
		                pax = 7;
		                addpaxrate = 99;
		                totaladdpax = addpaxrate * addpax;
		                total = roomrate + totaladdpax;
		            } else if (roomtype.equalsIgnoreCase("RECORDING ROOM 1") ||
		                    roomtype.equalsIgnoreCase("RECORDING ROOM 2")) {
		                	if (hours < 8){
								roomrate = 1300 * totalhours;
		                   	}
		                   	else {
		                   		roomrate = 10000;
		                   	}
		                pax = 7;
		                addpaxrate = 189;
		                totaladdpax = addpaxrate * addpax;
		                total = roomrate + totaladdpax;
		            } else {
		                	if (hours < 8){
								roomrate = 2600 * totalhours;
		                   	}
		                   	else {
		                   		roomrate = 20000;
		                   	}
		                pax = 15;
		                addpaxrate = 369;
		                totaladdpax = addpaxrate * addpax;
		                total = roomrate + totaladdpax;
		            }

		            String formattedStartTime = start.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
					String formattedEndTime = end.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

		            if (clientdrums.isSelected()) { EquipmentAvailability("drums", datereservation, formattedStartTime, formattedEndTime);}
			        if (clientflute.isSelected()) { EquipmentAvailability("flute", datereservation, formattedStartTime, formattedEndTime);}
			        if (clientpiano.isSelected()) { EquipmentAvailability("piano", datereservation, formattedStartTime, formattedEndTime);}
		            if (clientacoustic.isSelected()) { EquipmentAvailability("acoustic", datereservation, formattedStartTime, formattedEndTime); }
		            if (clientelectric.isSelected()) { EquipmentAvailability("electric", datereservation, formattedStartTime, formattedEndTime);}
		            if (clientampli.isSelected()) { EquipmentAvailability("amplifier", datereservation, formattedStartTime, formattedEndTime); }
		            if (clientmic.isSelected()) { EquipmentAvailability("microphone", datereservation, formattedStartTime, formattedEndTime); }
		            if (clientstand.isSelected()) { EquipmentAvailability("musicstand", datereservation, formattedStartTime, formattedEndTime); }
		            if (clientheadphone.isSelected()) { EquipmentAvailability("headphone", datereservation, formattedStartTime, formattedEndTime); }
		            if (clientmicstand.isSelected()) { EquipmentAvailability("micstand", datereservation, formattedStartTime, formattedEndTime); }

		            grandtotal = total + addontotal;
		            downpayment = grandtotal / 2;

		            clientaddontotaltf.setText(String.valueOf(addontotal));
		            clientdownpaymenttf.setText(String.valueOf(downpayment));
		            clienttotaltf.setText(String.valueOf(total));
		            clientgrandtotaltf.setText(String.valueOf(grandtotal));

				            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null, "Invalid value for Additional Pax. Please enter a valid number.");
			            } catch (Exception ex) {
			                JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Click on terms and agreement first!");
			        }
			    }
		});

		clientcontactnumtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();

                // Check if the entered character is a digit
                if (!Character.isDigit(inputChar)) {
                    e.consume(); // Ignore the input if it's not a digit

                    // Display a JOptionPane to inform the user
                    JOptionPane.showMessageDialog(null, "Please enter number only.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        clientaddpaxtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();

                // Check if the entered character is a digit
                if (!Character.isDigit(inputChar)) {
                    e.consume(); // Ignore the input if it's not a digit

                    // Display a JOptionPane to inform the user
                    JOptionPane.showMessageDialog(null, "Please enter number only.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

	clientreserve.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to take reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);

		        if (confirmation == JOptionPane.YES_OPTION) {
	            String fullname = clientfulltf.getText();
	            String address = clientaddresstf.getText();
	            String contactnum = clientcontactnumtf.getText();
	            String roomtype = clientroomtypecb.getSelectedItem().toString();
				LocalDate datereservation = clientdatereservationtf.getDate();
		        String formattedDate = datereservation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		        String starttime = clientstarttimetf.getSelectedItem().toString();
		        String endtime = clientendtimetf.getSelectedItem().toString();
		    	String status = clientstatustf.getText();
		    	int pax = Integer.parseInt(clientpaxtf.getText());
		    	int addpax = Integer.parseInt(clientaddpaxtf.getText());
		    	int addontotal = Integer.parseInt(clientaddontotaltf.getText());
		    	int total = Integer.parseInt(clienttotaltf.getText());
		    	int downpayment = Integer.parseInt(clientdownpaymenttf.getText());
		    	int grandtotal = Integer.parseInt(clientgrandtotaltf.getText());

		    	int drumsch = 0;
					int flutech = 0;
					int pianoch = 0;
					int acousticch = 0;
					int electricch = 0;
					int amplifierch = 0;
					int micch = 0;
					int musicstandch = 0;
					int headphonech = 0;
					int micstandch = 0;

					String users = "client";

				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
				    if (clientdrums.isSelected()) {		drumsch = 1;	}
	            	if (clientflute.isSelected()) {		flutech = 1;	}
	            	if (clientpiano.isSelected()) {		pianoch = 1;	}
			        if (clientacoustic.isSelected()) {	acousticch = 1;	}
			        if (clientelectric.isSelected()) {	electricch = 1;	}
			        if (clientampli.isSelected()) {		amplifierch = 1;}
			        if (clientmic.isSelected()) {			micch = 1;		}
			        if (clientstand.isSelected()) {		musicstandch = 1;}
			        if (clientheadphone.isSelected()) {	headphonech = 1;}
			        if (clientmicstand.isSelected()) {	micstandch = 1;	}

				    String sql = "INSERT INTO reservation (fullname, address, contactnumber, typeofroom, datereserve, starttime, endtime, status, pax, additionalpax, addontotal, downpayment, grandtotal, total, drums, flute, piano, acoustic, electric, amplifier, microphone, musicstand, headphone, micstand, user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				        preparedStatement.setString(1, fullname);
				        preparedStatement.setString(2, address);
				        preparedStatement.setString(3, contactnum);
				        preparedStatement.setString(4, roomtype);
				        preparedStatement.setString(5, formattedDate);
				        LocalTime localStartTime = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("h:mm a"));
				        LocalTime localEndTime = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("h:mm a"));
				        java.sql.Time startTime = java.sql.Time.valueOf(localStartTime);
				        java.sql.Time endTime = java.sql.Time.valueOf(localEndTime);
				        preparedStatement.setTime(6, startTime);
				        preparedStatement.setTime(7, endTime);
				        preparedStatement.setString(8, status);
				        preparedStatement.setInt(9, pax);
				        preparedStatement.setInt(10, addpax);
				        preparedStatement.setInt(11, addontotal);
				        preparedStatement.setInt(12, downpayment);
				        preparedStatement.setInt(13, grandtotal);
				        preparedStatement.setInt(14, total);
				        preparedStatement.setInt(15, drumsch);
				        preparedStatement.setInt(16, flutech);
				        preparedStatement.setInt(17, pianoch);
				        preparedStatement.setInt(18, acousticch);
				        preparedStatement.setInt(19, electricch);
				        preparedStatement.setInt(20, amplifierch);
				        preparedStatement.setInt(21, micch);
				        preparedStatement.setInt(22, musicstandch);
				        preparedStatement.setInt(23, headphonech);
				        preparedStatement.setInt(24, micstandch);
				        preparedStatement.setString(25, users);

				         preparedStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Reservation Successful!");
							clearaddreservation();
                        }

                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERROR: " + ex);
                    }
 				} else {
		            JOptionPane.showMessageDialog(null, "Reservation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});

        //borders
       	clientfulltf.setBorder(new LineBorder(Color.BLACK, 2));
       	clientaddresstf.setBorder(new LineBorder(Color.BLACK, 2));
		clientcontactnumtf.setBorder(new LineBorder(Color.BLACK, 2));
		clientdatereservationtf.setBorder(new LineBorder(Color.BLACK, 2));
		clientroomtypecb.setBorder(new LineBorder(Color.BLACK, 2));
		clientstarttimetf.setBorder(new LineBorder(Color.BLACK, 2));
		clientendtimetf.setBorder(new LineBorder(Color.BLACK, 2));
		clientstatustf.setBorder(new LineBorder(Color.BLACK, 2));
		clientpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		clientaddpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		clienttermsagreementcb.setBorder(new LineBorder(Color.BLACK, 2));
		clientaddontotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		clientdownpaymenttf.setBorder(new LineBorder(Color.BLACK, 2));
		clienttotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		clientgrandtotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		clientcompute.setBorder(new LineBorder(cred, 2));
		clientreserve.setBorder(new LineBorder(cgreen, 2));

		//add components
		clientaddreservation.add(clienttitletextaddreserve);
		clientaddreservation.add(clientfullname);
		clientaddreservation.add(clientaddress);
		clientaddreservation.add(clientcontactnum);
		clientaddreservation.add(clientroomtype);
		clientaddreservation.add(clientdatereservation);
		clientaddreservation.add(clientstarttime);
		clientaddreservation.add(clientendtime);
		clientaddreservation.add(clientstatus);
		clientaddreservation.add(clientpax);
		clientaddreservation.add(clientaddpax);
		clientaddreservation.add(clientfulltf);
		clientaddreservation.add(clientaddresstf);
		clientaddreservation.add(clientcontactnumtf);
		clientaddreservation.add(clientroomtypecb);
		clientaddreservation.add(clientdatereservationtf);
		clientaddreservation.add(clientstarttimetf);
		clientaddreservation.add(clientendtimetf);
		clientaddreservation.add(clientstatustf);
		clientaddreservation.add(clientpaxtf);
		clientaddreservation.add(clientaddpaxtf);
		clientaddreservation.add(clienttermsagreementcb);
		clientaddreservation.add(clientviewterms);
		clientaddreservation.add(clientaddontotal);
		clientaddreservation.add(clientaddontotaltf);
		clientaddreservation.add(clientdownpayment);
		clientaddreservation.add(clientdownpaymenttf);
		clientaddreservation.add(clienttotal);
		clientaddreservation.add(clienttotaltf);
		clientaddreservation.add(clientgrandtotal);
		clientaddreservation.add(clientgrandtotaltf);
		clientaddreservation.add(clientaddonequip);
		clientaddreservation.add(clientdrums);
		clientaddreservation.add(clientflute);
		clientaddreservation.add(clientpiano);
		clientaddreservation.add(clientacoustic);
		clientaddreservation.add(clientelectric);
		clientaddreservation.add(clientampli);
		clientaddreservation.add(clientmic);
		clientaddreservation.add(clientstand);
		clientaddreservation.add(clientheadphone);
		clientaddreservation.add(clientmicstand);
		clientaddreservation.add(clientaddonsbox);
		clientaddreservation.add(clientcompute);
		clientaddreservation.add(clientaddback);
		clientaddreservation.add(clientreserve);


		//setbounds add reservation
		clienttitletextaddreserve.setBounds(110, 0, 800, 70);
		clientaddback.setBounds(20, 20, 75, 30);
		clientfullname.setBounds(30, 74, 220, 30);
		clientfulltf.setBounds(30, 101, 240, 30);
		clientaddress.setBounds(30, 137, 220, 30);
		clientaddresstf.setBounds(30, 164, 240, 30);
		clientcontactnum.setBounds(30, 200, 220, 30);
		clientcontactnumtf.setBounds(30, 227, 240, 30);
		clientroomtype.setBounds(30, 263, 220, 30);
		clientroomtypecb.setBounds(30, 290, 240, 30);
		clientdatereservation.setBounds(30, 325, 220, 30);
		clientdatereservationtf.setBounds(30, 352, 240, 30);
		clientstarttime.setBounds(300, 74, 220, 30);
		clientstarttimetf.setBounds(300, 101, 240, 30);
		clientendtime.setBounds(300, 137, 220, 30);
		clientendtimetf.setBounds(300, 164, 240, 30);
		clientstatus.setBounds(300, 200, 220, 30);
		clientstatustf.setBounds(300, 227, 240, 30);
		clientpax.setBounds(300, 263, 220, 30);
		clientpaxtf.setBounds(300, 290, 240, 30);
		clientaddpax.setBounds(300, 325, 220, 30);
		clientaddpaxtf.setBounds(300, 352, 240, 30);
		clienttermsagreementcb.setBounds(140, 407, 300, 20);
		clientviewterms.setBounds(180, 417, 250, 30);
		clientaddontotal.setBounds(33, 462, 150, 30);
		clientaddontotaltf.setBounds(160, 462, 150, 30);
		clientdownpayment.setBounds(30, 507, 150, 30);
		clientdownpaymenttf.setBounds(160, 507, 150, 30);
		clienttotal.setBounds(355, 462, 150, 30);
		clienttotaltf.setBounds(445, 462, 150, 30);
		clientgrandtotal.setBounds(330, 507, 150, 30);
		clientgrandtotaltf.setBounds(445, 507, 150, 30);
		clientaddonequip.setBounds(585, 88, 270, 30);
		clientdrums.setBounds(590, 120, 150, 30);
		clientflute.setBounds(590, 150, 150, 30);
		clientpiano.setBounds(590, 180, 150, 30);
		clientacoustic.setBounds(590, 210, 200, 30);
		clientelectric.setBounds(590, 240, 150, 30);
		clientampli.setBounds(590, 270, 150, 30);
		clientmic.setBounds(590, 300, 150, 30);
		clientstand.setBounds(590, 330, 150, 30);
		clientheadphone.setBounds(590, 360, 150, 30);
		clientmicstand.setBounds(590, 390, 150, 30);
		clientaddonsbox.setBounds(570, 80, 285, 350);
		clientcompute.setBounds(645, 450, 180, 40);
		clientreserve.setBounds(645, 500, 180, 40);
		clientaddreservation.setBounds(225, 70, 900, 600);

        // bg
        clientaddreservation.getContentPane().setBackground(Color.WHITE);
        clientaddreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientaddreservation.setLayout(null);
        clientaddreservation.setVisible(true);

	    }
private boolean checkForTimeOverlap(String date, String startTime, String endTime, String roomtype) {
        try {

LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            LocalTime formattedStartTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("hh:mm a"));
            LocalTime formattedEndTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("hh:mm a"));

            // Check for time overlap with room type condition
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
                String query = "SELECT * FROM reservation WHERE datereserve = ? AND typeofroom = ? AND " +
                               "((endtime > ? AND starttime < ?) OR " +
                               "(endtime > ? AND starttime < ?) OR " +
                               "(endtime >= ? AND starttime <= ?))";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setObject(1, formattedDate);
                    preparedStatement.setString(2, roomtype);
                    preparedStatement.setObject(3, formattedStartTime);
                    preparedStatement.setObject(4, formattedEndTime);
                    preparedStatement.setObject(5, formattedStartTime);
                    preparedStatement.setObject(6, formattedEndTime);
                    preparedStatement.setObject(7, formattedStartTime);
                    preparedStatement.setObject(8, formattedEndTime);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        // Overlapping reservation found
                        JOptionPane.showMessageDialog(null, "There is an overlapping reservation. Please choose a different time.");
                        return true;
                    }
                }
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error checking for time overlap: " + ex.getMessage());
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error parsing date/time: " + e.getMessage());
        }

        return false;
    }
	public void clearaddreservation(){
			clientfulltf.setText("");
		    clientaddresstf.setText("");
		    clientcontactnumtf.setText("");
		    clientroomtypecb.setSelectedIndex(0);
		    clientdatereservationtf.setDate(null);
		    clientstarttimetf.setSelectedIndex(0);
		    clientendtimetf.setSelectedIndex(0);
		    clientstatustf.setText("WAITING");
		    clientpaxtf.setText("");
		    clientaddpaxtf.setText("");
		    clientaddontotaltf.setText("");
		    clienttotaltf.setText("");
		    clientdownpaymenttf.setText("");
		    clientgrandtotaltf.setText("");
		    clientdrums.setSelected(false);
			clientflute.setSelected(false);
			clientpiano.setSelected(false);
			clientacoustic.setSelected(false);
			clientelectric.setSelected(false);
			clientampli.setSelected(false);
			clientmic.setSelected(false);
			clientstand.setSelected(false);
			clientheadphone.setSelected(false);
			clientmicstand.setSelected(false);
	}

public void EquipmentAvailability(String equipmentName, String datereservation, String start, String end) throws SQLException {
    // Assuming you have an 'equipment' table with columns 'equipmentname', 'noofavailable', and 'borrowed'
    int drumsres = 0;
    int fluteres = 0;
    int pianores = 0;
	int acousticres = 0;
	int electricres = 0;
	int amplifierres = 0;
	int microphoneres = 0;
	int musicstandres = 0;
	int headphoneres = 0;
	int micstandres = 0;
    try (Connection connection = DriverManager.getConnection(url, usernamedb, passworddb)) {
        String query = "SELECT equipmentname, quantity FROM equipment";
        int totalquantity = 0;
		System.out.println(start);
		System.out.println(end);
		System.out.println(datereservation);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int drumsquantity = resultSet.getInt("quantity");
                    int flutequantity = resultSet.getInt("quantity");
                    int pianoquantity = resultSet.getInt("quantity");
                    int acousticquantity = resultSet.getInt("quantity");
                    int electricquantity = resultSet.getInt("quantity");
                    int amplifierquantity = resultSet.getInt("quantity");
                    int microphonequantity = resultSet.getInt("quantity");
                    int musicstandquantity = resultSet.getInt("quantity");
                    int headphonequantity = resultSet.getInt("quantity");
                    int micstandquantity = resultSet.getInt("quantity");

                     String reservationQuery = "SELECT drums, flute, piano, acoustic, electric, amplifier, microphone, musicstand, headphone, micstand FROM reservation WHERE datereserve = ? AND starttime >= ? AND endtime <= ?";
                    try (PreparedStatement reservationStatement = connection.prepareStatement(reservationQuery)) {
                        reservationStatement.setString(1, datereservation);
                        reservationStatement.setString(2, start);
                        reservationStatement.setString(3, end);

						int totaldrums = 0;
						int totalflute = 0;
						int totalpiano = 0;
						int totalacoustic = 0;
						int totalelectric = 0;
						int totalamplifier = 0;
						int totalmic = 0;
						int totalmusicstand = 0;
						int totalheadphone = 0;
						int totalmicstand = 0;
                        try (ResultSet reservationResultSet = reservationStatement.executeQuery()) {
                            while (reservationResultSet.next()) {
                                drumsres = reservationResultSet.getInt("drums");
                                fluteres = reservationResultSet.getInt("flute");
                                 pianores = reservationResultSet.getInt("piano");
                                 acousticres = reservationResultSet.getInt("acoustic");
                                 electricres = reservationResultSet.getInt("electric");
                                 amplifierres = reservationResultSet.getInt("amplifier");
                                 microphoneres = reservationResultSet.getInt("microphone");
                                 musicstandres = reservationResultSet.getInt("musicstand");
                                 headphoneres = reservationResultSet.getInt("headphone");
                                 micstandres = reservationResultSet.getInt("micstand");

								totaldrums += drumsres;
								totalflute += fluteres;
								totalpiano += pianores;
								totalacoustic += acousticres;
								totalelectric += electricres;
								totalamplifier += amplifierres;
								totalmic += microphoneres;
								totalmusicstand += musicstandres;
								totalheadphone += headphoneres;
								totalmicstand += micstandres;


                            }

                                switch (equipmentName) {
                                    case "drums":
                                        if (totaldrums >= 0) {
                                            drumsquantity -= totaldrums;
                                            System.out.print(drumsquantity);
                                            if (drumsquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientdrums.setSelected(false);
                                            }else {
                                            	addontotal += getEquipmentRate("drums");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "flute":
                                        if (totalflute >= 0) {
                                            flutequantity -= totalflute;
                                            System.out.print(flutequantity);
                                            if (flutequantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientflute.setSelected(false);
                                            } else{
                                            	addontotal += getEquipmentRate("flute");
                                            	System.out.print(addontotal);
                                            }

                                        }
                                        break;
                                    case "piano":
                                        if (totalpiano >= 0) {
                                            pianoquantity -= totalpiano;
                                            System.out.print(pianoquantity);
                                            if (pianoquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientpiano.setSelected(false);
                                            } else{
                                            	addontotal += getEquipmentRate("piano");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "acoustic":
                                        if (totalacoustic >= 0) {
                                            acousticquantity -= totalacoustic;
                                            System.out.print(acousticquantity);
                                            if (acousticquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientacoustic.setSelected(false);
                                            } else {
                                            	addontotal += getEquipmentRate("acoustic guitar");
                                            	System.out.print(addontotal);
                                            }

                                        }
                                        break;
                                    case "electric":
                                        if (totalelectric >= 0) {
                                            electricquantity -= totalelectric;
                                            System.out.print(electricquantity);
                                            if (electricquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientelectric.setSelected(false);
                                            } else {
                                            	addontotal += getEquipmentRate("electric guitar");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "amplifier":
                                        if (totalamplifier >= 0) {
                                            amplifierquantity -= totalamplifier;
                                            System.out.print(amplifierquantity);
                                            if (amplifierquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientampli.setSelected(false);
                                            } else{
                                            	addontotal += getEquipmentRate("amplifier");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "microphone":
                                        if (totalmic >= 0) {
                                            microphonequantity -= totalmic;
                                            System.out.print(microphonequantity);
                                            if (microphonequantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientmic.setSelected(false);
                                            } else{
                                            	addontotal += getEquipmentRate("mic");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "musicstand":
                                        if (totalmusicstand >= 0) {
                                            musicstandquantity -= totalmusicstand;
                                            System.out.print(musicstandquantity);
                                            if (musicstandquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientstand.setSelected(false);
                                            } else {
                                            	addontotal += getEquipmentRate("music stand");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "headphone":
                                        if (totalheadphone >= 0) {
                                            headphonequantity -= totalheadphone;
                                            System.out.print(headphonequantity);
                                            if (headphonequantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientheadphone.setSelected(false);
                                            } else {
                                            	addontotal += getEquipmentRate("headphone");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                    case "micstand":
                                        if (totalmicstand >= 0) {
                                            micstandquantity -= totalmicstand;
                                            System.out.print(micstandquantity);
                                            if (micstandquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                clientmicstand.setSelected(false);
                                            } else {
                                            	addontotal += getEquipmentRate("mic stand");
                                            	System.out.print(addontotal);
                                            }
                                        }
                                        break;
                                }

                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
        }
    }
}

public int getEquipmentRate(String equipmentName) {
    int rate = 0;

    try (Connection connection = DriverManager.getConnection(url, usernamedb, passworddb)) {
        String query = "SELECT rate FROM equipment WHERE LOWER(equipmentname) = LOWER(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, equipmentName.toLowerCase());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    rate = resultSet.getInt("rate");
                } else {
                    // Equipment not found, display a JOptionPane message
                    JOptionPane.showMessageDialog(null, "Equipment not found: " + equipmentName,
                            "Equipment Not Found", JOptionPane.WARNING_MESSAGE);
					switch (equipmentName) {
                        case "drums":
                            clientdrums.setSelected(false);
                            break;
                        case "flute":
                            clientflute.setSelected(false);
                            break;
                        case "piano":
                            clientpiano.setSelected(false);
                            break;
                        case "acoustic guitar":
                            clientacoustic.setSelected(false);
                            break;
                        case "electric guitar":
                            clientelectric.setSelected(false);
                            break;
                        case "amplifier":
                            clientampli.setSelected(false);
                            break;
                        case "mic":
                            clientmic.setSelected(false);
                            break;
                        case "music stand":
                            clientstand.setSelected(false);
                            break;
                        case "headphone":
                            clientheadphone.setSelected(false);
                            break;
                        case "mic stand":
                            clientmicstand.setSelected(false);
                            break;
					}

                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    }

    return rate;
}

}