package garber.flicker;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	private final JLabel label;
	private final String url;

	public DownloadImageThread(final JLabel label, final String url) {
		this.label = label;
		this.url = url;

	}

	@Override
	public void run() {

		BufferedImage image = null;
		try {
			image = ImageIO.read(new URL(url));
			ImageIcon icon = new ImageIcon(image);
			label.setIcon(icon);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
