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


	    public void forapproved(){
		// equipment TABLE
        JLabel forapprovedtitletext = new JLabel("MUSIC ROOM RESERVATION");
        forapprovedtitletext.setFont(title);

		JLabel forapprovedlist = new JLabel("LIST OF RESERVATION REQUESTS");
		forapprovedlist.setFont(list);

		String forapprovedrow[][] = {};
        String forapprovedcol[] = { "ID", "NAME", "DATE OF REQUEST", "TYPE OF ROOM", "DATE OF PAYMENT", "START TIME", "END TIME", "GRAND TOTAL" };
        DefaultTableModel forapprovedmodel = new DefaultTableModel(forapprovedrow, forapprovedcol);
        JTable forapprovedtbl = new JTable(forapprovedmodel);
        JScrollPane forapprovedsp = new JScrollPane(forapprovedtbl);
        forapprovedtbl.setEnabled(false);

        //set the table and header color and font
        JTableHeader forapprovedtableHeader = forapprovedtbl.getTableHeader();
        forapprovedtableHeader.setBackground(Color.BLACK);
        forapprovedtableHeader.setForeground(Color.WHITE);
        forapprovedtbl.setBackground(Color.WHITE);
        forapprovedtbl.setForeground(Color.BLACK);
		Font forapprovedheaderFont = subtitle;
		forapprovedtableHeader.setFont(forapprovedheaderFont);


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
}