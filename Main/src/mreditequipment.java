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


public class mreditequipment implements designs {
		JFrame editequipmentf = new JFrame("Edit Equipment");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	    public static JLabel imageLabel;
    	public static File selectedFile;
    	private byte[] existingImageBytes;


	    private static byte[] getImageBytes(File selectedFile) throws IOException {
	        FileInputStream fis = new FileInputStream(selectedFile);
	        byte[] imageBytes = new byte[(int) selectedFile.length()];
	        fis.read(imageBytes);
	        fis.close();
	        return imageBytes;
	    }
	    private static void displayImage(File selectedFile) {
	        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
	        Image image = imageIcon.getImage().getScaledInstance(240, 110, Image.SCALE_SMOOTH);
	        imageIcon = new ImageIcon(image);
	        imageLabel.setIcon(imageIcon);
	    }

	   	public void editequipments(int getid){


        //EDIT EQUIPMENT

        JLabel edittitletextaddequipment = new JLabel("MUSIC ROOM RESERVATION");
        edittitletextaddequipment.setFont(title);

        JLabel editsubaddequipment = new JLabel("EDIT EQUIPMENT");
        editsubaddequipment.setFont(addequip);

		JLabel editequipname = new JLabel("EQUIPMENT NAME");
        editequipname.setFont(subtitle);
        JTextField editequipnametf = new JTextField();
        editequipnametf.setFont(subtitle);

       	JLabel editquantity = new JLabel("QUANTITY");
        editquantity.setFont(subtitle);
        JTextField editquantitytf = new JTextField();
        editquantitytf.setFont(subtitle);

        JLabel editrate = new JLabel("RATE");
        editrate.setFont(subtitle);
        JTextField editratetf = new JTextField();
        editratetf.setFont(subtitle);

		JLabel editequipimg = new JLabel("EQUIPMENT IMAGE");
        editequipimg.setFont(subtitle);
        JButton edituploadimg = new JButton("Upload Equipment Image");
        edituploadimg.setFont(subtitle);
		edituploadimg.setBackground(Color.WHITE);

		JLabel editimgprev = new JLabel("IMAGE PREVIEW");
		editimgprev.setFont(subtitle);
		imageLabel = new JLabel();
        FileNameExtensionFilter editimageFilter = new FileNameExtensionFilter("Image Files", "png", "jpeg", "jpg");
        JFileChooser editfileChooser = new JFileChooser();
        editfileChooser.setFileFilter(editimageFilter);


        JButton editsaveequip = new JButton("SAVE");
		editsaveequip.setBackground(cgreen);
		editsaveequip.setFont(comp);
        editsaveequip.setForeground(Color.WHITE);

        JButton editbackequip = new JButton("BACK");
		editbackequip.setBackground(cred);
		editbackequip.setFont(comp);
        editbackequip.setForeground(Color.WHITE);


        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT * FROM equipment WHERE id = " + getid;
        ResultSet rSet = statement.executeQuery(sqlQuery);

        if (rSet.next()) {
            String equipmentname = rSet.getString("equipmentname");
            int quantity = rSet.getInt("quantity");
            int rate = rSet.getInt("rate");
            byte[] imageBytes = rSet.getBytes("image");

            // Display fetched data in text fields
            editequipnametf.setText(equipmentname);
            editquantitytf.setText(String.valueOf(quantity));
            editratetf.setText(String.valueOf(rate));

            // Display fetched image in imageLabel
            if (imageBytes != null && imageBytes.length > 0) {
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                Image image = imageIcon.getImage().getScaledInstance(242, 110, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } else {
                // Handle the case when imageBytes is null or empty
                // You can set a placeholder or handle it according to your needs
                System.out.println("Image is null or empty for equipment with ID: " + getid);
                imageLabel.setIcon(null); // Set a default image or leave it blank
            }
        }

        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(editequipmentf, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

        //image upload
	        edituploadimg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = editfileChooser.showOpenDialog(editequipmentf);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    selectedFile = editfileChooser.getSelectedFile();
                    // Check if the selected file has a valid extension
                    if (editimageFilter.accept(selectedFile)) {
                        displayImage(selectedFile);
                    } else {
                        JOptionPane.showMessageDialog(editequipmentf, "Please select a valid image file (png or jpeg).", "Invalid File", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
            Statement statement = connection.createStatement();

            String selectImageQuery = "SELECT image FROM equipment WHERE id = " + getid;
            ResultSet imageResultSet = statement.executeQuery(selectImageQuery);

            if (imageResultSet.next()) {
                existingImageBytes = imageResultSet.getBytes("image");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

// Save button action listener
		editsaveequip.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	if (editequipnametf.getText().isEmpty() || editquantitytf.getText().isEmpty() || editratetf.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                	editequipnametf.setText("");
		            editquantitytf.setText("");
		            editratetf.setText("");
		            imageLabel.setIcon(null);
                	return; // Stop further processing if any field is empty
           			}

           		Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

	            // Get data from UI components
	            String equipmentname = editequipnametf.getText();
	            int quantity = Integer.parseInt(editquantitytf.getText());
	            int rate = Integer.parseInt(editratetf.getText());

	            // Use the global variable selectedFile
	            byte[] imageequip = null;

	            if (selectedFile != null) {
	                // If a new image is selected, update the image bytes
	                imageequip = getImageBytes(selectedFile);
	            }

	            // Prepare SQL statement for updating data in the database
	            String updateQuery = "UPDATE equipment SET equipmentname=?, quantity=?, rate=?, image=? WHERE id=?";
	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                // Bind parameters
	                updateStatement.setString(1, equipmentname);
	                updateStatement.setInt(2, quantity);
	                updateStatement.setInt(3, rate);

	                if (imageequip != null) {
	                    // If a new image is selected, update the image column
	                    updateStatement.setBytes(4, imageequip);
	                } else {
	                    // If no new image is selected, use the existing image column
	                    updateStatement.setBytes(4, existingImageBytes);
	                }

	                updateStatement.setInt(5, getid);

	                // Execute SQL statement
	                int rowsAffected = updateStatement.executeUpdate();

	                // Show message dialog based on success or failure
	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(null, "Equipment updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Failed to update equipment.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }

	            // Close the database connection
	            connection.close();

	            // Clear text fields and image preview after updating
	            editequipnametf.setText("");
	            editquantitytf.setText("");
	            editratetf.setText("");
	            imageLabel.setIcon(null);

	        } catch (Exception eeq) {
	            eeq.printStackTrace();
	            JOptionPane.showMessageDialog(editequipmentf, "An error occurred: " + eeq.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	});
	editbackequip.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	editequipmentf.setVisible(false);
		    	mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();
		    }
	});


		//border
		editequipnametf.setBorder(new LineBorder(Color.BLACK, 2));
		editquantitytf.setBorder(new LineBorder(Color.BLACK, 2));
		editratetf.setBorder(new LineBorder(Color.BLACK, 2));
		edituploadimg.setBorder(new LineBorder(Color.BLACK, 2));
		imageLabel.setBorder(new LineBorder(Color.BLACK, 2));
		editsaveequip.setBorder(new LineBorder(cgreen, 2));

        //component
        editequipmentf.add(edittitletextaddequipment);
        editequipmentf.add(editsubaddequipment);
        editequipmentf.add(editequipname);
        editequipmentf.add(editequipnametf);
        editequipmentf.add(editquantity);
        editequipmentf.add(editquantitytf);
        editequipmentf.add(editrate);
        editequipmentf.add(editratetf);
        editequipmentf.add(editequipimg);
        editequipmentf.add(edituploadimg);
        editequipmentf.add(editimgprev);
        editequipmentf.add(imageLabel);
        editequipmentf.add(editsaveequip);
        editequipmentf.add(editbackequip);



        //setbounds addequipment
        edittitletextaddequipment.setBounds(110, 0, 800, 70);
        editsubaddequipment.setBounds(300, 70, 300, 70);
        editequipname.setBounds(160, 150, 220, 30);
        editequipnametf.setBounds(160, 177, 240, 30);
        editquantity.setBounds(160, 230, 250, 30);
        editquantitytf.setBounds(160, 257, 240, 30);
        editrate.setBounds(160, 310, 250, 30);
        editratetf.setBounds(160, 337, 240, 30);
        editequipimg.setBounds(460, 150, 220, 30);
        edituploadimg.setBounds(460, 177, 240, 30);
        editimgprev.setBounds(460, 230, 220, 30);
        imageLabel.setBounds(460, 257, 242, 110);
		editsaveequip.setBounds(430, 400, 180, 40);
		editbackequip.setBounds(230, 400, 180, 40);
        editequipmentf.setBounds(100, 50, 900, 600);


        // bg
        editequipmentf.getContentPane().setBackground(Color.WHITE);
        editequipmentf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editequipmentf.setLayout(null);
        editequipmentf.setVisible(true);
	   	}

public void archiveequipment(int getid) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
        Statement statement = connection.createStatement();

        // Retrieve data from the equipment table
        String sqlQuery = "SELECT * FROM equipment WHERE id = " + getid;
        ResultSet rSet = statement.executeQuery(sqlQuery);

        while (rSet.next()) {
            // Extract data from the result set
            int id = rSet.getInt(1);
            String equipmentname = rSet.getString(2);
            int quantity = rSet.getInt(3);
            int rate = rSet.getInt(4);
            int noofavailable = rSet.getInt(5);
            int noofborrow = rSet.getInt(6);
            byte[] imageBytes = rSet.getBytes(7);

            try {
                // Insert data into the archivereservation table
                String archiveSql = "INSERT INTO archiveequipment (id, equipmentname, quantity, rate, noofavailable, noofborrow, image) VALUES (?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement archiveStatement = connection.prepareStatement(archiveSql)) {
                    // Set parameters for the archive statement
                    archiveStatement.setInt(1, id);
                    archiveStatement.setString(2, equipmentname);
                    archiveStatement.setInt(3, quantity);
                    archiveStatement.setInt(4, rate);
                    archiveStatement.setInt(5, noofavailable);
                    archiveStatement.setInt(6, noofborrow);
                    archiveStatement.setBytes(7, imageBytes);

                    // Execute the archive statement
                    archiveStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Equipment archived successfully!");

                    // Call the method to delete the equipment from the original table
                    deleteEquipment(getid);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error archiving equipment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void deleteEquipment(int getid) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

        // Delete from equipment
        String deleteQuery = "DELETE FROM equipment WHERE id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, getid);
            deleteStatement.executeUpdate();
        }

        mrequipmenttbl equipment = new mrequipmenttbl();
        equipment.equipments();

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting equipment.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


}