package garber.mtamap;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class MTAMapFrame extends JFrame {

	public MTAMapFrame() {
		this.setTitle("MTA map");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		try {
			this.add(new MTAMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);

	}

	public static void main(String[] args) {
		MTAMapFrame app = new MTAMapFrame();
		app.setVisible(true);
	}

}
