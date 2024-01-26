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

import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.components.DatePicker.*;


public class mraddreservation implements designs {
		JFrame addreservation = new JFrame("Add Reservation");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
		private JTextField fulltf;
		private JTextField addresstf;
		private JTextField contactnumtf;
		private JComboBox roomtypecb;
		private DatePicker datereservationtf;
		private JComboBox starttimetf;
		private JComboBox endtimetf;
		private JComboBox statuscb;
		private JTextField paxtf;
		private JTextField addpaxtf;
		private JTextField addontotaltf;
		private JTextField downpaymenttf;
		private JTextField totaltf;
		private JTextField grandtotaltf;
		private JCheckBox drums;
		private JCheckBox flute;
		private JCheckBox piano;
		private JCheckBox acoustic;
		private JCheckBox electric;
		private JCheckBox ampli;
		private JCheckBox mic;
		private JCheckBox stand;
		private JCheckBox headphone;
		private JCheckBox micstand;

		public int addontotal = 0;

	public void addreservations(){


		//ADD RESERVATION
        JLabel titletextaddreserve = new JLabel("MUSIC ROOM RESERVATION");
        titletextaddreserve.setFont(title);

        JButton addback = new JButton("BACK");
		addback.setBackground(cred);
		addback.setFont(listbtn);
        addback.setForeground(Color.WHITE);

        //declare component
        JLabel fullname = new JLabel("FULL NAME *");
        fullname.setFont(subtitle);
        fulltf = new JTextField();
        fulltf.setFont(subtitle);

        JLabel address = new JLabel("ADDRESS *");
        address.setFont(subtitle);
        addresstf = new JTextField();
        addresstf.setFont(subtitle);

        JLabel contactnum = new JLabel("CONTACT NUMBER *");
        contactnum.setFont(subtitle);
        contactnumtf = new JTextField();
        contactnumtf.setFont(subtitle);

        JLabel roomtype = new JLabel("TYPE OF ROOM *");
        roomtype.setFont(subtitle);
        String roomtypearr [] = {"MUSIC ROOM 1", "MUSIC ROOM 2", "MUSIC ROOM 3", "RECORDING ROOM 1", "RECORDING ROOM 2", "DELUXE ROOM 1","DELUXE ROOM 2"};
        roomtypecb = new JComboBox(roomtypearr);
        roomtypecb.setFont(subtitle);
        roomtypecb.setBackground(Color.WHITE);

        JLabel datereservation = new JLabel("DATE OF RESERVATION *");
        datereservation.setFont(subtitle);
        datereservationtf = new DatePicker();
        datereservationtf.setFont(subtitle);

        JLabel starttime = new JLabel("START TIME OF RESERVATION *");
        starttime.setFont(subtitle);
        String starttimearr [] = {"10:01 AM", "11:01 AM", "12:01 PM", "01:01 PM", "02:01 PM", "03:01 PM", "04:01 PM", "05:01 PM"};
        starttimetf = new JComboBox(starttimearr);
        starttimetf.setFont(subtitle);
        starttimetf.setBackground(Color.WHITE);

        JLabel endtime = new JLabel("END TIME TIME OF RESERVATION *");
        endtime.setFont(subtitle);
        String endtimearr [] = {"11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM"};
        endtimetf = new JComboBox(endtimearr);
        endtimetf.setFont(subtitle);
        endtimetf.setBackground(Color.WHITE);

        JLabel status = new JLabel("STATUS *");
        status.setFont(subtitle);
        String statusarr [] = {"PENDING", "ON-GOING", "DONE"};
        statuscb = new JComboBox(statusarr);
        statuscb.setFont(subtitle);
        statuscb.setBackground(Color.WHITE);

        JLabel pax = new JLabel("PAX");
        pax.setFont(subtitle);
        paxtf = new JTextField(" MAX NUMBER OF PERSON ");
        paxtf.setFont(subtitle);
        paxtf.setBackground(lightgray);
        paxtf.setForeground(Color.BLACK);
        paxtf.setDisabledTextColor(Color.BLACK);
        paxtf.setEnabled(false);

        JLabel addpax = new JLabel("ADDITIONAL PAX *");
        addpax.setFont(subtitle);
        addpaxtf = new JTextField();
        addpaxtf.setFont(subtitle);

		JLabel addontotallbl = new JLabel("ADD-ON TOTAL");
        addontotallbl.setFont(subtitle);
        addontotaltf = new JTextField();
        addontotaltf.setFont(subtitle);
        addontotaltf.setBackground(lightgray);
        addontotaltf.setForeground(Color.BLACK);
        addontotaltf.setDisabledTextColor(Color.BLACK);
        addontotaltf.setEnabled(false);

		JLabel downpayment = new JLabel("DOWN PAYMENT");
        downpayment.setFont(subtitle);
        downpaymenttf = new JTextField();
        downpaymenttf.setFont(subtitle);
        downpaymenttf.setBackground(lightgray);
        downpaymenttf.setForeground(Color.BLACK);
        downpaymenttf.setDisabledTextColor(Color.BLACK);
        downpaymenttf.setEnabled(false);

        JLabel total = new JLabel("TOTAL");
        total.setFont(subtitle);
        totaltf = new JTextField();
        totaltf.setFont(subtitle);
        totaltf.setBackground(lightgray);
        totaltf.setForeground(Color.BLACK);
        totaltf.setDisabledTextColor(Color.BLACK);
        totaltf.setEnabled(false);

        JLabel grandtotal = new JLabel("GRAND TOTAL");
        grandtotal.setFont(subtitle);
        grandtotaltf = new JTextField();
        grandtotaltf.setFont(subtitle);
        grandtotaltf.setBackground(lightgray);
        grandtotaltf.setForeground(Color.BLACK);
        grandtotaltf.setDisabledTextColor(Color.BLACK);
        grandtotaltf.setEnabled(false);


		JLabel addonequip = new JLabel("ADD-ON EQUIPMENTS");
		addonequip.setFont(list);

		drums = new JCheckBox("DRUMS");
        drums.setFont(subtitle);
        drums.setBackground(Color.WHITE);

        flute = new JCheckBox("FLUTE");
        flute.setFont(subtitle);
        flute.setBackground(Color.WHITE);

        piano = new JCheckBox("PIANO");
        piano.setFont(subtitle);
        piano.setBackground(Color.WHITE);

        acoustic = new JCheckBox("ACOUSTIC GUITAR");
        acoustic.setFont(subtitle);
        acoustic.setBackground(Color.WHITE);

        electric = new JCheckBox("ELECTRIC GUITAR");
        electric.setFont(subtitle);
        electric.setBackground(Color.WHITE);

        ampli = new JCheckBox("AMPLIFIER");
        ampli.setFont(subtitle);
        ampli.setBackground(Color.WHITE);

        mic = new JCheckBox("MICROPHONE");
        mic.setFont(subtitle);
        mic.setBackground(Color.WHITE);

        stand = new JCheckBox("MUSIC STAND");
        stand.setFont(subtitle);
        stand.setBackground(Color.WHITE);

        headphone = new JCheckBox("HEADPHONE");
        headphone.setFont(subtitle);
        headphone.setBackground(Color.WHITE);

        micstand = new JCheckBox("MIC STAND");
        micstand.setFont(subtitle);
        micstand.setBackground(Color.WHITE);

       	JButton addonsbox = new JButton();
		addonsbox.setBackground(Color.WHITE);
		addonsbox.setEnabled(false);

		JButton compute = new JButton("COMPUTE");
		compute.setFont(comp);
		compute.setBackground(cred);
        compute.setForeground(Color.WHITE);

		JButton reserve = new JButton("RESERVE");
		reserve.setEnabled(false);
		reserve.setBackground(cgreen);
		reserve.setFont(comp);
        reserve.setForeground(Color.WHITE);


	//actions
		addback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				addreservation.setVisible(false);
				mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();
	    	}
		});



		roomtypecb.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String roomtype = roomtypecb.getSelectedItem().toString();
			if (roomtype.equalsIgnoreCase("MUSIC ROOM 1") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 2") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 3")) {
					    paxtf.setText("7");
					} else if (roomtype.equalsIgnoreCase("RECORDING ROOM 1") ||
					           roomtype.equalsIgnoreCase("RECORDING ROOM 2")) {
					     paxtf.setText("7");
					} else {
					   	 paxtf.setText("15");
					}
	    	}
		});

		contactnumtf.addKeyListener(new KeyAdapter() {
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

        addpaxtf.addKeyListener(new KeyAdapter() {
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

		compute.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String fullname = fulltf.getText();
		        String address = addresstf.getText();
		        String contactnum = contactnumtf.getText();
		        String roomtype = roomtypecb.getSelectedItem().toString();
		        LocalDate dateString = datereservationtf.getDate();
		        String starttime = starttimetf.getSelectedItem().toString();
		        String endtime = endtimetf.getSelectedItem().toString();
		        String addonpax = addpaxtf.getText();
		        String status = statuscb.getSelectedItem().toString();

		        try {
		            int addpax = 0;
		            if (!addpaxtf.getText().isEmpty()) {
		                addpax = Integer.parseInt(addpaxtf.getText());
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
                    	reserve.setEnabled(true);
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

		            if (drums.isSelected()) { EquipmentAvailability("drums", datereservation, formattedStartTime, formattedEndTime); }
			        if (flute.isSelected()) { EquipmentAvailability("flute", datereservation, formattedStartTime, formattedEndTime);  }
			        if (piano.isSelected()) { EquipmentAvailability("piano", datereservation, formattedStartTime, formattedEndTime); }
		            if (acoustic.isSelected()) { EquipmentAvailability("acoustic", datereservation, formattedStartTime, formattedEndTime);  }
		            if (electric.isSelected()) { EquipmentAvailability("electric", datereservation, formattedStartTime, formattedEndTime);  }
		            if (ampli.isSelected()) { EquipmentAvailability("amplifier", datereservation, formattedStartTime, formattedEndTime); }
		            if (mic.isSelected()) { EquipmentAvailability("microphone", datereservation, formattedStartTime, formattedEndTime); }
		            if (stand.isSelected()) { EquipmentAvailability("musicstand", datereservation, formattedStartTime, formattedEndTime); }
		            if (headphone.isSelected()) { EquipmentAvailability("headphone", datereservation, formattedStartTime, formattedEndTime);  }
		            if (micstand.isSelected()) { EquipmentAvailability("micstand", datereservation, formattedStartTime, formattedEndTime);  }

		            grandtotal = total + addontotal;
		            downpayment = grandtotal / 2;

		            addontotaltf.setText(String.valueOf(addontotal));
		            downpaymenttf.setText(String.valueOf(downpayment));
		            totaltf.setText(String.valueOf(total));
		            grandtotaltf.setText(String.valueOf(grandtotal));


		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Invalid value for Additional Pax. Please enter a valid number.");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
		        }
		    }

		});

		reserve.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to reserve this?", "Confirmation", JOptionPane.YES_NO_OPTION);

		        if (confirmation == JOptionPane.YES_OPTION) {
		            String fullname = fulltf.getText();
		            String address = addresstf.getText();
		            String contactnum = contactnumtf.getText();
		            String roomtype = roomtypecb.getSelectedItem().toString();
		            LocalDate datereservation = datereservationtf.getDate();
		            String formattedDate = datereservation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		            String starttime = starttimetf.getSelectedItem().toString();
		            String endtime = endtimetf.getSelectedItem().toString();
		            String status = statuscb.getSelectedItem().toString();
		            int pax = Integer.parseInt(paxtf.getText());
		            int addpax = Integer.parseInt(addpaxtf.getText());

		            int addontotal = Integer.parseInt(addontotaltf.getText());
		            int total = Integer.parseInt(totaltf.getText());
		            int downpayment = Integer.parseInt(downpaymenttf.getText());
		            int grandtotal = Integer.parseInt(grandtotaltf.getText());
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

		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
		                if (drums.isSelected()) {
			            	updateEquipmentAvailability(connection, "drums", 1, status);
			            	drumsch = 1;
			            }
	            		if (flute.isSelected()) {
	            			updateEquipmentAvailability(connection, "flute", 1, status);
	            			flutech = 1;
	            		}
	            		if (piano.isSelected()) {
	            			updateEquipmentAvailability(connection, "piano", 1, status);
	            			pianoch = 1;
	            		}
			            if (acoustic.isSelected()) {
			            	updateEquipmentAvailability(connection, "acoustic guitar", 1, status);
			            	acousticch = 1;
			            }
			            if (electric.isSelected()) {
			            	updateEquipmentAvailability(connection, "electric guitar", 1, status);
			            	electricch = 1;
			            }
			            if (ampli.isSelected()) {
			            	updateEquipmentAvailability(connection, "amplifier", 1, status);
			            	amplifierch = 1;
			            }
			            if (mic.isSelected()) {
			            	updateEquipmentAvailability(connection, "mic", 1, status);
			            	micch = 1;
			            }
			            if (stand.isSelected()) {
			            	updateEquipmentAvailability(connection, "music stand", 1, status);
			            	musicstandch = 1;
			            }
			            if (headphone.isSelected()) {
			            	updateEquipmentAvailability(connection, "headphone", 1, status);
			            	headphonech = 1;
			            }
			            if (micstand.isSelected()) {
			            	updateEquipmentAvailability(connection, "mic stand", 1, status);
			            	micstandch = 1;
			            }
			            String users = "admin";

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
				        JOptionPane.showMessageDialog(null, "Reservation Successfull!");
				        clearaddreservation();
		                }

		                connection.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Reservation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});


        //borders
       	fulltf.setBorder(new LineBorder(Color.BLACK, 2));
       	addresstf.setBorder(new LineBorder(Color.BLACK, 2));
		contactnumtf.setBorder(new LineBorder(Color.BLACK, 2));
		datereservationtf.setBorder(new LineBorder(Color.BLACK, 2));
		roomtypecb.setBorder(new LineBorder(Color.BLACK, 2));
		starttimetf.setBorder(new LineBorder(Color.BLACK, 2));
		endtimetf.setBorder(new LineBorder(Color.BLACK, 2));
		statuscb.setBorder(new LineBorder(Color.BLACK, 2));
		paxtf.setBorder(new LineBorder(Color.BLACK, 2));
		addpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		addontotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		downpaymenttf.setBorder(new LineBorder(Color.BLACK, 2));
		totaltf.setBorder(new LineBorder(Color.BLACK, 2));
		grandtotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		addonsbox.setBorder(new LineBorder(Color.BLACK, 1));
		compute.setBorder(new LineBorder(cred, 2));
		reserve.setBorder(new LineBorder(cgreen, 2));

		//add components
		addreservation.add(titletextaddreserve);
		addreservation.add(addback);
		addreservation.add(fullname);
		addreservation.add(address);
		addreservation.add(contactnum);
		addreservation.add(roomtype);
		addreservation.add(datereservation);
		addreservation.add(starttime);
		addreservation.add(endtime);
		addreservation.add(status);
		addreservation.add(pax);
		addreservation.add(addpax);
		addreservation.add(fulltf);
		addreservation.add(addresstf);
		addreservation.add(contactnumtf);
		addreservation.add(roomtypecb);
		addreservation.add(datereservationtf);
		addreservation.add(starttimetf);
		addreservation.add(endtimetf);
		addreservation.add(statuscb);
		addreservation.add(paxtf);
		addreservation.add(addpaxtf);
		addreservation.add(addontotallbl);
		addreservation.add(addontotaltf);
		addreservation.add(downpayment);
		addreservation.add(downpaymenttf);
		addreservation.add(total);
		addreservation.add(totaltf);
		addreservation.add(grandtotal);
		addreservation.add(grandtotaltf);
		addreservation.add(addonequip);
		addreservation.add(drums);
		addreservation.add(flute);
		addreservation.add(piano);
		addreservation.add(acoustic);
		addreservation.add(electric);
		addreservation.add(ampli);
		addreservation.add(mic);
		addreservation.add(stand);
		addreservation.add(headphone);
		addreservation.add(micstand);
		addreservation.add(addonsbox);
		addreservation.add(compute);
		addreservation.add(reserve);


		//setbounds add reservation
		titletextaddreserve.setBounds(110, 0, 800, 70);
		addback.setBounds(20, 20, 75, 30);
		fullname.setBounds(30, 74, 220, 30);
		fulltf.setBounds(30, 101, 240, 30);
		address.setBounds(30, 137, 220, 30);
		addresstf.setBounds(30, 164, 240, 30);
		contactnum.setBounds(30, 200, 220, 30);
		contactnumtf.setBounds(30, 227, 240, 30);
		roomtype.setBounds(30, 263, 220, 30);
		roomtypecb.setBounds(30, 290, 240, 30);
		datereservation.setBounds(30, 325, 220, 30);
		datereservationtf.setBounds(30, 352, 240, 30);
		starttime.setBounds(300, 74, 220, 30);
		starttimetf.setBounds(300, 101, 260, 30);
		endtime.setBounds(300, 137, 220, 30);
		endtimetf.setBounds(300, 164, 260, 30);
		status.setBounds(300, 200, 220, 30);
		statuscb.setBounds(300, 227, 240, 30);
		pax.setBounds(300, 263, 220, 30);
		paxtf.setBounds(300, 290, 240, 30);
		addpax.setBounds(300, 325, 220, 30);
		addpaxtf.setBounds(300, 352, 240, 30);
		addontotallbl.setBounds(33, 462, 150, 30);
		addontotaltf.setBounds(160, 462, 150, 30);
		downpayment.setBounds(30, 507, 150, 30);
		downpaymenttf.setBounds(160, 507, 150, 30);
		total.setBounds(355, 462, 150, 30);
		totaltf.setBounds(445, 462, 150, 30);
		grandtotal.setBounds(330, 507, 150, 30);
		grandtotaltf.setBounds(445, 507, 150, 30);
		addonequip.setBounds(585, 88, 270, 30);
		drums.setBounds(590, 120, 150, 30);
		flute.setBounds(590, 150, 150, 30);
		piano.setBounds(590, 180, 150, 30);
		acoustic.setBounds(590, 210, 200, 30);
		electric.setBounds(590, 240, 150, 30);
		ampli.setBounds(590, 270, 150, 30);
		mic.setBounds(590, 300, 150, 30);
		stand.setBounds(590, 330, 150, 30);
		headphone.setBounds(590, 360, 150, 30);
		micstand.setBounds(590, 390, 150, 30);
		addonsbox.setBounds(570, 80, 285, 350);
		compute.setBounds(645, 450, 180, 40);
		reserve.setBounds(645, 500, 180, 40);
		addreservation.setBounds(225, 70, 900, 600);

        // bg
        addreservation.getContentPane().setBackground(Color.WHITE);
        addreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addreservation.setLayout(null);
        addreservation.setVisible(true);
	}
	public void clearaddreservation(){
			fulltf.setText("");
		    addresstf.setText("");
		    contactnumtf.setText("");
		    roomtypecb.setSelectedIndex(0);
		    datereservationtf.setDate(null);
		    starttimetf.setSelectedIndex(0);
		    endtimetf.setSelectedIndex(0);
		    statuscb.setSelectedIndex(0);
		    paxtf.setText("");
		    addpaxtf.setText("");
		    addontotaltf.setText("");
		    totaltf.setText("");
		    downpaymenttf.setText("");
		    grandtotaltf.setText("");
		    drums.setSelected(false);
			flute.setSelected(false);
			piano.setSelected(false);
			acoustic.setSelected(false);
			electric.setSelected(false);
			ampli.setSelected(false);
			mic.setSelected(false);
			stand.setSelected(false);
			headphone.setSelected(false);
			micstand.setSelected(false);
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
                            drums.setSelected(false);
                            break;
                        case "flute":
                            flute.setSelected(false);
                            break;
                        case "piano":
                            piano.setSelected(false);
                            break;
                        case "acoustic guitar":
                            acoustic.setSelected(false);
                            break;
                        case "electric guitar":
                            electric.setSelected(false);
                            break;
                        case "amplifier":
                            ampli.setSelected(false);
                            break;
                        case "mic":
                            mic.setSelected(false);
                            break;
                        case "music stand":
                            stand.setSelected(false);
                            break;
                        case "headphone":
                            headphone.setSelected(false);
                            break;
                        case "mic stand":
                            micstand.setSelected(false);
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
private void updateEquipmentAvailability(Connection connection, String equipmentName, int changeAmount, String status) throws SQLException {

    // Assuming you have an 'equipment' table with columns 'equipmentname', 'noofavailable', and 'borrowed'
    String query = "SELECT noofavailable, noofborrow FROM equipment WHERE LOWER(equipmentname) = LOWER(?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, equipmentName.toLowerCase());

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int noOfAvailable = resultSet.getInt("noofavailable");
                int borrowed = resultSet.getInt("noofborrow");

                // Update availability based on the status
                if ("on-going".equalsIgnoreCase(status)) {
                    noOfAvailable -= changeAmount;
                    borrowed += changeAmount;
                } else if ("done".equalsIgnoreCase(status)) {
                    noOfAvailable += changeAmount;
                    borrowed -= changeAmount;
                }

                // Update the equipment table
                String updateQuery = "UPDATE equipment SET noofavailable = ?, noofborrow = ? WHERE LOWER(equipmentname) = LOWER(?)";

                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, noOfAvailable);
                    updateStatement.setInt(2, borrowed);
                    updateStatement.setString(3, equipmentName.toLowerCase());
                    updateStatement.executeUpdate();
                }
            }
        }
    }
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

								System.out.print(totaldrums);
                            }

                                switch (equipmentName) {
                                    case "drums":
                                        if (totaldrums >= 0) {
                                            drumsquantity -= totaldrums;
                                            System.out.print(drumsquantity);
                                            if (drumsquantity <= 0) {
                                                JOptionPane.showMessageDialog(null, "Equipment is fully booked " + equipmentName,
                                                        "Equipment Not Available", JOptionPane.WARNING_MESSAGE);
                                                drums.setSelected(false);
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
                                                flute.setSelected(false);
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
                                                piano.setSelected(false);
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
                                                acoustic.setSelected(false);
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
                                                electric.setSelected(false);
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
                                                ampli.setSelected(false);
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
                                                mic.setSelected(false);
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
                                                stand.setSelected(false);
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
                                                headphone.setSelected(false);
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
                                                micstand.setSelected(false);
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

}