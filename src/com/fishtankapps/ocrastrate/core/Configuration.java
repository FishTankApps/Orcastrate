package com.fishtankapps.ocrastrate.core;

import java.io.File;
import java.io.FileOutputStream;

import com.fishtankapps.orcastrate.logging.Log;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Configuration {
	
	private transient XStream xmlReaderAndWriter;
	
	private String lookAndFeelName;
	
	private Configuration() {
		lookAndFeelName = Constants.DEFAULT_LOOK_AND_FEEL;
	}
	
	public void save() {
		try {
			File configurationFile = new File(Constants.CONFIGURATION_FILE_PATH);
			FileOutputStream outputStream = new FileOutputStream(configurationFile);
			Log.v("Configuration.save: Saving to save file '" + configurationFile.getName() + "'");
			
			xmlReaderAndWriter.toXML(this, outputStream);
			
			Log.v("Configuration.save: Saving Successful!");
		} catch (Exception e) {
			Log.e("Configuration.save: Error saving configuration file.", e);
		}
		
	}
	
	public String getLookAndFeelName() {
		return lookAndFeelName;
	}
	
	
	
	
	private static Configuration configuration;
	static {
		File appDataFolder = new File(Constants.APP_DATA_FOLDER_PATH);		
		if(!appDataFolder.exists()) {
			Log.e("App Data folder not found. Creating a new one...");
			appDataFolder.mkdirs();
		}
		
		Log.v("Configuration.static: Opening configuration from \"" + Constants.CONFIGURATION_FILE_PATH + '"');
		File configurationFile = new File(Constants.CONFIGURATION_FILE_PATH);
		
		try {
			if(!configurationFile.exists()) {
				throw new Exception("Configuration file not found. Creating a new one...");
				
			} else {
				XStream xmlReaderAndWriter = createXMLReaderAndWriter();
				Object rawConfiguration = xmlReaderAndWriter.fromXML(configurationFile);
				
				if(!(rawConfiguration instanceof Configuration))
					throw new Exception("Error parsing XML. Object is '" + rawConfiguration.getClass() + "' and not 'Configuration.' Creating new Configuration...");
				
				configuration = (Configuration) rawConfiguration;
				configuration.xmlReaderAndWriter = xmlReaderAndWriter;
				
				Log.v("Configuration.static: Configuration opened.");
			}
			
		} catch (Exception e) {
			Log.e("Configuration.static: Error loading Configuration: ", e);
			configuration = new Configuration();
			configuration.xmlReaderAndWriter = createXMLReaderAndWriter();
			configuration.save();
		}
		
	}
	
	private static XStream createXMLReaderAndWriter() {
		XStream xStream = new XStream(new DomDriver());
		
		xStream.allowTypes(new Class[] {Configuration.class});
		
		Log.v("Configuration.createXMLReaderAndWriter: Adding alias \"configuration\" for Configuration.class");
		xStream.alias("configuration", Configuration.class);

		return xStream;
	}
	
	public static Configuration getInstance() {
		return configuration;
	}
	
}
