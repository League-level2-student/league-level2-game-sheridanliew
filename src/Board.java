import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private int yoffset = 225;
	private int xoffset = 105;

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < 5; i++) {
			g.fillRect(xoffset, yoffset, 600, 1);
			yoffset += 150;
		}
		yoffset = 225;

		for (int i = 0; i < 5; i++) {
			g.fillRect(xoffset, yoffset, 1, 600);
			xoffset += 150;
		}
		xoffset = 105;
	}

}
