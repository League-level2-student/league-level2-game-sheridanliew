import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	Block[][] gameBoard;
	MixObjectManager om;
	Timer cellSpawn;
	JPanel panel;
	JLabel gameBGImageLabel;
//	public static BufferedImage image;
	
	//restructure entire program!! (delete all useless code that doesn't actually do anything)


	MixGamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 200);
		bodyFont = new Font("Arial", Font.PLAIN, 50);
		captionFont = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		om = new MixObjectManager();
		panel = new JPanel();
		gameBGImageLabel = new JLabel();
//		try {
//			image = ImageIO.read(this.getClass().getResourceAsStream("screenshot.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	void intitializeBlocks() {
		Random random = new Random();
		int x1 = random.nextInt(4);
		int y1 = random.nextInt(4);
		int x2 = random.nextInt(4);
		int y2 = random.nextInt(4);
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				gameBoard[i][j] = new Block();
				gameBoard[i][j].setOpaque(true);
				gameBoard[i][j].setBackground(Color.GREEN);
				panel.add(gameBoard[i][j]);
			}
		}
		Mix.frame.add(panel);
		while (x1 == x2 && y1 == y2) {
			x2 = random.nextInt(4);
			y2 = random.nextInt(4);
		}
		gameBoard[x1][y1].setValue("2");
		gameBoard[x2][y2].setValue("2");
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void startGame() {
		cellSpawn = new Timer(1000, om);
		cellSpawn.start();
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
		g.setFont(captionFont);
		g.setColor(Color.MAGENTA);
		g.drawString("a 2048 game", 35, 245);
		g.setFont(bodyFont);
		g.setColor(Color.CYAN);
		g.drawString("Press ENTER to start", 30, 420);
	}
	
	void intitializeMenuState() {
		
	}

	void drawGameState(Graphics g) {
//		g.setColor(Color.DARK_GRAY);
//		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
//		g.drawImage(image, 0, 0, 800, 947, null);
		gameBGImageLabel.setIcon(new ImageIcon("gameScreenshot.png"));
		panel.add(gameBGImageLabel);
		System.out.println("game");
//		g.setFont(titleFont);
//		g.setColor(Color.MAGENTA);
//		g.drawString("MIX", 20, 180);
//		g.setFont(bodyFont);
//		g.setColor(Color.CYAN);
//		g.drawString("SCORE: " + om.score, 500, 180);
//		g.setFont(captionFont);
//		g.drawString("Use the arrow keys to move the blocks. When two tiles with the same", 35, 870);
//		g.drawString("number touch, they merge into one. Join the numbers to reach the", 35, 895);
//		g.drawString("2048 tile!", 35, 920);
//		g.setColor(Color.GRAY);
//		g.fillRoundRect(100, 220, 610, 610, 20, 20);
//		g.setColor(Color.LIGHT_GRAY);
//		g.fillRoundRect(110, 230, 140, 140, 10, 10);
//		g.fillRoundRect(110, 380, 140, 140, 10, 10);
//		g.fillRoundRect(110, 530, 140, 140, 10, 10);
//		g.fillRoundRect(110, 680, 140, 140, 10, 10);
//		g.fillRoundRect(260, 230, 140, 140, 10, 10);
//		g.fillRoundRect(260, 380, 140, 140, 10, 10);
//		g.fillRoundRect(260, 530, 140, 140, 10, 10);
//		g.fillRoundRect(260, 680, 140, 140, 10, 10);
//		g.fillRoundRect(410, 230, 140, 140, 10, 10);
//		g.fillRoundRect(410, 380, 140, 140, 10, 10);
//		g.fillRoundRect(410, 530, 140, 140, 10, 10);
//		g.fillRoundRect(410, 680, 140, 140, 10, 10);
//		g.fillRoundRect(560, 230, 140, 140, 10, 10);
//		g.fillRoundRect(560, 380, 140, 140, 10, 10);
//		g.fillRoundRect(560, 530, 140, 140, 10, 10);
//		g.fillRoundRect(560, 680, 140, 140, 10, 10);
		om.draw(g);
	}
	void intitializeGameState() {
		gameBGImageLabel.setIcon(new ImageIcon("gameScreenshot.png"));
		panel.add(gameBGImageLabel);
		System.out.println("game");
		//image will not show up?
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("GAME", 20, 180);
		g.drawString("OVER", 20, 380);
		g.setColor(Color.CYAN);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to restart", 30, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * if (currentState == MENU) { System.out.println("menu on"); updateMenuState();
		 * } else if (currentState == GAME) { System.out.println("game on");
		 * updateGameState(); } else if (currentState == END) {
		 * System.out.println("end on"); updateEndState(); } repaint();
		 */
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
				cellSpawn.stop();
			}
		}
		repaint();
		if (currentState == GAME) {
			for (Block b : om.blocks) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("UP");
					b.up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("DOWN");
					b.down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("LEFT");
					b.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("RIGHT");
					b.right();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}



}
