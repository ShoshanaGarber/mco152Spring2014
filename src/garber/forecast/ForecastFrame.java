package garber.forecast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ForecastFrame extends JFrame {

	private Forecast forecast;
	private final ForecastGraph forecastGraph;
	private final JTextField textFeild;
	private final JButton button;

	public ForecastFrame() {
		this.setTitle("Forecast");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		textFeild = new JTextField();
		this.add(textFeild, BorderLayout.NORTH);
		button = new JButton("Enter City");
		this.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ButtonListener());

		forecastGraph = new ForecastGraph();
		this.add(forecastGraph, BorderLayout.CENTER);

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ForecastThread ft = new ForecastThread(forecastGraph, forecast,
					textFeild);
			ft.start();

		}

	}

	public static void main(String[] args) {

		ForecastFrame app = new ForecastFrame();
		app.setVisible(true);

	}

}
