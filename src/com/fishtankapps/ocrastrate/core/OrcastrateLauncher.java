package com.fishtankapps.ocrastrate.core;

import javax.swing.UIManager;
import javafx.embed.swing.JFXPanel;

import com.fishtankapps.orcastrate.logging.Log;

public class OrcastrateLauncher {

	public static void main(String[] args) throws Exception {
		initializeLog();
		initializeUI();
	}

	private static void initializeLog() {
		Log.i(" Orcastrate ~ " + Constants.VERSION_CODE);
		Log.i("  - OS Name ........... " + System.getProperty("os.name"));
		Log.i("  - OS Arch ........... " + System.getProperty("os.arch"));
		Log.i("  - OS Version ........ " + System.getProperty("os.version"));
		Log.i("  - Java Vender ....... " + System.getProperty("java.vendor"));
		Log.i("  - Java Version ...... " + System.getProperty("java.version"));
		Log.i("  - Java VM Name ...... " + System.getProperty("java.vm.name"));

		Constants.JAVA_FX_INSTALLED = false;

		try {
			@SuppressWarnings("unused")
			JFXPanel usedToInitializeJFXTools = new JFXPanel();
			Constants.JAVA_FX_INSTALLED = true;
		} catch (Exception e) {
		}

		Log.i("  - JavaFX Installed .. " + Constants.JAVA_FX_INSTALLED);
		Log.i("  - Working Dir ....... " + System.getProperty("user.dir"));
		Log.i("  - App Data Folder ... " + Constants.APP_DATA_FOLDER_PATH);
	}

	public static void initializeUI() throws Exception {

		String lookAndFeel = Configuration.getInstance().getLookAndFeelName();

		Log.i("  - Look And Feel ..... " + lookAndFeel + "\n");

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		if (!lookAndFeel.equals(Constants.DEFAULT_LOOK_AND_FEEL))
			UIManager.setLookAndFeel(lookAndFeel);

		else if (Constants.OPERATING_SYSTEM == Constants.OperatingSystem.WINDOWS)
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		else if (Constants.OPERATING_SYSTEM == Constants.OperatingSystem.LINUX)
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		else if (Constants.OPERATING_SYSTEM == Constants.OperatingSystem.OS_X) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}

	}

}
