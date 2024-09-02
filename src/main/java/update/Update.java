/*
 * Author: FulgurStrike
 * Description: Class that allows users to update the description of the task.
 */

package update;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Is designed to update task descriptions in a JSON file based on an ID and new
 * description. It retrieves the current date and time upon execution, updates the
 * relevant task details, and writes the modified data back to the file. The changes
 * are persisted immediately after detection of the target task.
 */
public class Update {

    /**
     * Modifies a task's description and updated date in a JSON file. It iterates over
     * an array of tasks, finds the task with the specified ID, updates its details, and
     * writes the modified object to the JSON file. The update is written as soon as a
     * matching task is found.
     *
     * @param id identifier of the task to be updated, which is used to locate and modify
     * its description within a JSON-formatted task list.
     *
     * Deconstructed into:
     * - A numeric value (of type Long) representing a unique identifier.
     *
     * @param newDescription updated description of a task, which is stored in the
     * "description" field within a JSONObject upon finding and matching its id.
     */
    public static void update(Long id, String newDescription) {
        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);

        LocalDateTime unformattedDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for(int i=0; i<taskListArray.size(); i++) {
            JSONObject task = (JSONObject) taskListArray.get(i);
            if(task.get("id").equals(id)) {
                task.remove("description");
                task.put("description", newDescription);
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
