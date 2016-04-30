import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Paddle {
	private int WIDTH, HEIGHT;
	private Game game;
	private int up, down;
	private int x,xa;
	private int y,ya;
	private boolean orientation;
	private Color col;
	
	public Paddle(Game game, int up, int down, int x, boolean b, Color c) {
		this.game = game;
		this.col = c;
		this.orientation = b;
		if(orientation) {
			this.x = x;
			y = game.getHeight() / 2;
			WIDTH = 10;
			HEIGHT = 60;
		} else {
			this.x = game.getWidth() / 2;
			y = x;
			WIDTH = 60;
			HEIGHT = 10;
		}
		this.up = up;
		this.down = down;
	}
	
	public void update() {
		if(orientation) {
			if (y>2 && y< game.getHeight()-HEIGHT-32) y += 2*ya;
			else if(y>0 && y<game.getHeight()-HEIGHT-30) y += ya;
			else if (y==0) y++;
			else if (y == game.getHeight()-HEIGHT-30) y--;
		} else {
			if (x>2 && x< game.getWidth()-WIDTH-32) x += 2*xa;
			else if (x>0 && x<game.getWidth()-WIDTH-30) x += xa;
			else if (x==0) x++;
			else if (x == game.getWidth()-WIDTH-30) x--;
		}
	}
	
	public void pressed(int keycode) {
		if(orientation) {
			if (keycode == up) ya = -1;
			else if (keycode == down) ya = 1;			
		} else {
			if (keycode == up) xa = -1;
			else if (keycode == down) xa = 1;
		}
	}
	
	public void released(int keycode) {
		if (keycode == up || keycode == down) {
			ya = 0;
			xa = 0;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public void paint(Graphics g) {
		g.setColor(col);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
