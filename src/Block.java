import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Block extends JLabel{
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	Font numberFont;
	private String number;
	Color color;

	Block() {
		collisionBox = new Rectangle(x, y, width, height);
		numberFont = new Font("Arial", Font.PLAIN, 36);
		number = "2";
	}
	
	void setValue(String number) {
		this.number=number;
		this.setText(number);
	}

	void update() {

	}

	void draw(Graphics g) {

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
