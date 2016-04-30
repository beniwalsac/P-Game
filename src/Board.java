import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	private Ball ball;
	private Paddle player1, player2, player3, player4;
	private int score1, score2, score3, score4;
	
	public Board(Game game) {
		setBackground(Color.yellow);
		this.game = game;
		ball = new Ball(game);
		player1 = new Paddle(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth()-40,true,Color.BLUE);
		player2 = new Paddle(game, KeyEvent.VK_W, KeyEvent.VK_S, 10,true,Color.CYAN);
		player3 = new Paddle(game, KeyEvent.VK_B, KeyEvent.VK_N, game.getHeight()-50, false,Color.orange);
		player4 = new Paddle(game, KeyEvent.VK_O, KeyEvent.VK_P, 20, false,Color.green);
		Timer timer = new Timer(5, this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public Paddle getPlayer(int player) {
		if(player == 1) return player1;
		else if(player == 2) return player2;
		else if(player == 3) return player3;
		else return player4;
	}
	
	public void increaseScore(int player) {
		if(player == 1 && score1<10) score1++;
		else if(player == 2 && score2<10) score2++;
		else if(player == 3 && score3<10) score3++;
		else if(player == 4 && score3<10) score4++;
	}
	
	public int getScore(int player) {
		if (player == 1) return score1;
		else if(player == 2) return score2;
		else if(player == 3) return score3;
		else return score4;
	}
	
	private void update() {
		ball.update();
		if(score1<10) player1.update();
		if(score2<10) player2.update();
		if(score3<10) player3.update();
		if(score4<10) player4.update();
	}
	
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		if(score1<10) player1.pressed(e.getKeyCode());
		if(score2<10) player2.pressed(e.getKeyCode());
		if(score3<10) player3.pressed(e.getKeyCode());
		if(score4<10) player4.pressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		if(score1<10) player1.released(e.getKeyCode());
		if(score2<10) player2.released(e.getKeyCode());
		if(score3<10) player3.released(e.getKeyCode());
		if(score4<10) player4.released(e.getKeyCode());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		String s1 = Integer.toString(game.getPanel().getScore(1));	
		String s2 = Integer.toString(game.getPanel().getScore(2));
		String s3 = Integer.toString(game.getPanel().getScore(3));
		String s4 = Integer.toString(game.getPanel().getScore(4));
		g.drawString(s1+" : "+s2+" : "+s3+" : "+s4, (game.getWidth()/2)-10, 10);
		ball.paint(g);
		if(score1<10) player1.paint(g);
		if(score2<10) player2.paint(g);
		if(score3<10) player3.paint(g);
		if(score4<10) player4.paint(g);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
