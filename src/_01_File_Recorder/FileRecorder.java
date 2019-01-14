package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main (String[] args) {
		try {
			FileWriter w = new FileWriter("src/_01_File_Recorder/file.txt");
			w.write(JOptionPane.showInputDialog("Enter a message"));
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
