package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static String encrypt(String s) {
		String n = "";
		for (char c : s.toCharArray())
			n += (char) (c + 100);
		return n;
	}
	
	public static void main(String[] args) {
		try {
			FileWriter w = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			String s = JOptionPane.showInputDialog("Enter a message");
			w.write(encrypt(s));
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
