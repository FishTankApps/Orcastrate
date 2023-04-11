package com.fishtankapps.orcastrate.logging;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

import com.fishtankapps.ocrastrate.core.Constants;

public class Log {
		
	private static boolean logFileAvalible = Constants.ENABLE_FILE_LOGGING;
	
	private Log() {
	}

	public static final void v(Object message) {
		log(LoggingLevel.VERBOSE, message.toString());
	}
	public static final void d(Object message) {
		log(LoggingLevel.DEBUG, message.toString());
	}
	public static final void i(Object message) {
		log(LoggingLevel.INFO, message.toString());
	}
	public static final void w(Object message) {
		log(LoggingLevel.WARN, message.toString());
	}
	public static final void e(Object message) {
		log(LoggingLevel.ERROR, message.toString());
	}
	public static final void e(Object message, Throwable throwable) {
		log(message.toString(), throwable);
	}
	
	
	private static final void log(LoggingLevel level, String message) {	
		
		if(level.importance < Constants.LOGGING_LEVEL.importance)
			return;
		
		message = level.tag + message;
		
		if(logFileAvalible) {
			String logFilePath = Constants.LOG_FILE_PATH + 
					(Constants.START_UP_TIME.get(Calendar.MONTH) + 1) + "." +
					Constants.START_UP_TIME.get(Calendar.DATE) + "." + 
					Constants.START_UP_TIME.get(Calendar.YEAR) + "_" +
					Constants.START_UP_TIME.get(Calendar.HOUR_OF_DAY) + "." + 
					Constants.START_UP_TIME.get(Calendar.MINUTE) + "." + 
					Constants.START_UP_TIME.get(Calendar.SECOND) + "_log.txt";
			try {
				
				FileWriter fileWriter = new FileWriter(logFilePath, true);
				fileWriter.append(message + "\n");
				fileWriter.close();
				
			} catch (Exception e) {
				
				try {
					logFileAvalible = false;
					log(LoggingLevel.INFO, "Unable to access log file, attempting to create new log file.");
					
					if(!new File(logFilePath).exists()) {
						if(!new File(logFilePath).getParentFile().exists())
							new File(logFilePath).getParentFile().mkdirs();
						
						new File(logFilePath).createNewFile();
						
						log(LoggingLevel.INFO, "New log file created at: " + new File(Constants.LOG_FILE_PATH).getAbsolutePath());
						logFileAvalible = true;
						
						log(level, message);
						return;
					}					
				} catch (Exception e1) {
					logFileAvalible = false;
					log(LoggingLevel.ERROR, "Unable to create new log file, using standard output instead.");
					System.err.println(message);
					return;
				}
				
				logFileAvalible = false;
				log(LoggingLevel.ERROR, "Unable to access log file, using standard output instead.");
			}	
		}		
		
		
		if(level.equals(LoggingLevel.ERROR))
			System.err.println(message);
		else 
			System.out.println(message);		
	}	
	
	private static final void log(String message, Throwable throwable) {
		
		message += "\n" + LoggingLevel.ERROR.tag + throwable.getClass().getName();		
		
		if(throwable.getMessage() != null)
			message += "\n" + LoggingLevel.ERROR.tag + throwable.getMessage();
		
		for(StackTraceElement element : throwable.getStackTrace()) {
			message += "\n" + LoggingLevel.ERROR.tag + "   " + element.toString();
		}
		
		log(LoggingLevel.ERROR, message);
	}
}
