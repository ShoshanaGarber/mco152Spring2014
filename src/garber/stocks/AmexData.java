package garber.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	// E:\workspace\mco152\resources\amex

	HashMap<String, List<DailyPrice>> map = new HashMap<String, List<DailyPrice>>();

	public AmexData() throws IOException, ParseException {

		List<String> letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");

		for (int i = 0; i < 4; i++) {

			CSVReader reader = new CSVReader(new FileReader(
					"./resources/amex/AMEX_daily_prices_" + letters.get(i)
							+ ".csv"), ',', '\"', 1);
			String[] nextLine;
			String exchange;
			String symbol;
			double openPrice;
			double highPrice;
			double lowPrice;
			double closePrice;
			int volume;
			double adjustedClosePrice;

			while ((nextLine = reader.readNext()) != null) {

				DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");

				exchange = nextLine[0];
				symbol = nextLine[1];
				Date date = dateF.parse(nextLine[2]);
				openPrice = Double.parseDouble(nextLine[3]);
				highPrice = Double.parseDouble(nextLine[4]);
				lowPrice = Double.parseDouble(nextLine[5]);
				closePrice = Double.parseDouble(nextLine[6]);
				volume = Integer.parseInt(nextLine[7]);
				adjustedClosePrice = Double.parseDouble(nextLine[8]);
				DailyPrice dailyPrice = new DailyPrice(exchange, symbol, date,
						openPrice, highPrice, lowPrice, closePrice, volume,
						adjustedClosePrice);
				if (map.containsKey(symbol)) {
					List<DailyPrice> list = map.get(symbol);
					list.add(dailyPrice);
					map.put(symbol, list);
				} else {
					List<DailyPrice> list = new ArrayList<DailyPrice>();
					list.add(dailyPrice);
					map.put(symbol, list);

				}

			}
			reader.close();

		}

	}

	public boolean contains(String symbol) {
		return map.containsKey(symbol);
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> list;
		if (contains(symbol)) {
			list = map.get(symbol);
			Collections.sort(list);

		} else {
			list = new ArrayList<DailyPrice>();
		}
		return list;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {

		List<DailyPrice> list = new ArrayList<DailyPrice>();
		if (contains(symbol)) {
			list = map.get(symbol);
			for (DailyPrice d : list) {
				if (d.getDate().compareTo(startDate) >= 0
						&& d.getDate().compareTo(startDate) <= 0) {
					list.add(d);
					Collections.sort(list);
				}
			}
		}
		return list;

	}

	public static void main(String[] args) throws IOException, ParseException {
		AmexData a = new AmexData();
		List<DailyPrice> list = a.getPrices("AIP");
		System.out.println(list.get(0).toString());
	}
}
