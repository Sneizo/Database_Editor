package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

/**
 * Create the information bar containing the date and user name
 * @author Mael and Damien
 *
 */
public class InformationBar extends JPanel{
	
	private JLabel date;
	private JLabel user;
	private JLabel hours;
	
	public InformationBar(){
		initComponant();
	}
	
	private void initComponant(){
		
		setBackground(new Color(80, 80, 80));
		
		Font f = new Font("Arimo", Font.PLAIN, 20);
		
		//Récupération de la date
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dat = dateFormat.format(actuelle);
		
		date = new JLabel(dat);
		date.setFont(f);
		date.setForeground(Color.WHITE);
		
		user = new JLabel("User");
		user.setFont(f);
		user.setForeground(Color.WHITE);
		
		Calendar cal = new GregorianCalendar(); 
		int h = cal.get(Calendar.HOUR_OF_DAY); 
		int min = cal.get(Calendar.MINUTE); 
		hours = new JLabel();
		
		String str = String.valueOf(min);
		if(str.length() == 1) {
			str = "0"+str;
		}
		hours.setText(String.valueOf(h)+"h"+str); 
		hours.setFont(f);
		hours.setForeground(Color.WHITE);
		hours.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		BorderLayout br = new BorderLayout();
		setLayout(br);
		add(hours, BorderLayout.CENTER);
		add(user, BorderLayout.WEST);
		add(date, BorderLayout.EAST);
		
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,10,10,10))));
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		
		
		
	}

	/**
	 * @return the date
	 */
	public JLabel getDate() {
		return date;
	}

	/**
	 * @return the user
	 */
	public JLabel getUser() {
		return user;
	}

	/**
	 * @return the hours
	 */
	public JLabel getHours() {
		return hours;
	}

	
	
}
