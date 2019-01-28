package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ToDoList {

	private ArrayList<String> tasks;
	private String list;
	private final String STORE_LAST = "src/_03_To_Do_List/last.txt";

	public ToDoList() {
		try {
			tasks = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(STORE_LAST));
			list = br.readLine();
			if (list == null)
				list = "src/_03_To_Do_List/list.txt";
			br.close();
			BufferedReader r = new BufferedReader(new FileReader(list));
			String line = r.readLine();
			while (line != null) {
				tasks.add(line);
				line = r.readLine();
			}
			r.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		menu();
	}

	public void menu() {
		String[] ops = { "Add Task", "View Tasks", "Remove Task", "Save List", "Load List" };
		int op = JOptionPane.showOptionDialog(null, "Choose an option.", "To Do List", 0, 0, null, ops, null);
		switch (op) {
		case 0:
			addTask();
			break;
		case 1:
			viewTasks();
			break;
		case 2:
			removeTask();
			break;
		case 3:
			saveList();
			break;
		case 4:
			loadList();
			break;
		default:
			break;
		}
	}

	public void addTask() {
		String task = JOptionPane.showInputDialog("What task would you like to add?");
		tasks.add(task);
		menu();
	}

	public void viewTasks() {
		String msg = "";
		for (String s : tasks) {
			msg += "- " + s + "\n";
		}
		JOptionPane.showMessageDialog(null, msg);
		menu();
	}

	public void removeTask() {
		String rmv = JOptionPane.showInputDialog("Which task would you like to remove?");
		tasks.remove(rmv);
		menu();
	}

	public void saveList() {
		try {
			FileWriter w = new FileWriter(list);
			for (String s : tasks) {
				w.write(s + "\n");
			}
			w.close();
			FileWriter fw = new FileWriter(STORE_LAST);
			fw.write(list);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		menu();
	}

	public void loadList() {
		list = JOptionPane.showInputDialog("Enter the file location of the task list you want to load.");
		try {
			tasks = new ArrayList<String>();
			BufferedReader r = new BufferedReader(new FileReader(list));
			String line = r.readLine();
			while (line != null) {
				tasks.add(line);
				line = r.readLine();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter w = new FileWriter(STORE_LAST);
			w.write(list);
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		menu();
	}

	public static void main(String[] args) {
		new ToDoList();
	}
}