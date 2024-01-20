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


public class mraddreservation implements designs {
		JFrame addreservation = new JFrame("Add Reservation");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
		private JTextField fulltf;
		private JTextField addresstf;
		private JTextField contactnumtf;
		private JComboBox roomtypecb;
		private JTextField datereservationtf;
		private JTextField starttimetf;
		private JTextField endtimetf;
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
        datereservationtf = new JTextField(" (MM/DD/YYYY) ");
        datereservationtf.setFont(subtitle);

		datereservationtf.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent e) {
		    	datereservationtf.setText("");
		    }
        });

        JLabel starttime = new JLabel("START TIME OF RESERVATION *");
        starttime.setFont(subtitle);
        starttimetf = new JTextField(" (HH:MM AM/PM) ");
        starttimetf.setFont(subtitle);
       	starttimetf.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent e) {
		    	starttimetf.setText("");
		    }
        });

        JLabel endtime = new JLabel("END TIME OF RESERVATION *");
        endtime.setFont(subtitle);
        endtimetf = new JTextField("(HH:MM AM/PM)");
        endtimetf.setFont(subtitle);
		endtimetf.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	endtimetf.setText("");
		    }
        });

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

		JLabel addontotal = new JLabel("ADD-ON TOTAL");
        addontotal.setFont(subtitle);
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
		        String datereservation = datereservationtf.getText();
		        String starttime = starttimetf.getText();
		        String endtime = endtimetf.getText();
		        String addonpax = addpaxtf.getText();
		        String status = statuscb.getSelectedItem().toString();

		        try {
		            int addpax = 0;
		            if (!addpaxtf.getText().isEmpty()) {
		                addpax = Integer.parseInt(addpaxtf.getText());
		            }

		            if (fullname.isEmpty() || address.isEmpty() || contactnum.isEmpty() || datereservation.isEmpty() || starttime.isEmpty() || endtime.isEmpty() || addonpax.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
		                return;
		            }
		            if (!isValidDateFormat(datereservation) || !isValidTimeFormat(starttime) || !isValidTimeFormat(endtime)) {
		                JOptionPane.showMessageDialog(null, "Invalid date or time format. Please check your input. \n     Examples:    Date: 1/1/2024     Time: 12:00 AM");
		                return;
		            }
		            if (!checkForTimeOverlap(datereservation, starttimetf.getText(), endtimetf.getText(), roomtypecb.getSelectedItem().toString())) {
                    	reserve.setEnabled(true);
                	}


		            int pax = 0;
		            int roomrate = 0;
		            int addpaxrate = 0;
		            int totaladdpax = 0;
		            int addontotal = 0;
		            int downpayment = 0;
		            int total = 0;
		            int grandtotal = 0;

		            LocalTime start = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("h:mm a"));
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

		            if (drums.isSelected()) { addontotal += 500; }
		            if (flute.isSelected()) { addontotal += 500; }
		            if (piano.isSelected()) { addontotal += 500; }
		            if (acoustic.isSelected()) { addontotal += 500; }
		            if (electric.isSelected()) { addontotal += 500; }
		            if (ampli.isSelected()) { addontotal += 400; }
		            if (mic.isSelected()) { addontotal += 100; }
		            if (stand.isSelected()) { addontotal += 100; }
		            if (headphone.isSelected()) { addontotal += 100; }
		            if (micstand.isSelected()) { addontotal += 100; }

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
				private boolean isValidTimeFormat(String time) {
			        try {
			            LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mm a"));
			            return true;
			        } catch (DateTimeParseException e) {
			            return false;
			        }
			    }
			    private boolean isValidDateFormat(String date) {
			        try {
			            LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
			            return true;
			        } catch (DateTimeParseException e) {
			            return false;
			        }
			    }

		});


		reserve.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
		    	String fullname = fulltf.getText();
		    	String address = addresstf .getText();
		    	String contactnum = contactnumtf.getText();
		    	String roomtype = roomtypecb.getSelectedItem().toString();
		    	String datereservation = datereservationtf.getText();
		    	String starttime = starttimetf.getText();
		    	String endtime = endtimetf.getText();
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

		            if (drums.isSelected()) { drumsch = 1; }
		            if (flute.isSelected()) { flutech = 1; }
		            if (piano.isSelected()) { pianoch = 1; }
		            if (acoustic.isSelected()) { acousticch = 1; }
		            if (electric.isSelected()) { electricch = 1; }
		            if (ampli.isSelected()) { amplifierch = 1; }
		            if (mic.isSelected()) { micch = 1; }
		            if (stand.isSelected()) { musicstandch = 1;}
		            if (headphone.isSelected()) { headphonech = 1;}
		            if (micstand.isSelected()) { micstandch = 1; }

				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
				    String sql = "INSERT INTO reservation (fullname, address, contactnumber, typeofroom, datereserve, starttime, endtime, status, pax, additionalpax, addontotal, downpayment, grandtotal, total, drums, flute, piano, acoustic, electric, amplifier, microphone, musicstand, headphone, micstand) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				        preparedStatement.setString(1, fullname);
				        preparedStatement.setString(2, address);
				        preparedStatement.setString(3, contactnum);
				        preparedStatement.setString(4, roomtype);
				        LocalDate localDate = LocalDate.parse(datereservation, DateTimeFormatter.ofPattern("M/d/yyyy"));
				        preparedStatement.setDate(5, java.sql.Date.valueOf(localDate));
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

				        preparedStatement.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Reservation Successfull!");
				        clearaddreservation();
				   }

				    connection.close();
				} catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "ERROR" + ex);
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
		addreservation.add(addontotal);
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
		starttimetf.setBounds(300, 101, 240, 30);
		endtime.setBounds(300, 137, 220, 30);
		endtimetf.setBounds(300, 164, 240, 30);
		status.setBounds(300, 200, 220, 30);
		statuscb.setBounds(300, 227, 240, 30);
		pax.setBounds(300, 263, 220, 30);
		paxtf.setBounds(300, 290, 240, 30);
		addpax.setBounds(300, 325, 220, 30);
		addpaxtf.setBounds(300, 352, 240, 30);
		addontotal.setBounds(33, 462, 150, 30);
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
		    datereservationtf.setText("");
		    starttimetf.setText("");
		    endtimetf.setText("");
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
        // Convert "mm-dd-yyyy" to "yyyy-MM-dd"
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        java.util.Date formattedDate = inputDateFormat.parse(date);
        String formattedDateString = outputDateFormat.format(formattedDate);

        // Convert "hh:mm a" to "HH:mm:ss"
        SimpleDateFormat inputTimeFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat outputTimeFormat = new SimpleDateFormat("HH:mm:ss");

        java.util.Date startDate = inputTimeFormat.parse(startTime);
        String formattedStartTime = outputTimeFormat.format(startDate);

        java.util.Date endDate = inputTimeFormat.parse(endTime);
        String formattedEndTime = outputTimeFormat.format(endDate);

        // Check for time overlap with room type condition
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
            String query = "SELECT * FROM reservation WHERE datereserve = ? AND typeofroom = ? AND " +
                           "((starttime < ? AND endtime > ?) OR " +
                           "(starttime < ? AND endtime > ?) OR " +
                           "(starttime >= ? AND endtime <= ?))";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, formattedDateString);
                preparedStatement.setString(2, roomtype);
                preparedStatement.setString(3, formattedStartTime);
                preparedStatement.setString(4, formattedStartTime);
                preparedStatement.setString(5, formattedStartTime);
                preparedStatement.setString(6, formattedEndTime);
                preparedStatement.setString(7, formattedStartTime);
                preparedStatement.setString(8, formattedEndTime);

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
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error parsing date/time: " + e.getMessage());
    }

    return false;
}


}