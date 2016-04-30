import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Window.Type;


public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton btnMultiPlayer = new JButton("Multi Player");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setBackground(new Color(255, 0, 0));
		btnSinglePlayer.setForeground(new Color(204, 51, 0));
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Game();
			}
		});
		contentPane.add(btnSinglePlayer);
		btnMultiPlayer.setBackground(new Color(255, 102, 0));
		btnMultiPlayer.setForeground(new Color(255, 0, 51));
		contentPane.add(btnMultiPlayer);
	}

}
