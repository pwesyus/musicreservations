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


public class mrequipmenttbl implements designs {
		JFrame equipment = new JFrame("Equipment");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";
	    public static int selectedRow = -1;
	    public static int selectedColumn = -1;
	    public static int getid = 0;
	    public DefaultTableModel equipmentmodel;

	   	public void equipments(){

		// EQUIPMENT TABLE
        JLabel equipmenttitletext = new JLabel("MUSIC ROOM RESERVATION");
        equipmenttitletext.setFont(title);

		JLabel listofequipment = new JLabel("LIST OF EQUIPMENTS");
		listofequipment.setFont(list);

		//actions buttons
		JButton addequipment = new JButton("ADD");
		addequipment.setFont(listbtn);
		addequipment.setBackground(Color.WHITE);

		JButton editequipment = new JButton("EDIT");
		editequipment.setFont(listbtn);
		editequipment.setBackground(Color.WHITE);

		JButton archiveequipment = new JButton("ARCHIVE");
		archiveequipment.setFont(listbtn);
		archiveequipment.setBackground(Color.WHITE);

		ImageIcon equipmentactiveimg = new ImageIcon("../pictures/equipmentactive.png");
        JButton equipmentactivebtn = new JButton(equipmentactiveimg);


		        // table
        String equipmentrow[][] = {};
        String equipmentcol[] = { "ID", "EQUIPMENT NAME", "QUANTITY", "RATE", "NUMBER OF AVAILABLE", "NUMBER OF BORROW", "IMAGE" };
        equipmentmodel = new DefaultTableModel(equipmentrow, equipmentcol);
        JTable equipmenttbl = new JTable(equipmentmodel);
        JScrollPane equipmentsp = new JScrollPane(equipmenttbl);
        equipmenttbl.setEnabled(true);

        //set the table and header color and font
        JTableHeader equipmenttableHeader = equipmenttbl.getTableHeader();
        equipmenttableHeader.setBackground(Color.BLACK);
        equipmenttableHeader.setForeground(Color.WHITE);
        equipmenttbl.setBackground(Color.WHITE);
        equipmenttbl.setForeground(Color.BLACK);
		Font equipmentheaderFont = subtitle;
		equipmenttableHeader.setFont(equipmentheaderFont);

		equipmenttbl.setRowHeight(80);
		//set the text in center and font
		DefaultTableCellRenderer equipmentcenterRenderer = new DefaultTableCellRenderer();
		equipmentcenterRenderer.setFont(subtitle);
        equipmentcenterRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < equipmentmodel.getColumnCount(); i++) {
            equipmenttbl.getColumnModel().getColumn(i).setCellRenderer(equipmentcenterRenderer);
        }
		//database sql
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
		    Statement statement = connection.createStatement();
		    ResultSet rSet = statement.executeQuery("select * from equipment");

			equipmenttbl.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
		    // Clear existing data from the table model
		    equipmentmodel.setRowCount(0);

		    while (rSet.next()) {
		        String id = String.valueOf(rSet.getInt(1));
		        String equipmentname = rSet.getString(2);
		        String quantity = String.valueOf(rSet.getInt(3));
		        String rate = String.valueOf(rSet.getInt(4));
		        String numofavailable = String.valueOf(rSet.getInt(5));
		        String numofborrow = String.valueOf(rSet.getInt(6));

		        // Get the image bytes from the database
		         byte[] imageBytes = rSet.getBytes("image");

		        if (imageBytes != null && imageBytes.length > 0) {
                // Convert byte array to ImageIcon
                ImageIcon imageIcon = new ImageIcon(imageBytes);

	                // Add row to the table model
	                Object[] add_rowequip = { id, equipmentname, quantity, rate, numofavailable, numofborrow, imageIcon };
	                equipmentmodel.addRow(add_rowequip);
	            } else {
	                // Handle the case when imageBytes is null or empty
	                // You can set a placeholder or handle it according to your needs
	                System.out.println("Image is null or empty for row with ID: " + id);
	            }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println(e);
		}



        // menu buttons
        ImageIcon equipdashboardimg = new ImageIcon("../pictures/dashboard.png");
        JButton equipdashboardbtn = new JButton(equipdashboardimg);

        ImageIcon equipreservationimg = new ImageIcon("../pictures/reservation.png");
        JButton equipreservationbtn = new JButton(equipreservationimg);

        ImageIcon equiproomsimg = new ImageIcon("../pictures/rooms.png");
        JButton equiproomsbtn = new JButton(equiproomsimg);

        ImageIcon equipequipmentsimg = new ImageIcon("../pictures/equipmentactive.png");
        JButton equipequipmentsbtn = new JButton(equipequipmentsimg);

        ImageIcon equipsettingsimg = new ImageIcon("../pictures/settings.png");
        JButton equipsettingsbtn = new JButton(equipsettingsimg);

