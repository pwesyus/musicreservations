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

public class csdashboard implements designs {
    JFrame clientSide = new JFrame("Client Dashboard");
    public static String url = "jdbc:mysql://localhost:3306/musicreservation";
    public static String usernamedb = "root";
    public static String passworddb = "";
    private DefaultTableModel dashboardmodel;
    public static int selectedRow = -1;
    public static int selectedColumn = -1;
    public static int getid = 0;
    public static String getreason;

    private int[] calculateColumnWidths(JTable table) {
        int columnCount = table.getColumnCount();
        int[] columnWidths = new int[columnCount];

        // Calculate widths based on header content
        for (int i = 0; i < columnCount; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int headerWidth = calculateHeaderWidth(column);
            columnWidths[i] = headerWidth;
        }

        return columnWidths;
    }

    private int calculateHeaderWidth(TableColumn column) {
        TableCellRenderer headerRenderer = column.getHeaderRenderer();
        if (headerRenderer == null) {
            headerRenderer = new JTableHeader().getDefaultRenderer();
        }

        Component headerComponent = headerRenderer.getTableCellRendererComponent(null, column.getHeaderValue(),
                false, false, -1, 0);

        return headerComponent.getPreferredSize().width;
    }

    public void clientdashboard() {

        // CLIENT SIDE
        JPanel clientjpnl = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        clientjpnl.setBackground(Color.WHITE);

        JPanel clientjpnl2 = new JPanel();
        clientjpnl2.setBackground(Color.WHITE);

        JPanel clientjpnl3 = new JPanel();
        clientjpnl3.setBackground(Color.WHITE);

        JPanel clientjpnl4 = new JPanel();
        clientjpnl4.setBackground(Color.WHITE);

        // new component
        JLabel clientclienttitletext = new JLabel("MUSIC ROOM RESERVATION");
        clientclienttitletext.setFont(title);

        JLabel clientroomStatusOverviewLbl = new JLabel("ROOM STATUS OVERVIEW");
        clientroomStatusOverviewLbl.setFont(list);

        JLabel clientlblOccupied = new JLabel("OCCUPIED");
        clientlblOccupied.setFont(list);

        JLabel clientlblAvailable = new JLabel("AVAILABLE");
        clientlblAvailable.setFont(list);

        JLabel clientlblReserve = new JLabel("");
        clientlblReserve.setFont(list);

        // actions buttons

        JButton clientoccupied = new JButton("");
        clientoccupied.setFont(listbtn);
        clientoccupied.setBackground(Color.RED);

        JButton clientavailable = new JButton("");
        clientavailable.setFont(listbtn);
        clientavailable.setBackground(Color.WHITE);

        JButton clientreservenow = new JButton("RESERVE NOW!");
        clientreservenow.setFont(listbtn);
        clientreservenow.setBackground(cgreen);
        clientreservenow.setForeground(Color.WHITE);

        JButton clientview = new JButton("VIEW");
        clientview.setFont(listbtn);
        clientview.setBackground(Color.BLACK);
        clientview.setForeground(Color.WHITE);

        JButton clientlogout = new JButton("LOGOUT");
        clientlogout.setFont(listbtn);
        clientlogout.setBackground(cred);
        clientlogout.setForeground(Color.WHITE);

        // room buttons
        JButton clientroom1 = new JButton("MUSIC ROOM 1");
        clientroom1.setFont(roomLblName);
        clientroom1.setBackground(Color.WHITE);

        JButton clientroom2 = new JButton("MUSIC ROOM 2");
        clientroom2.setFont(roomLblName);
        clientroom2.setBackground(Color.WHITE);

        JButton clientroom3 = new JButton("MUSIC ROOM 3");
        clientroom3.setFont(roomLblName);
        clientroom3.setBackground(Color.WHITE);

        // recording room
        JButton clientroom4 = new JButton("RECORDING ROOM 1");
        clientroom4.setFont(roomLblName);
        clientroom4.setBackground(Color.WHITE);

        JButton clientroom5 = new JButton("RECORDING ROOM 2");
        clientroom5.setFont(roomLblName);
        clientroom5.setBackground(Color.WHITE);

        // deluxe room
        JButton clientroom6 = new JButton("DELUXE ROOM 1");
        clientroom6.setFont(roomLblName);
        clientroom6.setBackground(Color.WHITE);

        JButton clientroom7 = new JButton("DELUXE ROOM 2");
        clientroom7.setFont(roomLblName);
        clientroom7.setBackground(Color.WHITE);

        // room status
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
            String sqlQuery = "SELECT id, datereserve, starttime, endtime, typeofroom " +
                  "FROM reservation " +
                  "WHERE datereserve = '" + currentDate + "' " +
                  "AND starttime <= '" + currentTime + "' " +
                  "AND endtime >= '" + currentTime + "' " +
                  "AND status = 'on-going'";
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
                        clientroom1.setForeground(Color.WHITE);
                        clientroom1.setBackground(Color.RED);
                        break;
                    case "MUSIC ROOM 2":
                        clientroom2.setForeground(Color.WHITE);
                        clientroom2.setBackground(Color.RED);
                        break;
                    case "MUSIC ROOM 3":
                        clientroom3.setBackground(Color.RED);
                        clientroom3.setForeground(Color.WHITE);
                        break;
                    case "RECORDING ROOM 1":
                        clientroom4.setBackground(Color.RED);
                        clientroom4.setForeground(Color.WHITE);
                        break;
                    case "RECORDING ROOM 2":
                        clientroom5.setBackground(Color.RED);
                        clientroom5.setForeground(Color.WHITE);
                        break;
                    case "DELUXE ROOM 1":
                        clientroom6.setBackground(Color.RED);
                        clientroom6.setForeground(Color.WHITE);
                        break;
                    case "DELUXE ROOM 2":
                        clientroom7.setBackground(Color.RED);
                        clientroom7.setForeground(Color.WHITE);
                        break;
                    // Add more cases for other room types if needed
                }
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // table
        String dashboardrow[][] = {};
        String dashboardcol[] = { "ID", "NAME", "DATE OF RESERVATION", "START TIME", "END TIME", "ROOM", "STATUS",
                "REASON" };
        dashboardmodel = new DefaultTableModel(dashboardrow, dashboardcol);
        JTable dashboardtbl = new JTable(dashboardmodel);
        JScrollPane dashboardsp = new JScrollPane(dashboardtbl);
        dashboardtbl.setEnabled(true);

