/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121.poepart1;

/**
 *
 * @author Home
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private static final List<String> developers = new ArrayList<>();
    private static final List<String> taskNames = new ArrayList<>();
    private static final List<String> taskIDs = new ArrayList<>();
    private static final List<Integer> taskDurations = new ArrayList<>();
    private static final List<String> taskStatuses = new ArrayList<>();

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private int taskNumber;

    public static final int MAX_DESCRIPTION_LENGTH = 50;

    public Task() {
        
    }

    public boolean checkTaskDescription(String taskDescription) {
        // Check if the task description is within the allowed length
        return taskDescription.length() <= MAX_DESCRIPTION_LENGTH;
    }

    public String createTaskID(int taskNumber, String developerDetails) {
        // Create a task ID based on the task name and developer details
        String taskID = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase();
        taskID += ":" + taskNumber + ":" + developerDetails.substring(Math.max(developerDetails.length(), 2)).toUpperCase();
        return taskID;
    }

    public void printTaskDetails() {
        // Print the task details
        String taskID = createTaskID(taskNumber, developerDetails);
        String taskDetails = "Task Status:" + taskStatus + "\n" +
                "Developer Details:" + developerDetails + "\n" +
                "Task Number:" + taskNumber + "\n" +
                "Task Name:" + taskName + "\n" +
                "Task Description:" + taskDescription + "\n" +
                "Task ID:" + taskID + "\n" +
                "Task Duration:" + taskDuration + " hours";
        JOptionPane.showMessageDialog(null, taskDetails);
    }

    public void enterTaskDetails(int taskNumber) {
        // Enter and validate task details
        
        taskName = JOptionPane.showInputDialog("Enter Task Name for Task " + taskNumber + ":");
        taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters) for Task " + taskNumber + ":");
        while (!checkTaskDescription(taskDescription)) {
            taskDescription = JOptionPane.showInputDialog("Invalid task description length. Enter Task Description (max 50 characters) for Task " + taskNumber + ":");
        }
        developerDetails = JOptionPane.showInputDialog("Enter Developer Details for Task " + taskNumber + ":");
        taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours) for Task " + taskNumber + ":"));
        taskStatus = (String) JOptionPane.showInputDialog(null, "Choose Task Status for Task " + taskNumber + ":", "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Done", "Doing"}, "To Do");

        
        developers.add(developerDetails);
        taskNames.add(taskName);
        taskIDs.add(createTaskID(taskNumber, developerDetails));
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);

        printTaskDetails();
    }

    public static void displayTasksByStatus(String status) {
        // Display tasks based on their status
        System.out.println("Tasks with status '" + status + "':");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase(status)) {
                System.out.println("Task Name: " + taskNames.get(i) + ", Developer: " + developers.get(i) + ", Duration: " + taskDurations.get(i) + " hours");
            }
        }
    }

    public static void displayLongestTask() {
        // Display the task with the longest duration
        int maxDuration = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            System.out.println("Task with longest duration:");
            System.out.println("Task Name: " + taskNames.get(maxIndex) + ", Developer: " + developers.get(maxIndex) + ", Duration: " + taskDurations.get(maxIndex) + " hours");
        }
    }

    public static void searchTaskByName(String name) {
        // Search for tasks by name
        System.out.println("Search results for task with name '" + name + "':");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(name)) {
                System.out.println("Task Name: " + taskNames.get(i) + ", Developer: " + developers.get(i) + ", Status: " + taskStatuses.get(i));
            }
        }
    }

    public static void displayTasksByDeveloper(String developer) {
        System.out.println("Tasks assigned to developer '" + developer + "':");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                System.out.println("Task Name: " + taskNames.get(i) + ", Status: " + taskStatuses.get(i));
                //shows task assigned to whichever developer is searched in the search bar
            }
        }
    }

    public static void deleteTaskByName(String name) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(name)) {
                taskNames.remove(i);
                developers.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                System.out.println("Task '" + name + "' deleted successfully.");
                return;
                //method above used to delete task ame when user clicks "delete task" option and puts in necessary info on which task is to be deleted.
            }
        }
        System.out.println("Task '" + name + "' not found.");
    }

    public static void displayReport() {
        System.out.println("----- Task Report -----");
        for (int i = 0; i < taskNames.size(); i++) {
            System.out.println("Task Name: " + taskNames.get(i));
            System.out.println("Task ID: " + taskIDs.get(i));
            System.out.println("Developer: " + developers.get(i));
            System.out.println("Task Duration: " + taskDurations.get(i) + " hours");
            System.out.println("Task Status: " + taskStatuses.get(i));
            System.out.println("-----------------------");
            //method above used to display a report of all tasks
        }
    }
}


//Code Attribution
//This method was taken from stackoverflow
//https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
//Beezer
//https://stackoverflow.com/users/3074057/beezer

//Code Attribution
//This method was taken from GeeksForGeeks
//https://www.geeksforgeeks.org/java-for-loop-with-examples/?ref=lbp
//Chinmoy Lenka
//https://www.geeksforgeeks.org/user/chinmoy%20lenka/

//Code Attribution
// This method was taken from youtube
//https://www.youtube.com/watch?v=ES6h3AwIvOE
//Computing for all
//https://www.youtube.com/@C4A