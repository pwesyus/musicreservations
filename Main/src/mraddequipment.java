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


public class mraddequipment implements designs {
		JFrame addequipmentf = new JFrame("Add Equipment");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	    public static JLabel imageLabel;
    	public static File selectedFile;


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

	   	public void addequipments(){
	   		 //ADD EQUIPMENT
        JLabel titletextaddequipment = new JLabel("MUSIC ROOM RESERVATION");
        titletextaddequipment.setFont(title);

        JLabel subaddequipment = new JLabel("ADD EQUIPMENT");
        subaddequipment.setFont(addequip);

		JLabel equipname = new JLabel("EQUIPMENT NAME *");
        equipname.setFont(subtitle);
        JTextField equipnametf = new JTextField();
        equipnametf.setFont(subtitle);

       	JLabel quantity = new JLabel("QUANTITY *");
        quantity.setFont(subtitle);
        JTextField quantitytf = new JTextField();
        quantitytf.setFont(subtitle);

        JLabel rate = new JLabel("RATE *");
        rate.setFont(subtitle);
        JTextField ratetf = new JTextField();
        ratetf.setFont(subtitle);

		JLabel equipimg = new JLabel("EQUIPMENT IMAGE *");
        equipimg.setFont(subtitle);
        JButton uploadimg = new JButton("Upload Equipment Image");
        uploadimg.setFont(subtitle);
		uploadimg.setBackground(Color.WHITE);

		JLabel imgprev = new JLabel("IMAGE PREVIEW");
		imgprev.setFont(subtitle);
		imageLabel = new JLabel();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpeg", "jpg");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(imageFilter);

        JButton saveequip = new JButton("SAVE");
		saveequip.setBackground(cgreen);
		saveequip.setFont(comp);
        saveequip.setForeground(Color.WHITE);

        JButton backequip = new JButton("BACK");
		backequip.setBackground(cred);
		backequip.setFont(comp);
        backequip.setForeground(Color.WHITE);

        //image upload
	        uploadimg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(addequipmentf);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    // Check if the selected file has a valid extension
                    if (imageFilter.accept(selectedFile)) {
                        displayImage(selectedFile);
                    } else {
                        JOptionPane.showMessageDialog(addequipmentf, "Please select a valid image file (png or jpeg).", "Invalid File", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

          quantitytf.addKeyListener(new KeyAdapter() {
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
       	ratetf.addKeyListener(new KeyAdapter() {
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

// Save button action listener
		saveequip.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (equipnametf.getText().isEmpty() || quantitytf.getText().isEmpty() || ratetf.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                	equipnametf.setText("");
		            quantitytf.setText("");
		            ratetf.setText("");
		            imageLabel.setIcon(null);
                	return; // Stop further processing if any field is empty
           			}
		    	int result = JOptionPane.showConfirmDialog(null,"Do you want to save this equipment?", "Confirm Save", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
		        try {


		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);

		            // Get data from UI components
		            String equipmentname = equipnametf.getText();
		            int quantity = Integer.parseInt(quantitytf.getText());
		            int rate = Integer.parseInt(ratetf.getText());

		            // Use the global variable selectedFile
		            byte[] imageequip = getImageBytes(selectedFile);


		            // Prepare SQL statement for selecting existing data
		            String selectQuery = "SELECT quantity, noofavailable, noofborrow FROM equipment WHERE equipmentname = ?";
		            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
		                selectStatement.setString(1, equipmentname);
		                ResultSet rSet = selectStatement.executeQuery();

		                if (rSet.next()) {
		                    // Equipment name already exists
		                    JOptionPane.showMessageDialog(null, "Equipment is already exist!", "Error", JOptionPane.ERROR_MESSAGE);
		                } else {
		                    // Prepare SQL statement for inserting data into the database
		                    String insertQuery = "INSERT INTO equipment (equipmentname, quantity, rate, noofavailable, noofborrow, image) VALUES (?, ?, ?, ?, ?, ?)";
		                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
		                        // Bind parameters
		                        insertStatement.setString(1, equipmentname);
		                        insertStatement.setInt(2, quantity);
		                        insertStatement.setInt(3, rate);
		                        insertStatement.setInt(4, quantity); // Assume all items are available initially
		                        insertStatement.setInt(5, 0); // Assume no items are borrowed initially
		                        insertStatement.setBytes(6, imageequip);

		                        // Execute SQL statement
		                        int rowsAffected = insertStatement.executeUpdate();

		                        // Show message dialog based on success or failure
		                        if (rowsAffected > 0) {
		                            JOptionPane.showMessageDialog(null, "Equipment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		                        } else {
		                            JOptionPane.showMessageDialog(null, "Failed to add equipment.", "Error", JOptionPane.ERROR_MESSAGE);
		                        }
		                    }
		                }
		            }

		            // Close the database connection
		            connection.close();

		            // Clear text fields and image preview after insertion
		            equipnametf.setText("");
		            quantitytf.setText("");
		            ratetf.setText("");
		            imageLabel.setIcon(null);
		        } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                    addequipmentf,
                    "An error occurred: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(null, "Equipment saved cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
});

		backequip.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	addequipmentf.setVisible(false);
		    	mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();
		    }
		});

		//border
		equipnametf.setBorder(new LineBorder(Color.BLACK, 2));
		quantitytf.setBorder(new LineBorder(Color.BLACK, 2));
		ratetf.setBorder(new LineBorder(Color.BLACK, 2));
		uploadimg.setBorder(new LineBorder(Color.BLACK, 2));
		imageLabel.setBorder(new LineBorder(Color.BLACK, 2));
		saveequip.setBorder(new LineBorder(cgreen, 2));

        //component
        addequipmentf.add(titletextaddequipment);
        addequipmentf.add(subaddequipment);
        addequipmentf.add(equipname);
        addequipmentf.add(equipnametf);
        addequipmentf.add(quantity);
        addequipmentf.add(quantitytf);
        addequipmentf.add(rate);
        addequipmentf.add(ratetf);
        addequipmentf.add(equipimg);
        addequipmentf.add(uploadimg);
        addequipmentf.add(imgprev);
        addequipmentf.add(imageLabel);
        addequipmentf.add(saveequip);
        addequipmentf.add(backequip);



        //setbounds addequipment
        titletextaddequipment.setBounds(110, 0, 800, 70);
        subaddequipment.setBounds(300, 70, 300, 70);
        equipname.setBounds(160, 150, 220, 30);
        equipnametf.setBounds(160, 177, 240, 30);
        quantity.setBounds(160, 230, 250, 30);
        quantitytf.setBounds(160, 257, 240, 30);
        rate.setBounds(160, 310, 250, 30);
        ratetf.setBounds(160, 337, 240, 30);
        equipimg.setBounds(460, 150, 220, 30);
        uploadimg.setBounds(460, 177, 240, 30);
        imgprev.setBounds(460, 230, 220, 30);
        imageLabel.setBounds(460, 257, 242, 110);
		saveequip.setBounds(430, 400, 180, 40);
		backequip.setBounds(230, 400, 180, 40);
        addequipmentf.setBounds(225, 70, 900, 600);


        // bg
        addequipmentf.getContentPane().setBackground(Color.WHITE);
        addequipmentf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addequipmentf.setLayout(null);
        addequipmentf.setVisible(true);



	   	}
}