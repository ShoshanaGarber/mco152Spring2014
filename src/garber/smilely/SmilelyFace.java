package garber.smilely;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmilelyFace extends JComponent {

	public SmilelyFace() {

	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(0, this.getHeight(), this.getWidth(), 0);
		g.setColor(Color.GREEN);
		g.fillOval(getWidth() / 2 - 100, getHeight() / 2 - 100, 200, 200);
		g.drawOval(155, 100, 10, 20);
		g.fillOval(230, 100, 10, 20);
		g.drawArc(150, 160, 100, 50, 180, 180);

	}
}
