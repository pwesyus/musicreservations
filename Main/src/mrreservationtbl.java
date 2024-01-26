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


public class mrreservationtbl implements designs {
	    JFrame reservation = new JFrame("Reservation");
	    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
	    private DefaultTableModel reservemodel;
	   	public static int selectedRow = -1;
	    public static int selectedColumn = -1;
	    public static int getid = 0;


	    public void reservations(){
			// RESERVATION TABLE
	        JLabel titletext = new JLabel("MUSIC ROOM RESERVATION");
	        titletext.setFont(title);

			JLabel listofreserve = new JLabel("LIST OF RESERVATION");
			listofreserve.setFont(list);

			//actions buttons
			JButton add = new JButton("ADD");
			add.setFont(listbtn);
			add.setBackground(Color.WHITE);

			JButton edit = new JButton("EDIT");
			edit.setFont(listbtn);
			edit.setBackground(Color.WHITE);

			JButton archive = new JButton("ARCHIVE");
			archive.setFont(listbtn);
			archive.setBackground(Color.WHITE);

			JButton view = new JButton("VIEW");
			view.setFont(listbtn);
			view.setBackground(Color.WHITE);

	        // menu buttons
	        ImageIcon dashboardimg = new ImageIcon("../pictures/dashboard.png");
	        JButton dashboardbtn = new JButton(dashboardimg);

	        ImageIcon reservationimg = new ImageIcon("../pictures/reservationactive.png");
	        JButton reservationbtn = new JButton(reservationimg);

	        ImageIcon roomsimg = new ImageIcon("../pictures/rooms.png");
	        JButton roomsbtn = new JButton(roomsimg);

	        ImageIcon equipmentsimg = new ImageIcon("../pictures/equipment.png");
	        JButton equipmentsbtn = new JButton(equipmentsimg);

	        ImageIcon settingsimg = new ImageIcon("../pictures/settings.png");
	        JButton settingsbtn = new JButton(settingsimg);

	        ImageIcon logoutimg = new ImageIcon("../pictures/logout.png");
	        JButton logoutbtn = new JButton(logoutimg);

	        JButton forapprovedbtn = new JButton("FOR APPROVED");
			forapprovedbtn.setFont(listbtn);
	        forapprovedbtn.setBackground(cgreen);
	        forapprovedbtn.setForeground(Color.WHITE);

	        // table
	        String reserverow[][] = {};
	        String reservecol[] = { "ID", "NAME", "CONTACT NUMBER", "DATE OF RESERVATION", "ROOM", "STATUS" };
	        reservemodel = new DefaultTableModel(reserverow, reservecol);
	        JTable reservationtbl = new JTable(reservemodel);
	        JScrollPane reservesp = new JScrollPane(reservationtbl);
	        reservationtbl.setEnabled(true);

	        //set the table and header color and font
	        JTableHeader tableHeader = reservationtbl.getTableHeader();
	        tableHeader.setBackground(Color.BLACK);
	        tableHeader.setForeground(Color.WHITE);
	        reservationtbl.setBackground(Color.WHITE);
	        reservationtbl.setForeground(Color.BLACK);
			Font headerFont = subtitle;
			tableHeader.setFont(headerFont);

			//set the text in center and font
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setFont(subtitle);
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	        for (int i = 0; i < reservemodel.getColumnCount(); i++) {
	            reservationtbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
			refreshreservationtbl();

			add.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	reservation.setVisible(false);
	                mraddreservation addreserve = new mraddreservation();
        			addreserve.addreservations();

	            }
	        });
	        edit.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        reservation.setVisible(false);
			        selectedRow = reservationtbl.getSelectedRow();

			        if (selectedRow != -1) {
			            String getidmodel = reservemodel.getValueAt(selectedRow, 0).toString();
			            getid = Integer.parseInt(getidmodel);

			            // Check if the status is "Done" (case-insensitive and trimmed)
			            String status = reservemodel.getValueAt(selectedRow, 5).toString().trim();
			            if ("Done".equalsIgnoreCase(status)) {
			                JOptionPane.showMessageDialog(null, "Reservation with status 'Done' cannot be edited.", "Invalid Action", JOptionPane.WARNING_MESSAGE);
			                reservation.setVisible(true);
			            } else {
			                mreditreservation editreserve = new mreditreservation();
			                editreserve.editreservations(getid);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
			            reservation.setVisible(true);
			        }
			    }
			});

			view.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        reservation.setVisible(false);
			        selectedRow = reservationtbl.getSelectedRow();

			        if (selectedRow != -1) {
			            String getidmodel = reservemodel.getValueAt(selectedRow, 0).toString();
			            getid = Integer.parseInt(getidmodel);
			            mrviewreservation viewreserve = new mrviewreservation();
			            viewreserve.viewreservations(getid);
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to view.", "No Selection", JOptionPane.WARNING_MESSAGE);
			            reservation.setVisible(true);
			        }
			    }
			});
			archive.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {

			        selectedRow = reservationtbl.getSelectedRow();

			        if (selectedRow != -1) {
			            String getidmodel = reservemodel.getValueAt(selectedRow, 0).toString();
			            getid = Integer.parseInt(getidmodel);
			            mrviewreservation viewreserve = new mrviewreservation();
			            viewreserve.archivereservation(getid);
			            reservation.setVisible(false);
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
			            reservation.setVisible(true);
			        }
			    }
			});

        logoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });

		dashboardbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrdashboard dash = new mrdashboard();
        		dash.dashboard();

            }
        });

		reservationbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
        });
        roomsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrroom room = new mrroom();
        		room.rooms();

            }
        });

        equipmentsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();

            }
        });
        settingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrsettings setting = new mrsettings();
        		setting.settings();

            }
        });
        forapprovedbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reservation.setVisible(false);
                mrforapproved approve = new mrforapproved();
        		approve.forapproved();

            }
        });

	        // border of button
	        add.setBorder(new LineBorder(Color.BLACK, 2));
	        edit.setBorder(new LineBorder(Color.BLACK, 2));
	        archive.setBorder(new LineBorder(Color.BLACK, 2));
	        view.setBorder(new LineBorder(Color.BLACK, 2));
	        dashboardbtn.setBorder(new LineBorder(Color.BLACK, 3));
	        reservationbtn.setBorder(new LineBorder(Color.BLACK, 3));
	        roomsbtn.setBorder(new LineBorder(Color.BLACK, 3));
	        equipmentsbtn.setBorder(new LineBorder(Color.BLACK, 3));
	        settingsbtn.setBorder(new LineBorder(Color.BLACK, 3));
	        logoutbtn.setBorder(new LineBorder(Color.BLACK, 3));

	        // reservation SetBounds
	        titletext.setBounds(110, 0, 800, 70);
	        listofreserve.setBounds(210, 70, 400, 80);
	        add.setBounds(535, 96, 75, 27);
	        edit.setBounds(615, 96, 75, 27);
	        archive.setBounds(695, 96, 75, 27);
	        view.setBounds(775, 96, 75, 27);
	        dashboardbtn.setBounds(30, 86, 150, 65);
	        reservationbtn.setBounds(30, 161, 150, 65);
	        roomsbtn.setBounds(30, 236, 150, 65);
	        equipmentsbtn.setBounds(30, 311, 150, 65);
	        settingsbtn.setBounds(30, 386, 150, 65);
	        logoutbtn.setBounds(30, 461, 150, 65);
	        reservesp.setBounds(210, 130, 640, 320);
	        forapprovedbtn.setBounds(670, 475, 180, 50);
	        reservation.setBounds(225, 70, 900, 600);

	        // add components
	        reservation.add(titletext);
	        reservation.add(listofreserve);
	        reservation.add(add);
	        reservation.add(edit);
	        reservation.add(archive);
	        reservation.add(view);
	        reservation.add(dashboardbtn);
	        reservation.add(reservationbtn);
	        reservation.add(roomsbtn);
	        reservation.add(equipmentsbtn);
	        reservation.add(settingsbtn);
	        reservation.add(logoutbtn);
	        reservation.add(reservesp);
	        reservation.add(forapprovedbtn);


	        // bg
	        reservation.getContentPane().setBackground(Color.WHITE);
	        reservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        reservation.setLayout(null);
	        reservation.setVisible(true);

	    }

	    public void refreshreservationtbl() {
		 try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
		    Statement statement = connection.createStatement();

		    // Updated SQL query to filter by specific status values and order by date, starttime
		    String sqlQuery = "SELECT id, fullname, contactnumber, datereserve, typeofroom, status " +
		                      "FROM reservation " +
		                      "WHERE status IN ('ON-GOING', 'PENDING', 'DONE') " +
		                      "ORDER BY " +
		                      "  CASE WHEN status = 'ON-GOING' THEN 1 " +
		                      "       WHEN status = 'PENDING' THEN 2 " +
		                      "       WHEN status = 'DONE' THEN 3 " +
		                      "  END, " +
		                      "  datereserve ASC, starttime ASC";

		    ResultSet rSet = statement.executeQuery(sqlQuery);

		    while (rSet.next()) {
		        String id = String.valueOf(rSet.getInt(1));
		        String fullname = rSet.getString(2);
		        String contactnumber = rSet.getString(3);
		        String datereserve = String.valueOf(rSet.getDate(4));
		        String room = rSet.getString(5);
		        String status = rSet.getString(6);
		        String add_row[] = {id, fullname, contactnumber, datereserve, room, status};
		        reservemodel.addRow(add_row);
		    }

		    connection.close();
		} catch (Exception e) {
		    System.out.println(e);
		}
		}

}