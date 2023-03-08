package com.example.CloudFarm.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class StringUtils {


	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isNotNull(Object object) {
		return !isNull(object);
	}

	public static boolean isEmpty(String str) {
		boolean isNull = false;
		if (str == null || "".equals(str)) {
			isNull = true;
		}
		return isNull;
	}

	public static String[] split(String toSplit, String delimiter) {
		if (isEmpty(toSplit)) {
			return null;
		}
		if (!toSplit.contains(delimiter)) {
			return null;
		}
		return toSplit.split(delimiter);
	}

	public static LocalDate stringToLocalDate(String date, String format) {
		if (date.contains("/")) {
			date = date.replaceAll("/", "-");
		}
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(date, fmt);
	}
	
	public static LocalDateTime stringToLocalDateTime(String dateTime, String format) {
		if (dateTime.contains("/")) {
			dateTime = dateTime.replaceAll("/", "-");
		}
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
		return LocalDateTime.parse(dateTime, fmt);
	}

	public static String sqlLike(String column) {
		return String.format("%s%s%s", "%",column,"%");
	}
}
