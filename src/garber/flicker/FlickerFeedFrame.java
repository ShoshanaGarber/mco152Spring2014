package garber.flicker;

import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickerFeedFrame extends JFrame {

	private final Scrollbar scroll;
	private final DownloadFlickerFeedThread dithread;

	private static final long serialVersionUID = 1L;

	public FlickerFeedFrame() throws IOException {

		this.setTitle("Flicker");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		scroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 300);
		this.add(scroll);

		dithread = new DownloadFlickerFeedThread(this);
		dithread.start();

		this.setVisible(true);

	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {

		Flick[] items = feed.getItems();

		for (int i = 0; i < 20; i++) {
			DownloadImageThread downloadImageThread = new DownloadImageThread(
					new JLabel(), items[i].getMedia().getM());
			downloadImageThread.start();
		}

	}

	public static void main(final String args[]) throws IOException {
		new FlickerFeedFrame().setVisible(true);
	}

}
