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


public class mrroom implements designs {
		JFrame roomsModule = new JFrame("Rooms");
		public static String url = "jdbc:mysql://localhost:3306/musicreservation";
	    public static String usernamedb = "root";
	    public static String passworddb = "";

	public void rooms(){
		//ROOMS
        // transparent panel
        JPanel jpnl = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jpnl.setBackground(Color.WHITE);

        JPanel jpnl2 = new JPanel();
        jpnl2.setBackground(Color.WHITE);

        JPanel jpnl3 = new JPanel();
        jpnl3.setBackground(Color.WHITE);

        JPanel jpnl4 = new JPanel();
        jpnl4.setBackground(Color.WHITE);

        JLabel roomtitletext = new JLabel("MUSIC ROOM RESERVATION");
        roomtitletext.setFont(title);

        JLabel roomStatusOverviewLbl = new JLabel("ROOM STATUS OVERVIEW");
        roomStatusOverviewLbl.setFont(list);

        JLabel lblOccupied = new JLabel("OCCUPIED");
        lblOccupied.setFont(list);

        JLabel lblAvailable = new JLabel("AVAILABLE");
        lblAvailable.setFont(list);

        JLabel lbListOfPackages = new JLabel("LIST OF PACKAGE");
        lbListOfPackages.setFont(list);

        JLabel lblMusicRoom = new JLabel("MUSIC ROOM");
        lblMusicRoom.setFont(listbtn);

        JLabel lblMRInclusions = new JLabel("INCLUSIONS:");
        lblMRInclusions.setFont(packageFonts);

        JLabel lblAllMusicalEquipments = new JLabel("* ALL MUSICAL EQUIPMENTS");
        lblAllMusicalEquipments.setFont(roomLblName);

        JLabel lblAllSoundSystems = new JLabel("* ALL SOUND SYSTEMS");
        lblAllSoundSystems.setFont(roomLblName);

        JLabel lblTotalPerson = new JLabel("* TOTAL PERSON INSIDE: 7");
        lblTotalPerson.setFont(roomLblName);

        JLabel lblRoomPrice = new JLabel("* 5,000 PER DAY");
        lblRoomPrice.setFont(roomLblName);

        JLabel lblRoomPriceHr = new JLabel("* 650 PER HOUR");
        lblRoomPriceHr.setFont(roomLblName);

        // 2nd package

        JLabel lblPackageRRoom = new JLabel("RECORDING ROOM");
        lblPackageRRoom.setFont(listbtn);

        JLabel lblPRInclusions = new JLabel("INCLUSIONS:");
        lblPRInclusions.setFont(packageFonts);

        JLabel lblAllRecordingEquipments = new JLabel("* ALL RECORDING EQUIPMENTS");
        lblAllRecordingEquipments.setFont(roomLblName);

        JLabel DAW = new JLabel("* DIGITAL AUDIO WORKSTATION");
        DAW.setFont(roomLblName);

        JLabel PC = new JLabel("* COMPUTER");
        PC.setFont(roomLblName);

        JLabel midi = new JLabel("* MIDI CONTROLLER");
        midi.setFont(roomLblName);

        JLabel PRTotalPerson = new JLabel("* TOTAL PERSON INSIDE: 7");
        PRTotalPerson.setFont(roomLblName);

        JLabel PRPerDay = new JLabel("* 10,000 PER DAY");
        PRPerDay.setFont(roomLblName);

        JLabel PRPerHR = new JLabel("* 1,300 PER HOUR");
        PRPerHR.setFont(roomLblName);

        // 3rd Package
        JLabel lblPackageDRoom = new JLabel("DELUXE ROOM");
        lblPackageDRoom.setFont(listbtn);

        JLabel lblRecordingRoom = new JLabel("RECORDING ROOM");
        lblRecordingRoom.setFont(list);

        JLabel lblDeluxeRoom = new JLabel("DELUXE ROOM");
        lblDeluxeRoom.setFont(list);

        JLabel lblDRInclusions = new JLabel("INCLUSIONS:");
        lblDRInclusions.setFont(packageFonts);

        JLabel lblDRAllRecordingEquipments = new JLabel("* ALL RECORDING EQUIPMENTS");
        lblDRAllRecordingEquipments.setFont(roomLblName);

        JLabel lblDRAllSoundsSystems = new JLabel("* ALL SOUND SYSTEMS");
        lblDRAllSoundsSystems.setFont(roomLblName);

        JLabel DRDAW = new JLabel("* DIGITAL AUDIO WORKSTATION");
        DRDAW.setFont(roomLblName);

        JLabel DRPC = new JLabel("* COMPUTER");
        DRPC.setFont(roomLblName);

        JLabel DRmidi = new JLabel("* MIDI CONTROLLER");
        DRmidi.setFont(roomLblName);

        JLabel DRTotalPerson = new JLabel("* TOTAL PERSON INSIDE: 15");
        DRTotalPerson.setFont(roomLblName);

        JLabel DRPerDay = new JLabel("* 20,000 PER DAY");
        DRPerDay.setFont(roomLblName);

        JLabel DRRoomHr = new JLabel("* 2,600 PER HOUR");
        DRRoomHr.setFont(roomLblName);

        // actions buttons

        JButton occupied = new JButton("");
        occupied.setFont(listbtn);
        occupied.setBackground(Color.RED);

        JButton available = new JButton("");
        available.setFont(listbtn);
        available.setBackground(Color.WHITE);

        // room buttons
        JButton room1 = new JButton("MUSIC ROOM 1");
        room1.setFont(roomLblName);
        room1.setBackground(Color.WHITE);

        JButton room2 = new JButton("MUSIC ROOM 2");
        room2.setFont(roomLblName);
        room2.setBackground(Color.WHITE);

        JButton room3 = new JButton("MUSIC ROOM 3");
        room3.setFont(roomLblName);
        room3.setBackground(Color.WHITE);

        // recording room
        JButton room4 = new JButton("RECORDING ROOM 1");
        room4.setFont(roomLblName);
        room4.setBackground(Color.WHITE);

        JButton room5 = new JButton("RECORDING ROOM 2");
        room5.setFont(roomLblName);
        room5.setBackground(Color.WHITE);

        // deluxe room
        JButton room6 = new JButton("DELUXE ROOM 1");
        room6.setFont(roomLblName);
        room6.setBackground(Color.WHITE);

        JButton room7 = new JButton("DELUXE ROOM 2");
        room7.setFont(roomLblName);
        room7.setBackground(Color.WHITE);

        // menu buttons
        ImageIcon roomdashboardimg = new ImageIcon("../pictures/dashboard.png");
        JButton roomdashboardbtn = new JButton(roomdashboardimg);

        ImageIcon roomreservationimg = new ImageIcon("../pictures/reservation.png");
        JButton roomreservationbtn = new JButton(roomreservationimg);

        ImageIcon roomroomsimg = new ImageIcon("../pictures/roomsactive.png");
        JButton roomroomsbtn = new JButton(roomroomsimg);

        ImageIcon roomequipmentsimg = new ImageIcon("../pictures/equipment.png");
        JButton roomequipmentsbtn = new JButton(roomequipmentsimg);

        ImageIcon roomsettingsimg = new ImageIcon("../pictures/settings.png");
        JButton roomsettingsbtn = new JButton(roomsettingsimg);

        ImageIcon roomlogoutimg = new ImageIcon("../pictures/logout.png");
        JButton roomlogoutbtn = new JButton(roomlogoutimg);

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
    Statement statement = connection.createStatement();

    // Get the current date and time
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String currentDate = currentDateTime.format(dateFormatter);
    String currentTime = currentDateTime.format(timeFormatter);

    // Query to retrieve reservations matching the conditions
    String sqlQuery = "SELECT id, datereserve, starttime, endtime, typeofroom FROM reservation " +
                      "WHERE datereserve = '" + currentDate + "' " +
                      "AND starttime <= '" + currentTime + "' AND endtime >= '" + currentTime + "'";
    ResultSet resultSet = statement.executeQuery(sqlQuery);

    while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String dateReserve = resultSet.getString("datereserve");
        String startTime = resultSet.getString("starttime");
        String endTime = resultSet.getString("endtime");
        String roomType = resultSet.getString("typeofroom");

        // Update button colors based on room type
        switch (roomType) {
            case "MUSIC ROOM 1":
            	room1.setForeground(Color.WHITE);
                room1.setBackground(Color.RED);
                break;
            case "MUSIC ROOM 2":
            	room2.setForeground(Color.WHITE);
                room2.setBackground(Color.RED);
                break;
            case "MUSIC ROOM 3":
                room3.setBackground(Color.RED);
                room3.setForeground(Color.WHITE);
                break;
            case "RECORDING ROOM 1":
                room4.setBackground(Color.RED);
                room4.setForeground(Color.WHITE);
                break;
            case "RECORDING ROOM 2":
                room5.setBackground(Color.RED);
                room5.setForeground(Color.WHITE);
                break;
            case "DELUXE ROOM 1":
                room6.setBackground(Color.RED);
                room6.setForeground(Color.WHITE);
                break;
            case "DELUXE ROOM 2":
                room7.setBackground(Color.RED);
                room7.setForeground(Color.WHITE);
                break;
            // Add more cases for other room types if needed
        }
    }

