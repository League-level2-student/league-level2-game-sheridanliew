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
	String number;

	Block(int x, int y, int width, int height) {
		this.x = x;
		x=100;
		this.y = y;
		y=100;
		this.width = width;
		width=140;
		this.height = height;
		height=140;
		speed = 10;
		isActive = true;
		collisionBox = new Rectangle(x, y, width, height);
		numberFont = new Font("Arial", Font.PLAIN, 24);
		number = "2";
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRoundRect(x, y, width, height, 10, 10);
		g.setColor(Color.DARK_GRAY);
		g.setFont(numberFont);
		g.drawString(number, width/2, height/2);
	}
	
	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	public void left() {
		x -= speed;
	}

	public void right() {
		x += speed;
	}
}

//if collision: parseInt number to num, num=num+num;
//2=white, 4=yellow, 8=orange, 16=red, 32=pink, 64=magenta, 128=purple, 256=blue, 512=cyan, 1024=green, 2048=black
