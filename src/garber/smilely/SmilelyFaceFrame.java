package garber.smilely;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmilelyFaceFrame extends JFrame {

	public SmilelyFaceFrame() {
		this.setTitle("Smilely");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		this.add(new SmilelyFace(), BorderLayout.CENTER);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		SmilelyFaceFrame app = new SmilelyFaceFrame();
		app.setVisible(true);
	}

}
