package com.cathayunitedbank.interview.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    
    public static final SimpleDateFormat SDF_ISO_IN = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public static final SimpleDateFormat SDF_UTC_IN = new SimpleDateFormat("EEE dd, yyyy HH:mm:ss ZZZ"); // not working
    public static final SimpleDateFormat SDF_BST_IN = new SimpleDateFormat("EEE dd, yyyy 'at' HH:mm ZZZ"); // not working
    // output format
    public static final SimpleDateFormat SDF_OUT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public static String getFormattedDateStr(String str, int formatCase) {
		try {
			switch (formatCase) {
                case 1:
                    Date isoDate = SDF_ISO_IN.parse(str);
                    return SDF_OUT.format(isoDate);
                case 2:
                    Date bstDate = SDF_BST_IN.parse(str);
                    return SDF_OUT.format(bstDate);
                default:
                    Date utcDate = SDF_UTC_IN.parse(str);
                    return SDF_OUT.format(utcDate);
            }
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
