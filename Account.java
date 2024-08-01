/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog5121.poepart1;

/**
 *
 * @author Home
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Account {
    static String userName = "";
    static String regPassword = "";
    static String usernameLogin = "";
    static String passwordLogin = "";
    static String firstName = "";
    static String lastName = "";

    public static void main(String[] args) {
        firstName = JOptionPane.showInputDialog("Please enter your first name.");
        lastName = JOptionPane.showInputDialog("Please enter your last name.");
        userName = JOptionPane.showInputDialog("Please enter your username");

        while(!Login.checkUserName(userName)){
            JOptionPane.showMessageDialog(null, "Wrong username, try again");
            userName = JOptionPane.showInputDialog("Please enter your username");
        }

        regPassword = JOptionPane.showInputDialog("Please enter your password");
        while(!Login.checkPasswordComplexity(regPassword)){
            JOptionPane.showMessageDialog(null, "Incorrect password, try again");
            regPassword = JOptionPane.showInputDialog("Please enter your password");
        }

        JOptionPane.showMessageDialog(null, Login.registerUser());

        usernameLogin = JOptionPane.showInputDialog("Please enter your username");
        passwordLogin = JOptionPane.showInputDialog("Please enter your password");

        while(!Login.loginUser(userName, regPassword, usernameLogin, passwordLogin)){
            JOptionPane.showMessageDialog(null, Login.returnLoginStatus(userName, regPassword));
            usernameLogin = JOptionPane.showInputDialog("Please enter your username");
            passwordLogin = JOptionPane.showInputDialog("Please enter your password");
        }

        JOptionPane.showMessageDialog(null, "Welcome to Easykanban");

        boolean continueApp = true;

        while (continueApp) {
            List<String> optionList = new ArrayList<>();
            optionList.add("Add tasks");
            optionList.add("Show report");
            optionList.add("Display 'Done' tasks");
            optionList.add("Longest task");
            optionList.add("Search by name");
            optionList.add("Search by developer");
            optionList.add("Delete task");
            optionList.add("Quit");

            Object[] options = optionList.toArray();
            int value = JOptionPane.showOptionDialog(null,
                    "Please select your option:",
                    "Pick", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, optionList.get(0));

            String opt = optionList.get(value);
            JOptionPane.showMessageDialog(null, "You picked " + opt);

            switch (opt) {
                case "Add tasks":
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to enter:"));
                    for (int i = 0; i < numTasks; i++) {
                        Task task = new Task();
                        task.enterTaskDetails(i + 1);
                    }
                    break;

                case "Show report":
                    Task.displayReport();
                    break;

                case "Display 'Done' tasks":
                    Task.displayTasksByStatus("Done");
                    break;

                case "Longest task":
                    Task.displayLongestTask();
                    break;

                case "Search by name":
                    String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
                    Task.searchTaskByName(taskName);
                    break;

                case "Search by developer":
                    String developer = JOptionPane.showInputDialog("Enter the developer name to search:");
                    Task.displayTasksByDeveloper(developer);
                    break;

                case "Delete task":
                    String taskToDelete = JOptionPane.showInputDialog("Enter the task name to delete:");
                    Task.deleteTaskByName(taskToDelete);
                    break;

                case "Quit":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    continueApp = false;
                    break;
            }
        }
    }
}


//Code attribution
//This method was taken from stackoverflow
//https://stackoverflow.com/questions/21059080/joptionpane-input-dialog-menu
//MadProgrammer
//https://stackoverflow.com/users/992484/madprogrammer
        
          
 //Code attribution
//This method was taken from youtube
//TheTigerTutorials
//https://www.youtube.com/watch?v=E3JQrxxQKIo
    
   
//Code attribution
//This method was taken from stack overflow
//https://stackoverflow.com/questions/20597229/joptionpane-and-while-loop-user-input-addition
//DaoWen
//https://stackoverflow.com/users/1427124/daowen
     

//Code Attribution
//This method was taken from GeeksForGeeks
//https://www.geeksforgeeks.org/switch-statement-in-java/
//Gaurav Miglani
//no access to profile
        
        
            
           
   




    
    

