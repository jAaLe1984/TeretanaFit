package Gym;


import java.awt.Color;
 

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.regex.Pattern;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;


import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class CoachsForm extends JFrame  {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField CPhone;
	private JTextField CoachsName;
	private  JTextField CAge;
    private JTextField CAddress;
    JTextField CGen = new JTextField();
    JTextField CId = new JTextField();
    JTable Coachtbl = new JTable();



	protected JTable model;

	protected Integer Key;
	private JTextField textFieldTrainers;
    
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	
		
		public CoachsForm() {
		setType(Type.UTILITY);
	;
	        FlatDraculaIJTheme.setup();
			setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 943, 803);
			// Ova metoda centrirati će formu na sredinu ekrana
	        setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setBounds(0, 0, 944, 803);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(128, 128, 255));
			panel_1.setBounds(0, 0, 230, 803);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblMembers = new JLabel("Members");
			lblMembers.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new MembersForm().setVisible(true);
					Window parentWindow = SwingUtilities.getWindowAncestor(lblMembers);
			        parentWindow.dispose();
					
				}
			});
			lblMembers.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
			lblMembers.setHorizontalAlignment(SwingConstants.CENTER);
			lblMembers.setOpaque(true);
			lblMembers.setBackground(new Color(96, 79, 162));
			lblMembers.setFont(new Font("Verdana Pro", Font.BOLD, 20));
			lblMembers.setBounds(35, 61, 165, 35);
			panel_1.add(lblMembers);
			
			JLabel lblPayment = new JLabel("Payment");
			lblPayment.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					PaymentForm paymentForm = new PaymentForm();
			        paymentForm.setVisible(true);
			        Window parentWindow = SwingUtilities.getWindowAncestor(lblPayment);
			        parentWindow.dispose();
				}
			});
			lblPayment.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
			lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
			lblPayment.setOpaque(true);
			lblPayment.setFont(new Font("Verdana Pro", Font.BOLD, 20));
			lblPayment.setBackground(new Color(96, 79, 162));
			lblPayment.setBounds(35, 139, 165, 35);
			panel_1.add(lblPayment);
			
			JLabel lblLogoutCoachs = new JLabel("Logout");
			lblLogoutCoachs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					LoginForm loginForm = new LoginForm();
			        loginForm.setVisible(true);
			        Window parentWindow = SwingUtilities.getWindowAncestor(lblLogoutCoachs);
			        if (parentWindow != null) {
			            parentWindow.dispose();
			        }
				}
			});
			lblLogoutCoachs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
			lblLogoutCoachs.setOpaque(true);
			lblLogoutCoachs.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoutCoachs.setFont(new Font("Verdana Pro", Font.BOLD, 20));
			lblLogoutCoachs.setBackground(new Color(96, 79, 162));
			lblLogoutCoachs.setBounds(37, 672, 165, 35);
			panel_1.add(lblLogoutCoachs);
			
			   //MouseListener je dodat na labelu, koji reaguje na događaj klika mišem. Kada korisnik klikne na labelu "Logout", pokreće se metod mouseClicked.
				//U ovom metodu, kreiran je novi objekat LoginForm, koji se zatim prikazuje (setVisible(true)), omogućavajući korisniku da se ponovo prijavi.
				//Takođe, pronalazi se prozor koji je roditelj labeli (lblLogoutCoachs) koristeći SwingUtilities.getWindowAncestor, i zatim se taj prozor zatvara (dispose()), efektivno zatvarajući trenutnu sesiju i vraćajući korisnika na ekran za prijavu.
			
			
			JLabel lblgymgols = new JLabel("");
			lblgymgols.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/g2.gif")));
			lblgymgols.setBounds(0, 204, 230, 275);
			panel_1.add(lblgymgols);
			
			JLabel lblCoachsLogo = new JLabel("");
			lblCoachsLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/trener.jpg")));
			lblCoachsLogo.setBounds(52, 537, 123, 108);
			panel_1.add(lblCoachsLogo);
			
			JLabel lblNewLabel_1_1 = new JLabel("Coachs");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1.setFont(new Font("Verdana Pro", Font.BOLD, 20));
			lblNewLabel_1_1.setBackground(Color.BLACK);
			lblNewLabel_1_1.setBounds(49, 490, 126, 21);
			panel_1.add(lblNewLabel_1_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(96, 79, 162));
			panel_2.setBounds(231, 0, 713, 31);
			panel.add(panel_2);
			
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
			lblClose.setBounds(877, 55, 57, 44);
			panel.add(lblClose);
			
			JLabel lblMenageCoachs = new JLabel("Insert Coachs");
			lblMenageCoachs.setForeground(new Color(128, 128, 255));
			lblMenageCoachs.setOpaque(true);
			lblMenageCoachs.setHorizontalAlignment(SwingConstants.CENTER);
			lblMenageCoachs.setFont(new Font("Verdana Pro", Font.BOLD, 22));
			lblMenageCoachs.setBackground(new Color(0, 0, 0));
			lblMenageCoachs.setBounds(375, 55, 391, 31);
			panel.add(lblMenageCoachs);
			
			JLabel lblCoachName = new JLabel("Coachs Name");
			lblCoachName.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblCoachName.setForeground(new Color(128, 128, 192));
			lblCoachName.setBounds(260, 97, 141, 31);
			panel.add(lblCoachName);
			
		
			CoachsName = new JTextField();
			CoachsName.setBackground(new Color(128, 128, 255));
			CoachsName.setForeground(new Color(0, 0, 0));
			CoachsName.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
			CoachsName.setBounds(260, 150, 176, 26);
			panel.add(CoachsName);
			CoachsName.setColumns(10);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setForeground(new Color(128, 128, 192));
			lblPhoneNumber.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblPhoneNumber.setBounds(492, 97, 150, 31);
			panel.add(lblPhoneNumber);
			
			CPhone = new JTextField();
			CPhone.setBackground(new Color(128, 128, 255));
			CPhone.setForeground(new Color(0, 0, 0));
			CPhone.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
			CPhone.setColumns(10);
			CPhone.setBounds(492, 150, 176, 26);
			panel.add(CPhone);
			
			JLabel lblAge = new JLabel("Age");
			lblAge.setForeground(new Color(128, 128, 192));
			lblAge.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblAge.setBounds(749, 97, 96, 31);
			panel.add(lblAge);
			
			CAge = new JTextField();
			CAge.setBackground(new Color(128, 128, 255));
			CAge.setForeground(new Color(0, 0, 0));
			CAge.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
			CAge.setColumns(10);
			CAge.setBounds(745, 150, 87, 26);
			panel.add(CAge);
			
			JComboBox CGen = new JComboBox();
			CGen.setBackground(new Color(128, 128, 255));
			CGen.setForeground(new Color(255, 0, 255));
			CGen.setModel(new DefaultComboBoxModel(new String[] {"Please select gender","Male", "Female"}));
			CGen.setName("Male,Female");
			CGen.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
			CGen.setBounds(498, 266, 120, 26);
			panel.add(CGen);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setForeground(new Color(128, 128, 192));
			lblGender.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblGender.setBounds(492, 212, 96, 31);
			panel.add(lblGender);
			
			JLabel lblAdress = new JLabel("Adress");
			lblAdress.setForeground(new Color(128, 128, 192));
			lblAdress.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblAdress.setBounds(260, 212, 150, 31);
			panel.add(lblAdress);
			
			CAddress = new JTextField();
			CAddress.setBackground(new Color(128, 128, 255));
			CAddress.setForeground(new Color(0, 0, 0));
			CAddress.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
			CAddress.setColumns(10);
			CAddress.setBounds(262, 266, 211, 26);
			panel.add(CAddress);
			
			
			
			JButton btnAdd_2 = new JButton("Add");
			btnAdd_2.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (CoachsName.getText().isEmpty() || CPhone.getText().isEmpty() || CAge.getText().isEmpty() || CAddress.getText().isEmpty() || CGen.getSelectedIndex() == -1) {
			            JOptionPane.showMessageDialog(btnAdd_2, "Please fill in all fields.");
			        } else {
			            new Thread(() -> { // Move database operations to a new thread
			                try {
			                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO coachtbl(CName, CPhone, CAge, CAddress, CGen) VALUES (?, ?, ?, ?, ?)");
			                    preparedStatement.setString(1, CoachsName.getText());
			                    preparedStatement.setString(2, CPhone.getText());
			                    preparedStatement.setInt(3, Integer.parseInt(CAge.getText()));
			                    preparedStatement.setString(4, CAddress.getText());
			                    preparedStatement.setString(5, CGen.getSelectedItem().toString());

			                    int rows = preparedStatement.executeUpdate();
			                    if (rows > 0) {
			                        SwingUtilities.invokeLater(() -> {
			                            JOptionPane.showMessageDialog(btnAdd_2, "Coach added successfully.");
			                            DisplayCoachs(); // Refresh the coach display
			                        });
			                    }
			                    connection.close();
			                } catch (Exception ex) {
			                    SwingUtilities.invokeLater(() -> {
			                        JOptionPane.showMessageDialog(btnAdd_2, "An error occurred: " + ex.getMessage());
			                    });
			                    ex.printStackTrace();
			                }
			            }).start();
			        }
			    }
			});
			
           btnAdd_2.setForeground(new Color(255, 0, 128));
			btnAdd_2.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 15));
			btnAdd_2.setBackground(new Color(128, 128, 255));
			btnAdd_2.setBounds(354, 393, 98, 26);
			panel.add(btnAdd_2);
			
			// Display the coaches in the table
						DisplayCoachs();
			
