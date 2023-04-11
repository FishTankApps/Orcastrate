package com.fishtankapps.ocrastrate.core;

import java.io.File;
import java.util.GregorianCalendar;

import com.fishtankapps.orcastrate.logging.LoggingLevel;

public final class Constants {
	private Constants() {}
	
	
	//----------{ "Settings" }---------------------------------------------------------------------	
	public static final String LOG_FILE_PATH = "resources" + File.separator + "logs" + File.separator;
	public static final String APP_DATA_FOLDER_PATH = System.getenv("APPDATA") + File.separator + "Orcastrate";
	public static final String CONFIGURATION_FILE_NAME = "configuration.xml";
	public static final String CONFIGURATION_FILE_PATH = APP_DATA_FOLDER_PATH + File.separator + CONFIGURATION_FILE_NAME;
	
	public static final boolean ENABLE_FILE_LOGGING = false;
	public static final LoggingLevel  LOGGING_LEVEL = LoggingLevel.DEBUG;

	
	
	//----------{ Replacement Values For Understanding }-------------------------------------------
	public static final String VERSION_CODE = "0.0.1";
	
	public static final String DEFAULT_LOOK_AND_FEEL = "%DEFAULT%"; // Passed if no L&F has been chosen
	
	public static final int CTRL = 2;
	public static final int SHIFT = 1;
	public static final int CTRL_SHIFT = 3;
	public static final int META = 4;
	public static final int META_SHIFT = 5;
	public static final int META_CTRL = 6;
	public static final int META_CTRL_SHIFT = 7;
	public static final int ALT = 8;
	public static final int ALT_SHIFT = 9;
	public static final int CTRL_ALT = 10;
	public static final int CTRL_ALT_SHIFT = 11;
	public static final int META_ALT = 12;
	public static final int META_ALT_SHIRT = 13;
	public static final int META_CTRL_ALT = 14;
	public static final int META_CTRL_ALT_SHIFT = 15;
	public static final int JUST_THE_KEY = 16;	
	
	public static final int LEFT_MOUSE_BUTTON = 1;
	public static final int RIGHT_MOUSE_BUTTON = 3;
	public static final int SCROLL_WHEEL_BUTTON = 2;
	public static final int LEFT_SCROLL_WHEEL_BUTTON = 4;
	public static final int RIGHT_SCROLL_WHEEL_BUTTON = 5;	
	
	public static boolean JAVA_FX_INSTALLED = true;
	public static final GregorianCalendar START_UP_TIME = new GregorianCalendar();
	public static final OperatingSystem OPERATING_SYSTEM = (System.getProperty("os.name").contains("Windows")) ? OperatingSystem.WINDOWS : ((System.getProperty("os.name").contains("Linux")) ? OperatingSystem.LINUX : OperatingSystem.OS_X);
	public enum OperatingSystem {
		OS_X, WINDOWS, LINUX
	}	
}