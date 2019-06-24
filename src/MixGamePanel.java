import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.swing.JPanel;

public class MixGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font bodyFont;
	Font captionFont;
	Timer frameDraw;
	ObjectManager om;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	MixGamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 200);
		bodyFont = new Font("Arial", Font.PLAIN, 50);
		captionFont = new Font("Arial", Font.PLAIN, 18);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		om = new ObjectManager();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
			System.out.println("draw");
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void startGame() {
		System.out.println("game state");
	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("MIX", 20, 180);
		g.setFont(bodyFont);
		g.setColor(Color.CYAN);
		g.drawString("Press ENTER to start", 30, 300);
		g.drawString("Press SPACE for intructions", 30, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(250, 250, 200, 200);
	//	om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME", 20, 180);
		g.drawString("OVER", 20, 380);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to restart", 30, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
/*		if (currentState == MENU) {
			System.out.println("menu on");
			updateMenuState();
		} else if (currentState == GAME) {
			System.out.println("game on");
			updateGameState();
		} else if (currentState == END) {
			System.out.println("end on");
			updateEndState();
		}
		repaint();*/
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(currentState);
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else if (currentState == MENU) {
				currentState++;
				startGame();
			} else if (currentState == GAME) {
				currentState++;
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
