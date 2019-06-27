import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MixObjectManager {
	int[][] board;
	List<Block> blocks;
	Random random;
	int r;
	int score;

	MixObjectManager() {
		board = new int[4][4];
		blocks = new ArrayList<Block>();
		random = new Random();
		r = random.nextInt(4);
		score = 0;
	}

	int getScore() {
		return score;
	}

	void addBlock(Block b) {
		blocks.add(new Block(board[r][r], 0, 50, 50));
	}

	void draw(Graphics g) {
		for (Block b : blocks) {
			b.draw(g);
		}
	}

	void update() {
		for (Block b : blocks) {
			b.update();
//			if (a.y < 0 || a.y > LeagueInvaders.HEIGHT) {
//				a.isActive = false;
//			}
		}
//		checkCollision();
//		purgeObjects();
	}

//	void checkCollision() {
//		for (int i = 0; i < blocks.size(); i++) {
//			if (blocks.get(i).collisionBox.intersects(blocks.get(i).collisionBox)) {
//				r.isActive = false;
//				aliens.get(i).isActive = false;
//			}
//			for (int j = 0; j < projectiles.size(); j++) {
//				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
//					projectiles.get(j).isActive = false;
//					aliens.get(i).isActive = false;
//					score++;
//				}
//			}
//		}
//
//	void purgeObjects() {
//		for (int i = 0; i < aliens.size(); i++) {
//			if (aliens.get(i).isActive == false) {
//				aliens.remove(aliens.get(i));
//			}
//		}
//		for (int i = 0; i < projectiles.size(); i++) {
//			if (projectiles.get(i).isActive == false) {
//				projectiles.remove(projectiles.get(i));
//			}
//		}
//	}

}
