import javax.swing.JFrame;
//2048 game
public class Mix {
	static JFrame frame;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;
	GamePanel gp;

	public Mix() {
		frame = new JFrame();
		gp = new GamePanel();
	}

	void setup() {
		frame.addKeyListener(gp);
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Mix m = new Mix();
		m.setup();
	}
}
