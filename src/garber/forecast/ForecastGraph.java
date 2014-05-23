package garber.forecast;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ForecastGraph extends JComponent {

	private ArrayList<Double> list;

	public ForecastGraph() {
		list = new ArrayList<Double>();
	}

	public void setForecastGraph(ArrayList<Double> list) {
		this.list = list;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		double mapWidth = this.getWidth() - 1;
		double mapHeight = this.getHeight() - 1;

		double xInc = (mapWidth - 2 * 20) / (list.size() - 1);
		double scale = (mapHeight - 2 * 20) / 110;
		for (int i = 0; i < list.size() - 1; i++) {
			double x1 = 20 + i * xInc;
			double y1 = mapHeight - 20 - scale * list.get(i);
			double x2 = 20 + (i + 1) * xInc;
			double y2 = mapHeight - 20 - scale * list.get(i + 1);
			g2.draw(new Line2D.Double(x1, y1, x2, y2));

		}

	}
}
