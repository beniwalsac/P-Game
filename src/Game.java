import java.awt.Color;

import javax.swing.JFrame;


public class Game extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int WIDTH = 800, HEIGHT = 600;
	private Board panel;
	
	public Game() {
		setSize(WIDTH, HEIGHT);
		setTitle("Pong");
		setBackground(Color.WHITE);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new Board(this);
		add(panel);
	}
	
	public Board getPanel() {
		return panel;
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
