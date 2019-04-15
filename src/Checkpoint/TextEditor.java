package Checkpoint;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		JTextArea text = new JTextArea(50, 100);

		panel.add(text);
		panel.add(save);
		panel.add(load);
		frame.add(panel);

		frame.setSize(2000, 1000);
		frame.setVisible(true);

		save.addActionListener((e) -> {
			FileWriter fw;
			try {
				fw = new FileWriter(JOptionPane.showInputDialog("Enter the file name to save to."));
				System.out.println(text.getText());
				fw.write(text.getText());
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		load.addActionListener((e) -> {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(JOptionPane.showInputDialog("Enter the file name to load.")));
				String s = "";
				String line = "";
				try {
					while (line != null) {
						s += line;
						line = br.readLine();
						s += "\n";
					}
					text.setText(s);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}
}
