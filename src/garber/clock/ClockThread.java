package garber.clock;

public class ClockThread extends Thread implements Runnable {

	private final Clock clock;

	public ClockThread(Clock clock) {

		this.clock = clock;

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clock.repaint();
		}
	}

}
