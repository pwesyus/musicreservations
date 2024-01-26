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


public class mrviewreservation implements designs {
		JFrame viewreservation = new JFrame("View Reservation");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	public void viewreservations(int getid){

        //VIEW RESERVATION
        JLabel titletextviewreserve = new JLabel("MUSIC ROOM RESERVATION");
        titletextviewreserve.setFont(title);

        //declare component
        JLabel viewfullname = new JLabel("FULL NAME");
        viewfullname.setFont(subtitle);
        JTextField viewfulltf = new JTextField();
        viewfulltf.setFont(subtitle);
        viewfulltf.setBackground(lightgray);
        viewfulltf.setForeground(Color.BLACK);
        viewfulltf.setDisabledTextColor(Color.BLACK);
        viewfulltf.setEnabled(false);

        JLabel viewaddress = new JLabel("ADDRESS");
        viewaddress.setFont(subtitle);
        JTextField viewaddresstf = new JTextField();
        viewaddresstf.setFont(subtitle);
        viewaddresstf.setBackground(lightgray);
        viewaddresstf.setForeground(Color.BLACK);
        viewaddresstf.setDisabledTextColor(Color.BLACK);
        viewaddresstf.setEnabled(false);

        JLabel viewcontactnum = new JLabel("CONTACT NUMBER");
        viewcontactnum.setFont(subtitle);
        JTextField viewcontactnumtf = new JTextField();
        viewcontactnumtf.setFont(subtitle);
        viewcontactnumtf.setBackground(lightgray);
        viewcontactnumtf.setForeground(Color.BLACK);
        viewcontactnumtf.setDisabledTextColor(Color.BLACK);
        viewcontactnumtf.setEnabled(false);

        JLabel viewroomtype = new JLabel("TYPE OF ROOM");
        viewroomtype.setFont(subtitle);
        String viewroomtypearr [] = {"MUSIC ROOM 1", "MUSIC ROOM 2", "MUSIC ROOM 3", "RECORDING ROOM 1", "RECORDING ROOM 2", "DELUXE ROOM 1","DELUXE ROOM 2"};
        JComboBox viewroomtypecb = new JComboBox(viewroomtypearr);
        viewroomtypecb.setFont(subtitle);
        viewroomtypecb.setBackground(Color.WHITE);
        viewroomtypecb.setEnabled(false);

        JLabel viewdatereservation = new JLabel("DATE OF RESERVATION");
        viewdatereservation.setFont(subtitle);
        JTextField viewdatereservationtf = new JTextField();
        viewdatereservationtf.setFont(subtitle);
        viewdatereservationtf.setBackground(lightgray);
        viewdatereservationtf.setForeground(Color.BLACK);
        viewdatereservationtf.setDisabledTextColor(Color.BLACK);
        viewdatereservationtf.setEnabled(false);

        JLabel viewstarttime = new JLabel("START TIME OF RESERVATION");
        viewstarttime.setFont(subtitle);
        JTextField viewstarttimetf = new JTextField();
        viewstarttimetf.setFont(subtitle);
        viewstarttimetf.setBackground(lightgray);
        viewstarttimetf.setForeground(Color.BLACK);
        viewstarttimetf.setDisabledTextColor(Color.BLACK);
        viewstarttimetf.setEnabled(false);

        JLabel viewendtime = new JLabel("END TIME OF RESERVATION");
        viewendtime.setFont(subtitle);
        JTextField viewendtimetf = new JTextField();
        viewendtimetf.setBackground(lightgray);
        viewendtimetf.setForeground(Color.BLACK);
        viewendtimetf.setDisabledTextColor(Color.BLACK);
        viewendtimetf.setFont(subtitle);
        viewendtimetf.setEnabled(false);

        JLabel viewstatus = new JLabel("STATUS");
        viewstatus.setFont(subtitle);
        String viewstatusarr [] = {"PENDING", "ON-GOING", "DONE"};
        JComboBox viewstatuscb = new JComboBox(viewstatusarr);
        viewstatuscb.setFont(subtitle);
        viewstatuscb.setBackground(Color.WHITE);
        viewstatuscb.setEnabled(false);

        JLabel viewpax = new JLabel("PAX");
        viewpax.setFont(subtitle);
        JTextField viewpaxtf = new JTextField(" MAX NUMBER OF PERSON");
        viewpaxtf.setFont(subtitle);
        viewpaxtf.setBackground(lightgray);
        viewpaxtf.setForeground(Color.BLACK);
        viewpaxtf.setDisabledTextColor(Color.BLACK);
        viewpaxtf.setEnabled(false);

        JLabel viewaddpax = new JLabel("ADDITIONAL PAX");
        viewaddpax.setFont(subtitle);
        JTextField viewaddpaxtf = new JTextField();
        viewaddpaxtf.setBackground(lightgray);
        viewaddpaxtf.setForeground(Color.BLACK);
        viewaddpaxtf.setDisabledTextColor(Color.BLACK);
        viewaddpaxtf.setEnabled(false);

		JLabel viewaddontotal = new JLabel("ADD-ON TOTAL");
        viewaddontotal.setFont(subtitle);
        JTextField viewaddontotaltf = new JTextField();
        viewaddontotaltf.setFont(subtitle);
        viewaddontotaltf.setBackground(lightgray);
        viewaddontotaltf.setForeground(Color.BLACK);
        viewaddontotaltf.setDisabledTextColor(Color.BLACK);
        viewaddontotaltf.setEnabled(false);

		JLabel viewdownpayment = new JLabel("DOWN PAYMENT");
        viewdownpayment.setFont(subtitle);
        JTextField viewdownpaymenttf = new JTextField();
        viewdownpaymenttf.setFont(subtitle);
        viewdownpaymenttf.setBackground(lightgray);
        viewdownpaymenttf.setForeground(Color.BLACK);
        viewdownpaymenttf.setDisabledTextColor(Color.BLACK);
        viewdownpaymenttf.setEnabled(false);

        JLabel viewtotal = new JLabel("TOTAL");
        viewtotal.setFont(subtitle);
        JTextField viewtotaltf = new JTextField();
        viewtotaltf.setFont(subtitle);
        viewtotaltf.setBackground(lightgray);
        viewtotaltf.setForeground(Color.BLACK);
        viewtotaltf.setDisabledTextColor(Color.BLACK);
        viewtotaltf.setEnabled(false);

        JLabel viewgrandtotal = new JLabel("GRAND TOTAL");
        viewgrandtotal.setFont(subtitle);
        JTextField viewgrandtotaltf = new JTextField();
        viewgrandtotaltf.setFont(subtitle);
        viewgrandtotaltf.setBackground(lightgray);
        viewgrandtotaltf.setForeground(Color.BLACK);
        viewgrandtotaltf.setDisabledTextColor(Color.BLACK);
        viewgrandtotaltf.setEnabled(false);


		JLabel viewaddonequip = new JLabel("ADD-ON EQUIPMENTS");
		viewaddonequip.setFont(list);

		JCheckBox viewdrums = new JCheckBox("DRUMS");
        viewdrums.setFont(subtitle);
        viewdrums.setBackground(Color.WHITE);
        viewdrums.setEnabled(false);


        JCheckBox viewflute = new JCheckBox("FLUTE");
        viewflute.setFont(subtitle);
        viewflute.setBackground(Color.WHITE);
        viewflute.setEnabled(false);

        JCheckBox viewpiano = new JCheckBox("PIANO");
       	viewpiano.setFont(subtitle);
        viewpiano.setBackground(Color.WHITE);
        viewpiano.setEnabled(false);

        JCheckBox viewacoustic = new JCheckBox("ACOUSTIC GUITAR");
        viewacoustic.setFont(subtitle);
        viewacoustic.setBackground(Color.WHITE);
        viewacoustic.setEnabled(false);

        JCheckBox viewelectric = new JCheckBox("ELECTRIC GUITAR");
        viewelectric.setFont(subtitle);
        viewelectric.setBackground(Color.WHITE);
        viewelectric.setEnabled(false);

        JCheckBox viewampli = new JCheckBox("AMPLIFIER");
        viewampli.setFont(subtitle);
        viewampli.setBackground(Color.WHITE);
        viewampli.setEnabled(false);

        JCheckBox viewmic = new JCheckBox("MICROPHONE");
        viewmic.setFont(subtitle);
        viewmic.setBackground(Color.WHITE);
        viewmic.setEnabled(false);

        JCheckBox viewstand = new JCheckBox("MUSIC STAND");
        viewstand.setFont(subtitle);
        viewstand.setBackground(Color.WHITE);
        viewstand.setEnabled(false);

        JCheckBox viewheadphone = new JCheckBox("HEADPHONE");
        viewheadphone.setFont(subtitle);
        viewheadphone.setBackground(Color.WHITE);
        viewheadphone.setEnabled(false);

        JCheckBox viewmicstand = new JCheckBox("MIC STAND");
        viewmicstand.setFont(subtitle);
        viewmicstand.setBackground(Color.WHITE);
        viewmicstand.setEnabled(false);

       	JButton viewaddonsbox = new JButton();
		viewaddonsbox.setBackground(Color.WHITE);
		viewaddonsbox.setEnabled(false);

		JButton viewreserve = new JButton("BACK");
		viewreserve.setBackground(cred);
		viewreserve.setFont(comp);
        viewreserve.setForeground(Color.WHITE);

		//actions
		viewreserve.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				viewreservation.setVisible(false);
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
	        String viewgetfullname = rSet.getString(2);
	        String viewgetaddress = rSet.getString(3);
	        String viewgetcontactnumber = rSet.getString(4);
	        String viewgettypeofroom = rSet.getString(5);
	        String viewgetdate = String.valueOf(rSet.getDate(6));
			String viewgetstarttime = String.valueOf(rSet.getTime(7));
			String viewgetendtime = String.valueOf(rSet.getTime(8));
	        String viewgetstatus = rSet.getString(9);
	        String viewgetpax= String.valueOf(rSet.getInt(10));
	        String viewgetadditionalpax = String.valueOf(rSet.getInt(11));
	        String viewgetaddontotal= String.valueOf(rSet.getInt(12));
	        String viewgetdownpayment = String.valueOf(rSet.getInt(13));
	        String viewgettotal = String.valueOf(rSet.getInt(14));
	        String viewgetgrandtotal = String.valueOf(rSet.getInt(15));
	        String viewgetdrums = String.valueOf(rSet.getInt(16));
	        String viewgetflute = String.valueOf(rSet.getInt(17));
	        String viewgetpiano = String.valueOf(rSet.getInt(18));
	        String viewgetacoustic = String.valueOf(rSet.getInt(19));
	        String viewgetelectric = String.valueOf(rSet.getInt(20));
	        String viewgetamplifier = String.valueOf(rSet.getInt(21));
	        String viewgetmicrophone = String.valueOf(rSet.getInt(22));
	        String viewgetmusicstand = String.valueOf(rSet.getInt(23));
	        String viewgetheadphone = String.valueOf(rSet.getInt(24));
	        String viewgetmicstand = String.valueOf(rSet.getInt(25));

			DateFormat targetFormat = new SimpleDateFormat("M/d/yyyy");
        	String viewgetdatereserve = targetFormat.format(rSet.getDate(6));

        	DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	        String formattedStartTime = timeFormat.format(rSet.getTime(7));
	        String formattedEndTime = timeFormat.format(rSet.getTime(8));

		    viewfulltf.setText(viewgetfullname);
		   	viewaddresstf.setText(viewgetaddress);
		    viewcontactnumtf.setText(viewgetcontactnumber);
		    viewroomtypecb.setSelectedItem(viewgettypeofroom);
		    viewdatereservationtf.setText(viewgetdatereserve);
	        viewstarttimetf.setText(formattedStartTime);
	        viewendtimetf.setText(formattedEndTime);
		    viewstatuscb.setSelectedItem(viewgetstatus);
		    viewpaxtf.setText(viewgetpax);
		    viewaddpaxtf.setText(viewgetadditionalpax);
		    viewaddontotaltf.setText(viewgetaddontotal);
		    viewdownpaymenttf.setText(viewgetdownpayment);
		    viewtotaltf.setText(viewgettotal);
		    viewgrandtotaltf.setText(viewgetgrandtotal);


		    if (viewgetdrums.equals("1")){		viewdrums.setSelected(true);		} else {	viewdrums.setSelected(false);	}
		    if (viewgetflute.equals("1")){		viewflute.setSelected(true);		} else {	viewflute.setSelected(false);	}
		    if (viewgetpiano.equals("1")){		viewpiano.setSelected(true);		} else {	viewpiano.setSelected(false);	}
		    if (viewgetacoustic.equals("1")){	viewacoustic.setSelected(true);		} else {	viewacoustic.setSelected(false);}
		    if (viewgetelectric.equals("1")){	viewelectric.setSelected(true);		} else {	viewelectric.setSelected(false);}
		    if (viewgetamplifier.equals("1")){	viewampli.setSelected(true);		} else {	viewampli.setSelected(false);	}
		    if (viewgetmicrophone.equals("1")){	viewmic.setSelected(true);			} else {	viewmic.setSelected(false);		}
		    if (viewgetmusicstand.equals("1")){	viewstand.setSelected(true);		} else {	viewstand.setSelected(false);	}
		    if (viewgetheadphone.equals("1")){	viewheadphone.setSelected(true);	} else {	viewheadphone.setSelected(false);}
		    if (viewgetmicstand.equals("1")){	viewmicstand.setSelected(true);		} else {	viewmicstand.setSelected(false);}
	}
	    connection.close();
	} catch (Exception e) {
	    System.out.println(e);
	}




        //borders
       	viewfulltf.setBorder(new LineBorder(Color.BLACK, 2));
       	viewaddresstf.setBorder(new LineBorder(Color.BLACK, 2));
		viewcontactnumtf.setBorder(new LineBorder(Color.BLACK, 2));
		viewdatereservationtf.setBorder(new LineBorder(Color.BLACK, 2));
		viewroomtypecb.setBorder(new LineBorder(Color.BLACK, 2));
		viewstarttimetf.setBorder(new LineBorder(Color.BLACK, 2));
		viewendtimetf.setBorder(new LineBorder(Color.BLACK, 2));
		viewstatuscb.setBorder(new LineBorder(Color.BLACK, 2));
		viewpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		viewaddpaxtf.setBorder(new LineBorder(Color.BLACK, 2));
		viewaddontotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		viewdownpaymenttf.setBorder(new LineBorder(Color.BLACK, 2));
		viewtotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		viewgrandtotaltf.setBorder(new LineBorder(Color.BLACK, 2));
		viewaddonsbox.setBorder(new LineBorder(Color.BLACK, 1));
		viewreserve.setBorder(new LineBorder(cred, 2));

		//add components
		viewreservation.add(titletextviewreserve);
		viewreservation.add(viewfullname);
		viewreservation.add(viewaddress);
		viewreservation.add(viewcontactnum);
		viewreservation.add(viewroomtype);
		viewreservation.add(viewdatereservation);
		viewreservation.add(viewstarttime);
		viewreservation.add(viewendtime);
		viewreservation.add(viewstatus);
		viewreservation.add(viewpax);
		viewreservation.add(viewaddpax);
		viewreservation.add(viewfulltf);
		viewreservation.add(viewaddresstf);
		viewreservation.add(viewcontactnumtf);
		viewreservation.add(viewroomtypecb);
		viewreservation.add(viewdatereservationtf);
		viewreservation.add(viewstarttimetf);
		viewreservation.add(viewendtimetf);
		viewreservation.add(viewstatuscb);
		viewreservation.add(viewpaxtf);
		viewreservation.add(viewaddpaxtf);
		viewreservation.add(viewaddontotal);
		viewreservation.add(viewaddontotaltf);
		viewreservation.add(viewdownpayment);
		viewreservation.add(viewdownpaymenttf);
		viewreservation.add(viewtotal);
		viewreservation.add(viewtotaltf);
		viewreservation.add(viewgrandtotal);
		viewreservation.add(viewgrandtotaltf);
		viewreservation.add(viewaddonequip);
		viewreservation.add(viewdrums);
		viewreservation.add(viewflute);
		viewreservation.add(viewpiano);
		viewreservation.add(viewacoustic);
		viewreservation.add(viewelectric);
		viewreservation.add(viewampli);
		viewreservation.add(viewmic);
		viewreservation.add(viewstand);
		viewreservation.add(viewheadphone);
		viewreservation.add(viewmicstand);
		viewreservation.add(viewaddonsbox);
		viewreservation.add(viewreserve);


		//setbounds add reservation
		titletextviewreserve.setBounds(110, 0, 800, 70);
		viewfullname.setBounds(30, 74, 220, 30);
		viewfulltf.setBounds(30, 101, 240, 30);
		viewaddress.setBounds(30, 137, 220, 30);
		viewaddresstf.setBounds(30, 164, 240, 30);
		viewcontactnum.setBounds(30, 200, 220, 30);
		viewcontactnumtf.setBounds(30, 227, 240, 30);
		viewroomtype.setBounds(30, 263, 220, 30);
		viewroomtypecb.setBounds(30, 290, 240, 30);
		viewdatereservation.setBounds(30, 325, 220, 30);
		viewdatereservationtf.setBounds(30, 352, 240, 30);
		viewstarttime.setBounds(300, 74, 220, 30);
		viewstarttimetf.setBounds(300, 101, 240, 30);
		viewendtime.setBounds(300, 137, 220, 30);
		viewendtimetf.setBounds(300, 164, 240, 30);
		viewstatus.setBounds(300, 200, 220, 30);
		viewstatuscb.setBounds(300, 227, 240, 30);
		viewpax.setBounds(300, 263, 220, 30);
		viewpaxtf.setBounds(300, 290, 240, 30);
		viewaddpax.setBounds(300, 325, 220, 30);
		viewaddpaxtf.setBounds(300, 352, 240, 30);
		viewaddontotal.setBounds(33, 462, 150, 30);
		viewaddontotaltf.setBounds(160, 462, 150, 30);
		viewdownpayment.setBounds(30, 507, 150, 30);
		viewdownpaymenttf.setBounds(160, 507, 150, 30);
		viewtotal.setBounds(355, 462, 150, 30);
		viewtotaltf.setBounds(445, 462, 150, 30);
		viewgrandtotal.setBounds(330, 507, 150, 30);
		viewgrandtotaltf.setBounds(445, 507, 150, 30);
		viewaddonequip.setBounds(585, 88, 270, 30);
		viewdrums.setBounds(590, 120, 150, 30);
		viewflute.setBounds(590, 150, 150, 30);
		viewpiano.setBounds(590, 180, 150, 30);
		viewacoustic.setBounds(590, 210, 200, 30);
		viewelectric.setBounds(590, 240, 150, 30);
		viewampli.setBounds(590, 270, 150, 30);
		viewmic.setBounds(590, 300, 150, 30);
		viewstand.setBounds(590, 330, 150, 30);
		viewheadphone.setBounds(590, 360, 150, 30);
		viewmicstand.setBounds(590, 390, 150, 30);
		viewaddonsbox.setBounds(570, 80, 285, 350);
		viewreserve.setBounds(645, 480, 180, 40);
		viewreservation.setBounds(225, 70, 900, 600);
		// Iterate through all components



        // bg
        viewreservation.getContentPane().setBackground(Color.WHITE);
        viewreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewreservation.setLayout(null);
        viewreservation.setVisible(true);
	}

