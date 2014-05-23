package garber.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;

public class Clock extends JComponent {

	private int hour;
	private int minutes;
	private int seconds;

	public Clock() {
		hour = 0;
		minutes = 0;
		seconds = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		GregorianCalendar currentTime = (GregorianCalendar) GregorianCalendar
				.getInstance();
		hour = currentTime.get(Calendar.HOUR_OF_DAY);
		minutes = currentTime.get(Calendar.MINUTE);
		seconds = currentTime.get(Calendar.SECOND);
		int xcenter = 150, ycenter = 150;

		int xsecond = (int) (Math.cos(seconds * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
		int ysecond = (int) (Math.sin(seconds * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
		int xminute = (int) (Math.cos(minutes * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
		int yminute = (int) (Math.sin(minutes * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
		int xhour = (int) (Math.cos((hour * 30 + minutes / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + xcenter);

		int yhour = (int) (Math.sin((hour * 30 + minutes / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + ycenter);

		g.drawOval(0, 0, getWidth(), getHeight());

		g.drawLine(getWidth() / 2, getHeight() / 2, xhour, yhour);
		g.drawLine(getWidth() / 2, getHeight() / 2, xminute, yminute);
		g.drawLine(getWidth() / 2, getHeight() / 2, xsecond, ysecond);
		

		int lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;



		g.setColor(Color.magenta);
				if (xsecond != lastxs || ysecond != lastys) {
					g.drawLine(xcenter, ycenter, lastxs, lastys);

				}
				if (xminute != lastxm || yminute != lastym) {
					g.drawLine(xcenter, ycenter - 1, lastxm, lastym);
					g.drawLine(xcenter - 1, ycenter, lastxm, lastym);

				}
				if (xhour != lastxh || yhour != lastyh) {
					g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);
					g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);

				}

				g.setColor(Color.magenta);
				g.drawLine(xcenter, ycenter, xsecond, ysecond);
				g.setColor(Color.red);
				g.drawLine(xcenter, ycenter - 1, xminute, yminute);
				g.drawLine(xcenter - 1, ycenter, xminute, yminute);
				g.setColor(Color.green);
				g.drawLine(xcenter, ycenter - 1, xhour, yhour);
				g.drawLine(xcenter - 1, ycenter, xhour, yhour);

				lastxs = xsecond;
				lastys = ysecond;
				lastxm = xminute;
				lastym = yminute;
				lastxh = xhour;
				lastyh = yhour;


	}

}
