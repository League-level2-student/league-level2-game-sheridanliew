import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	Font numberFont;

	Block(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 0;
		isActive = true;
		collisionBox = new Rectangle(x, y, width, height);
		numberFont = new Font("Arial", Font.PLAIN, 24);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.DARK_GRAY);
		g.setFont(numberFont);
		g.drawString("2", width/2, height/2);
	}
}
