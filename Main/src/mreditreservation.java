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


public class mreditreservation implements designs {
		JFrame editreservation = new JFrame("Edit Reservation");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	public void editreservations(int getid){
		//EDIT RESERVATION

        JLabel titletexteditreserve = new JLabel("MUSIC ROOM RESERVATION");
        titletexteditreserve.setFont(title);

        JButton editback = new JButton("BACK");
        editback.setFont(listbtn);
        editback.setForeground(Color.WHITE);
        editback.setBackground(cred);

        //declare component
        JLabel editfullname = new JLabel("FULL NAME");
        editfullname.setFont(subtitle);
        JTextField editfulltf = new JTextField();
        editfulltf.setFont(subtitle);

        JLabel editaddress = new JLabel("ADDRESS");
        editaddress.setFont(subtitle);
        JTextField editaddresstf = new JTextField();
        editaddresstf.setFont(subtitle);

        JLabel editcontactnum = new JLabel("CONTACT NUMBER");
        editcontactnum.setFont(subtitle);
        JTextField editcontactnumtf = new JTextField();
        editcontactnumtf.setFont(subtitle);

        JLabel editroomtype = new JLabel("TYPE OF ROOM");
        editroomtype.setFont(subtitle);
        String editroomtypearr [] = {"MUSIC ROOM 1", "MUSIC ROOM 2", "MUSIC ROOM 3", "RECORDING ROOM 1", "RECORDING ROOM 2", "DELUXE ROOM 1","DELUXE ROOM 2"};
        JComboBox editroomtypecb = new JComboBox(editroomtypearr);
        editroomtypecb.setFont(subtitle);
        editroomtypecb.setEnabled(false);
        editroomtypecb.setBackground(lightgray);
        editroomtypecb.setForeground(Color.BLACK);


        JLabel editdatereservation = new JLabel("DATE OF RESERVATION");
        editdatereservation.setFont(subtitle);
        JTextField editdatereservationtf = new JTextField();
        editdatereservationtf.setFont(subtitle);
        editdatereservationtf.setBackground(lightgray);
        editdatereservationtf.setForeground(Color.BLACK);
        editdatereservationtf.setDisabledTextColor(Color.BLACK);
        editdatereservationtf.setEnabled(false);

        JLabel editstarttime = new JLabel("START TIME OF RESERVATION");
        editstarttime.setFont(subtitle);
        JTextField editstarttimetf = new JTextField();
        editstarttimetf.setFont(subtitle);
        editstarttimetf.setBackground(lightgray);
        editstarttimetf.setForeground(Color.BLACK);
        editstarttimetf.setDisabledTextColor(Color.BLACK);
        editstarttimetf.setEnabled(false);

        JLabel editendtime = new JLabel("END TIME OF RESERVATION");
        editendtime.setFont(subtitle);
        JTextField editendtimetf = new JTextField();
        editendtimetf.setFont(subtitle);
        editendtimetf.setBackground(lightgray);
        editendtimetf.setForeground(Color.BLACK);
        editendtimetf.setDisabledTextColor(Color.BLACK);
        editendtimetf.setEnabled(false);

        JLabel editstatus = new JLabel("STATUS");
        editstatus.setFont(subtitle);
        String editstatusarr [] = {"PENDING", "ON-GOING", "DONE"};
        JComboBox editstatuscb = new JComboBox(editstatusarr);
        editstatuscb.setFont(subtitle);
        editstatuscb.setBackground(Color.WHITE);

        JLabel editpax = new JLabel("PAX");
        editpax.setFont(subtitle);
        JTextField editpaxtf = new JTextField(" MAX NUMBER OF PERSON");
        editpaxtf.setFont(subtitle);
        editpaxtf.setBackground(lightgray);
        editpaxtf.setForeground(Color.BLACK);
        editpaxtf.setDisabledTextColor(Color.BLACK);
        editpaxtf.setEnabled(false);

        JLabel editaddpax = new JLabel("ADDITIONAL PAX");
        editaddpax.setFont(subtitle);
        JTextField editaddpaxtf = new JTextField();
        editaddpaxtf.setFont(subtitle);

		JLabel editaddontotal = new JLabel("ADD-ON TOTAL");
        editaddontotal.setFont(subtitle);
        JTextField editaddontotaltf = new JTextField();
        editaddontotaltf.setFont(subtitle);
        editaddontotaltf.setBackground(lightgray);
        editaddontotaltf.setForeground(Color.BLACK);
        editaddontotaltf.setDisabledTextColor(Color.BLACK);
        editaddontotaltf.setEnabled(false);

		JLabel editdownpayment = new JLabel("DOWN PAYMENT");
        editdownpayment.setFont(subtitle);
        JTextField editdownpaymenttf = new JTextField();
        editdownpaymenttf.setFont(subtitle);
        editdownpaymenttf.setBackground(lightgray);
        editdownpaymenttf.setForeground(Color.BLACK);
        editdownpaymenttf.setDisabledTextColor(Color.BLACK);
        editdownpaymenttf.setEnabled(false);

        JLabel edittotal = new JLabel("TOTAL");
        edittotal.setFont(subtitle);
        JTextField edittotaltf = new JTextField();
        edittotaltf.setFont(subtitle);
        edittotaltf.setBackground(lightgray);
        edittotaltf.setForeground(Color.BLACK);
        edittotaltf.setDisabledTextColor(Color.BLACK);
        edittotaltf.setEnabled(false);

        JLabel editgrandtotal = new JLabel("GRAND TOTAL");
        editgrandtotal.setFont(subtitle);
        JTextField editgrandtotaltf = new JTextField();
        editgrandtotaltf.setFont(subtitle);
        editgrandtotaltf.setBackground(lightgray);
        editgrandtotaltf.setForeground(Color.BLACK);
        editgrandtotaltf.setDisabledTextColor(Color.BLACK);
        editgrandtotaltf.setEnabled(false);


		JLabel editaddonequip = new JLabel("ADD-ON EQUIPMENTS");
		editaddonequip.setFont(list);

		JCheckBox editdrums = new JCheckBox("DRUMS");
        editdrums.setFont(subtitle);
        editdrums.setBackground(Color.WHITE);

        JCheckBox editflute = new JCheckBox("FLUTE");
        editflute.setFont(subtitle);
        editflute.setBackground(Color.WHITE);

        JCheckBox editpiano = new JCheckBox("PIANO");
        editpiano.setFont(subtitle);
        editpiano.setBackground(Color.WHITE);

        JCheckBox editacoustic = new JCheckBox("ACOUSTIC GUITAR");
        editacoustic.setFont(subtitle);
        editacoustic.setBackground(Color.WHITE);

        JCheckBox editelectric = new JCheckBox("ELECTRIC GUITAR");
        editelectric.setFont(subtitle);
        editelectric.setBackground(Color.WHITE);

        JCheckBox editampli = new JCheckBox("AMPLIFIER");
        editampli.setFont(subtitle);
        editampli.setBackground(Color.WHITE);

        JCheckBox editmic = new JCheckBox("MICROPHONE");
        editmic.setFont(subtitle);
        editmic.setBackground(Color.WHITE);

        JCheckBox editstand = new JCheckBox("MUSIC STAND");
        editstand.setFont(subtitle);
        editstand.setBackground(Color.WHITE);

        JCheckBox editheadphone = new JCheckBox("HEADPHONE");
        editheadphone.setFont(subtitle);
        editheadphone.setBackground(Color.WHITE);

        JCheckBox editmicstand = new JCheckBox("MIC STAND");
        editmicstand.setFont(subtitle);
        editmicstand.setBackground(Color.WHITE);

       	JButton editaddonsbox = new JButton();
		editaddonsbox.setBackground(Color.WHITE);
		editaddonsbox.setEnabled(false);

		JButton editcompute = new JButton("COMPUTE");
		editcompute.setFont(comp);
		editcompute.setBackground(cred);
        editcompute.setForeground(Color.WHITE);

		JButton editreserve = new JButton("RESERVE");
		editreserve.setEnabled(false);
		editreserve.setBackground(cgreen);
		editreserve.setFont(comp);
        editreserve.setForeground(Color.WHITE);


		//actions
		editback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String roomtype = editroomtypecb.getSelectedItem().toString();
				editreservation.setVisible(false);
				mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();
	    	}
		});
		//database sql
        try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
	    Statement statement = connection.createStatement();

	    String sqlQuery = "SELECT * FROM reservation WHERE id = " + getid;
		System.out.print(getid);
	    ResultSet rSet = statement.executeQuery(sqlQuery);

	    while (rSet.next()) {
	    	int editgetid = rSet.getInt(1);
	        String editgetfullname = rSet.getString(2);
	        String editgetaddress = rSet.getString(3);
	        String editgetcontactnumber = rSet.getString(4);
	        String editgettypeofroom = rSet.getString(5);
	        String editgetdate = String.valueOf(rSet.getDate(6));
			String editgetstarttime = String.valueOf(rSet.getTime(7));
			String editgetendtime = String.valueOf(rSet.getTime(8));
	        String editgetstatus = rSet.getString(9);
	        String editgetpax= String.valueOf(rSet.getInt(10));
	        String editgetadditionalpax = String.valueOf(rSet.getInt(11));
	        String editgetaddontotal= String.valueOf(rSet.getInt(12));
	        String editgetdownpayment = String.valueOf(rSet.getInt(13));
	        String editgettotal = String.valueOf(rSet.getInt(14));
	        String editgetgrandtotal = String.valueOf(rSet.getInt(15));
	        String editgetdrums = String.valueOf(rSet.getInt(16));
	        String editgetflute = String.valueOf(rSet.getInt(17));
	        String editgetpiano = String.valueOf(rSet.getInt(18));
	        String editgetacoustic = String.valueOf(rSet.getInt(19));
	        String editgetelectric = String.valueOf(rSet.getInt(20));
	        String editgetamplifier = String.valueOf(rSet.getInt(21));
	        String editgetmicrophone = String.valueOf(rSet.getInt(22));
	        String editgetmusicstand = String.valueOf(rSet.getInt(23));
	        String editgetheadphone = String.valueOf(rSet.getInt(24));
	        String editgetmicstand = String.valueOf(rSet.getInt(25));

			DateFormat targetFormat = new SimpleDateFormat("M/d/yyyy");
        	String editgetdatereserve = targetFormat.format(rSet.getDate(6));

        	DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	        String formattedStartTime = timeFormat.format(rSet.getTime(7));
	        String formattedEndTime = timeFormat.format(rSet.getTime(8));

		    editfulltf.setText(editgetfullname);
		   	editaddresstf.setText(editgetaddress);
		    editcontactnumtf.setText(editgetcontactnumber);
		    editroomtypecb.setSelectedItem(editgettypeofroom);
		    editdatereservationtf.setText(editgetdatereserve);
	        editstarttimetf.setText(formattedStartTime);
	        editendtimetf.setText(formattedEndTime);
		    editstatuscb.setSelectedItem(editgetstatus);
		    editpaxtf.setText(editgetpax);
		    editaddpaxtf.setText(editgetadditionalpax);
		    editaddontotaltf.setText(editgetaddontotal);
		    editdownpaymenttf.setText(editgetdownpayment);
		    edittotaltf.setText(editgettotal);
		    editgrandtotaltf.setText(editgetgrandtotal);


		    if (editgetdrums.equals("1")){	editdrums.setSelected(true);			} else {	editdrums.setSelected(false);	}
		    if (editgetflute.equals("1")){	editflute.setSelected(true);			} else {	editflute.setSelected(false);	}
		    if (editgetpiano.equals("1")){	editpiano.setSelected(true);			} else {	editpiano.setSelected(false);	}
		    if (editgetacoustic.equals("1")){	editacoustic.setSelected(true);		} else {	editacoustic.setSelected(false);	}
		    if (editgetelectric.equals("1")){	editelectric.setSelected(true);		} else {	editelectric.setSelected(false);	}
		    if (editgetamplifier.equals("1")){	editampli.setSelected(true);		} else {	editampli.setSelected(false);	}
		    if (editgetmicrophone.equals("1")){	editmic.setSelected(true);			} else {	editmic.setSelected(false);	}
		    if (editgetmusicstand.equals("1")){	editstand.setSelected(true);		} else {	editstand.setSelected(false);	}
		    if (editgetheadphone.equals("1")){	editheadphone.setSelected(true);	} else {	editheadphone.setSelected(false);	}
		    if (editgetmicstand.equals("1")){	editmicstand.setSelected(true);	} else {	editmicstand.setSelected(false);	}
	}
	    connection.close();
	} catch (Exception e) {
	    System.out.println(e);
	}


		editroomtypecb.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String roomtype = editroomtypecb.getSelectedItem().toString();
			if (roomtype.equalsIgnoreCase("MUSIC ROOM 1") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 2") ||
					    roomtype.equalsIgnoreCase("MUSIC ROOM 3")) {
					    editpaxtf.setText("7");
					} else if (roomtype.equalsIgnoreCase("RECORDING ROOM 1") ||
					           roomtype.equalsIgnoreCase("RECORDING ROOM 2")) {
					     editpaxtf.setText("7");
					} else {
					   	 editpaxtf.setText("15");
					}
	    	}
		});
		editcontactnumtf.addKeyListener(new KeyAdapter() {
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

        editaddpaxtf.addKeyListener(new KeyAdapter() {
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


	editcompute.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String fullname = editfulltf.getText();
        String address = editaddresstf.getText();
        String contactnum = editcontactnumtf.getText();
        String roomtype = editroomtypecb.getSelectedItem().toString();
        String datereservation = editdatereservationtf.getText();
        String starttime = editstarttimetf.getText();
        String endtime = editendtimetf.getText();
        String status = editstatuscb.getSelectedItem().toString();
        String addonpax = editaddpaxtf.getText();

        try {

		   if (fullname.isEmpty() || address.isEmpty() || contactnum.isEmpty() || datereservation.isEmpty() || starttime.isEmpty() || endtime.isEmpty() || addonpax.isEmpty()) {
		   JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
		   return;
		   }
		   if (!isValidDateFormat(datereservation) || !isValidTimeFormat(starttime) || !isValidTimeFormat(endtime)) {
		       JOptionPane.showMessageDialog(null, "Invalid date or time format. Please check your input. \n     Examples:    Date: 1/1/2024     Time: 12:00 AM");
		       return;
		   }
            int pax = 0;
            int roomrate = 0;
            int addpaxrate = 0;
            int totaladdpax = 0;
            int addontotal = 0;
            int downpayment = 0;
            int total = 0;
            int grandtotal = 0;

            try {

		            LocalTime start = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("h:mm a"));
			        LocalTime end = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("h:mm a"));

			        // Calculate duration
			        Duration duration = Duration.between(start, end);
			        long hours = duration.toHours();
			        int totalhours = (int) hours;

                    int addpax = Integer.parseInt(editaddpaxtf.getText());


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
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid value for Pax. Please enter a valid number.");
                return;
            }

            if (editdrums.isSelected()) { addontotal += 500; }
            if (editflute.isSelected()) { addontotal += 500; }
            if (editpiano.isSelected()) { addontotal += 500; }
            if (editacoustic.isSelected()) { addontotal += 500; }
            if (editelectric.isSelected()) { addontotal += 500; }
            if (editampli.isSelected()) { addontotal += 400; }
            if (editmic.isSelected()) { addontotal += 100; }
            if (editstand.isSelected()) { addontotal += 100; }
            if (editheadphone.isSelected()) { addontotal += 100; }
            if (editmicstand.isSelected()) { addontotal += 100; }

            grandtotal = total + addontotal;
            downpayment = grandtotal / 2;

            editaddontotaltf.setText(String.valueOf(addontotal));
            editdownpaymenttf.setText(String.valueOf(downpayment));
            edittotaltf.setText(String.valueOf(total));
            editgrandtotaltf.setText(String.valueOf(grandtotal));

            editreserve.setEnabled(true);

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



	editreserve.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String fullname = editfulltf.getText();
        String address = editaddresstf.getText();
        String contactnum = editcontactnumtf.getText();
        String roomtype = editroomtypecb.getSelectedItem().toString();
        String datereservation = editdatereservationtf.getText();
        String starttime = editstarttimetf.getText();
        String endtime = editendtimetf.getText();
        String status = editstatuscb.getSelectedItem().toString();
        int pax = Integer.parseInt(editpaxtf.getText());
        int addpax = Integer.parseInt(editaddpaxtf.getText());
        int addontotal = Integer.parseInt(editaddontotaltf.getText());
        int total = Integer.parseInt(edittotaltf.getText());
        int downpayment = Integer.parseInt(editdownpaymenttf.getText());
        int grandtotal = Integer.parseInt(editgrandtotaltf.getText());
        int drumsch = editdrums.isSelected() ? 1 : 0;
        int flutech = editflute.isSelected() ? 1 : 0;
        int pianoch = editpiano.isSelected() ? 1 : 0;
        int acousticch = editacoustic.isSelected() ? 1 : 0;
        int electricch = editelectric.isSelected() ? 1 : 0;
        int amplifierch = editampli.isSelected() ? 1 : 0;
        int micch = editmic.isSelected() ? 1 : 0;
        int musicstandch = editstand.isSelected() ? 1 : 0;
        int headphonech = editheadphone.isSelected() ? 1 : 0;
        int micstandch = editmicstand.isSelected() ? 1 : 0;

        try {
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
            connection.setAutoCommit(false);

            String sqlUpdate = "UPDATE reservation SET fullname=?, address=?, contactnumber=?, typeofroom=?, datereserve=?, starttime=?, endtime=?, status=?, pax=?, additionalpax=?, addontotal=?, downpayment=?, total=?, grandtotal=?, drums=?, flute=?, piano=?, acoustic=?, electric=?, amplifier=?, microphone=?, musicstand=?, headphone=?, micstand=? WHERE id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {
                preparedStatement.setString(1, fullname);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, contactnum);
                preparedStatement.setString(4, roomtype);
                LocalDate localDate = LocalDate.parse(datereservation, DateTimeFormatter.ofPattern("M/d/yyyy"));
                preparedStatement.setDate(5, java.sql.Date.valueOf(localDate));
                LocalTime localStartTime = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("h:mm a"));
                LocalTime localEndTime = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("h:mm a"));
                preparedStatement.setTime(6, java.sql.Time.valueOf(localStartTime));
                preparedStatement.setTime(7, java.sql.Time.valueOf(localEndTime));
                preparedStatement.setString(8, status);
                preparedStatement.setInt(9, pax);
                preparedStatement.setInt(10, addpax);
                preparedStatement.setInt(11, addontotal);
                preparedStatement.setInt(12, downpayment);
                preparedStatement.setInt(13, total);
                preparedStatement.setInt(14, grandtotal);
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
                preparedStatement.setInt(25, getid);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);

                connection.commit();
                JOptionPane.showMessageDialog(null, "Reservation Updated Successful!");
            } catch (SQLException ex) {
                // Handle exceptions and rollback the transaction
                if (connection != null) {
                    connection.rollback();
                }
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating reservation. Please check your input.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
        }
    }
});

        //borders
       	editfulltf.setBorder(new LineBorder(Color.BLACK, 2));
       	editaddresstf.setBorder(new LineBorder(Color.BLACK, 2));
		editcontactnumtf.setBorder(new LineBorder(Color.BLACK, 2));
		editdatereservationtf.setBorder(new LineBorder(Color.BLACK, 2));
		editroomtypecb.setBorder(new LineBorder(Color.BLACK, 2));
		editstarttimetf.setBorder(new LineBorder(Color.BLACK, 2));
		editendtimetf.setBorder(new LineBorder(Color.BLACK, 2));
		editstatuscb.setBorder(new LineBorder(Color.BLACK, 2));
		editpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		editaddpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		editaddontotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		editdownpaymenttf.setBorder(new LineBorder(Color.BLACK, 2));
		edittotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		editgrandtotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		editaddonsbox.setBorder(new LineBorder(Color.BLACK, 1));
		editcompute.setBorder(new LineBorder(cred, 2));
		editreserve.setBorder(new LineBorder(cgreen, 2));

		//add components
		editreservation.add(titletexteditreserve);
		editreservation.add(editback);
		editreservation.add(editfullname);
		editreservation.add(editaddress);
		editreservation.add(editcontactnum);
		editreservation.add(editroomtype);
		editreservation.add(editdatereservation);
		editreservation.add(editstarttime);
		editreservation.add(editendtime);
		editreservation.add(editstatus);
		editreservation.add(editpax);
		editreservation.add(editaddpax);
		editreservation.add(editfulltf);
		editreservation.add(editaddresstf);
		editreservation.add(editcontactnumtf);
		editreservation.add(editroomtypecb);
		editreservation.add(editdatereservationtf);
		editreservation.add(editstarttimetf);
		editreservation.add(editendtimetf);
		editreservation.add(editstatuscb);
		editreservation.add(editpaxtf);
		editreservation.add(editaddpaxtf);
		editreservation.add(editaddontotal);
		editreservation.add(editaddontotaltf);
		editreservation.add(editdownpayment);
		editreservation.add(editdownpaymenttf);
		editreservation.add(edittotal);
		editreservation.add(edittotaltf);
		editreservation.add(editgrandtotal);
		editreservation.add(editgrandtotaltf);
		editreservation.add(editaddonequip);
		editreservation.add(editdrums);
		editreservation.add(editflute);
		editreservation.add(editpiano);
		editreservation.add(editacoustic);
		editreservation.add(editelectric);
		editreservation.add(editampli);
		editreservation.add(editmic);
		editreservation.add(editstand);
		editreservation.add(editheadphone);
		editreservation.add(editmicstand);
		editreservation.add(editaddonsbox);
		editreservation.add(editcompute);
		editreservation.add(editreserve);


		//setbounds edit reservation
		titletexteditreserve.setBounds(110, 0, 800, 70);
		editback.setBounds(20, 20, 75, 30);
		editfullname.setBounds(30, 74, 220, 30);
		editfulltf.setBounds(30, 101, 240, 30);
		editaddress.setBounds(30, 137, 220, 30);
		editaddresstf.setBounds(30, 164, 240, 30);
		editcontactnum.setBounds(30, 200, 220, 30);
		editcontactnumtf.setBounds(30, 227, 240, 30);
		editroomtype.setBounds(30, 263, 220, 30);
		editroomtypecb.setBounds(30, 290, 240, 30);
		editdatereservation.setBounds(30, 325, 220, 30);
		editdatereservationtf.setBounds(30, 352, 240, 30);
		editstarttime.setBounds(300, 74, 220, 30);
		editstarttimetf.setBounds(300, 101, 240, 30);
		editendtime.setBounds(300, 137, 220, 30);
		editendtimetf.setBounds(300, 164, 240, 30);
		editstatus.setBounds(300, 200, 220, 30);
		editstatuscb.setBounds(300, 227, 240, 30);
		editpax.setBounds(300, 263, 220, 30);
		editpaxtf.setBounds(300, 290, 240, 30);
		editaddpax.setBounds(300, 325, 220, 30);
		editaddpaxtf.setBounds(300, 352, 240, 30);
		editaddontotal.setBounds(33, 462, 150, 30);
		editaddontotaltf.setBounds(160, 462, 150, 30);
		editdownpayment.setBounds(30, 507, 150, 30);
		editdownpaymenttf.setBounds(160, 507, 150, 30);
		edittotal.setBounds(355, 462, 150, 30);
		edittotaltf.setBounds(445, 462, 150, 30);
		editgrandtotal.setBounds(330, 507, 150, 30);
		editgrandtotaltf.setBounds(445, 507, 150, 30);
		editaddonequip.setBounds(585, 88, 270, 30);
		editdrums.setBounds(590, 120, 150, 30);
		editflute.setBounds(590, 150, 150, 30);
		editpiano.setBounds(590, 180, 150, 30);
		editacoustic.setBounds(590, 210, 200, 30);
		editelectric.setBounds(590, 240, 150, 30);
		editampli.setBounds(590, 270, 150, 30);
		editmic.setBounds(590, 300, 150, 30);
		editstand.setBounds(590, 330, 150, 30);
		editheadphone.setBounds(590, 360, 150, 30);
		editmicstand.setBounds(590, 390, 150, 30);
		editaddonsbox.setBounds(570, 80, 285, 350);
		editcompute.setBounds(645, 450, 180, 40);
		editreserve.setBounds(645, 500, 180, 40);
		editreservation.setBounds(100, 50, 900, 600);

        // bg
        editreservation.getContentPane().setBackground(Color.WHITE);
        editreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editreservation.setLayout(null);
        editreservation.setVisible(true);


	}
}
