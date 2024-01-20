import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;
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


public class mrdashboard implements designs {
	    JFrame musicRoomDashboard = new JFrame("Dashboard");
	    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
	    private DefaultTableModel mrdOnGoingReservationModel;
	    JLabel mrdNoOfUpcomingReservation = new JLabel();
	    JLabel mrdNoOfOnGoingReservation = new JLabel();

	    public void dashboard(){

		// USER DASHBOARD
		// LABELS
        JLabel musicRoomDashboardTitle = new JLabel("MUSIC ROOM RESERVATION");
        musicRoomDashboardTitle.setFont(title);

        JLabel musicRoomDashboardReservationListLbl = new JLabel("LIST OF ON-GOING RESERVATION");
        musicRoomDashboardReservationListLbl.setFont(list);


        mrdNoOfOnGoingReservation.setFont(title);
        mrdNoOfOnGoingReservation.setForeground(Color.WHITE);


        mrdNoOfUpcomingReservation.setFont(title);
        mrdNoOfUpcomingReservation.setForeground(Color.WHITE);

        JLabel mrdPanel1Label = new JLabel("NUMBER OF ON-GOING RESERVATION");
        mrdPanel1Label.setFont(subtitle);
        mrdPanel1Label.setForeground(Color.WHITE);

        JLabel mrdPanel2Label = new JLabel("NUMBER OF UPCOMING RESERVATION");
        mrdPanel2Label.setFont(subtitle);
        mrdPanel2Label.setForeground(Color.WHITE);

        // menu buttons
        ImageIcon mrddashboardimg = new ImageIcon("../pictures/dashboardactive.png");
        JButton mrddashboardbtn = new JButton(mrddashboardimg);

        ImageIcon mrdreservationimg = new ImageIcon("../pictures/reservation.png");
        JButton mrdreservationbtn = new JButton(mrdreservationimg);

        ImageIcon mrdroomsimg = new ImageIcon("../pictures/rooms.png");
        JButton mrdroomsbtn = new JButton(mrdroomsimg);

        ImageIcon mrdequipmentsimg = new ImageIcon("../pictures/equipment.png");
        JButton mrdequipmentsbtn = new JButton(mrdequipmentsimg);

        ImageIcon mrdsettingsimg = new ImageIcon("../pictures/settings.png");
        JButton mrdsettingsbtn = new JButton(mrdsettingsimg);

        ImageIcon mrdlogoutimg = new ImageIcon("../pictures/logout.png");
        JButton mrdlogoutbtn = new JButton(mrdlogoutimg);

        // panel
        JPanel mrdJPanel1 = new JPanel();
        mrdJPanel1.setBackground(cgreen);

        JPanel mrdJPanel2 = new JPanel();
        mrdJPanel2.setBackground(cred);

        // table
        String row[][] = {};
        String col[] = { "RESERVATION ID", "NAME", "ROOM", "START TIME", "END TIME" };
		mrdOnGoingReservationModel = new DefaultTableModel(row, col);
        JTable mrdOnGoingReservationTbl = new JTable(mrdOnGoingReservationModel);
        JScrollPane mrdOnGoingReservationSP = new JScrollPane(mrdOnGoingReservationTbl);
        mrdOnGoingReservationTbl.setEnabled(false);

        // set the table and header color and font
        JTableHeader mrdtableHeader = mrdOnGoingReservationTbl.getTableHeader();
        mrdtableHeader.setBackground(Color.BLACK);
        mrdtableHeader.setForeground(Color.WHITE);
        mrdOnGoingReservationTbl.setBackground(Color.WHITE);
        mrdOnGoingReservationTbl.setForeground(Color.BLACK);
        Font mrdheaderFont = subtitle;
        mrdtableHeader.setFont(mrdheaderFont);

		//set the text in center and font
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setFont(subtitle);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < mrdOnGoingReservationModel.getColumnCount(); i++) {
            mrdOnGoingReservationTbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        refreshdashboardtbl();

        mrdlogoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });

		mrddashboardbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                mrdashboard dash = new mrdashboard();
        		dash.dashboard();

            }
        });

		mrdreservationbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
        });
        mrdroomsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                mrroom room = new mrroom();
        		room.rooms();

            }
        });

        mrdequipmentsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();

            }
        });
        mrdsettingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	musicRoomDashboard.setVisible(false);
                mrsettings setting = new mrsettings();
        		setting.settings();

            }
        });


        // border of button
        mrdJPanel1.setBorder(new LineBorder(Color.BLACK, 3));
        mrdJPanel2.setBorder(new LineBorder(Color.BLACK, 3));
        mrddashboardbtn.setBorder(new LineBorder(Color.BLACK, 3));
        mrdreservationbtn.setBorder(new LineBorder(Color.BLACK, 3));
        mrdroomsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        mrdequipmentsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        mrdsettingsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        mrdlogoutbtn.setBorder(new LineBorder(Color.BLACK, 3));

        // setting bounds
        mrdJPanel1.setBounds(220, 100, 300, 100);
        mrdNoOfOnGoingReservation.setBounds(350, 85, 300, 100);
        mrdPanel1Label.setBounds(240, 130, 300, 100);
        mrdPanel2Label.setBounds(560, 130, 300, 100);
        mrdNoOfUpcomingReservation.setBounds(675, 85, 300, 100);
        mrdJPanel2.setBounds(540, 100, 300, 100);

        musicRoomDashboardTitle.setBounds(150, 10, 900, 65);
        musicRoomDashboardReservationListLbl.setBounds(340, 100, 500, 300);
        mrdOnGoingReservationSP.setBounds(200, 270, 660, 250);

        mrddashboardbtn.setBounds(30, 86, 150, 65);
        mrdreservationbtn.setBounds(30, 161, 150, 65);
        mrdroomsbtn.setBounds(30, 236, 150, 65);
        mrdequipmentsbtn.setBounds(30, 311, 150, 65);
        mrdsettingsbtn.setBounds(30, 386, 150, 65);
        mrdlogoutbtn.setBounds(30, 461, 150, 65);

        musicRoomDashboard.setBounds(225, 70, 900, 600);

        // adding components to the frame
        musicRoomDashboard.add(mrdNoOfOnGoingReservation);
        musicRoomDashboard.add(mrdPanel1Label);
        musicRoomDashboard.add(mrdPanel2Label);
        musicRoomDashboard.add(mrdNoOfUpcomingReservation);
        musicRoomDashboard.add(mrdJPanel1);

        musicRoomDashboard.add(mrdOnGoingReservationSP);

        musicRoomDashboard.add(mrdJPanel2);
        musicRoomDashboard.add(musicRoomDashboardTitle);
        musicRoomDashboard.add(mrddashboardbtn);
        musicRoomDashboard.add(mrdreservationbtn);
        musicRoomDashboard.add(mrdroomsbtn);
        musicRoomDashboard.add(mrdequipmentsbtn);
        musicRoomDashboard.add(mrdsettingsbtn);
        musicRoomDashboard.add(mrdlogoutbtn);
        musicRoomDashboard.add(musicRoomDashboardReservationListLbl);
        musicRoomDashboard.getContentPane().setBackground(Color.WHITE);
        musicRoomDashboard.setLayout(null);
        musicRoomDashboard.setVisible(true);
	    }
	    public void refreshdashboardtbl(){
	    	//database table sql
        try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
	    Statement statement = connection.createStatement();

	    // Updated SQL query to filter by specific status values
	    String sqlQuery = "SELECT id, fullname, typeofroom, starttime, endtime, status " +
	                      "FROM reservation " +
	                      "WHERE status IN ('ON-GOING')";

	    ResultSet rSet = statement.executeQuery(sqlQuery);

	    while (rSet.next()) {
	        String id = String.valueOf(rSet.getInt(1));
	        String fullname = rSet.getString(2);
	        String room = rSet.getString(3);
	        String starttime = String.valueOf(rSet.getTime(4));
	        String endtime = String.valueOf(rSet.getTime(5));
	        String status = rSet.getString(6);
	        String add_row[] = {id, fullname, room, starttime, endtime};
	        mrdOnGoingReservationModel.addRow(add_row);
	    }

	    connection.close();
	} catch (Exception a) {
	    System.out.println(a);
	}
		//database pending sql
        try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
	    Statement statement = connection.createStatement();

	    // Updated SQL query to filter by specific status values
	    String sqlQuery = "SELECT COUNT(*) as totalongoing FROM reservation WHERE status = 'ON-GOING'";


	    ResultSet rSet = statement.executeQuery(sqlQuery);

	    while (rSet.next()) {
	        String pending = String.valueOf(rSet.getInt(1));
	        mrdNoOfOnGoingReservation.setText(pending);
	    }

	    connection.close();
	} catch (Exception b) {
	    System.out.println(b);
	}

	//database ongoing sql
        try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
	    Statement statement = connection.createStatement();

	    // Updated SQL query to filter by specific status values
	    String sqlQuery = "SELECT COUNT(*) as totalpending FROM reservation WHERE status = 'PENDING'";


	    ResultSet rSet = statement.executeQuery(sqlQuery);

	    while (rSet.next()) {
	        String upcoming = String.valueOf(rSet.getInt(1));
	        mrdNoOfUpcomingReservation.setText(upcoming);
	    }

	    connection.close();
	} catch (Exception c) {
	    System.out.println(c);
	}

	    }
}
