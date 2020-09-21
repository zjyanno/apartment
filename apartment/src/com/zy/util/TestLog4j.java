package com.zy.util;

import org.apache.log4j.Logger;

public class TestLog4j {
	
	private static Logger logger = Logger.getLogger(TestLog4j.class);
	public static void main(String[] args) {
		logger.debug("This is debug message.");
		logger.info("This is info message.");
		logger.warn("This is warn message.");
		logger.error("This is error message.");
	}
}
