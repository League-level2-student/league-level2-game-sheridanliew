import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MixObjectManager {
	List<Block> blocks;
	Random random;
	int score;

	MixObjectManager() {
		blocks = new ArrayList<Block>();
		random = new Random();
		score = 0;
	}
	
	int getScore() {
		return score;
	}

	void addBlock(Block b) {
		blocks.add(new Block(random.nextInt(Mix.WIDTH), 0, 50, 50));

	}


}
