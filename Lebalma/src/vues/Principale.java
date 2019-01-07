package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Principale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
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
	public Principale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 51, 91, 259);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(115, 51, 579, 259);
		contentPane.add(layeredPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(62, 45, 75, 80);
		layeredPane.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 682, 37);
		contentPane.add(panel_1);
	}
}
