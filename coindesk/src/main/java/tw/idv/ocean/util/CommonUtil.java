package tw.idv.ocean.util;

import static tw.idv.ocean.util.Constants.SDF_IN;
import static tw.idv.ocean.util.Constants.SDF_OUT;

import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;

public class CommonUtil {
	
	public static String getFormattedDateStr(JsonNode jsonNode) {
		try {
			final String dateStrIn = jsonNode.asText();
			Date date = SDF_IN.parse(dateStrIn);
			return SDF_OUT.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
