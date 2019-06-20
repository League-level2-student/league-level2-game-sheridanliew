import javax.swing.JFrame;

public class Mix {
	JFrame frame;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	MixGamePanel gp;

	public Mix() {
		frame = new JFrame();
		gp = new MixGamePanel();
	}

	void setup() {
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
