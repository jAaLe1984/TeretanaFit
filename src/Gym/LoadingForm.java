package Gym;

import javax.swing.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;
import java.awt.*;

public class LoadingForm extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JProgressBar progressBar;
    private Timer timer;
   
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingForm frame = new LoadingForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    
    
    
    public LoadingForm() {
      
    	FlatDraculaIJTheme.setup();
        setType(Type.UTILITY);
        setUndecorated(true);
        getContentPane().setBackground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(542, 271);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel loadingLabel = new JLabel("", SwingConstants.CENTER);
        loadingLabel.setForeground(new Color(128, 128, 192));
        loadingLabel.setFont(new Font("Verdana Pro", Font.BOLD, 14));
        loadingLabel.setBounds(72, 11, 397, 69);
        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/loa1.gif")));
        getContentPane().add(loadingLabel);
        
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(255, 0, 128));
        progressBar.setBackground(new Color(128, 128, 192));
        progressBar.setBounds(72, 228, 397, 14);
        progressBar.setIndeterminate(true);
        getContentPane().add(progressBar);
        
        JLabel lblGif1 = new JLabel("");
        lblGif1.setBounds(27, 88, 482, 124);
        lblGif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Slike/101.gif")));
        getContentPane().add(lblGif1);

        setVisible(true);

        // Timer to simulate the loading process
        timer = new Timer(10000, e -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            dispose();  // Close the loading form once the main form is displayed
        });
        timer.setRepeats(false);  // Only run once
        timer.start();
    }
    
    
	
    }

	
    