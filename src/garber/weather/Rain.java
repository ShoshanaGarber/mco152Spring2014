package garber.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@Override
	public String toString() {
		return "Rain [threeh=" + threeh + "]";
	}

	@SerializedName("3h")
	private String threeh;

}
