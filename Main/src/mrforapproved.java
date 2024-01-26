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


public class mrforapproved implements designs {
	    JFrame forapproved = new JFrame("For Approved");
	    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
	    private DefaultTableModel forapprovedmodel;
	   	public static int selectedRow = -1;
	    public static int selectedColumn = -1;
	    public static int getid = 0;


	    public void forapproved(){
		// equipment TABLE
        JLabel forapprovedtitletext = new JLabel("MUSIC ROOM RESERVATION");
        forapprovedtitletext.setFont(title);

		JLabel forapprovedlist = new JLabel("LIST OF RESERVATION REQUESTS");
		forapprovedlist.setFont(list);

		String forapprovedrow[][] = {};
        String forapprovedcol[] = {"ID", "NAME", "DATE OF RESERVATION", "TYPE OF ROOM", "START TIME", "END TIME", "DOWNPAYMENT", "GRAND TOTAL" };
		forapprovedmodel = new DefaultTableModel(forapprovedrow, forapprovedcol);
        JTable forapprovedtbl = new JTable(forapprovedmodel);
        JScrollPane forapprovedsp = new JScrollPane(forapprovedtbl);

        //set the table and header color and font
        JTableHeader forapprovedtableHeader = forapprovedtbl.getTableHeader();
        forapprovedtableHeader.setBackground(Color.BLACK);
        forapprovedtableHeader.setForeground(Color.WHITE);
        forapprovedtbl.setBackground(Color.WHITE);
        forapprovedtbl.setForeground(Color.BLACK);
		Font forapprovedheaderFont = subtitle;
		forapprovedtableHeader.setFont(forapprovedheaderFont);

		//set the text in center and font
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setFont(subtitle);
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	        for (int i = 0; i < forapprovedmodel.getColumnCount(); i++) {
	            forapprovedtbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }

		refreshforapprovedtbl();


		JButton forapprovedaccept = new JButton("ACCEPT");
		forapprovedaccept.setFont(listbtn);
		forapprovedaccept.setBackground(cgreen);
		forapprovedaccept.setForeground(Color.WHITE);


		JButton forapproveddecline = new JButton("DECLINE");
		forapproveddecline.setFont(listbtn);
		forapproveddecline.setBackground(cred);
		forapproveddecline.setForeground(Color.WHITE);

		JButton forapprovedback = new JButton("BACK");
		forapprovedback.setBackground(cred);
		forapprovedback.setFont(listbtn);
        forapprovedback.setForeground(Color.WHITE);


		//actions

		forapprovedback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	forapproved.setVisible(false);
            	mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
		});
		forapprovedaccept.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        selectedRow = forapprovedtbl.getSelectedRow();

		        if (selectedRow != -1) {
		            String getidmodel = forapprovedmodel.getValueAt(selectedRow, 0).toString();
		            getid = Integer.parseInt(getidmodel);

		            int result = JOptionPane.showConfirmDialog(
		                    null,
		                    "Do you really want to approve this reservation?",
		                    "Confirm Approval",
		                    JOptionPane.YES_NO_OPTION
		            );

		            if (result == JOptionPane.YES_OPTION) {
		                // Update the status to PENDING
		                try {
		                    Class.forName("com.mysql.cj.jdbc.Driver");
		                    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

		                    String updateQuery = "UPDATE reservation SET status = 'PENDING' WHERE id = ?";
		                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
		                        updateStatement.setInt(1, getid);
		                        int rowsAffected = updateStatement.executeUpdate();

		                        if (rowsAffected > 0) {
		                            JOptionPane.showMessageDialog(null, "Reservation approved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Failed to approve reservation.", "Error", JOptionPane.ERROR_MESSAGE);
		                        }
		                    }

		                    connection.close();
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Approval process cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
		            }
		        }
		    }
		});

		forapproveddecline.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        selectedRow = forapprovedtbl.getSelectedRow();

		        if (selectedRow != -1) {
		            String getidmodel = forapprovedmodel.getValueAt(selectedRow, 0).toString();
		            getid = Integer.parseInt(getidmodel);

		            String reason = JOptionPane.showInputDialog(null, "Enter the reason for declining the reservation:");

		            if (reason != null) {
		                // Get data from the reservation table based on getid
		                try {
		                    Class.forName("com.mysql.cj.jdbc.Driver");
		                    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

		                    String selectQuery = "SELECT * FROM reservation WHERE id = ?";
		                    try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
		                        selectStatement.setInt(1, getid);
		                        ResultSet resultSet = selectStatement.executeQuery();

		                        if (resultSet.next()) {
		                            String fullname = resultSet.getString("fullname");
		                            String address = resultSet.getString("address");
		                            String contactnumber = resultSet.getString("contactnumber");
		                            String typeofroom = resultSet.getString("typeofroom");
		                            String datereserve = resultSet.getString("datereserve");
		                            String starttime = resultSet.getString("starttime");
		                            String endtime = resultSet.getString("endtime");
		                            String status = resultSet.getString("status");
		                            String pax = resultSet.getString("pax");
		                            String additionalpax = resultSet.getString("additionalpax");
		                            String addonTotal = resultSet.getString("addontotal");
		                            String downpayment = resultSet.getString("downpayment");
		                            String total = resultSet.getString("total");
		                            String grandtotal = resultSet.getString("grandtotal");
		                            String drums = resultSet.getString("drums");
		                            String flute = resultSet.getString("flute");
		                            String piano = resultSet.getString("piano");
		                            String acoustic = resultSet.getString("acoustic");
		                            String electric = resultSet.getString("electric");
		                            String amplifier = resultSet.getString("amplifier");
		                            String microphone = resultSet.getString("microphone");
		                            String musicstand = resultSet.getString("musicstand");
		                            String headphone = resultSet.getString("headphone");
		                            String micstand = resultSet.getString("micstand");
		                            String user = resultSet.getString("user");

									status = "DECLINE";
		                            // Insert into declineclient table
		                            String insertQuery = "INSERT INTO declineclient (id, fullname, address, contactnumber, typeofroom, datereserve, starttime, endtime, status, pax, additionalpax, addontotal, downpayment, total, grandtotal, drums, flute, piano, acoustic, electric, amplifier, microphone, musicstand, headphone, micstand, user, reason) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		                            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
									    insertStatement.setInt(1, getid);
									    insertStatement.setString(2, fullname);
									    insertStatement.setString(3, address);
									    insertStatement.setString(4, contactnumber);
									    insertStatement.setString(5, typeofroom);
									    insertStatement.setString(6, datereserve);
									    insertStatement.setString(7, starttime);
									    insertStatement.setString(8, endtime);
									    insertStatement.setString(9, status);
									    insertStatement.setString(10, pax);
									    insertStatement.setString(11, additionalpax);
									    insertStatement.setString(12, addonTotal);
									    insertStatement.setString(13, downpayment);
									    insertStatement.setString(14, total);
									    insertStatement.setString(15, grandtotal);
									    insertStatement.setString(16, drums);
									    insertStatement.setString(17, flute);
									    insertStatement.setString(18, piano);
									    insertStatement.setString(19, acoustic);
									    insertStatement.setString(20, electric);
									    insertStatement.setString(21, amplifier);
									    insertStatement.setString(22, microphone);
									    insertStatement.setString(23, musicstand);
									    insertStatement.setString(24, headphone);
									    insertStatement.setString(25, micstand);
									    insertStatement.setString(26, user);
									    insertStatement.setString(27, reason);

		                                int rowsAffected = insertStatement.executeUpdate();

		                                if (rowsAffected > 0) {
		                                    // Delete from reservation table
		                                    String deleteQuery = "DELETE FROM reservation WHERE id = ?";
		                                    try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
		                                        deleteStatement.setInt(1, getid);
		                                        deleteStatement.executeUpdate();

		                                        JOptionPane.showMessageDialog(null, "Reservation declined successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                        forapproved.setVisible(false);
		                                        forapproved.setVisible(true);
		                                    }
		                                } else {
		                                    JOptionPane.showMessageDialog(null, "Failed to decline reservation.", "Error", JOptionPane.ERROR_MESSAGE);
		                                }
		                            }
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Reservation not found.", "Error", JOptionPane.ERROR_MESSAGE);
		                        }
		                    }
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        }
		    }
		});


		//set the text in center and font

        forapprovedtitletext.setBounds(110, 0, 800, 70);
        forapprovedback.setBounds(20, 20, 75, 30);
        forapprovedlist.setBounds(50, 70, 400, 80);
        forapprovedsp.setBounds(50, 130, 780, 300);
        forapprovedaccept.setBounds(240, 470, 200, 50);
        forapproveddecline.setBounds(500, 470, 200, 50);
        forapproved.setBounds(225, 70, 900, 600);

        forapproved.add(forapprovedtitletext);
        forapproved.add(forapprovedback);
        forapproved.add(forapprovedsp);
        forapproved.add(forapprovedaccept);
        forapproved.add(forapproveddecline);
        forapproved.add(forapprovedlist);

        forapproved.getContentPane().setBackground(Color.WHITE);
        forapproved.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forapproved.setLayout(null);
        forapproved.setVisible(true);

	    }
public void refreshforapprovedtbl() {
		 try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
		    Statement statement = connection.createStatement();

		    // Updated SQL query to filter by specific status values and order by date, starttime
		    String sqlQuery = "SELECT id, fullname, datereserve, typeofroom, starttime, endtime, downpayment, grandtotal, status " +
                  "FROM reservation " +
                  "WHERE status IN ('WAITING') " +
                  "ORDER BY datereserve ASC, starttime ASC";


		    ResultSet rSet = statement.executeQuery(sqlQuery);

		    while (rSet.next()) {
		        String id = String.valueOf(rSet.getInt(1));
		        String fullname = rSet.getString(2);
		        String datereserve = String.valueOf(rSet.getDate(3));
		        String room = rSet.getString(5);
		        String start = rSet.getString(6);
		        String end = rSet.getString(7);
		        String downpayment = rSet.getString(8);
		        String grandtotal = rSet.getString(9);
		        String add_row[] = {id, fullname, datereserve, room, start, end, downpayment, grandtotal};
		        forapprovedmodel.addRow(add_row);
		    }
		    connection.close();
		} catch (Exception e) {
		    System.out.println(e);
		}
		}
}