
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
			titleFont = new Font("Times New Roman", Font.PLAIN, 200);
			bodyFont = new Font("Times New Roman", Font.PLAIN, 50);
			captionFont = new Font("Times New Roman", Font.PLAIN, 18);
			frameDraw = new Timer(1000 / 60, this);
			frameDraw.start();
			om = new ObjectManager();
			if (needImage) {
				loadImage("space-1.png");
			}
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
//			alienSpawn = new Timer(1000, om);
//			alienSpawn.start();
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
			g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.MAGENTA);
			g.drawString("MIX", 20, 150);
			g.setFont(bodyFont);
			g.setColor(Color.CYAN);
			g.drawString("Press ENTER to start", 70, 400);
			g.drawString("Press SPACE for intructions", 30, 600);
		}

		void drawGameState(Graphics g) {
			if (gotImage) {
				g.drawImage(image, 0, 0, Breakout.WIDTH, Breakout.HEIGHT, null);
			} else {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
				g.setColor(Color.LIGHT_GRAY);
				g.fillOval(250, 250, 200, 200);
			}
			om.draw(g);
	}
	
		void drawEndState(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 90, 150);
			g.setFont(bodyFont);
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
				} else if (currentState == MENU) {
					currentState++;
					startGame();
				} else if (currentState == GAME) {
					currentState++;
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
