/*
* Author: FulgurStrike
* Description: Class to add a task to the TaskList file
*/
package add;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Contains a single static method to add a task to a JSON file. It generates a unique
 * ID for the task and records current date and time. The task is then added to the
 * existing list in the JSON file if input is provided.
 */
public class Add {

    /**
     * Parses a user input string, generates a unique task ID, and creates a new JSON
     * object representing the task with current date and time. It appends this task to
     * an existing JSONArray in a JSON file and displays a confirmation message with the
     * generated ID.
     *
     * @param input task description to be added to the task list, which is used to create
     * a new JSONObject containing the task data if not empty.
     */
    public static void add(String input) {

        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);

        int nextID = taskListArray.size() + 1;
        JSONObject taskData = new JSONObject();

        LocalDateTime unformattedDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


        if(!input.equals("")) {
            taskData.put("id", nextID);
            taskData.put("description", input);
            taskData.put("status", "to-do");
            taskData.put("createdAt", unformattedDate.format(formatter));
            taskData.put("updatedAt", unformattedDate.format(formatter));
        }else {
            System.out.println("Enter a task");
        }
        taskListArray.add(taskData);

        JSONController.writeJSONFile(taskListObject);


        System.out.printf("Task added successfully (ID: %d)\n", nextID);;
    }
}
