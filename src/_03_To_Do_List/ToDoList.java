package _03_To_Do_List;

import javax.swing.JOptionPane;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public void addTask() {

	}

	public void viewTasks() {

	}

	public void removeTask() {

	}

	public void saveList() {

	}

	public void loadList() {

	}

	public static void main(String[] args) {
		String[] ops = {"Add Task", "View Tasks", "Remove Task", "Save List", "Load List"};
		JOptionPane.showOptionDialog(null, "Choose an option.", "To Do List", 0, 0, null, ops, null);
	}
}
