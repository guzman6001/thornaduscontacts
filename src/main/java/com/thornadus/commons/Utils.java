package com.thornadus.commons;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static String Now() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
