package com.fishtankapps.ocrastrate.core;

import java.awt.FileDialog;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.fishtankapps.orcastrate.logging.Log;

import javafx.application.Platform;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class CrossPlatformFileChooser {
	
	public enum Mode {
		OPEN, OPEN_MULTIPLE, OPEN_FOLDER, SAVE;
	}

	private String dialogTitle;
	private File initalFile;
	private int fileChooser; // 0 = Auto, 1 = AWT, 2 = JavaFX, 3 = Swing
	private Mode mode;
	
	public CrossPlatformFileChooser(Mode mode, String dialogTitle) {
		this.dialogTitle = dialogTitle;
		this.mode = mode;
		
		initalFile = new File("C:/Users/Whitaker/Documents");
		
		if(fileChooser == 0)
			fileChooser = (Constants.OPERATING_SYSTEM == Constants.OperatingSystem.WINDOWS) ? 2 : 1;
	}
	
	public void showFileChooser(FileSelectedListener listener) {
		
		Log.d("CrossPlatformFileChooser - Creating File Chooser...");
		
		if(fileChooser == 2) {
			if(Constants.JAVA_FX_INSTALLED) {
				Log.d("CrossPlatformFileChooser - JavaFX Selected");
				showJavaFXChooser(listener);				
			} else {
				Log.d("CrossPlatformFileChooser - JavaFX not installed, using AWT");
				showAWTChooser(listener);
			}
		} else if(fileChooser == 1) {
			Log.d("CrossPlatformFileChooser - AWT Selected");
			showAWTChooser(listener);
		} else if(fileChooser == 3) {
			Log.d("CrossPlatformFileChooser - Swing Selected");
			showSwingChooser(listener);
		}		
	}
	
	private void showJavaFXChooser(FileSelectedListener listener) {
		
		Platform.runLater(() -> {
				if(mode != Mode.OPEN_FOLDER) {
					FileChooser fileChooser = new FileChooser();		
					fileChooser.setTitle(dialogTitle);			
					fileChooser.setInitialDirectory((initalFile.isDirectory()) ? initalFile : initalFile.getParentFile());
					
					List<File> selectedFiles = null;
					if(mode == Mode.OPEN) {
						File selectedFile = fileChooser.showOpenDialog(null);
						
						if(selectedFile != null)
							selectedFiles = Arrays.asList(selectedFile);				
						
					} else if(mode == Mode.OPEN_MULTIPLE) {
						selectedFiles = fileChooser.showOpenMultipleDialog(null);
					}  else if(mode == Mode.SAVE) {
						File selectedFile = fileChooser.showSaveDialog(null);
						
						if(selectedFile != null)
							selectedFiles = Arrays.asList(selectedFile);		
					}
					
					if(selectedFiles != null) {
						listener.onFileSelected(selectedFiles);
					}
					
					
				} else {
					DirectoryChooser  directoryChooser  = new DirectoryChooser ();		
					directoryChooser.setTitle(dialogTitle);			
					directoryChooser.setInitialDirectory((initalFile.isDirectory()) ? initalFile : initalFile.getParentFile());			
					
					File selectedFile = directoryChooser.showDialog(null);
					
					if(selectedFile != null) 
						listener.onFileSelected(Arrays.asList(selectedFile));
				}
			});
	}
	
	private void showSwingChooser(FileSelectedListener listener) {
		new Thread(() -> {
			JFileChooser fileChooser = new JFileChooser();		
			fileChooser.setDialogTitle(dialogTitle);			
			fileChooser.setCurrentDirectory((initalFile.isDirectory()) ? initalFile : initalFile.getParentFile());
						
			fileChooser.setAcceptAllFileFilterUsed(true);			
			
			List<File> selectedFiles = null;
			if(mode == Mode.OPEN) {
				fileChooser.showOpenDialog(null);				
				File selectedFile = fileChooser.getSelectedFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(selectedFile);				
				
			} else if(mode == Mode.OPEN_MULTIPLE) {
				fileChooser.setMultiSelectionEnabled(true);
				
				fileChooser.showOpenDialog(null);				
				File selectedFile = fileChooser.getSelectedFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(selectedFile);	
			} else if(mode == Mode.OPEN_FOLDER) {
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				fileChooser.showOpenDialog(null);				
				File[] selectedFile = fileChooser.getSelectedFiles();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(selectedFile);	
				
			}  else if(mode == Mode.SAVE) {				
				fileChooser.showSaveDialog(null);				
				File selectedFile = fileChooser.getSelectedFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(selectedFile);	
			}
			
			if(selectedFiles != null) {
				listener.onFileSelected(selectedFiles);
			}
		}).start();
	}	

	private void showAWTChooser(FileSelectedListener listener) {
		new Thread(() -> {
			// TODO: Add good parent (not new JFrame())
			FileDialog fileDialog = new FileDialog(new JFrame(), dialogTitle, (mode == Mode.SAVE) ? FileDialog.SAVE : FileDialog.LOAD);		
			fileDialog.setDirectory(((initalFile.isDirectory()) ? initalFile : initalFile.getParentFile()).getAbsolutePath());			
			
			
			
			List<File> selectedFiles = null;
			if(mode == Mode.OPEN) {
				fileDialog.setVisible(true);			
				String selectedFile = fileDialog.getFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(new File(selectedFile));				
				
			} else if(mode == Mode.OPEN_MULTIPLE) {
				fileDialog.setMultipleMode(true);
				
				fileDialog.setVisible(true);			
				File[] selectedFilesArray = fileDialog.getFiles();
				
				if(selectedFilesArray != null)
					selectedFiles = Arrays.asList(selectedFilesArray);		
				
			} else if(mode == Mode.OPEN_FOLDER) {
				fileDialog.setVisible(true);			
				String selectedFile = fileDialog.getFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(new File(selectedFile));			
				
			}  else if(mode == Mode.SAVE) {				
				fileDialog.setVisible(true);			
				String selectedFile = fileDialog.getFile();				
				
				if(selectedFile != null)
					selectedFiles = Arrays.asList(new File(selectedFile));		
			}
			
			if(selectedFiles != null && selectedFiles.size() != 0) {
				listener.onFileSelected(selectedFiles);
			}
		}).start();
	}
		
	
	public interface FileSelectedListener {
		void onFileSelected(List<File> files);
	}
}
