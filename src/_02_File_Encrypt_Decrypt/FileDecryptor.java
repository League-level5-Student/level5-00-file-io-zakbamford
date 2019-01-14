package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	public static String decrypt(String s) {
		String n = "";
		for (char c : s.toCharArray())
			n += (char) (c - 100);
		return n;
	}

	public static void main(String[] args) {
		try {
			FileReader r = new FileReader("src/_02_File_Encrypt_Decrypt/file.txt");
			String s = "";
			int c = 0;
			while (c != -1) {
				c = r.read();
				if (c != -1)
					s += (char) c;
			}
			JOptionPane.showMessageDialog(null, decrypt(s));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