        ImageIcon equiplogoutimg = new ImageIcon("../pictures/logout.png");
        JButton equiplogoutbtn = new JButton(equiplogoutimg);

        // functions of the buttons
		equiplogoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });

		equipdashboardbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mrdashboard dash = new mrdashboard();
        		dash.dashboard();

            }
        });

		equipreservationbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
        });
        equiproomsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mrroom room = new mrroom();
        		room.rooms();

            }
        });

        equipequipmentsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();

            }
        });
        equipsettingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mrsettings setting = new mrsettings();
        		setting.settings();

            }
        });

        addequipment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                mraddequipment addequip = new mraddequipment();
        		addequip.addequipments();

            }
        });
       editequipment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

			        selectedRow = equipmenttbl.getSelectedRow();

			        if (selectedRow != -1) {
			            String getidmodel = equipmentmodel.getValueAt(selectedRow, 0).toString();
			            getid = Integer.parseInt(getidmodel);
			            equipment.setVisible(false);
			            mreditequipment editequip = new mreditequipment();
			            editequip.editequipments(getid);
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
			            equipment.setVisible(true);
			        }
			    }

        });
        archiveequipment.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        selectedRow = equipmenttbl.getSelectedRow();

			        if (selectedRow != -1) {
			            String getidmodel = equipmentmodel.getValueAt(selectedRow, 0).toString();
			            getid = Integer.parseInt(getidmodel);
			            equipment.setVisible(false);
			            mreditequipment editequip = new mreditequipment();
			            editequip.archiveequipment(getid);
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
			            equipment.setVisible(true);
			        }
			    }
			});

       equiplogoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	equipment.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });


        // border of button
        addequipment.setBorder(new LineBorder(Color.BLACK, 2));
        editequipment.setBorder(new LineBorder(Color.BLACK, 2));
        archiveequipment.setBorder(new LineBorder(Color.BLACK, 2));
        equipdashboardbtn.setBorder(new LineBorder(Color.BLACK, 3));
        equipreservationbtn.setBorder(new LineBorder(Color.BLACK, 3));
        equiproomsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        equipequipmentsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        equipsettingsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        equiplogoutbtn.setBorder(new LineBorder(Color.BLACK, 3));

        // equipment SetBounds
        equipmenttitletext.setBounds(110, 0, 800, 70);
        listofequipment.setBounds(210, 70, 400, 80);
        addequipment.setBounds(610, 96, 75, 27);
        editequipment.setBounds(690, 96, 75, 27);
        archiveequipment.setBounds(770, 96, 75, 27);
        equipdashboardbtn.setBounds(30, 86, 150, 65);
        equipreservationbtn.setBounds(30, 161, 150, 65);
        equiproomsbtn.setBounds(30, 236, 150, 65);
        equipequipmentsbtn.setBounds(30, 311, 150, 65);
        equipsettingsbtn.setBounds(30, 386, 150, 65);
        equiplogoutbtn.setBounds(30, 461, 150, 65);
        equipmentsp.setBounds(210, 130, 640, 300);
        equipment.setBounds(225, 70, 900, 600);

        // add components
        equipment.add(equipmenttitletext);
        equipment.add(listofequipment);
        equipment.add(addequipment);
        equipment.add(editequipment);
        equipment.add(archiveequipment);
        equipment.add(equipdashboardbtn);
        equipment.add(equipreservationbtn);
        equipment.add(equiproomsbtn);
        equipment.add(equipequipmentsbtn);
        equipment.add(equipsettingsbtn);
        equipment.add(equiplogoutbtn);
        equipment.add(equipmentsp);

        // bg
        equipment.getContentPane().setBackground(Color.WHITE);
        equipment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        equipment.setLayout(null);
        equipment.setVisible(true);


	   	}
class ImageRenderer extends DefaultTableCellRenderer {
    private static final int MAX_IMAGE_WIDTH = 100; // Set the maximum width for the resized image
    private static final int CELL_HEIGHT = 100;     // Set the desired height for the cell

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check if the value is an ImageIcon
        if (value instanceof ImageIcon) {
            // Resize the image while maintaining its aspect ratio
            ImageIcon originalIcon = (ImageIcon) value;
            Image originalImage = originalIcon.getImage();
            int originalWidth = originalImage.getWidth(this);
            int originalHeight = originalImage.getHeight(this);

            int newWidth = MAX_IMAGE_WIDTH;
            int newHeight = (int) (((double) originalHeight / originalWidth) * newWidth);

            // Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));

            // Set the resized ImageIcon as the icon for the label
            setIcon(resizedIcon);
            setText(""); // Clear text if any

            // Set the preferred size of the cell
            setPreferredSize(new Dimension(newWidth, CELL_HEIGHT));
        }

        // Set alignment and other properties as needed
        setHorizontalAlignment(JLabel.CENTER);

        return c;
    }
}

}
