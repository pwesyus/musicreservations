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
import javax.swing.event.*;


public class csterms implements designs {
	JFrame clienttermsandcondition = new JFrame("Terms and Condition");

	public void termsandagree(){

		//TERMS AND CONDITION

        JLabel clientterms = new JLabel("TERMS AND CONDITION");
        clientterms.setFont(comp);

        JLabel client11 = new JLabel("1. Reservations can be made by walk-in, through online, or by contacting us.");
        client11.setFont(subtitle);
        JLabel client12 = new JLabel("2. Reservations are subject to availability and are confirmed only upon receiving of payment.");
        client12.setFont(subtitle);

        JLabel client21 = new JLabel("3. The reservation is for a specific time slot as indicated in your booking confirmation.");
        client21.setFont(subtitle);
        JLabel client22 = new JLabel("4. Users are expected to start and finish their sessions promptly within the reserved time.");
        client22.setFont(subtitle);

        JLabel client31 = new JLabel("5. There's no cancellation and refund of the scheduled reservation.");
        client31.setFont(subtitle);

        JLabel client41 = new JLabel("6. 50% payment of the total bill must be paid to confirm the reservation.");
        client41.setFont(subtitle);
        JLabel client42 = new JLabel("7. All of the online reservation is required to go to the studio to pay the 50% of the total bill to confirm the reservation,");
        client42.setFont(subtitle);
        JLabel client421 = new JLabel("failed to pay the downpayment it will automatically cancelled the reservation.");
        client421.setFont(subtitle);
        JLabel client43 = new JLabel("8. The remaining 50% of the total bill is required to pay before entering the room.");
        client43.setFont(subtitle);
        JLabel client44 = new JLabel("9. All of the payment is only made in the cashier of the studio.");
        client44.setFont(subtitle);

        JLabel client51 = new JLabel("10. Users are responsible for the proper use and care of the music room and equipment during their reservation.");
        client51.setFont(subtitle);
        JLabel client52 = new JLabel("11. Any damage or loss caused by the user will be the responsibility of the individual making the reservation.");
        client52.setFont(subtitle);
        JLabel client53 = new JLabel("12. Users are expected to follow a code of conduct that promotes a positive and respectful environment for all.");
        client53.setFont(subtitle);
        JLabel client54 = new JLabel("13. Inappropriate behavior, including but not limited to harassment or any illegal activities,");
        client54.setFont(subtitle);
        JLabel client541 = new JLabel("may result in immediate termination of the reservation.");
        client541.setFont(subtitle);

        JLabel client55 = new JLabel("14. Users are responsible for the security of their personal belongings.");
        client55.setFont(subtitle);

        JLabel client61 = new JLabel("15. The number of individuals allowed in the music room is limited based on the type of room selected.");
        client61.setFont(subtitle);
        JLabel client62 = new JLabel("16. Exceeding this limit may result in additional charges or termination of the reservation.");
        client62.setFont(subtitle);

        JLabel client71 = new JLabel("17. Users must comply with any guidelines provided for the use of equipment within the music room.");
        client71.setFont(subtitle);
        JLabel client72 = new JLabel("18. Users should report any technical issues or concerns to facility staff promptly.");
        client72.setFont(subtitle);

        JLabel client81 = new JLabel("19. We reserve the right to terminate any reservation due to violations of these terms and conditions ");
        client81.setFont(subtitle);
		JLabel client812 = new JLabel("19. We reserve the right to terminate any reservation due to violations of these terms and conditions ");
        client812.setFont(subtitle);

        JLabel client9 = new JLabel("By making a reservation, you acknowledge that you have read, understood, and agree to abide by these terms and conditions.");
        client9.setFont(condition);


        //add
        clienttermsandcondition.add(clientterms);
        clienttermsandcondition.add(client11);
        clienttermsandcondition.add(client12);
        clienttermsandcondition.add(client21);
        clienttermsandcondition.add(client22);
        clienttermsandcondition.add(client31);
        clienttermsandcondition.add(client41);
        clienttermsandcondition.add(client42);
        clienttermsandcondition.add(client421);
        clienttermsandcondition.add(client43);
        clienttermsandcondition.add(client44);
        clienttermsandcondition.add(client51);
        clienttermsandcondition.add(client52);
        clienttermsandcondition.add(client53);
        clienttermsandcondition.add(client54);
        clienttermsandcondition.add(client541);
        clienttermsandcondition.add(client55);
        clienttermsandcondition.add(client61);
        clienttermsandcondition.add(client62);
        clienttermsandcondition.add(client71);
        clienttermsandcondition.add(client72);
        clienttermsandcondition.add(client81);
        clienttermsandcondition.add(client812);
        clienttermsandcondition.add(client9);

        //setbounds add reservation
        clienttermsandcondition.setBounds(225, 70, 900, 600);
        clientterms.setBounds(280, 0, 300, 40);
        client11.setBounds(50, 40, 600, 40);
        client12.setBounds(50, 60, 700, 40);
        client21.setBounds(50, 80, 900, 40);
        client22.setBounds(50, 100, 900, 40);
        client31.setBounds(50, 120, 900, 40);
        client41.setBounds(50, 140, 900, 40);
        client42.setBounds(50, 160, 900, 40);
        client421.setBounds(70, 180, 900, 40);
        client43.setBounds(50, 200, 900, 40);
        client44.setBounds(50, 220, 900, 40);
        client51.setBounds(50, 240, 900, 40);
        client52.setBounds(50, 260, 900, 40);
        client53.setBounds(50, 280, 900, 40);
        client54.setBounds(50, 300, 900, 40);
        client541.setBounds(80, 320, 900, 40);
        client55.setBounds(50, 340, 900, 40);
        client61.setBounds(50, 360, 900, 40);
        client62.setBounds(50, 380, 900, 40);
        client71.setBounds(50, 400, 900, 40);
        client72.setBounds(50, 420, 900, 40);
        client81.setBounds(50, 440, 900, 40);
        client812.setBounds(50, 460, 900, 40);
        client9.setBounds(25, 495, 900, 40);


        // bg
        clienttermsandcondition.getContentPane().setBackground(Color.WHITE);
        clienttermsandcondition.setLayout(null);
        clienttermsandcondition.setVisible(true);
	}
}