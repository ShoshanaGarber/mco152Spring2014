package garber.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {

	private final List<ZipCode> zipCodes;

	public ZipCodes() throws IOException {
		zipCodes = new ArrayList<ZipCode>();

		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"));

		String zip, lat, lon, city, state;
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {

			zip = nextLine[0];
			if ("".equals(nextLine[1])) {
				lat = null;
			} else {
				lat = nextLine[1];
			}
			if ("".equals(nextLine[2])) {
				lon = null;
			} else {
				lon = nextLine[2];
			}

			city = nextLine[3];
			state = nextLine[4];
			zipCodes.add(new ZipCode(zip, lat, lon, city, state));
		}

		reader.close();

	}

	public List<ZipCode> getZipCodes() {
		return zipCodes;
	}
}
