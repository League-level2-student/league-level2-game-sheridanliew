import javax.swing.JFrame;

public class Breakout {
	JFrame frame;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	GamePanel gp;

	public Breakout() {
		frame = new JFrame();
		gp = new GamePanel();
	}

	void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Breakout b = new Breakout();
		b.setup();
	}
}
