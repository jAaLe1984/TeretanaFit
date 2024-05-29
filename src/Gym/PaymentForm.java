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


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.time.ZoneId;

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

import net.proteanit.sql.DbUtils;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField AmounttextField;
	private JTextField PaymentstextField;
	private JTable Paymentstable;
	

	
	JDateChooser dateChooserOd_1 = new JDateChooser();
	JDateChooser dateChooserDo_1 = new JDateChooser();
    
   
 protected JComboBox<String> PMemeber;
		
		private JComboBox<String> MemeberFinCB;

		
		protected Integer Key;
		
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public PaymentForm() {
		setType(Type.UTILITY);
		
		
		initComponents();
        DisplayPayments();
        getMembers();
        
	
        FlatDraculaIJTheme.setup();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 741);
		// Ova metoda centrirati će formu na sredinu ekrana
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 935, 744);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 230, 744);
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
		
		JLabel lblPayment = new JLabel("Coaches");
		lblPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CoachsForm coachsForm = new CoachsForm();
		        coachsForm.setVisible(true);
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
		
		JLabel lblLogoutPay = new JLabel("Logout");
		lblLogoutPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginForm loginForm = new LoginForm();
		        loginForm.setVisible(true);
		        Window parentWindow = SwingUtilities.getWindowAncestor(lblLogoutPay);
		        if (parentWindow != null) {
		            parentWindow.dispose();
		        }
			}
		});
		lblLogoutPay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
		lblLogoutPay.setOpaque(true);
		lblLogoutPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoutPay.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		lblLogoutPay.setBackground(new Color(96, 79, 162));
		lblLogoutPay.setBounds(37, 672, 165, 35);
		panel_1.add(lblLogoutPay);
		
		JLabel lblgymgols = new JLabel("");
		lblgymgols.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/payment1.gif")));
		lblgymgols.setBounds(0, 204, 230, 303);
		panel_1.add(lblgymgols);
		
		JLabel lblFinance = new JLabel("");
		lblFinance.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/pay.png")));
		lblFinance.setBackground(new Color(0, 0, 0));
		lblFinance.setForeground(new Color(0, 0, 0));
		lblFinance.setBounds(59, 554, 123, 108);
		panel_1.add(lblFinance);
		
		JLabel lblNewLabel_1 = new JLabel("Membership Payments");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(128, 128, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 518, 210, 25);
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
		
		JLabel lblMenageMembers = new JLabel("Membership Payments");
		lblMenageMembers.setForeground(new Color(128, 128, 255));
		lblMenageMembers.setOpaque(true);
		lblMenageMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenageMembers.setFont(new Font("Verdana Pro", Font.BOLD, 22));
		lblMenageMembers.setBackground(new Color(0, 0, 0));
		lblMenageMembers.setBounds(375, 55, 391, 31);
		panel.add(lblMenageMembers);
		
		
		MemeberFinCB = new JComboBox<String>();
		 MemeberFinCB.setBounds(262, 292, 198, 26);
		MemeberFinCB.setModel(new DefaultComboBoxModel<>(new String[] {"Please select a member"}));
	        List<String> members = getMembers();
	        for (String member : members) {
	        MemeberFinCB.addItem(member);
		    MemeberFinCB.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		
		panel.add(MemeberFinCB);
        }
	
		
		
		JButton btnPay = new JButton("Pay");
		btnPay.addMouseListener(new MouseAdapter() {
		

			@Override
			public void mouseClicked(MouseEvent e) {
				
				  if (AmounttextField.getText().trim().isEmpty() || MemeberFinCB.getSelectedIndex() == -1 || 
			                dateChooserOd_1.getDate() == null || dateChooserDo_1.getDate() == null) {
			            JOptionPane.showMessageDialog(btnPay, "Please fill in all fields and select valid dates.");
			        } else {
			            new Thread(() -> {
			                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "")) {
			                    String sql = "INSERT INTO financetbl (PPeriodOd, PPeriodDo, PMember, PAmount) VALUES (?, ?, ?, ?)";
			                    java.sql.Date sqlDateOd = new java.sql.Date(dateChooserOd_1.getDate().getTime());
			                    java.sql.Date sqlDateDo = new java.sql.Date(dateChooserDo_1.getDate().getTime());

			                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			                        preparedStatement.setDate(1, sqlDateOd);
			                        preparedStatement.setDate(2, sqlDateDo);
			                        preparedStatement.setString(3, MemeberFinCB.getSelectedItem().toString());
			                        preparedStatement.setInt(4, Integer.parseInt(AmounttextField.getText()));

			                        int rows = preparedStatement.executeUpdate();
			                        if (rows > 0) {
			                            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(btnPay, "Payment added successfully."));
			                        }
			                        DisplayPayments(); // Refresh the display
			                    }
			                } catch (Exception ex) {
			                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(btnPay, "An error occurred: " + ex.getMessage()));
			                    ex.printStackTrace();
			                }
			            }).start();
			        }
				
				    }
				});


			btnPay.setForeground(new Color(255, 0, 128));
			btnPay.setFont(new Font("Verdana Pro", Font.BOLD, 15));
			btnPay.setBackground(new Color(128, 128, 255));
			btnPay.setBounds(575, 400, 87, 26);
			panel.add(btnPay);
			
			    //MouseListener:
				//Na dugme je dodat MouseListener koji reaguje na klikove mišem.
				//U okviru metode mouseClicked, prvo se vrši provera da li su sva potrebna polja popunjena (tekstualno polje za iznos, padajući meni za člana, i dva date choosera za datume). Ako neki od uslova nije ispunjen, prikazuje se poruka o grešci.
				//Logika za Dodavanje Plaćanja
				//Provera i dodavanje plaćanja:
				//Ako su sva polja popunjena i datumi odabrani, kreiranje i dodavanje plaćanja se pokreće u novom threadu da se izbegne blokiranje grafičkog interfejsa.
				//Unutar threada, uspostavlja se konekcija sa bazom (jdbc:mysql://localhost:3306/gymdb).
				//Priprema se SQL naredba za dodavanje podataka o plaćanju u tabelu financetbl. Podaci uključuju početni i krajnji datum plaćanja, člana i iznos plaćanja.
				//Datum se pretvara iz java.util.Date u java.sql.Date kako bi bio kompatibilan sa SQL bazom.
				//Izvršava se SQL naredba, i ako je uspešna, prikazuje se poruka o uspešnom dodavanju plaćanja.
				//Obrada izuzetaka:
				//Ukoliko dođe do izuzetka prilikom povezivanja sa bazom ili izvršavanja upita, izuzetak se obrađuje, prikazujući korisniku poruku o grešci i štampajući trag greške.
				//Osvežavanje Prikaza
				//Osvežavanje prikaza plaćanja:
				//Nakon dodavanja plaćanja, poziva se metoda DisplayPayments() kako bi se ažurirao prikaz plaćanja na korisničkom interfejsu.
			
			
			
			
			
			
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  if (Key == null || Key == 0) {
			            JOptionPane.showMessageDialog(btnEdit, "No Payment Selected for Editing");
			        } else {
			            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "")) {
			            	String query = "UPDATE financetbl SET PPeriodOd = ?, PPeriodDo = ?, PMember = ?, PAmount = ? WHERE PId = ?";
                          try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			            	    java.sql.Date sqlDateOd = null;
			            	    java.sql.Date sqlDateDo = null;
			            	    if (dateChooserOd_1 != null && dateChooserDo_1 != null) {
			            	        sqlDateOd = new java.sql.Date(dateChooserOd_1.getDate().getTime());
			            	        sqlDateDo = new java.sql.Date(dateChooserDo_1.getDate().getTime());
			            	    }

			            	    preparedStatement.setDate(1, sqlDateOd);
			            	    preparedStatement.setDate(2, sqlDateDo);
			            	    preparedStatement.setString(3, MemeberFinCB.getSelectedItem().toString());
			            	    preparedStatement.setInt(4, Integer.parseInt(AmounttextField.getText()));
			            	    preparedStatement.setInt(5, Key); // Setting the value for PId

			            	    int rows = preparedStatement.executeUpdate();

			            	    if (rows > 0) {
			            	        JOptionPane.showMessageDialog(btnEdit, "Payment Edited Successfully");
			            	        DisplayPayments(); // Refresh the display
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
		btnEdit.setBounds(687, 400, 79, 26);
		panel.add(btnEdit);
		
		//MouseListener:
		//	Na dugme je dodat MouseListener koji reaguje na klikove mišem.
		//	Unutar metode mouseClicked, prvo se proverava da li je selektovan neki zapis za izmenu (provera promenljive Key). Ako nije, prikazuje se poruka da nije izabran zapis za izmenu.
		//	Logika za Izmenu Podataka
		//	Provera i Izmena Podataka:
		//	Ako je izabrano validno plaćanje (Key nije null ili 0), pokušava se izmena podataka u bazi podataka.
		//	Uspostavlja se konekcija sa bazom podataka (jdbc:mysql://localhost:3306/gymdb) i priprema SQL upit za ažuriranje (UPDATE) podataka u tabeli financetbl.
		//	Datumski izbori sa dateChooserOd_1 i dateChooserDo_1 pretvaraju se u java.sql.Date formate.
		//	Postavljaju se vrednosti za period plaćanja, člana, iznos, i identifikator plaćanja (PId), a zatim se izvršava SQL upit.
		//	Obrada Rezultata i Izuzetaka
		//Ako izmena uspe, prikazuje se poruka o uspešnoj izmeni i osvežava se prikaz plaćanja pozivom metode DisplayPayments().
		//	Ako izmena ne uspe, prikazuje se poruka o neuspehu.
		//	Obrada izuzetaka:
        //Bilo koji izuzetak koji se javi tokom procesa konekcije, pripreme SQL-a ili izvršavanja, štampa se na standardni izlaz, i korisniku se prikazuje poruka sa greškom.
		//	Završetak Konfiguracije
		//	Ovaj kod omogućava korisnicima da lako i efikasno izmene podatke o plaćanjima unutar aplikacije
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			        String searchText = PaymentstextField.getText().trim().toLowerCase();
			        TableRowSorter<TableModel> sorter = new TableRowSorter<>(Paymentstable.getModel());
			        Paymentstable.setRowSorter(sorter);
			        
			        if (searchText.isEmpty()) {
			            sorter.setRowFilter(null);
			        } else {
			            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));
			        }
			}
		});
		btnSearch.setForeground(new Color(255, 0, 128));
		btnSearch.setFont(new Font("Verdana Pro", Font.BOLD, 15));
		btnSearch.setBackground(new Color(128, 128, 255));
		btnSearch.setBounds(608, 213, 105, 26);
		panel.add(btnSearch);
		
		JLabel lblMembersList = new JLabel("Payments");
		lblMembersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembersList.setForeground(new Color(128, 128, 192));
		lblMembersList.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblMembersList.setBounds(662, 104, 121, 31);
		panel.add(lblMembersList);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setForeground(new Color(128, 128, 192));
		lblMember.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblMember.setBounds(262, 249, 96, 31);
		panel.add(lblMember);
		
		JLabel lblAmount = new JLabel("Amount membership");
		lblAmount.setForeground(new Color(128, 128, 192));
		lblAmount.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblAmount.setBounds(625, 281, 215, 31);
		panel.add(lblAmount);
		
		AmounttextField = new JTextField();
		AmounttextField.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		AmounttextField.setForeground(new Color(0, 0, 0));
		AmounttextField.setBackground(new Color(128, 128, 255));
		AmounttextField.setBounds(630, 323, 193, 26);
		panel.add(AmounttextField);
		AmounttextField.setColumns(10);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 @SuppressWarnings("unchecked")
				TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) Paymentstable.getRowSorter();
			        if (sorter != null) {
			            sorter.setRowFilter(null);
			        }
			        PaymentstextField.setText("");  // Očistite polje za pretragu
			    
			}
		});
		btnRefresh.setForeground(new Color(255, 0, 128));
		btnRefresh.setFont(new Font("Verdana Pro", Font.BOLD, 15));
		btnRefresh.setBackground(new Color(128, 128, 255));
		btnRefresh.setBounds(735, 213, 105, 26);
		panel.add(btnRefresh);
		
		PaymentstextField = new JTextField();
		PaymentstextField.setFont(new Font("Verdana Pro", Font.PLAIN, 15));
		PaymentstextField.setForeground(new Color(0, 0, 0));
		PaymentstextField.setBackground(new Color(128, 128, 255));
		PaymentstextField.setBounds(630, 146, 193, 26);
		panel.add(PaymentstextField);
		PaymentstextField.setColumns(10);
		
		
		Object[][] data = {
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			    {"", "", "", "", ""},
			};

			String[] columnNames = {"PId", "PPeriodOd", "PPeriodDo", "PMember", "PAmount"};
			Paymentstable = new JTable(data, columnNames);
			Paymentstable.setFont(new Font("Verdana Pro", Font.PLAIN, 12));
			Paymentstable.setBorder(new EmptyBorder(0, 0, 0, 0));
            Paymentstable.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	 int MyIndex = Paymentstable.getSelectedRow();
			         if (MyIndex != -1) {  // Provera da li je red selektovan
			             TableModel model = Paymentstable.getModel();
			             Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());

			           
			              try {
			                  LocalDate dateOd = LocalDate.parse(model.getValueAt(MyIndex, 1).toString());
			                  LocalDate dateDo = LocalDate.parse(model.getValueAt(MyIndex, 2).toString());
			                  
			                  
			                  // Konverzija iz LocalDate u java.util.Date
			                  Date dateOdUtil = Date.from(dateOd.atStartOfDay(ZoneId.systemDefault()).toInstant());
			                  Date dateDoUtil = Date.from(dateDo.atStartOfDay(ZoneId.systemDefault()).toInstant());
			                  // Postavljamo konvertovane datume
			                  dateChooserOd_1.setDate(dateOdUtil);
			                  dateChooserDo_1.setDate(dateDoUtil);
			              } catch (DateTimeParseException ex) {
			                  ex.printStackTrace();
			              }
			              
            

			              // Update the Member JComboBox selection
			              String memberValue = model.getValueAt(MyIndex, 3).toString();
			              if (memberExistsInComboBox(memberValue, MemeberFinCB)) {
			                  MemeberFinCB.setSelectedItem(memberValue);
			              }

			              AmounttextField.setText(model.getValueAt(MyIndex, 4).toString());
			          }
			      }
			      
			      private boolean memberExistsInComboBox(String memberValue, JComboBox<String> comboBox) {
			          for (int i = 0; i < comboBox.getItemCount(); i++) {
			              if (comboBox.getItemAt(i).equals(memberValue)) {
			                  return true;
			              }
			          }
			          return false;
			    }
			});
            Paymentstable.setGridColor(new Color(255, 0, 255));
            Paymentstable.setForeground(new Color(255, 0, 255));
			JScrollPane scrollPane = new JScrollPane(Paymentstable);
			scrollPane.setBounds(262, 472, 643, 261); // Set bounds as necessary

			// Add ONLY the JScrollPane to the panel, not the table
			panel.add(scrollPane);

		// Call the method to display data from the database
			DisplayPayments();
			
			//Tabela je namenjena za prikaz podataka o plaćanjima, a korisnici mogu selektovati redove za izmenu informacija. Evo detaljnog objašnjenja funkcionalnosti koda:
              //Inicijalizacija Podataka za Tabelu
			//	Data i Column Names:
				//data je dvodimenzionalni niz stringova koji predstavlja inicijalni prazni sadržaj tabele.
				//columnNames je niz stringova koji definiše nazive kolona za tabelu (PId, PPeriodOd, PPeriodDo, PMember, PAmount), odnosno identifikator plaćanja, početni i krajnji datum perioda plaćanja, člana i iznos.
				//Konfiguracija JTable
				//JTable i JScrollPane:
				//Paymentstable je tabela kreirana sa gore navedenim podacima i nazivima kolona.
				//Za tabelu je kreiran JScrollPane, koji omogućava skrolovanje kroz podatke. JScrollPane je pozicioniran i dodat na panel.
				//Dodavanje Funkcionalnosti za Selekciju i Izmenu
				//Tabeli je dodat MouseListener za detekciju klikova na redove.
				//Kada korisnik klikne na red, indeks selektovanog reda se proverava i koristi se za dohvatanje vrednosti iz modela tabele.
				//Podaci iz modela tabele se koriste za popunjavanje drugih GUI elemenata za izmenu, kao što su date choosers za datume i tekstualno polje za iznos.
				
				//Konverzija Datuma:
				//Izvlačenje i konverzija datuma iz String formata u LocalDate, a potom u java.util.Date radi postavljanja u GUI komponente koje zahtevaju datum (dateChooserOd_1 i dateChooserDo_1).
				
				//Ažuriranje Ostalih GUI Komponenata:
				//Proverava se i ažurira selekcija za JComboBox koji sadrži informacije o članu.
				//Tekstualno polje za iznos se ažurira na osnovu izabranog reda.
				//Pomoćne Metode
				//Pomoćna Metoda za Proveru Postojanja Člana:
				//memberExistsInComboBox je pomoćna metoda koja proverava da li dati član postoji u padajućem meniju.
				//Vizuelni Stil i Funkcionalnost
				//stilizovanje i Dodavanje na Panel:
				//Samo JScrollPane koji sadrži Paymentstable se dodaje na panel.
			    //Poziv Metode za Prikaz Podataka:
				//Poziva se metoda DisplayPayments() da osveži i prikaže podatke o plaćanjima iz baze podataka.
			
		dateChooserOd_1 = new JDateChooser();
		dateChooserOd_1.setBackground(new Color(128, 128, 255));
		dateChooserOd_1.setForeground(new Color(255, 128, 255));
		dateChooserOd_1.setBounds(262, 128, 193, 31);
		panel.add(dateChooserOd_1);
		
	    dateChooserDo_1 = new JDateChooser();
		dateChooserDo_1.setOpaque(false);
		dateChooserDo_1.setForeground(new Color(255, 128, 255));
		dateChooserDo_1.setBounds(262, 197, 193, 31);
		panel.add(dateChooserDo_1);
		
		JTextArea txtrDo = new JTextArea();
		txtrDo.setBackground(new Color(0, 0, 0));
		txtrDo.setForeground(new Color(128, 128, 192));
		txtrDo.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		txtrDo.setText("Do");
		txtrDo.setBounds(482, 186, 47, 31);
		panel.add(txtrDo);
		  
		JTextArea txtrOd = new JTextArea();
		txtrOd.setText("Od");
		txtrOd.setForeground(new Color(128, 128, 192));
		txtrOd.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		txtrOd.setBackground(Color.BLACK);
		txtrOd.setBounds(482, 139, 47, 31);
		panel.add(txtrOd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (Key == 0) {
			            JOptionPane.showMessageDialog(btnDelete, "Select Payment To Delete");
			        } else {
			            new Thread(() -> { // Perform database operations in a new thread
			                try {
			                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
			                    String query = "DELETE FROM financetbl WHERE PId = ?";
			                    PreparedStatement preparedStatement = connection.prepareStatement(query);
			                    preparedStatement.setInt(1, Key);
			                    
			                    int result = preparedStatement.executeUpdate();
			                    if (result > 0) {
			                        JOptionPane.showMessageDialog(btnDelete, "Payment Deleted Successfully");
			                        DisplayPayments();
			                    } else {
			                        JOptionPane.showMessageDialog(btnDelete, "Payment Not Found");
			                    }
			                } catch (Exception ex) {
			                    JOptionPane.showMessageDialog(btnDelete, "Error: " + ex.getMessage());
			                }
			            }).start();
			        }
			}
		});
		btnDelete.setForeground(new Color(255, 0, 128));
		btnDelete.setFont(new Font("Verdana Pro", Font.BOLD, 14));
		btnDelete.setBackground(new Color(128, 128, 255));
		btnDelete.setBounds(789, 400, 87, 26);
		panel.add(btnDelete);
		
		   // MouseListener:
			//Na dugme je dodat MouseListener koji detektuje klikove mišem.
			//Prilikom klikanja, prvo se proverava da li je plaćanje selektovano (provera da li je promenljiva Key jednaka 0). Ako nije selektovano nijedno plaćanje, prikazuje se poruka da korisnik treba da izabere plaćanje za brisanje.
			//Proces Brisanja u Novom Thread-u
			//Ako je plaćanje izabrano, brisanje se pokreće u novom thread-u kako bi se izbeglo blokiranje grafičkog interfejsa.
			//Uspostavlja se konekcija sa MySQL bazom podataka (gymdb).
			//Priprema se SQL upit za brisanje plaćanja iz tabele financetbl na osnovu identifikatora plaćanja (PId).
			//Izvršava se SQL naredba. Ako je plaćanje uspešno obrisano (rezultat veći od 0), prikazuje se poruka o uspehu, a zatim se poziva metoda DisplayPayments() da osveži prikaz. Ako plaćanje nije pronađeno, prikazuje se odgovarajuća poruka.
			//Obrada Izuzetaka:
			//Ukoliko dođe do bilo kakvog izuzetka tokom povezivanja sa bazom, pripreme upita, ili izvršavanja, izuzetak se hvata, prikazuje se poruka o grešci korisniku, i izuzetak se beleži (što je korisno za otkrivanje grešaka).
		
		
		JLabel lblMembershipPaymentsList = new JLabel("Membership payments list");
		lblMembershipPaymentsList.setForeground(new Color(128, 128, 192));
		lblMembershipPaymentsList.setFont(new Font("Verdana Pro", Font.PLAIN, 16));
		lblMembershipPaymentsList.setBounds(262, 430, 267, 31);
		panel.add(lblMembershipPaymentsList);
	}

		
	
		


	private void initComponents() {
	    MemeberFinCB = new JComboBox<>();
	    AmounttextField = new JTextField();
	    Paymentstable = new JTable();
	   
	}

	private List<String> getMembers() {
	    List<String> members = new ArrayList<>();
	    // Pretpostavljamo da je konekcija uspešna i resultSet nije null
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT MName FROM membertbl");
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        while (resultSet.next()) {
	            members.add(resultSet.getString("MName"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return members;  // Ova metoda bi uvek trebalo da vrati ne-null vrednost
	}
	
	//Ovaj Java kod definiše metodu getMembers(), koja izvlači spisak imena članova iz baze podataka i vraća ih u obliku liste. Evo detaljnog objašnjenja kako funkcioniše ovaj kod:
      //Definicija Metode i Inicijalizacija Liste
		//Metoda getMembers() ne prima argumente i vraća listu stringova (List<String>). Ova lista će sadržati imena članova.
		//members je ArrayList<>, inicijalizovan na početku metode, koji će biti korišćen za skladištenje imena članova izvučenih iz baze podataka.
		//Uspostavljanje Konekcije sa Bazom Podataka
		//Konekcija se uspostavlja pomoću DriverManager.getConnection(), gde je specificiran URL baze podataka (jdbc:mysql://localhost:3306/gymdb), korisničko ime (root) i bez lozinke. Ovo omogućava metodi da komunicira sa MySQL bazom podataka gymdb.
		//Priprema i Izvršavanje SQL Upita
		//PreparedStatement se koristi za pripremu SQL upita. Upit "SELECT MName FROM membertbl" služi za izvlačenje kolone MName iz tabele membertbl, što predstavlja imena članova.
		//executeQuery() pokreće upit i vraća ResultSet, koji je skup rezultata dobijenih iz baze podataka.
		//Obrada Rezultata Upita
		//Kroz while petlju se iterira kroz resultSet. Za svaki red u rezultatima, resultSet.next() pomeri kursor na sledeći red i vraća true ako postoji red za obradu.
		//resultSet.getString("MName") dohvata vrednost iz kolone MName trenutnog reda i dodaje je u listu members.
		//Obrada Izuzetaka
		//Metoda koristi blok try-catch za hvatanje i obradu SQLException, koje mogu nastati tokom povezivanja s bazom, izvršavanja upita, ili obrade rezultata. U slučaju izuzetka, štampa se trag izuzetka pomoću e.printStackTrace(), što pomaže u dijagnostikovanju problema.
		//Povratak Rezultata
		//Na kraju metode, return members; vraća listu imena članova. Ovo osigurava da, bez obzira na uspeh ili neuspeh operacija unutar bloka try, metoda će uvek vratiti listu (koja može biti prazna ako dođe do izuzetka ili ako nema članova).
		//Zaključak
		//Metoda getMembers() je robustna i efikasna za dohvatanje podataka iz baze i može se koristiti u različitim delovima aplikacije gde je potrebno prikazati ili obraditi informacije o članovima.
	
		
		   private void DisplayPayments() {
		        String query = "SELECT * FROM financetbl";
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
		             PreparedStatement preparedStatement = connection.prepareStatement(query);
		             ResultSet resultSet = preparedStatement.executeQuery()) {

		            Paymentstable.setModel(DbUtils.resultSetToTableModel(resultSet));
		        } catch (SQLException e) {
		            e.printStackTrace();
		            
		             }
		        
		        //Kod koji je prikazan je metoda DisplayPayments() u Java aplikaciji koja koristi JDBC za povezivanje sa MySQL bazom podataka. Cilj ove metode je da prikaže podatke o plaćanjima iz tabele financetbl u bazi podataka. Evo detaljnog objašnjenja kako metoda funkcioniše:
                  //Definicija SQL Upita
		        	//SQL upit: Definisan je SQL upit kao String query = "SELECT * FROM financetbl"; koji služi za dohvatanje svih podataka iz tabele financetbl. Ovo uključuje sve redove i kolone iz navedene tabele.
		        	//Uspostavljanje Konekcije
		        	//Konekcija sa bazom: Metoda koristi DriverManager.getConnection() za uspostavljanje konekcije sa lokalnom MySQL bazom podataka (gymdb). Pristup se vrši pod korisničkim imenom "root" bez lozinke.
		        	//Izvršavanje SQL Upita
		        	//Priprema i izvršavanje upita: Upotrebljava se PreparedStatement za pripremu SQL upita, čime se osigurava bezbednije i efikasnije izvršavanje upita u poređenju sa običnim Statement objektima. executeQuery() pokreće upit i vraća ResultSet, koji sadrži rezultate upita.
		        	//Postavljanje Modela za Tabelu
		        	//Ažuriranje modela tabele: Paymentstable.setModel(DbUtils.resultSetToTableModel(resultSet)); koristi se za postavljanje modela tabele Paymentstable. DbUtils.resultSetToTableModel(resultSet) konvertuje ResultSet u TableModel, što omogućava jednostavno postavljanje podataka u JTable komponentu bez potrebe za ručnim parsiranjem rezultata. Ovo je veoma korisno za dinamičko ažuriranje GUI-a na osnovu sadržaja baze podataka.
		        	//Obrada Izuzetaka
		        	//Obrada SQL izuzetaka: Blok catch hvata i obrađuje SQLException izuzetke koji mogu nastati tokom povezivanja, izvršavanja upita, ili manipulacije rezultatima. Izuzetak se štampa pomoću e.printStackTrace(), što pomaže u dijagnostikovanju problema.
		        	//Zaključak
		        	//Metoda DisplayPayments() efikasno i bezbedno pristupa podacima iz baze i prikazuje ih u korisničkom interfejsu aplikacije. Korišćenje DbUtils za konverziju ResultSet u TableModel pojednostavljuje kod i smanjuje mogućnost grešaka prilikom ručnog prevođenja podataka između baze i aplikacije. Ovo je primer kako se može izgraditi robustna i održiva funkcionalnost za prikaz podataka u modernim Java aplikacijama.







		    }
}

		
		
		
		
	
		
	

			
		


	    
	    


