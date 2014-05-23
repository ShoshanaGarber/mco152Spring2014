package garber.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListEarthquakes extends JList {

	private Earthquake[] list;

	public ListEarthquakes() {

	}

	public void setEarthquakesList(Earthquake[] list) {
		this.list = list;
	}

	class ComplexCellRenderer implements ListCellRenderer {
		protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		public Component getListCellRendererComponent(JList<Earthquake> jlist,
				Earthquake value, int index, boolean isSelected,
				boolean cellHasFocus) {

			JLabel renderer = (JLabel) defaultRenderer
					.getListCellRendererComponent(jlist, value, index,
							isSelected, cellHasFocus);

			for (int i = 0; i < list.length; i++) {
				if (value.getMagnitude() < 3) {
					renderer.setBackground(Color.BLUE);

				} else if (value.getMagnitude() < 4) {
					renderer.setBackground(Color.ORANGE);
				} else if (value.getMagnitude() > 4) {
					renderer.setBackground(Color.RED);
				}

			}
			return renderer;
		}

		@Override
		public Component getListCellRendererComponent(JList arg0, Object arg1,
				int arg2, boolean arg3, boolean arg4) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
