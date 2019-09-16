import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font bodyFont;
	Font captionFont;
	Timer frameDraw;
	Cell[][] gameBoard;
	ObjectManager om;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer cellSpawn;
	//Cell[cells.length-1][cells[cells.length-1].length-1];

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 200);
		bodyFont = new Font("Arial", Font.PLAIN, 50);
		captionFont = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		gameBoard = new Cell[4][4];
//		om = new ObjectManager(r);
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
//		om.update();
//		if (r.isActive == false) {
//			currentState = END;
//		}
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

	void drawGameState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("MIX", 20, 180);
		g.setFont(bodyFont);
		g.setColor(Color.CYAN);
		g.drawString("SCORE: " + om.score, 500, 180);
		g.setFont(captionFont);
		g.drawString("Use the arrow keys to move the blocks. When two tiles with the same", 35, 870);
		g.drawString("number touch, they merge into one. Join the numbers to reach the", 35, 895);
		g.drawString("2048 tile!", 35, 920);
		g.setColor(Color.GRAY);
		g.fillRoundRect(100, 220, 610, 610, 20, 20);

//		om.draw(g);
//		g.setFont(captionFont);
//		g.setColor(Color.WHITE);
//		g.drawString("Score: "+om.getScore(), 40, Mix.HEIGHT-40);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Mix.WIDTH, Mix.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 150);
		g.setFont(bodyFont);
		g.drawString("You have killed " + om.getScore() + " enemies", 30, 400);
		g.drawString("Press ENTER to restart", 60, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			System.out.println("menu on");
			updateMenuState();
		} else if (currentState == GAME) {
			System.out.println("game on");
			updateGameState();
		} else if (currentState == END) {
			System.out.println("end on");
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
//				om = new ObjectManager(r);
			} else if (currentState == MENU) {
				currentState++;
				startGame();
			} else if (currentState == GAME) {
				currentState++;
				cellSpawn.stop();
			}
//			else {
//				currentState++;
//			}
		}
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
//				if (r.y + (r.height / 2) >= r.height) {
//					r.up();
//				}
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
//				if (Mix.HEIGHT - (r.y + r.height) >= r.height) {
//					r.down();
//				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
//				if (r.x + r.width / 2 >= r.width) {
//					r.left();
//				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
//				if (Mix.WIDTH - (r.x + r.width) >= r.width / 2) {
//					r.right();
//				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//				om.addProjectile(r.getProjectile());
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}