import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font bodyFont;
	Font captionFont;
	Block[][] gameBoard;
	MixObjectManager om;
	JPanel menuState;
	JPanel gameState;
	JPanel endState;
	JLabel menuBGImageLabel;
	JLabel gameBGImageLabel;
	JLabel endBGImageLabel;
	
	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 200);
		bodyFont = new Font("Arial", Font.PLAIN, 50);
		captionFont = new Font("Arial", Font.PLAIN, 24);
		om = new MixObjectManager();
		JPanel menuState = new JPanel();
		JPanel gameState = new JPanel();
		JPanel endState = new JPanel();
		menuBGImageLabel = new JLabel();
		gameBGImageLabel = new JLabel();
		endBGImageLabel = new JLabel();
		Mix.frame.add(this);
		Mix.frame.pack();
		initializeMenuState();
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
				this.add(gameBoard[i][j]);
			}
		}
		while (x1 == x2 && y1 == y2) {
			x2 = random.nextInt(4);
			y2 = random.nextInt(4);
		}
		gameBoard[x1][y1].setValue("2");
		gameBoard[x2][y2].setValue("2");
	}

	void initializeMenuState() {
		menuBGImageLabel.setIcon(new ImageIcon("src/img/menuBG.png"));
		this.remove(endState);
		menuState.add(menuBGImageLabel);
		this.add(menuState);
		System.out.println("menu");
	}

	void initializeGameState() {
		gameBGImageLabel.setIcon(new ImageIcon("src/img/gameBG.png"));
		this.remove(menuBGImageLabel);
		this.add(gameBGImageLabel);
		System.out.println("game");
	}

	void initializeEndState() {
		endBGImageLabel.setIcon(new ImageIcon("src/img/endBG.png"));
		this.remove(gameBGImageLabel);
		this.add(endBGImageLabel);
		System.out.println("end");
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
				initializeMenuState();
			} else if (currentState == MENU) {
				currentState++;
				initializeGameState();
			} else if (currentState == GAME) {
				currentState++;
				initializeEndState();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}