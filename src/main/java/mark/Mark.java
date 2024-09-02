/*
 * Author: FulgurStrike
 * Description: Class that allows the user to mark tasks as done, to do or in progress.
 */

package mark;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Provides a method to update the status of tasks in a JSON file. It retrieves the
 * current date and time, updates the task with the given ID, and writes the updated
 * task list back to the JSON file. The method takes two parameters: the ID of the
 * task and its new status.
 */
public class Mark {

    /**
     * Updates the status and updatedAt field of a task with the given id in a stored
     * JSON file, using a provided status string and current date and time. It iterates
     * through a JSONArray to find and modify the matching JSONObject. The updated JSON
     * is then written back to the file.
     *
     * @param id identifier of a task to be updated, used to locate and modify its
     * corresponding status within a JSON-formatted data structure.
     *
     * The object destructure reveals that `id` has a type of `Long`.
     *
     * @param status updated status of a task and is used to replace the existing status
     * value associated with the specified `id`.
     */
    public static void mark(Long id, String status) {

        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);

        LocalDateTime unformattedDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for(int i=0; i<taskListArray.size(); i++) {
            JSONObject task = (JSONObject) taskListArray.get(i);
            if(task.get("id").equals(id)) {
                task.remove("status");
                task.put("status", status);
                task.remove("updatedAt");
                task.put("updatedAt", unformattedDate.format(formatter));

                taskListArray.set(i, task);
                taskListObject.put("taskList", taskListArray);
                JSONController.writeJSONFile(taskListObject);
                break;
            }
        }
    }
}
