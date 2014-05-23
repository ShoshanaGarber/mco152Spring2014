package garber.ufo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {

	public static void main(String[] args) throws Exception {

		Gson gson = new Gson();

		FileReader reader = new FileReader("ufo_awesome.json");
		Sightings list = gson.fromJson(reader, Sightings.class);
		Map<String, ArrayList<Sighting>> map = new HashMap<String, ArrayList<Sighting>>();

		for (Sighting s : list) {
			String location = s.getLocation();
			if (!map.containsKey(location)) {
				ArrayList<Sighting> sightings = map.get(location);
				if (sightings == null) {
					sightings = new ArrayList<Sighting>();

				}
				sightings.add(s);
				map.put(location, sightings);
			}
		}
		ZipCodes zips = new ZipCodes();

		List<ZipCode> listZips = zips.getZipCodes();
		for (int i = 0; i < list.size(); i++) {
			if ("19950115".equals(list.get(i).getSightedAt())) {

				for (ZipCode z : listZips) {
					String location = " " + z.getCity() + ", " + z.getState();

					if (location
							.equals(list.get(i).getLocation().toUpperCase())) {
						System.out.println(list.get(i) + " Zip Code: "
								+ z.getZipCode() + " Location: " + z.getLat()
								+ ", " + z.getLon());

					}
				}

			}
		}

	}

}