//Ovaj deo koda implementira funkcionalnost dodavanja novog trenera u bazu podataka kroz Java Swing aplikaciju. Evo detaljnog opisa svakog segmenta koda:
//Funkcionalnost Osluškivača Miša
//MouseListener:
//Na dugme je dodat MouseListener koji reaguje na događaj klika mišem.
//Unutar metode mouseClicked, prvo se proverava da li su sva potrebna polja popunjena (ime trenera, telefon, godine, adresa, pol). Ako neko od polja nije popunjeno ili nije izabran pol iz padajućeg menija (Cgen), prikazuje se poruka o grešci tražeći od korisnika da popuni sva polja.
//zvršavanje Operacija u Pozadini
//Izvršavanje u Novom Threadu:
//Ako su sva polja popunjena, kreiranje i umetanje podataka u bazu se pokreće u novom threadu da se izbegne blokiranje grafičkog interfejsa.
//U okviru threada, uspostavlja se konekcija sa bazom podataka (jdbc:mysql://localhost:3306/gymdb) koristeći korisničko ime "root" bez lozinke.
//SQL Operacije
//Pripremljena Naredba (PreparedStatement):

//Formira se SQL naredba za umetanje (INSERT) novih podataka o treneru u tabelu coachtbl.
//Postavljaju se vrednosti koje se uzimaju direktno iz GUI komponenata: ime trenera, telefon, godine, adresa, i pol.
//Izvršavanje i Obrada Rezultata:

