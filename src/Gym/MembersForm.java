
package Gym;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;



import net.proteanit.sql.DbUtils;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;

public class MembersForm extends JFrame  {

	private static final long serialVersionUID = 1L;

	
     private JPanel contentPane;
	 private JTextField MemberName, MemberPhone, MemberAge, MemberAmount;
	   
	
	private JComboBox<String> CoachComboBox;
	JTable Membertable = new JTable();
protected Integer Key;

protected JComboBox<String> MTiming;
protected JComboBox<String> MCoach;


/**
	 * Launch the application.
	 */
	
/**
 * Create the frame.
 */
	
	public MembersForm() {
		setType(Type.UTILITY);
		
		DisplayMembers();
		
		getCoaches();
		
		CountMember();
	
		

	
	    
		  
		FlatDraculaIJTheme.setup();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 743);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 944, 744);
		contentPane.add(panel);
		panel.setLayout(null);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 230, 744);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCoachs = new JLabel("Coaches");
		lblCoachs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CoachsForm  coachsForm = new CoachsForm();
            	coachsForm.setVisible(true);
            	Window parentWindow = SwingUtilities.getWindowAncestor(lblCoachs);
		        parentWindow.dispose();
			}
		});
		lblCoachs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
		lblCoachs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoachs.setOpaque(true);
		lblCoachs.setBackground(new Color(96, 79, 162));
		lblCoachs.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		lblCoachs.setBounds(35, 61, 165, 35);
		panel_1.add(lblCoachs);
		
		JLabel lblPayment = new JLabel("Payments");
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
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginForm loginForm = new LoginForm();
		        loginForm.setVisible(true);
		        Window parentWindow = SwingUtilities.getWindowAncestor(lblLogout);
		        if (parentWindow != null) {
		            parentWindow.dispose();
		        }
				
			}
		});
	
		lblLogout.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
		lblLogout.setOpaque(true);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		lblLogout.setBackground(new Color(96, 79, 162));
		lblLogout.setBounds(37, 672, 165, 35);
		panel_1.add(lblLogout);
		
		JLabel lblgymgols = new JLabel("");
		lblgymgols.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/11.gif")));
		lblgymgols.setBounds(0, 204, 230, 303);
		panel_1.add(lblgymgols);
		
		JLabel lblLogoMember = new JLabel("New label");
		lblLogoMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/members.jpg")));
		lblLogoMember.setBounds(56, 550, 123, 108);
		panel_1.add(lblLogoMember);
		
		JLabel lblNewLabel_1 = new JLabel("Members");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		lblNewLabel_1.setBounds(53, 518, 126, 21);
		panel_1.add(lblNewLabel_1);
		
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
		
		JLabel lblMenageMembers = new JLabel("Insert Members");
		lblMenageMembers.setForeground(new Color(128, 128, 255));
		lblMenageMembers.setOpaque(true);
		lblMenageMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenageMembers.setFont(new Font("Verdana Pro", Font.BOLD, 22));
		lblMenageMembers.setBackground(new Color(0, 0, 0));
		lblMenageMembers.setBounds(375, 55, 391, 31);
		panel.add(lblMenageMembers);
		
		JLabel lblNewLabel = new JLabel("Member Name");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(128, 128, 192));
		lblNewLabel.setBounds(262, 143, 141, 31);
		panel.add(lblNewLabel);
		
		MemberName = new JTextField();
		MemberName.setBackground(new Color(128, 128, 255));
		MemberName.setForeground(new Color(0, 0, 0));
		MemberName.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		MemberName.setBounds(260, 199, 173, 26);
		panel.add(MemberName);
		MemberName.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(128, 128, 192));
		lblPhoneNumber.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(456, 143, 150, 31);
		panel.add(lblPhoneNumber);
		
		MemberPhone = new JTextField();
		MemberPhone.setBackground(new Color(128, 128, 255));
		MemberPhone.setForeground(new Color(0, 0, 0));
		MemberPhone.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		MemberPhone.setColumns(10);
		MemberPhone.setBounds(456, 199, 164, 26);
		panel.add(MemberPhone);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(128, 128, 192));
		lblAge.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblAge.setBounds(649, 143, 96, 31);
		panel.add(lblAge);
		
		MemberAge = new JTextField();
		MemberAge.setBackground(new Color(128, 128, 255));
		MemberAge.setForeground(new Color(0, 0, 0));
		MemberAge.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		MemberAge.setColumns(10);
		MemberAge.setBounds(649, 199, 87, 26);
		panel.add(MemberAge);
		
		JComboBox GenderCB = new JComboBox();
		GenderCB.setBackground(new Color(128, 128, 255));
		GenderCB.setForeground(new Color(255, 0, 255));
		GenderCB.setModel(new DefaultComboBoxModel(new String[] {"Please select gender", "Male", "Female"}));
		GenderCB.setName("Male,Female");
		GenderCB.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		GenderCB.setBounds(757, 199, 164, 26);
		panel.add(GenderCB);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(128, 128, 192));
		lblGender.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblGender.setBounds(755, 143, 96, 31);
		panel.add(lblGender);
		
		JLabel lblAmount = new JLabel("Individual training price");
		lblAmount.setForeground(new Color(128, 128, 192));
		lblAmount.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		lblAmount.setBounds(262, 258, 190, 31);
		panel.add(lblAmount);
		
		MemberAmount = new JTextField();
		MemberAmount.setBackground(new Color(128, 128, 255));
		MemberAmount.setForeground(new Color(0, 0, 0));
		MemberAmount.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		MemberAmount.setColumns(10);
		MemberAmount.setBounds(262, 312, 181, 26);
		panel.add(MemberAmount);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setForeground(new Color(128, 128, 192));
		lblTiming.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblTiming.setBounds(797, 258, 96, 31);
		panel.add(lblTiming);
		
		JComboBox TimingCB = new JComboBox();
		TimingCB.setBackground(new Color(128, 128, 255));
		TimingCB.setForeground(new Color(255, 0, 255));
		TimingCB.setModel(new DefaultComboBoxModel(new String[] {"Please select time", "10h-12h", "12h-14h", "14h-16h", "16h-18h", "18h-20h", "20h-22h"}));
		TimingCB.setName("");
		TimingCB.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		TimingCB.setBounds(797, 312, 128, 26);
		panel.add(TimingCB);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setForeground(new Color(128, 128, 192));
		lblCoach.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblCoach.setBounds(532, 256, 96, 31);
		panel.add(lblCoach);
		
		
		
		JButton btnAddMember = new JButton("Add");
		CoachComboBox = new JComboBox<>();
		btnAddMember.addMouseListener(new MouseAdapter() {
			private int someIdValue;

			@Override
			public void mouseClicked(MouseEvent e) {
				 
				        if (MemberName.getText().trim().isEmpty() || MemberPhone.getText().trim().isEmpty() || 
				            MemberAge.getText().trim().isEmpty() || MemberAmount.getText().trim().isEmpty() || 
				            TimingCB.getSelectedIndex() == -1 || CoachComboBox.getSelectedIndex() == -1 || 
				            GenderCB.getSelectedIndex() == -1) {

				            JOptionPane.showMessageDialog(btnAddMember, "Please fill in all fields.");
			
				        } else {
				            new Thread(() -> { // Move database operations to a new thread
				                try {
				                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
				                    String sql = "INSERT INTO membertbl (MId, MName, MPhone, MAge, MAmount, MTiming, MCoach, MGen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				                    	
										preparedStatement.setInt(1, someIdValue); // You need to determine what this value should be
				                        preparedStatement.setString(2, MemberName.getText());
				                        preparedStatement.setString(3, MemberPhone.getText());
				                        preparedStatement.setInt(4, Integer.parseInt(MemberAge.getText()));
				                        preparedStatement.setInt(5, Integer.parseInt(MemberAmount.getText()));
				                        preparedStatement.setString(6, TimingCB.getSelectedItem().toString());
				                        preparedStatement.setString(7, CoachComboBox.getSelectedItem().toString()); // Assuming you get coach from CoachCB
				                        preparedStatement.setString(8, GenderCB.getSelectedItem().toString());
				                        

				                        int rows = preparedStatement.executeUpdate();
				                        if (rows > 0) {
				                            SwingUtilities.invokeLater(() -> {
				                                JOptionPane.showMessageDialog(btnAddMember, "Member added successfully.");
				                            });
				                        }
				                        connection.close();
				                        DisplayMembers(); // Refresh the display
				                    }
				                } catch (Exception ex) {
				                    SwingUtilities.invokeLater(() -> {
				                        JOptionPane.showMessageDialog(btnAddMember, "An error occurred: " + ex.getMessage());
				                    });
				                    ex.printStackTrace();
				                }
				            }).start();
				        }
				    }
				});
	
        btnAddMember.setForeground(new Color(255, 0, 128));
		btnAddMember.setFont(new Font("Verdana Pro", Font.BOLD, 15));
		btnAddMember.setBackground(new Color(128, 128, 255));
		btnAddMember.setBounds(354, 393, 98, 26);
		panel.add(btnAddMember);
		   //MouseListener:
			//Na dugme je dodat MouseListener koji detektuje klikove mišem.
			//U funkciji mouseClicked, prvo se vrši provera da li su popunjena sva obavezna polja (ime člana, telefon, godina, iznos, vreme, trener i pol). Ako neko od polja nije popunjeno ili nije izabrana opcija iz padajućih menija, prikazuje se poruka o grešci.
			//Izvršavanje Dodavanja Člana u Novom Thread-u
			//Proces Dodavanja:
			//Ako su svi uslovi ispunjeni, izvršavanje operacije dodavanja pokreće se u novom thread-u da se izbegne blokiranje grafičkog interfejsa.
			//Uspostavlja se konekcija sa MySQL bazom podataka (jdbc:mysql://localhost:3306/gymdb).
			//Priprema se SQL naredba za ubacivanje novih podataka o članu u tabelu membertbl. Polja uključuju identifikator, ime, telefon, godine, iznos, vreme treninga, trenera i pol.
			//Prilikom pripreme SQL naredbe, koriste se podaci izvedeni iz korisničkog interfejsa.
			//Nakon uspešnog izvršenja naredbe, prikazuje se poruka o uspehu, a zatim se poziva metoda DisplayMembers() za osvežavanje prikaza članova.
			//Obrada Izuzetaka
			//Obrada izuzetaka:
			//Ukoliko dođe do bilo kakvog izuzetka tokom procesa konekcije, pripreme upita, ili izvršavanja, izuzetak se hvata, i korisniku se prikazuje poruka o grešci, dok se trag izuzetka štampa u konzoli.
			//Zaključak
			//Kod omogućava efikasno i korisnički prijateljsko dodavanje novih članova teretane, pružajući intuitivan način za upravljanje podacima o članstvu
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  if (Key == null || Key == 0) {
			            JOptionPane.showMessageDialog(btnEdit, "No Member Selected for Editing");
			        } else {
			            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "")) {
			                String query = "UPDATE membertbl SET MName = ?, MPhone = ?, MAge = ?, MAmount = ?, MTiming = ?, MCoach = ?, MGen = ? WHERE MId = ?";
			                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			                    preparedStatement.setString(1, MemberName.getText());
			                    preparedStatement.setString(2, MemberPhone.getText());
			                    preparedStatement.setInt(3, Integer.parseInt(MemberAge.getText()));
			                    preparedStatement.setInt(4, Integer.parseInt(MemberAmount.getText()));
			                    preparedStatement.setString(5, TimingCB.getSelectedItem().toString());
			                    preparedStatement.setString(6, CoachComboBox.getSelectedItem().toString());
			                    preparedStatement.setString(7, GenderCB.getSelectedItem().toString());
			                    preparedStatement.setInt(8, Key);  // Fixed index for 'Key'

			                    int rows = preparedStatement.executeUpdate();

			                    if (rows > 0) {
			                        JOptionPane.showMessageDialog(btnEdit, "Member Edited Successfully");
			                        DisplayMembers(); // Refresh the display
			                    } else {
			                        JOptionPane.showMessageDialog(btnEdit, "Update Failed");
			                    }
			                }
			            } catch (Exception ex) {
			                ex.printStackTrace(); // It's better to use logging in real applications
			                JOptionPane.showMessageDialog(btnEdit, "Error occurred: " + ex.getMessage());
			            }
			        }
			    }
			});
			btnEdit.setForeground(new Color(255, 0, 128));
			btnEdit.setFont(new Font("Verdana Pro", Font.BOLD, 15));
			btnEdit.setBackground(new Color(128, 128, 255));
			btnEdit.setBounds(547, 393, 98, 26);
			panel.add(btnEdit);
			
			    //MouseListener:
				//Na dugme je dodat MouseListener koji detektuje klikove mišem.
				//U funkciji mouseClicked, prvo se proverava da li je član teretane selektovan za izmenu (proverom promenljive Key). Ako nije izabran nijedan član, prikazuje se poruka da korisnik treba da izabere člana za izmenu.
				//Izvršavanje Izmena u Novom Thread-u
				//Proces Izmena:
				//Ako je član izabran, izvršavanje operacije izmene pokreće se u novom thread-u kako bi se izbeglo blokiranje grafičkog interfejsa.
				//Uspostavlja se konekcija sa MySQL bazom podataka (jdbc:mysql://localhost:3306/gymdb).
				//Priprema se SQL naredba za ažuriranje podataka o članu u tabeli membertbl. SQL upit uključuje postavljanje novih vrednosti za ime, telefon, godine, iznos, vreme treninga, trenera i pol, uz korišćenje identifikatora člana za filtriranje (WHERE klauzula).
				//Izvršava se SQL naredba, i ako izmena uspe, prikazuje se poruka o uspehu, a zatim se poziva metoda DisplayMembers() za osvežavanje prikaza članova.
				//Obrada Izuzetaka
				//Obrada izuzetaka:
				//Ukoliko dođe do bilo kakvog izuzetka tokom procesa konekcije, pripreme upita, ili izvršavanja, izuzetak se hvata, štampa se trag izuzetka, i korisniku se prikazuje poruka o grešci. U stvarnim aplikacijama preporučuje se korišćenje mehanizama za logovanje umesto štampanja traga izuzetka.
				//Zaključak
				//Kod omogućava efikasno i korisnički prijateljsko upravljanje podacima o članovima teretane, pružajući funkcionalnost za izmenu postojećih zapisa.
			
			
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  if (Key == 0) {
			            JOptionPane.showMessageDialog(btnDelete, "Select Member To Delete");
			        } else {
			            new Thread(() -> { // Perform database operations in a new thread
			                try {
			                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			                    String query = "DELETE FROM membertbl WHERE MId = ?";
			                    PreparedStatement preparedStatement = connection.prepareStatement(query);
			                    preparedStatement.setInt(1, Key);
			                    
			                    int result = preparedStatement.executeUpdate();
			                    if (result > 0) {
			                        JOptionPane.showMessageDialog(btnDelete, "Member Deleted Successfully");
			                        DisplayMembers();
			                    } else {
			                        JOptionPane.showMessageDialog(btnDelete, "Member Not Found");
			                    }
			                } catch (Exception ex) {
			                    JOptionPane.showMessageDialog(btnDelete, "Error: " + ex.getMessage());
			                }
			            }).start();
			        }
			}
		});
		btnDelete.setForeground(new Color(255, 0, 128));
		btnDelete.setFont(new Font("Verdana Pro", Font.BOLD, 15));
		btnDelete.setBackground(new Color(128, 128, 255));
		btnDelete.setBounds(747, 393, 98, 26);
		panel.add(btnDelete);
		
		   //MouseListener:
			//Na dugme je dodat MouseListener koji detektuje klikove mišem.
			//U funkciji mouseClicked, prvo se proverava da li je selektovan neki član za brisanje (proverom promenljive Key). Ako Key iznosi 0, prikazuje se poruka da korisnik treba da izabere člana za brisanje.
			//Izvršavanje Brisanja u Novom Thread-u
			//Proces Brisanja:
			//Ako je član izabran (Key nije 0), izvršavanje operacije brisanja se pokreće u novom thread-u da se izbegne blokiranje grafičkog interfejsa.
			//Uspostavlja se konekcija sa MySQL bazom podataka (jdbc:mysql://localhost:3306/gymdb).
			//Priprema se SQL naredba za brisanje člana iz tabele membertbl na osnovu njegovog identifikatora (MId).
			//Izvršava se SQL naredba, i ako je rezultat veći od 0 (član je uspešno obrisan), prikazuje se poruka o uspehu i poziva se metoda DisplayMembers() da osveži prikaz članova.
			//Obrada izuzetaka:
			//Ukoliko dođe do izuzetka tokom procesa konekcije, pripreme upita, ili izvršavanja, izuzetak se hvata, štampa se trag izuzetka, i korisniku se prikazuje poruka o grešci.
			//Zaključak
			//Kod omogućava efikasno i korisnički prijateljsko brisanje podataka o članovima teretane, pružajući jednostavan mehanizam za upravljanje članstvom
		
		JLabel lblMembersList = new JLabel("Members List");
		lblMembersList.setForeground(new Color(128, 128, 192));
		lblMembersList.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblMembersList.setBounds(262, 440, 121, 31);
		panel.add(lblMembersList);
		
		
		
		
		Object[][] data = {
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			    {"", "", "", "", "", "","",""},
			};

			String[] columnNames = {"MId", "MName", "MPhone", "MAge", "MAmount", "MTiming", "MCoach", "MGen"};
			// Initialize with empty strings
			Membertable = new JTable(data, columnNames);
			Membertable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			Membertable.setFont(new Font("Verdana Pro", Font.PLAIN, 10));
			Membertable.setBorder(new EmptyBorder(0, 0, 0, 0));

			// MouseListener is fine here as it is
			Membertable.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        int MyIndex = Membertable.getSelectedRow();
			        if (MyIndex != -1) { // Ensure that a valid row is selected
			            TableModel model = Membertable.getModel();
			            Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
			            MemberName.setText(model.getValueAt(MyIndex, 1).toString());
			            MemberPhone.setText(model.getValueAt(MyIndex, 2).toString());
			            MemberAge.setText(model.getValueAt(MyIndex, 3).toString());
			            MemberAmount.setText(model.getValueAt(MyIndex, 4).toString());
			            TimingCB.setSelectedItem(model.getValueAt(MyIndex, 5).toString());
			            CoachComboBox.setSelectedItem(model.getValueAt(MyIndex, 6).toString());
			            GenderCB.setSelectedItem(model.getValueAt(MyIndex, 7).toString());
			        }
			    }
			});

			// Nastavak postavljanja boja
			Membertable.setGridColor(new Color(255, 0, 255));
			Membertable.setForeground(new Color(255, 0, 255));
			JScrollPane scrollPane = new JScrollPane(Membertable);
			scrollPane.setBounds(262, 472, 643, 261); // Set bounds as necessary

			// Add ONLY the JScrollPane to the panel, not the table
			panel.add(scrollPane);

		// Call the method to display data from the database
			DisplayMembers();
		
			  //inicijalizacija Tabele:
				//data je dvodimenzionalni niz stringova koji inicijalno sadrži prazne stringove, spreman za popunjavanje podacima. Tabela ima osam kolona.
				//columnNames su nazivi kolona za tabelu, uključujući ID, ime, telefon, godine, iznos, vreme, trenera i pol člana.
				//Membertable je instanca JTable koja se inicijalizuje sa ovim praznim podacima i nazivima kolona.
				
				//MouseListener:
				//Tabeli je dodat MouseListener za detekciju klikova na redove.
				//Kada korisnik klikne na red, indeks tog reda se proverava (MyIndex), i ako je validan (nije -1), podaci iz tog reda se koriste za ažuriranje GUI komponenti koje omogućavaju izmenu informacija (tekstualna polja i padajući meniji).
				//Osvežavanje Prikaza
				//JScrollPane se koristi za omotavanje Membertable, što omogućava skrolovanje kroz tabelu kada ima više redova nego što može stati u vidljivi deo tabele.
				//scrollPane je postavljen na određene koordinate unutar panela za smestanje tabele na željenu lokaciju.
				//Display Members:
				//Metoda DisplayMembers() se poziva na kraju kako bi se ažurirali prikazi podataka u tabeli korišćenjem podataka iz baze, osiguravajući da tabela prikaže aktuelne informacije o članovima teretane.
				//Ovaj kod omogućava efikasno prikazivanje i upravljanje podacima o članovima teretane, uz mogućnost jednostavnog ažuriranja i izmene podataka direktno kroz GUI, što korisnicima omogućava interaktivnu i intuitivnu upotrebu aplikacije.
			
				    
				CoachComboBox = new JComboBox();
		        CoachComboBox.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		        CoachComboBox.setBounds(528, 300, 238, 26);
		        CoachComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Please select a coach"}));
				List<String> coaches = getCoaches();
				for (String coach : coaches) {
				    CoachComboBox.addItem(coach);
		         panel.add(CoachComboBox);
		    }
	}
		 
	//Inicijalizacija JComboBox-a
	//Kreiranje JComboBox-a:
	//CoachComboBox je instanca JComboBox koja se koristi za prikaz liste trenera. Omogućava korisnicima da izaberu trenera iz padajućeg menija.
	//Postavljen je font "Verdana Pro", veličine 15, što olakšava čitanje i daje estetski prijatan izgled elementu.
	//Postavljanje Dimenzija i Položaja
	//Pozicioniranje JComboBox-a:
	//setBounds(528, 300, 238, 26) definira dimenzije i položaj JComboBox-a na panelu. Koordinate (528, 300) određuju gde će komponenta biti postavljena, dok dimenzije (238, 26) određuju širinu i visinu komponente.
	//Konfiguracija Modela
	//Postavljanje Modela:
	//setModel(new DefaultComboBoxModel<>(new String[] {"Please select a coach"})) inicijalno postavlja model za JComboBox sa opcijom koja podstiče korisnike da izaberu trenera. Ovo je korisno za slučajeve kada je potrebno naglasiti da korisnik treba prvo da napravi selekciju.
	//Dinamičko Dodavanje Opcija
	//Popunjavanje ComboBox-a:
	//Lista coaches se dohvata pozivom metode getCoaches(), koja vraća spisak trenera iz baze podataka ili nekog drugog izvora.
	//U petlji, svaki trener (string) iz liste coaches se dodaje u CoachComboBox pomoću metode addItem(). Ovo dinamički popunjava JComboBox sa realnim podacima.
	//Dodavanje JComboBox-a na Panel
	//Dodavanje na Panel:
	//panel.add(CoachComboBox) dodaje CoachComboBox na panel u Swing aplikaciji. Ovo omogućava da JComboBox bude vidljiv i interaktivan u korisničkom interfejsu.
	//Zaključak
	//Ovaj kod je ključan za omogućavanje korisnicima da lako izaberu trenera iz liste prilikom registracije ili ažuriranja podataka o članovima teretane. 
			
	
	
		// TODO Auto-generated method stub
		private int CountMember() {
			 int memberCount = 0;
			    try {
			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM membertbl");
			        ResultSet resultSet = preparedStatement.executeQuery();
			        if (resultSet.next()) {
			            memberCount = resultSet.getInt(1);
			        }
			        connection.close();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        // TODO: handle exception
			    }
			    return memberCount;
			}
	
		//CountMember je metoda koja ne prima argumente i vraća celobrojni rezultat (int), koji predstavlja broj članova u tabeli membertbl.
		//Inicijalizacija Brojača
		//int memberCount = 0; inicijalizuje promenljivu memberCount na 0. Ova promenljiva će biti korišćena za skladištenje broja članova koji se izračuna iz baze podataka.
		//Uspostavljanje Konekcije sa Bazom Podataka
		//Koristi se DriverManager.getConnection() za uspostavljanje konekcije sa lokalnom MySQL bazom podataka (jdbc:mysql://localhost:3306/gymdb) pod korisničkim imenom "root" i bez lozinke.
		//Priprema i Izvršavanje SQL Upita
		//PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM membertbl");
		//Ova linija koda priprema SQL naredbu koja izračunava ukupan broj zapisa u tabeli membertbl. SQL funkcija COUNT(*) vraća broj redova u tabeli.
		//ResultSet resultSet = preparedStatement.executeQuery();
		//Izvršava pripremljeni SQL upit i rezultate skladišti u objektu ResultSet.
		//Obrada Rezultata Upita
		//if (resultSet.next()) {
		//Ova provera je neophodna jer resultSet.next() pomera kursor na sledeći red u rezultatima. Za COUNT(*) uvek postoji samo jedan red, pa se ova metoda poziva jednom da bi se pročitao taj red.
		//memberCount = resultSet.getInt(1);
		//Uzima vrednost prvog stubca u trenutnom redu resultSet, što je broj dobijen iz funkcije COUNT(*), i dodeljuje ga promenljivoj memberCount.
		//Zatvaranje Konekcije
		//connection.close();
		//Veoma je važno zatvoriti konekciju nakon što se završe operacije nad bazom podataka kako bi se oslobodili resursi koje zauzima konekcija.
		//Obrada Izuzetaka
		//catch (SQLException e) {
		//Hvata bilo kakve SQL izuzetke koji mogu nastati tokom procesa konekcije, izvršavanja upita ili rada sa rezultatima. Trenutno se izuzetak samo štampa (e.printStackTrace();), ali u stvarnim aplikacijama, bilo bi poželjno logovati ovakve greške ili ih adekvatno obraditi.
		//Povratak Rezultata
		//return memberCount;
		//Metoda vraća izračunati broj članova kao rezultat.
		//Ovaj metod je koristan za dobijanje broja članova za izveštaje ili za validaciju podataka unutar aplikacije. Korišćenje try-with-resources za automatsko zatvaranje Connection i PreparedStatement objekata je preporučljiva praksa koja pomaže u sprečavanju curenja resursa.
	    
		private List<String> getCoaches() {
	    List<String> coaches = new ArrayList<>();
	    String query = "SELECT CName FROM coachtbl";
	   
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
	         PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            coaches.add(resultSet.getString("CName"));
	        }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return coaches;
	}
	
		//metoda getCoaches() koja se koristi za dohvatanje liste imena trenera iz baze podataka. Ova metoda je dizajnirana da se koristi unutar Java Swing ili bilo koje Java aplikacije koja interaguje sa bazom podataka. Evo detaljnog objašnjenja svake komponente ovog koda:

	//Definicija Metode i Inicijalizacija Liste
			//List<String> coaches = new ArrayList<>();
			//Ova linija koda inicijalizuje listu stringova coaches. Lista će biti korišćena za skladištenje imena trenera koje se izvlače iz baze podataka.
			//SQL Upit
			//String query = "SELECT CName FROM coachtbl";
			//Ovde se definiše SQL upit koji selektuje sve imena trenera (CName) iz tabele coachtbl. Ova tabela sadrži podatke o trenerima, uključujući njihova imena.
			//Uspostavljanje Konekcije i Izvršavanje Upita
			//try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");

			//Otvorena je konekcija sa MySQL bazom podataka gymdb koristeći JDBC. Koristi se korisničko ime "root" i prazna lozinka. Ova konekcija se automatski zatvara zahvaljujući try-with-resources izjavi.
			//PreparedStatement preparedStatement = connection.prepareStatement(query);

			//Kreira se PreparedStatement koji omogućava sigurnije i efikasnije izvršavanje SQL upita. Ova izjava takođe se automatski zatvara.
			//ResultSet resultSet = preparedStatement.executeQuery();

			//Izvršava se SQL upit koji vraća set rezultata (resultSet) sadrži imena trenera.
			//Obrada Rezultata Upita
			//while (resultSet.next()) {
			//Petlja prolazi kroz svaki red u resultSet. Metoda next() pomeri kursor na sledeći red i vraća true ako postoji još redova za obradu.
			//coaches.add(resultSet.getString("CName"));
			//Za svaki red, getString("CName") izvlači ime trenera iz kolone CName i dodaje ga u listu coaches.
			//Obrada Izuzetaka
			//catch (SQLException e) {
			//Ukoliko dođe do bilo kakve greške prilikom izvršavanja upita ili obrade podataka, izuzetak će biti uhvaćen. e.printStackTrace(); štampa trag izuzetka, što pomaže u dijagnostikovanju problema.
			//Povratak Rezultata
			//return coaches;
			//Nakon što se obrade svi redovi, lista coaches se vraća kao rezultat metode. Ova lista sadrži imena svih trenera koji su trenutno u bazi podataka.
			//Ova metoda je korisna za popunjavanje GUI komponenti poput JComboBox-a sa imenima trenera, omogućavajući korisnicima da izaberu trenera iz padajućeg menija.
	
	private void DisplayMembers() {
	    String query = "SELECT * FROM membertbl";
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
	         PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        Membertable.setModel(DbUtils.resultSetToTableModel(resultSet));
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	   // DisplayMembers(), koja se koristi za prikaz podataka o članovima teretane unutar tabele (JTable) u Java Swing aplikaciji. Evo detaljnog objašnjenja kako ovaj kod funkcioniše:

	     //Definicija SQL Upita
	    	//String query = "SELECT * FROM membertbl";
	    	//Ovde se definiše SQL upit koji dohvata sve podatke iz tabele membertbl, koja sadrži informacije o članovima teretane. SELECT * vraća sve kolone iz tabele, što je korisno za punjenje tabele u GUI-ju sa kompletnim podacima o članovima.
	    	//Uspostavljanje Konekcije sa Bazom Podataka
	    	//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
	    	//Uspostavlja se konekcija sa lokalnom MySQL bazom podataka koristeći JDBC. Baza podataka je specificirana kao gymdb, a koristi se korisničko ime "root" i prazna lozinka. Konekcija se automatski zatvara zbog korišćenja u try-with-resources bloku, što osigurava pravilno upravljanje resursima bez obzira na to da li se javi izuzetak ili ne.
	    	//priprema i Izvršavanje SQL Upita
	    	//PreparedStatement preparedStatement = connection.prepareStatement(query);
	    	//Kreira se PreparedStatement, što omogućava sigurno i efikasno izvršavanje SQL upita. Ovaj objekt se takođe automatski zatvara.
	    	//ResultSet resultSet = preparedStatement.executeQuery();
	    	//Izvršava se upit i rezultati se skladište u resultSet. Ovaj objekt sadrži redove podataka vraćene iz baze.
	    	//Postavljanje Modela za Tabelu
	    	//Membertable.setModel(DbUtils.resultSetToTableModel(resultSet));
	    	//DbUtils.resultSetToTableModel(resultSet) je metod iz biblioteke Apache Commons DbUtils koji konvertuje ResultSet direktno u TableModel. Ovo omogućava lako postavljanje podataka u JTable bez potrebe za ručnom iteracijom kroz resultSet i ručnim popunjavanjem modela tabele. Ova funkcija je veoma korisna jer automatski mapira kolone iz SQL upita u kolone u JTable.
	    	//Obrada Izuzetaka
	    	//catch (SQLException e) {
	    	//Hvata bilo kakve SQL izuzetke koji mogu nastati tokom povezivanja sa bazom, izvršavanja upita, ili obrade podataka. U slučaju greške, trag izuzetka se štampa, što pomaže u dijagnostikovanju problema.
	    	//Zaključak
	    	//Funkcija DisplayMembers() efikasno prikazuje podatke o članovima teretane u GUI aplikaciji, omogućavajući korisnicima da lako pregledaju i analiziraju informacije. Korišćenje DbUtils.resultSetToTableModel pojednostavljuje kod i smanjuje mogućnost grešaka, čineći aplikaciju pouzdanijom i lakšom za održavanje.
	    
	    
	    
	    
	}
}
	

			

	
			
		
		

	

