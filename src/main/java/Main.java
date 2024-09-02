/*
 * Author: FulgurStrike
 * Description: Class that controls user input.
 */

import java.util.Scanner;
import add.Add;
import list.List;
import jsoncontroller.JSONController;
import mark.Mark;
import update.Update;
import delete.Delete;

/**
 * Executes a task management system using user input from the console. It creates a
 * JSON file and repeatedly prompts users for commands until they enter "exit". The
 * system responds to various commands such as adding tasks, updating tasks, listing
 * tasks, and marking tasks as done or in-progress.
 */
public class Main {

    /**
     * Executes a task management console application, reading user commands to add,
     * update, delete tasks, and list tasks by status or all tasks. It continues to read
     * commands until the "exit" command is entered.
     *
     * @param args command-line arguments passed to the program when it is executed, but
     * it is not used in this function.
     *
     * Array of String objects representing command line arguments.
     * Mainly serves as an entry point for application execution.
     * Passed to main method when program is invoked from command line or IDE.
     */
    public static void main(String[] args) {

        JSONController.createJSONFile();

        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("task-cli ");
        String input = userInputScanner.nextLine();
        String[] arguments =  input.split(" ");
        String command = arguments[0];

        int count = 1;
        while(!command.equals("exit")){
            StringBuilder description = new StringBuilder();

            switch (command){
                case "add":

                    for(int i=1; i<arguments.length; i++) {
                        description.append(arguments[i] + " ");
                    }
                    Add.add(description.toString().trim());
                    count++;
                    break;
                case "update":
                    description = new StringBuilder();
                    for(int i=2; i<arguments.length; i++) {
                        description.append(arguments[i] + " ");
                    }
                    Update.update(Long.parseLong(arguments[1]), description.toString());
                    break;
                case "delete":
                    Delete.delete(Long.parseLong(arguments[1]));
                    break;
                case "list":
                    if(arguments.length == 1){
                        System.out.println(List.listAll());
                    }else if(arguments[1].equals("done")) {
                        System.out.println(List.listSpecificStatus("done"));
                    }else if(arguments[1].equals("in-progress")) {
                        System.out.println(List.listSpecificStatus("in-progress"));
                    }else if(arguments[1].equals("todo")) {
                        System.out.println(List.listSpecificStatus("to-do"));
                    }
                    break;
                case "mark-in-progress":
                    Mark.mark(Long.parseLong(arguments[1]), "in-progress");
                    break;
                case "mark-done":
                    Mark.mark(Long.parseLong(arguments[1]), "done");
            }
            System.out.print("task-cli ");
            input = userInputScanner.nextLine();
            arguments =  input.split(" ");
            command = arguments[0];
        }
    }
}