    connection.close();
} catch (Exception ex) {
    ex.printStackTrace();
}

	    roomlogoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                Login loginf = new Login();
        		loginf.logins();

            }
        });

		roomdashboardbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                mrdashboard dash = new mrdashboard();
        		dash.dashboard();

            }
        });

		roomreservationbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                mrreservationtbl reserve = new mrreservationtbl();
        		reserve.reservations();

            }
        });
        roomroomsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                mrroom room = new mrroom();
        		room.rooms();

            }
        });

        roomequipmentsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                mrequipmenttbl equipment = new mrequipmenttbl();
        		equipment.equipments();

            }
        });
        roomsettingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roomsModule.setVisible(false);
                mrsettings setting = new mrsettings();
        		setting.settings();

            }
        });


        // border of button
        jpnl.setBorder(new LineBorder(Color.BLACK, 2));
        jpnl2.setBorder(new LineBorder(Color.BLACK, 2));
        jpnl3.setBorder(new LineBorder(Color.BLACK, 2));
        jpnl4.setBorder(new LineBorder(Color.BLACK, 2));
        room1.setBorder(new LineBorder(Color.BLACK, 2));
        room2.setBorder(new LineBorder(Color.BLACK, 2));
        room3.setBorder(new LineBorder(Color.BLACK, 2));
        room4.setBorder(new LineBorder(Color.BLACK, 2));
        room5.setBorder(new LineBorder(Color.BLACK, 2));
        room6.setBorder(new LineBorder(Color.BLACK, 2));
        room7.setBorder(new LineBorder(Color.BLACK, 2));

        occupied.setBorder(new LineBorder(Color.RED, 2));

        roomdashboardbtn.setBorder(new LineBorder(Color.BLACK, 3));
        roomreservationbtn.setBorder(new LineBorder(Color.BLACK, 3));
        roomroomsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        roomequipmentsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        roomsettingsbtn.setBorder(new LineBorder(Color.BLACK, 3));
        roomlogoutbtn.setBorder(new LineBorder(Color.BLACK, 3));

        // rooms SetBounds
        roomtitletext.setBounds(110, 0, 800, 70);
        roomStatusOverviewLbl.setBounds(210, 70, 400, 80); // dito
        occupied.setBounds(530, 100, 20, 20);
        available.setBounds(700, 100, 20, 20);
        lblOccupied.setBounds(550, 95, 120, 30);
        lblAvailable.setBounds(720, 95, 150, 30);
        lbListOfPackages.setBounds(460, 290, 300, 100);

        jpnl.setBounds(210, 150, 650, 160);
        // package 1
        lblMusicRoom.setBounds(250, 300, 200, 160);
        lblMRInclusions.setBounds(270, 330, 200, 160);
        lblAllMusicalEquipments.setBounds(230, 370, 170, 100);
        lblAllSoundSystems.setBounds(230, 380, 170, 100);
        lblTotalPerson.setBounds(230, 390, 170, 100);
        lblRoomPrice.setBounds(230, 400, 170, 100);
        lblRoomPriceHr.setBounds(230, 410, 170, 100);
        jpnl2.setBounds(210, 360, 200, 160);
        // package 2
        lblPackageRRoom.setBounds(460, 300, 200, 160);
        lblPRInclusions.setBounds(510, 320, 200, 160);
        lblAllRecordingEquipments.setBounds(440, 330, 200, 160);
        DAW.setBounds(440, 340, 200, 160);
        PC.setBounds(440, 350, 200, 160);
        midi.setBounds(440, 360, 200, 160);
        PRTotalPerson.setBounds(440, 370, 200, 160);
        PRPerDay.setBounds(440, 380, 200, 160);
        PRPerHR.setBounds(440, 390, 200, 160);
        // package 3
        lblPackageDRoom.setBounds(710, 300, 200, 160);
        lblDRInclusions.setBounds(720, 315, 200, 160);
        lblDRAllRecordingEquipments.setBounds(670, 325, 200, 160);
        lblDRAllSoundsSystems.setBounds(670, 335, 200, 160);
        DRDAW.setBounds(670, 345, 200, 160);
        DRPC.setBounds(670, 355, 200, 160);
        DRmidi.setBounds(670, 365, 200, 160);
        DRTotalPerson.setBounds(670, 375, 200, 160);
        DRPerDay.setBounds(670, 385, 200, 160);
        DRRoomHr.setBounds(670, 395, 200, 160);
        jpnl3.setBounds(435, 360, 200, 160);
        jpnl4.setBounds(660, 360, 200, 160);

        // ROOMS BUTTONS SET BOUNDS
        room1.setBounds(210, 150, 150, 52);
        room2.setBounds(210, 202, 150, 52);
        room3.setBounds(210, 254, 150, 55);
        room4.setBounds(390, 150, 150, 80);
        room5.setBounds(390, 230, 150, 80);
        room6.setBounds(570, 150, 130, 160);
        room7.setBounds(730, 150, 130, 160);

        // recording room

        roomdashboardbtn.setBounds(30, 86, 150, 65);
        roomreservationbtn.setBounds(30, 161, 150, 65);
        roomroomsbtn.setBounds(30, 236, 150, 65);
        roomequipmentsbtn.setBounds(30, 311, 150, 65);
        roomsettingsbtn.setBounds(30, 386, 150, 65);
        roomlogoutbtn.setBounds(30, 461, 150, 65);

        // reservesp.setBounds(210, 130, 640, 300);
        roomsModule.setBounds(225, 70, 900, 600);

        // add components
        roomsModule.add(roomtitletext);
        roomsModule.add(roomStatusOverviewLbl);
        roomsModule.add(occupied);
        roomsModule.add(available);
        roomsModule.add(lblOccupied);
        roomsModule.add(lblAvailable);
        roomsModule.add(lbListOfPackages);
        roomsModule.add(room1);
        roomsModule.add(room2);
        roomsModule.add(room3);
        roomsModule.add(room4);
        roomsModule.add(room5);
        roomsModule.add(room6);
        roomsModule.add(room7);
        roomsModule.add(jpnl);
        roomsModule.add(lblMusicRoom);
        roomsModule.add(lblMRInclusions);
        roomsModule.add(lblAllMusicalEquipments);
        roomsModule.add(lblAllSoundSystems);
        roomsModule.add(lblTotalPerson);
        roomsModule.add(lblRoomPrice);
        roomsModule.add(lblRoomPriceHr);
        roomsModule.add(lblPackageRRoom);
        roomsModule.add(lblPRInclusions);
        roomsModule.add(lblAllRecordingEquipments);
        roomsModule.add(DAW);
        roomsModule.add(PC);
        roomsModule.add(midi);
        roomsModule.add(PRTotalPerson);
        roomsModule.add(PRPerDay);
        roomsModule.add(PRPerHR);
        roomsModule.add(lblPackageDRoom);
        roomsModule.add(lblDRInclusions);
        roomsModule.add(lblDRAllRecordingEquipments);
        roomsModule.add(lblDRAllSoundsSystems);
        roomsModule.add(DRDAW);
        roomsModule.add(DRPC);
        roomsModule.add(DRmidi);
        roomsModule.add(DRTotalPerson);
        roomsModule.add(DRPerDay);
        roomsModule.add(DRRoomHr);

        roomsModule.add(jpnl2);
        roomsModule.add(jpnl3);
        roomsModule.add(jpnl4);

        // room buttons

        roomsModule.add(roomdashboardbtn);
        roomsModule.add(roomreservationbtn);
        roomsModule.add(roomroomsbtn);
        roomsModule.add(roomequipmentsbtn);
        roomsModule.add(roomsettingsbtn);
        roomsModule.add(roomlogoutbtn);

        // bg
        roomsModule.getContentPane().setBackground(Color.WHITE);
        roomsModule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        roomsModule.setLayout(null);
        roomsModule.setVisible(true);
	}
}