public void archivereservation(int getid) {
    int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to archive this reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);

    if (confirmation == JOptionPane.YES_OPTION) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
            Statement statement = connection.createStatement();

            // Retrieve data from the reservation table
            String sqlQuery = "SELECT * FROM reservation WHERE id = " + getid;
            ResultSet rSet = statement.executeQuery(sqlQuery);

            while (rSet.next()) {
                // Extract data from the result set
                int editgetid = rSet.getInt(1);
                String fullname = rSet.getString(2);
                String address = rSet.getString(3);
                String contactnum = rSet.getString(4);
                String roomtype = rSet.getString(5);
                String datereservation = rSet.getString(6);
                String starttime = rSet.getString(7);
                String endtime = rSet.getString(8);
                String status = rSet.getString(9);
                int pax = rSet.getInt(10);
                int addpax = rSet.getInt(11);
                int addontotal = rSet.getInt(12);
                int downpayment = rSet.getInt(13);
                int grandtotal = rSet.getInt(14);
                int total = rSet.getInt(15);
                int drumsch = rSet.getInt(16);
                int flutech = rSet.getInt(17);
                int pianoch = rSet.getInt(18);
                int acousticch = rSet.getInt(19);
                int electricch = rSet.getInt(20);
                int amplifierch = rSet.getInt(21);
                int micch = rSet.getInt(22);
                int musicstandch = rSet.getInt(23);
                int headphonech = rSet.getInt(24);
                int micstandch = rSet.getInt(25);

                try {
                    // Insert data into the archivereservation table
                    String archiveSql = "INSERT INTO archivereservation (id, fullname, address, contactnumber, typeofroom, datereserve, starttime, endtime, status, pax, additionalpax, addontotal, downpayment, grandtotal, total, drums, flute, piano, acoustic, electric, amplifier, microphone, musicstand, headphone, micstand) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement archiveStatement = connection.prepareStatement(archiveSql)) {
                        // Set parameters for the archive statement
                        archiveStatement.setInt(1, getid); // Assuming getid is an integer
                        archiveStatement.setString(2, fullname);
                        archiveStatement.setString(3, address);
                        archiveStatement.setString(4, contactnum);
                        archiveStatement.setString(5, roomtype);
                        LocalDate localDate = LocalDate.parse(datereservation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        archiveStatement.setDate(6, java.sql.Date.valueOf(localDate));

                        LocalTime localStartTime = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("HH:mm:ss"));
                        LocalTime localEndTime = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("HH:mm:ss"));
                        archiveStatement.setTime(7, java.sql.Time.valueOf(localStartTime));
                        archiveStatement.setTime(8, java.sql.Time.valueOf(localEndTime));

                        archiveStatement.setString(9, status);
                        archiveStatement.setInt(10, pax);
                        archiveStatement.setInt(11, addpax);
                        archiveStatement.setInt(12, addontotal);
                        archiveStatement.setInt(13, downpayment);
                        archiveStatement.setInt(14, grandtotal);
                        archiveStatement.setInt(15, total);
                        archiveStatement.setInt(16, drumsch);
                        archiveStatement.setInt(17, flutech);
                        archiveStatement.setInt(18, pianoch);
                        archiveStatement.setInt(19, acousticch);
                        archiveStatement.setInt(20, electricch);
                        archiveStatement.setInt(21, amplifierch);
                        archiveStatement.setInt(22, micch);
                        archiveStatement.setInt(23, musicstandch);
                        archiveStatement.setInt(24, headphonech);
                        archiveStatement.setInt(25, micstandch);

                        // Execute the archive statement
                        archiveStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Reservation archived successfully!");

                        // Call the method to delete the reservation from the original table
                        deleteReservation(getid);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error archiving reservation.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Reservation archiving canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
    }
}


    public void deleteReservation(int getid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

            // Delete from reservation
            String deleteQuery = "DELETE FROM reservation WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, getid);
                deleteStatement.executeUpdate();
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();
            }



            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error archiving reservation.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}