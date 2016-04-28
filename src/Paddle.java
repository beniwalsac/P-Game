import java.awt.Graphics;
import java.awt.Rectangle;


public class Paddle {
	private static final int WIDTH = 10, HEIGHT = 60;
	private Game game;
	private int up, down;
	private int x;
	private int y,ya;
	
	public Paddle(Game game, int up, int down, int x) {
		this.game = game;
		this.x = x;
		y = game.getHeight() / 2;
		this.up = up;
		this.down = down;
	}
	
	public void update() {
		if (y>0 && y< game.getHeight()-HEIGHT-29) y += ya;
		else if (y==0) y++;
		else if (y == game.getHeight()-HEIGHT-29) y--;
	}
	
	public void pressed(int keycode) {
		if (keycode == up) ya = -2;
		else if (keycode == down) ya = 2;
	}
	
	public void released(int keycode) {
		if (keycode == up || keycode == down) ya = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
