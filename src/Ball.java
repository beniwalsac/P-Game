import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JOptionPane;


public class Ball {
	private static final int WIDTH = 30, HEIGHT = 30;
    private Game game;
    private int x, y, xa = 2, ya = 2;
    
    public Ball(Game game) {
    	this.game = game;
    	x = game.getWidth()/2;
    	y = game.getHeight()/2;
    }
    
    public void update() {
    	x += xa;
    	y += ya;
    	if(x<10) {
    		game.getPanel().increaseScore(2);
    		//x = game.getWidth()/2;
    		xa = -xa;
    	}
    	else if (x > game.getWidth()-WIDTH-20) {
    		game.getPanel().increaseScore(1);
    		//x = game.getWidth()/2;
    		xa = -xa;
    	}
    	else if (y<10){
    		game.getPanel().increaseScore(4);
    		ya = -ya;
    	} else if (y>game.getHeight()-HEIGHT-40) {
    		game.getPanel().increaseScore(3);
    		ya = -ya;
    	}
    	/*if(game.getPanel().getScore(1) == 10)
    		JOptionPane.showMessageDialog(null, "Player 1 loses", "Pong", JOptionPane.PLAIN_MESSAGE);
    	else if (game.getPanel().getScore(2) == 10)
    		JOptionPane.showMessageDialog(null, "Player 2 loses", "Pong", JOptionPane.PLAIN_MESSAGE);
    	else if (game.getPanel().getScore(3) == 10)
    		JOptionPane.showMessageDialog(null, "Player 3 loses", "Pong", JOptionPane.PLAIN_MESSAGE);
    	else if (game.getPanel().getScore(4) == 10)
    		JOptionPane.showMessageDialog(null, "Player 4 loses", "Pong", JOptionPane.PLAIN_MESSAGE);*/
    	int result=0,helper =0;
    	for (int i=1;i<5;i++) {
    		if(game.getPanel().getScore(i)<10) {
    			helper += 1;
    			result = i;
    		}
    	}
    	if(helper==1) {
    		JOptionPane.showMessageDialog(null, "Player "+result+" wins.");
    	}
    	checkCollision();
    }
    
    public void checkCollision() {
    	if(game.getPanel().getScore(1)<10) {
    		if (testIntersection(game.getPanel().getPlayer(1).getBounds(),getBounds())) xa = -xa;
    	}
    	if(game.getPanel().getScore(2)<10) {
    		if (testIntersection(game.getPanel().getPlayer(2).getBounds(),getBounds())) xa = -xa;
    	}
    	if(game.getPanel().getScore(3)<10) {
    		if (testIntersection(game.getPanel().getPlayer(3).getBounds(),getBounds())) ya = -ya;
    	}
    	if(game.getPanel().getScore(4)<10) {
    		if (testIntersection(game.getPanel().getPlayer(4).getBounds(),getBounds())) ya = -ya;
    	}
    }
    
    public boolean testIntersection(Shape shapeA, Shape shapeB) {
       Area areaA = new Area(shapeA);
   	   areaA.intersect(new Area(shapeB));
   	   return !areaA.isEmpty();
    }
    
    public Ellipse2D getBounds() {
    	Ellipse2D.Double circle = new Ellipse2D.Double(x,y,30,30);
    	return circle;
    }
    
    public void paint(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,30,30);
        g2d.setColor(Color.BLACK);
        g2d.fill(circle);
    }
}
