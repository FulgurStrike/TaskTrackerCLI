/*
* Author: FulgurStrike
* Description: Class to add a task to the TaskList file
*/
package add;

import main.jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Add {

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


        System.out.printf("Task added successfully (ID: %d)", nextID);;
    }
}
