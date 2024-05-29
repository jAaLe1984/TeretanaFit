package Gym;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;




import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		
		FlatDraculaIJTheme.setup();
		setType(Type.UTILITY);
		 setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 455);
		// Ova metoda centrirati će formu na sredinu ekrana
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 796, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 283, 459);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTEG = new JLabel("New label");
		lblTEG.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/morty2.gif")));
		lblTEG.setBounds(0, 0, 283, 225);
		panel_1.add(lblTEG);
		
		JLabel lblkingsbox = new JLabel("");
		lblkingsbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/box2.gif")));
		lblkingsbox.setBounds(39, 253, 221, 195);
		panel_1.add(lblkingsbox);
		
		JLabel lblNaslov = new JLabel("Teretana & Fitness");
		lblNaslov.setHorizontalAlignment(SwingConstants.LEFT);
		lblNaslov.setForeground(new Color(128, 128, 255));
		lblNaslov.setFont(new Font("Verdana Pro", Font.PLAIN, 41));
		lblNaslov.setBounds(343, 11, 390, 71);
		panel.add(lblNaslov);
		
		JLabel lblgymmy = new JLabel("");
		lblgymmy.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/teg2.gif")));
		lblgymmy.setBounds(343, 72, 346, 136);
		panel.add(lblgymmy);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setForeground(new Color(0, 0, 0));
		textFieldUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldUserName.getText().equals("username")) {
		            // Clear placeholder text when the field is focused
		            textFieldUserName.setText("");
		            textFieldUserName.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				 if (textFieldUserName.getText().isEmpty()) {
			            // Restore placeholder text if the field is empty
			            textFieldUserName.setText("username");
			            textFieldUserName.setForeground(new Color(126, 126, 126));
			        }
				
			}
		});
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUserName.setBackground(new Color(128, 128, 255));
		textFieldUserName.setBounds(359, 256, 362, 26);
		panel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				char[] passwordChars = passwordField.getPassword();
		        String password = new String(passwordChars).trim();
		        if (password.equals("password")) {
		            passwordField.setText("");
		            passwordField.setForeground(Color.BLACK);
		            passwordField.setEchoChar('*'); // Hide characters after focus is gained
		        
		    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				  char[] passwordChars = passwordField.getPassword();
			        String password = new String(passwordChars).trim();
			        if (password.isEmpty()) {
			            // Restore placeholder text if the field is empty
			            passwordField.setText("password");
			            passwordField.setForeground(new Color(126, 126, 126));
			            passwordField.setEchoChar((char)0); // Show characters in field for placeholder text
			        }
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBackground(new Color(128, 128, 255));
		passwordField.setBounds(359, 342, 362, 26);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(128, 128, 255));
		lblNewLabel.setBounds(455, 219, 169, 26);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(128, 128, 255));
		lblPassword.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		lblPassword.setBounds(455, 305, 169, 26);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String username = textFieldUserName.getText().trim();
			        String password = new String(passwordField.getPassword()).trim();

			        if (username.isEmpty() || password.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        try {
			        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			            String query = "SELECT * FROM `logintbl` WHERE `username`= ? AND `password`= ?";
			            PreparedStatement preparedStatement = connection.prepareStatement(query);
			            preparedStatement.setString(1, username);
			            preparedStatement.setString(2, password);
			            ResultSet resultSet = preparedStatement.executeQuery();

			            if (resultSet.next()) {
			                
			                // Prelazak na sledeci screen 
			            	MembersForm membersForm = new MembersForm();
			            	membersForm.setVisible(true);
			            	
			            	dispose();
			            } else {
			                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			            resultSet.close();
			            preparedStatement.close();
			            connection.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setFont(new Font("Verdana Pro", Font.PLAIN, 20));
		btnNewButton.setBounds(455, 399, 169, 35);
		panel.add(btnNewButton);
		
		//ActionListener:
			//btnNewButton ima dodat ActionListener koji reaguje na događaj klika. Kada korisnik klikne na dugme, izvršava se blok koda unutar metode actionPerformed.
			//Logika za Autentifikaciju
			//Provera Korisničkog Imena i Lozinke:
			//Iz tekstualnih polja se izvlače korisničko ime i lozinka, pri čemu se oba podatka odmažu od suvišnih praznih mesta (trim()).
			//Ako su polja za korisničko ime ili lozinka prazna, prikazuje se poruka o grešci koristeći JOptionPane.
			//Povezivanje sa Bazom i Izvršavanje SQL Upita
			//Konekcija sa Bazom:
			//Uspostavlja se konekcija sa MySQL bazom podataka gymdb.
			//Priprema se SQL upit koji proverava postojanje korisničkog imena i lozinke u tabeli logintbl.
			//zvršava se upit i rezultati se čuvaju u ResultSet.
			//Obrada Rezultata
			//Validacija Korisnika:
			//Ako upit vrati red (tj. korisničko ime i lozinka se poklapaju sa unetim vrednostima), korisnik se uspešno prijavljuje i otvara se novi prozor (MembersForm), a trenutni prozor se zatvara (dispose()).
			//Ako rezultati ne sadrže nijedan red, prikazuje se poruka o nevalidnom korisničkom imenu ili lozinci.
			//Obrada Izuzetaka
			//Obrada SQL Izuzetaka:
			//Ukoliko dođe do SQL izuzetka tokom procesa povezivanja, izvršavanja upita ili obrade rezultata, izuzetak se hvata i štampa, a korisniku se prikazuje poruka o grešci.
			//Zaključak
			//Kod pruža funkcionalnost za prijavljivanje korisnika uz proveru kredencijala iz baze podataka, omogućavajući siguran pristup aplikaciji. 
		
		JLabel lblClose = new JLabel(" X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//zatvaranje forme 
				  Window window = SwingUtilities.windowForComponent(lblClose);
			        window.dispose();
			}
		});
		lblClose.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Yu Gothic UI", Font.BOLD, 33));
		lblClose.setBounds(732, 11, 54, 44);
		panel.add(lblClose);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// prikazivanje i otkrivanje passworda 
				if(chckbxNewCheckBox.isSelected())
				{
					passwordField.setEchoChar((char)0);
				} else 
				{
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setForeground(new Color(255, 128, 255));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(359, 375, 116, 17);
		panel.add(chckbxNewCheckBox);
		
	
			//JCheckBox chckbxNewCheckBox je kreirana sa oznakom "Show password". Ova komponenta omogućava korisniku da klikne na kućicu kako bi se promenilo stanje prikazivanja teksta u polju za lozinku.
			//Dodavanje Osluškivača za Akciju
			//ActionListener:
			//Na chckbxNewCheckBox se dodaje ActionListener koji reaguje kada korisnik izvrši akciju (npr. klikne na kućicu). Kada se dogodi akcija, izvršava se metoda actionPerformed.
			//Logika za Prikazivanje i Skrivanje Lozinke
			//Provera stanja JCheckBox-a:
			//Unutar metode actionPerformed, prvo se proverava da li je kućica za potvrdu (chckbxNewCheckBox) označena koristeći isSelected(). Ako je označena, to znači da korisnik želi da vidi lozinku koju unosi.
			//Promena načina prikaza lozinke:
			//Ako je kućica označena (isSelected() == true):
			//passwordField.setEchoChar((char)0); - Ova linija koda postavlja karakter koji se koristi za prikazivanje lozinki u JPasswordField na nulu (char 0), što efektivno čini lozinku vidljivom jer ne postoji vizuelna maska.
			//Ako kućica nije označena (isSelected() == false):
			//passwordField.setEchoChar('*'); - Vraća karakter za prikrivanje unosa u JPasswordField na zvezdicu (*), čime se lozinka ponovo prikriva.
			//Zaključak
			//Ovaj kod efikasno omogućava korisnicima da kontroliraju da li žele da njihova lozinka bude vidljiva tokom unosa, što je korisno u situacijama kada je teško tačno uneti lozinku koristeći samo maskirani unos
	}
}
