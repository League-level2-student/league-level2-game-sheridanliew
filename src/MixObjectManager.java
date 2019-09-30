import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MixObjectManager implements ActionListener {
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

	}

	void draw(Graphics g) {

	}

	void update() {
		
	}

	void checkCollision() {
//		for (int i = 0; i < blocks.size(); i++) {
//			int num = Integer.parseInt(blocks.get(i).number);
//			if (blocks.get(i).collisionBox.intersects(blocks.get(i).collisionBox)) {
////				int num = Integer.parseInt(blocks.get(i).number);
//				num = num + num;
//			}
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