        // Set preferred column widths based on content
        int[] columnWidths = calculateColumnWidths(dashboardtbl);

        for (int i = 0; i < dashboardmodel.getColumnCount(); i++) {
            TableColumn column = dashboardtbl.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // set the table and header color and font
        JTableHeader tableHeader = dashboardtbl.getTableHeader();
        tableHeader.setBackground(Color.BLACK);
        tableHeader.setForeground(Color.WHITE);
        dashboardtbl.setBackground(Color.WHITE);
        dashboardtbl.setForeground(Color.BLACK);
        Font headerFont = subtitle;
        tableHeader.setFont(headerFont);

        // set the text in center and font
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setFont(subtitle);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < dashboardmodel.getColumnCount(); i++) {
            dashboardtbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        refreshdashboardtbl();

        // actions

        clientlogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientSide.setVisible(false);
                Login loginf = new Login();
                loginf.logins();
            }
        });
        clientview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientSide.setVisible(false);

                selectedRow = dashboardtbl.getSelectedRow();

                if (selectedRow != -1) {
                    String getidmodel = dashboardmodel.getValueAt(selectedRow, 0).toString();
                    getid = Integer.parseInt(getidmodel);
                    getreason = dashboardmodel.getValueAt(selectedRow, 7).toString();

                    csviewreservation csview = new csviewreservation();
                    csview.csviewreservations(getid, getreason);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to view.", "No Selection",
                            JOptionPane.WARNING_MESSAGE);
                    clientSide.setVisible(true);
                }

            }
        });

        clientreservenow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientSide.setVisible(false);
                csaddreservation csadd = new csaddreservation();
                csadd.clientreservation();

            }
        });

        clientoccupied.setBorder(new LineBorder(Color.RED, 2));

        // rooms SetBounds
        clientclienttitletext.setBounds(110, 0, 800, 70);
        clientroomStatusOverviewLbl.setBounds(50, 70, 400, 80); // dito
        clientoccupied.setBounds(530, 100, 20, 20);
        clientavailable.setBounds(700, 100, 20, 20);
        clientlblOccupied.setBounds(550, 95, 120, 30);
        clientlblAvailable.setBounds(720, 95, 150, 30);
        dashboardsp.setBounds(50, 300, 800, 150);
        clientreservenow.setBounds(600, 470, 200, 50);
        clientlogout.setBounds(100, 470, 180, 50);
        clientview.setBounds(350, 470, 180, 50);
        clientlblReserve.setBounds(450, 470, 180, 150);

        // ROOMS BUTTONS SET BOUNDS
        clientroom1.setBounds(50, 140, 200, 50);
        clientroom2.setBounds(50, 190, 200, 50);
        clientroom3.setBounds(50, 240, 200, 50);
        clientroom4.setBounds(280, 140, 200, 75);
        clientroom5.setBounds(280, 215, 200, 75);
        clientroom6.setBounds(510, 140, 160, 150);
        clientroom7.setBounds(700, 140, 160, 150);

        clientSide.setBounds(225, 70, 900, 600);

        clientjpnl.setBounds(50, 140, 650, 300);

        // add components
        clientSide.add(clientclienttitletext);
        clientSide.add(clientlogout);
        clientSide.add(clientview);

        clientSide.add(clientroomStatusOverviewLbl);
        clientSide.add(clientoccupied);
        clientSide.add(clientavailable);
        clientSide.add(clientlblOccupied);
        clientSide.add(clientlblAvailable);

        clientSide.add(clientroom1);
        clientSide.add(clientroom2);
        clientSide.add(clientroom3);
        clientSide.add(clientroom4);
        clientSide.add(clientroom5);
        clientSide.add(clientroom6);
        clientSide.add(clientroom7);
        clientSide.add(clientreservenow);
        clientSide.add(dashboardsp);
        clientSide.add(clientjpnl);

        // bg
        clientSide.getContentPane().setBackground(Color.WHITE);
        clientSide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientSide.setLayout(null);
        clientSide.setVisible(true);
    }

    public void refreshdashboardtbl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usernamedb, passworddb);
            Statement statement = connection.createStatement();

            // SQL query to select columns from the declineclient table
            String sqlQueryDecline = "SELECT id, fullname, datereserve, starttime, endtime, typeofroom, 'DECLINE' as status, reason FROM declineclient";

            // SQL query to select columns from the reservation table where user is 'client'
            String sqlQueryReservation = "SELECT id, fullname, datereserve, starttime, endtime, typeofroom, status, 'N/A' as reason FROM reservation WHERE user = 'client'";

            // Combine both queries using UNION
            String sqlQuery = sqlQueryDecline + " UNION " + sqlQueryReservation;

            ResultSet rSet = statement.executeQuery(sqlQuery);

            while (rSet.next()) {
                String id = String.valueOf(rSet.getInt(1));
                String fullname = rSet.getString(2);
                String datereserve = String.valueOf(rSet.getDate(3));
                String starttime = String.valueOf(rSet.getTime(4));
                String endtime = String.valueOf(rSet.getTime(5));
                String typeofroom = rSet.getString(6);
                String status = rSet.getString(7);
                String reason = rSet.getString(8);

                String add_row[] = { id, fullname, datereserve, starttime, endtime, typeofroom, status, reason };
                dashboardmodel.addRow(add_row);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}