//Naredba se izvršava i proverava se da li je dodavanje uspešno (ako je broj izmenjenih redova veći od 0).
//U zavisnosti od rezultata, na grafičkom interfejsu se prikazuje odgovarajuća poruka (uspeh ili greška), a lista trenera se osvežava.
//Obrada Izuzetaka
//Obrada Izuzetaka:
//Svi pokušaji povezivanja i izmena u bazi su obuhvaćeni blokom try-catch za hvatanje izuzetaka. U slučaju greške, korisniku se prikazuje poruka o grešci, a greška se štampa u konzoli.
			
			
			
			
			JButton btnEdit = new JButton("Edit");
			btnEdit.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (Key == 0) {
			            JOptionPane.showMessageDialog(btnEdit, "No Coach Selected for Editing");
			        } else {
			            try {
			                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			                String query = "UPDATE coachtbl SET CName = ?, CPhone = ?, CAge = ?, CAddress = ?, CGen = ? WHERE CId = ?";
			                PreparedStatement preparedStatement = connection.prepareStatement(query);
			                
			                preparedStatement.setString(1, CoachsName.getText());
			                preparedStatement.setString(2, CPhone.getText());
			                preparedStatement.setInt(3, Integer.parseInt(CAge.getText()));
			                preparedStatement.setString(4, CAddress.getText());                                                                                
			                preparedStatement.setString(5, CGen.getSelectedItem().toString());
			                preparedStatement.setInt(6, Key);
			                
			                int rows = preparedStatement.executeUpdate();

			                if (rows > 0) {
			                    JOptionPane.showMessageDialog(btnEdit, "Coach Edited Successfully");
			                    DisplayCoachs(); // Refresh the display of coaches
			                } else {
			                    JOptionPane.showMessageDialog(btnEdit, "Update Failed");
			                }

			                connection.close();

			            } catch (Exception e2) {
			                e2.printStackTrace(); // or log the error
			                JOptionPane.showMessageDialog(btnEdit, "Error occurred: " + e2.getMessage());
			            }
			        }
			    }
			});

			btnEdit.setForeground(new Color(255, 0, 128));
			btnEdit.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 15));
			btnEdit.setBackground(new Color(128, 128, 255));
			btnEdit.setBounds(510, 393, 98, 26);
			panel.add(btnEdit);
			
			//Dugme za izmenu (Edit Button):
			//JButton btnEdit je dugme sa tekstom "Edit".
		
			//Na dugme je dodat MouseListener koji reaguje na klik mišem.
			//Unutar metode mouseClicked, prvo se proverava da li je selektovan neki trener (promenljiva Key). Ako Key iznosi 0, to znači da nijedan trener nije izabran i korisniku se prikazuje poruka o grešci.
			//Ako je trener izabran (Key nije 0), pokreće se proces izmene podataka u bazi.
			//Operacije s Bazom Podataka
			//Konekcija na Bazu Podataka:

			//Uspostavlja se konekcija sa lokalnom bazom podataka MySQL (jdbc:mysql://localhost:3306/gymdb) koristeći korisničko ime "root" i bez lozinke.
			//Formira se SQL naredba za ažuriranje podataka trenera u tabeli coachtbl.
			//Pripremljena Naredba (PreparedStatement):

			//Kreira se PreparedStatement sa SQL naredbom za ažuriranje (UPDATE).
			//Postavljaju se vrednosti za ažuriranje iz tekstualnih polja korisničkog interfejsa: ime trenera, telefon, godine, adresa i pol. Vrednosti se uzimaju direktno iz GUI komponenata kao što su tekstualna polja i dropdown meni (getSelectedItem).
			//Izvršavanje i Obrada Rezultata:

			//Izvršava se SQL naredba i proverava se da li je bilo ažuriranja u bazi (broj izmenjenih redova veći od 0).
			//U zavisnosti od rezultata, korisniku se prikazuje poruka o uspehu ili neuspehu izmene.
			//Na kraju, zatvara se konekcija sa bazom.
			//Obrada Izuzetaka
			//Obrada Izuzetaka:
			// Sve operacije sa bazom su u bloku try-catch kako bi se uhvatili i obradili eventualni izuzeci. Ako dođe do izuzetka, štampa se trag greške i prikazuje poruka korisni

			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (Key == 0) {
			            JOptionPane.showMessageDialog(btnDelete, "Select Coach To Delete");
			        } else {
			            new Thread(() -> { // Perform database operations in a new thread
			                try {
			                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			                    String query = "DELETE FROM coachtbl WHERE CId = ?";
			                    PreparedStatement preparedStatement = connection.prepareStatement(query);
			                    preparedStatement.setInt(1, Key);
			                    
			                    int result = preparedStatement.executeUpdate();
			                    if (result > 0) {
			                        JOptionPane.showMessageDialog(btnDelete, "Coach Deleted Successfully");
			                        DisplayCoachs();
			                    } else {
			                        JOptionPane.showMessageDialog(btnDelete, "Coach Not Found");
			                    }
			                } catch (Exception ex) {
			                    JOptionPane.showMessageDialog(btnDelete, "Error: " + ex.getMessage());
			                }
			            }).start();
			        }
			    }
			});
			
			 btnDelete.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 15));
			 btnDelete.setBackground(new Color(128, 128, 255));
			 btnDelete.setForeground(new Color(255, 0, 128));
	          btnDelete.setBounds(667, 393, 98, 26);
	          panel.add(btnDelete);
	          
	          //Dugme za Brisanje (Delete Button):
	         
	         // MouseListener:
	          //Na dugme je dodat MouseListener koji reaguje na događaj klika mišem.
	          //Unutar metode mouseClicked, prvo se proverava da li je izabran trener (promenljiva Key). Ako Key iznosi 0, to znači da nijedan trener nije izabran, i korisniku se prikazuje poruka da selektuje trenera za brisanje.
	          //Izvršavanje Operacija u Pozadini
	          //Izvršavanje u Novom Threadu:
	          //Ako je trener izabran, brisanje se vrši u novom threadu kako bi se izbeglo blokiranje korisničkog interfejsa tokom operacije sa bazom podataka.
	          //Otvori se konekcija sa lokalnom bazom podataka MySQL (jdbc:mysql://localhost:3306/gymdb) koristeći korisničko ime "root".
	          //SQL Operacije
	          //SQL Naredba za Brisanje:
             //Kreira se PreparedStatement sa SQL naredbom za brisanje trenera na osnovu njegovog identifikatora (CId).
	          //Postavi se vrednost identifikatora iz promenljive Key i izvrši se naredba.
	          //Izvršavanje i Obrada Rezultata:
              //Ako je rezultat veći od 0, to znači da je trener uspešno obrisan, i korisniku se prikazuje poruka o uspehu. Lista trenera se osvežava.
	          //Ako rezultat nije veći od 0, to znači da trener nije pronađen, i prikazuje se odgovarajuća poruka.
	          //Obrada Izuzetaka
	          //Obrada Izuzetaka:
	          //Operacije su obuhvaćene blokom try-catch kako bi se uhvatili potencijalni izuzeci prilikom operacija sa bazom. U slučaju izuzetka, korisniku se prikazuje poruka sa opisom greške.
			
			
			
			JLabel lblMembersList = new JLabel("Coachs List");
			lblMembersList.setForeground(new Color(128, 128, 192));
			lblMembersList.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
			lblMembersList.setBounds(262, 443, 121, 31);
			panel.add(lblMembersList);
			
			   
			    
			Object[][] data = {
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""},
				    {"", "", "", "", "", ""}
				};

				// Column names
			String[] columnNames = {"CId", "Cname", "CPhone", "CAge", "CAddress", "CGen"};
			Coachtbl = new JTable(data, columnNames);
			Coachtbl.setBorder(new EmptyBorder(0, 0, 0, 0));

			// MouseListener is fine here as it is
			Coachtbl.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        int MyIndex = Coachtbl.getSelectedRow();
			        if (MyIndex != -1) { // Ensure that a valid row is selected
			            TableModel model = Coachtbl.getModel();
			            Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
			            CoachsName.setText(model.getValueAt(MyIndex, 1).toString());
			            CPhone.setText(model.getValueAt(MyIndex, 2).toString());
			            CAge.setText(model.getValueAt(MyIndex, 3).toString());
			            CAddress.setText(model.getValueAt(MyIndex, 4).toString());
			            CGen.setSelectedItem(model.getValueAt(MyIndex, 5).toString());
			        }
			    }
			});

			// Setting grid and foreground colors
			Coachtbl.setGridColor(new Color(255, 0, 255));
			Coachtbl.setForeground(new Color(255, 0, 255));

			// JScrollPane is added to the JTable
			JScrollPane scrollPane = new JScrollPane(Coachtbl);
			scrollPane.setBounds(262, 472, 643, 302); // Set bounds as necessary

			// Add ONLY the JScrollPane to the panel, not the table
			panel.add(scrollPane);
			
			    //Podaci Tabele (Data Array)
			    //Dvodimenzionalni niz data je inicijalizovan sa praznim stringovima u svakom polju. Niz ima 12 redova i 6 kolona, što odgovara broju trenera i njihovim atributima koji će biti prikazani.
				//Ovaj niz će služiti kao privremeni sadržaj za JTable dok se ne učitaju stvarni podaci iz baze podataka.
				//Imena Kolona (Column Names):
               //Niz columnNames sadrži imena kolona koje će se prikazati u tabeli. Ova imena su "CId", "Cname", "CPhone", "CAge", "CAddress", i "CGen", predstavljajući identifikator trenera, ime, telefon, starost, adresu i pol, respektivno.
				//Konfiguracija JTable
				//Kreiranje JTable:
				//Coachtbl je instanca JTable koja se koristi za prikaz informacija u vidu tabele, inicijalizovana sa podacima data i imenima kolona columnNames.
				//Postavljena je granična linija (border) na new EmptyBorder(0, 0, 0, 0), što znači da tabela neće imati vidljive okvire oko ćelija ili spoljašnje granice.
				//Interakcija Korisnika
				//MouseListener za JTable:
				//Na Coachtbl je dodat MouseListener koji reaguje na klikove mišem.
				//Kada korisnik klikne na red u tabeli, mouseClicked metod se aktivira, gde se prvo proverava da li je validan red selektovan (MyIndex != -1).
				//Ako je red validno selektovan, iz modela tabele se preuzimaju vrednosti za selektovani red i ažuriraju odgovarajući GUI elementi za prikaz detalja o treneru. Promenljiva Key se postavlja na vrednost iz prve kolone (CId), što može služiti za identifikaciju trenera pri operacijama editovanja ili brisanja.
			
			textFieldTrainers = new JTextField();
			textFieldTrainers.setForeground(new Color(0, 0, 0));
			textFieldTrainers.setBackground(new Color(128, 128, 192));
			textFieldTrainers.setBounds(716, 245, 189, 26);
			panel.add(textFieldTrainers);
			textFieldTrainers.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 String searchText = textFieldTrainers.getText().trim().toLowerCase();
				        TableRowSorter<TableModel> sorter = new TableRowSorter<>(Coachtbl.getModel());
				        Coachtbl.setRowSorter(sorter);
				        
				        if (searchText.isEmpty()) {
				            sorter.setRowFilter(null);
				        } else {
				            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));
				        }
				}
			});
			btnSearch.setForeground(new Color(255, 0, 255));
			btnSearch.setBackground(new Color(128, 128, 192));
			btnSearch.setBounds(716, 307, 89, 23);
			panel.add(btnSearch);
			
				//Na dugme je dodat ActionListener koji se aktivira kada korisnik klikne na dugme "Search".
				//Unutar metoda actionPerformed koji se poziva kada se dogodi akcija, preuzima se tekst iz tekstualnog polja textFieldTrainers. Tekst se obrađuje tako što se uklanjaju suvišni razmaci (trim()) i pretvara u mala slova (toLowerCase()).
				//Logika za Filtriranje Tabele
				//Konfiguracija TableRowSorter:
                 //Kreira se TableRowSorter koji se povezuje sa modelom tabele Coachtbl.getModel(). Ovaj sorter omogućava sortiranje i filtriranje podataka unutar tabele.
				//Tabeli Coachtbl se dodeljuje ovaj sorter (setRowSorter(sorter)).
				//Postavljanje RowFiltera:
                 //Ukoliko je tekstualno polje prazno (searchText.isEmpty()), filter se uklanja (sorter.setRowFilter(null)), što omogućava prikaz svih podataka u tabeli.
				//Ako tekstualno polje sadrži tekst, postavlja se filter za pretragu koji koristi regularni izraz. Regularni izraz je formiran tako da nije osetljiv na velika i mala slova ((?i)), i sigurno se pretvara uneti tekst u regularni izraz pomoću Pattern.quote(searchText). Ovo omogućava da se u tabeli prikažu samo redovi koji sadrže uneti tekst.
				//Završetak Konfiguracije
				//Ova implementacija omogućava korisnicima efikasno filtriranje podataka unutar tabele, što je posebno korisno u aplikacijama sa velikim skupovima podataka, kao što su evidencije trenera. 
			
			JButton btnRefresh = new JButton("Refresh");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) Coachtbl.getRowSorter();
				        if (sorter != null) {
				            sorter.setRowFilter(null);
				        }
				        textFieldTrainers.setText("");  // Očistite polje za pretragu
				    
				}
			});
			btnRefresh.setForeground(new Color(255, 0, 255));
			btnRefresh.setBackground(new Color(128, 128, 192));
			btnRefresh.setBounds(819, 307, 89, 23);
			panel.add(btnRefresh);
			
			//Na dugme je dodat ActionListener koji se aktivira kada korisnik klikne na dugme "Refresh".
			//Unutar metoda actionPerformed, koji se poziva pri događaju klik na dugme, izvršava se logika za resetovanje prikaza podataka i pretrage.
			//Logika za Resetovanje Prikaza Tabele
			//Resetovanje TableRowSorter-a:
            //Preuzima se TableRowSorter od tabele Coachtbl korišćenjem getRowSorter(), koji je ranije postavljen za omogućavanje filtriranja i sortiranja podataka u tabeli.
			//Proverava se da li sorter nije null, i ako nije, filter se resetuje (sorter.setRowFilter(null)), što rezultira prikazom svih podataka u tabeli bez primenjenih filtera za pretragu.
			//Čišćenje Tekstualnog Polja za Pretragu:
            //Polje za tekst textFieldTrainers, koje se koristi za unos teksta za pretragu, se resetuje (setText("")), čime se brišu svi prethodno uneti tekstovi i priprema za novi unos.
			
			
			
			JTextArea txtrFindACoach = new JTextArea();
			txtrFindACoach.setFont(new Font("Verdana Pro", Font.BOLD, 14));
			txtrFindACoach.setText("Find a Coach");
			txtrFindACoach.setForeground(new Color(128, 128, 255));
			txtrFindACoach.setBackground(new Color(0, 0, 0));
			txtrFindACoach.setBounds(716, 212, 189, 22);
			panel.add(txtrFindACoach);

		// Call the method to display data from the database
			        DisplayCoachs();
			    }
        
		
		private int CountCouch() {
			 int coachCount = 0;
			    try {
			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM coachtbl");
			        ResultSet resultSet = preparedStatement.executeQuery();
			        if (resultSet.next()) {
			            coachCount = resultSet.getInt(1);
			        }
			        connection.close();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        // TODO: handle exception
			    }
			    return coachCount;
			}
		// Java koda definiše metodu CountCouch() koja je namenjena da izračuna i vrati ukupan broj trenera u bazi podataka. Metoda koristi JDBC (Java Database Connectivity) za povezivanje sa MySQL bazom podataka i izvršavanje SQL upita. Evo detaljnog opisa kako kod funkcioniše:

			//Definicija Metode
			//Metoda CountCouch() je privatna i vraća celobrojnu vrednost (int). Ovo znači da je metoda dostupna samo unutar klase u kojoj je definisana.
			//Inicijalizacija Brojača
			//Promenljiva coachCount je inicijalizovana na nulu. Ova promenljiva će držati broj trenera koji se dobija iz upita bazi.
			//Uspostavljanje Konekcije
			//Metoda uspostavlja konekciju sa lokalnom MySQL bazom podataka gymdb koristeći DriverManager.getConnection(). Autentifikacija se vrši sa korisničkim imenom "root" i bez lozinke.
			//Izvršavanje SQL Upita
			//Koristi se PreparedStatement za pripremu SQL upita koji broji sve zapise u tabeli coachtbl. SQL upit koji se koristi je "SELECT COUNT(*) FROM coachtbl".
			//executeQuery() metoda pokreće upit i vraća ResultSet, koji sadrži rezultate upita.
			//Obrada Rezultata
			//Metoda proverava da li ResultSet sadrži neki rezultat pomoću resultSet.next(). Ako postoji rezultat, vrednost se čita koristeći resultSet.getInt(1) i dodeljuje se promenljivoj coachCount. Ova metoda čita prvu kolonu iz dobijenog rezultata, koja u ovom slučaju sadrži broj trenera.
			//Zatvaranje Konekcije
			//Konekcija se zatvara nakon obrade upita. To je važno za oslobađanje resursa koje zauzima konekcija.
			//Obrada Izuzetaka
			//Blok catch hvata i obrađuje SQLException izuzetke koje mogu nastati tokom povezivanja sa bazom, izvršavanja upita ili rada sa rezultatima. U ovom kodu, izuzetak se štampa na standardni izlaz pomoću e.printStackTrace(), što pomaže u dijagnostikovanju problema.
			//Povratak Rezultata
			//Metoda vraća vrednost coachCount, koja predstavlja broj trenera pronađenih u bazi.
			//Korišćenje ove metode je korisno za dobijanje brzog pregleda koliko trenera trenutno postoji u bazi, što može biti korisno za izveštavanje, praćenje kapaciteta teretane ili za potrebe administrativne kontrole.
				
			private void DisplayCoachs() {
		
		try {
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
		        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM coachtbl");
		        ResultSet resultSet = preparedStatement.executeQuery();
		        Coachtbl.setModel(DbUtils.resultSetToTableModel(resultSet));
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		//Ovaj deo Java koda opisuje metodu DisplayCoachs(), koja se koristi za dohvatanje i prikaz podataka o trenerima iz baze podataka na korisničkom interfejsu u JTable. Metoda koristi JDBC za povezivanje sa MySQL bazom podataka i izvršavanje SQL upita. Evo detaljnog opisa procesa:
       //Uspostavljanje Konekcije
		//	Konekcija sa bazom: Metoda započinje uspostavljanjem konekcije sa lokalnom MySQL bazom podataka (gymdb) koristeći DriverManager.getConnection(). Pristup se vrši sa korisničkim imenom "root" i bez lozinke.
		//	Priprema i Izvršavanje SQL Upita
		//	SQL Upit: Koristi se PreparedStatement za pripremu i izvršavanje SQL upita SELECT * FROM coachtbl, koji dohvata sve zapise iz tabele coachtbl u kojoj su smešteni podaci o trenerima.
		//	Izvršavanje upita: Metoda executeQuery() pokreće upit i vraća ResultSet, koji sadrži rezultate upita.
		//	Postavljanje Modela za Tabelu
		//	Postavljanje modela tabele: Rezultati dobijeni iz baze se konvertuju u TableModel pomoću bibliotečke funkcije DbUtils.resultSetToTableModel(resultSet). Ova funkcija efikasno transformiše ResultSet u format prihvatljiv za JTable (Coachtbl), omogućavajući prikaz podataka u tabelarnom formatu na GUI.
		//	Osvežavanje prikaza: Coachtbl (tabela koja se koristi na korisničkom interfejsu za prikaz trenera) se ažurira tako što joj se postavlja novi model koji sadrži ažurirane podatke iz baze.
		//	Zatvaranje Konekcije
		//	Zatvaranje konekcije: Veoma je važno zatvoriti konekciju nakon što su operacije sa bazom podataka završene. Ovo oslobađa resurse koji su bili zauzeti tokom sesije sa bazom.
		//	Obrada Izuzetaka
		//	Obrada izuzetaka: U slučaju greške, kao što je problem sa konekcijom, izvršavanjem upita ili drugim problemima vezanim za SQL, SQLException će biti uhvaćen. Izuzetak se obrađuje tako što se štampa trag izuzetka (e.printStackTrace()), što pomaže u dijagnostikovanju i razumevanju problema.
		//	Opšti Pregled
		//	Metoda DisplayCoachs() je ključni deo aplikacije za upravljanje teretanom, omogućavajući administratorima da lako pristupe i pregledaju sve trenutne trenera. Ovaj pristup povećava efikasnost i produktivnost u upravljanju podacima o trenerima, obezbeđujući da informacije budu ažurirane i lako dostupne.
		
		
		
		}
	}

		
		
	
		


	
			
			
			