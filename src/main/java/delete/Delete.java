/*
 * Author: FulgurStrike
 * Description: Class that allows users to delete tasks.
 */

package delete;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Is designed to remove tasks from a task list based on their unique ID. It interacts
 * with JSON data stored in files and updates them accordingly. The class provides a
 * static method for deleting tasks by ID.
 */
public class Delete {

    /**
     * Removes a task from a list based on its ID. It iterates through the list, checks
     * if the ID matches the specified value, and if found, it deletes the task and updates
     * the JSON file with the updated list. The change is then written to a file.
     *
     * @param id identifier of a task to be deleted from a JSON data storage.
     *
     * Identifies and deletes a specific task based on its id.
     *
     * It has an unknown or unspecified data type that may be nullable; its value can be
     * compared for equality with other values using the equals method.
     */
    public static void delete(Long id) {
        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);

        for(int i=0; i<taskListArray.size(); i++) {
            JSONObject task = (JSONObject) taskListArray.get(i);
            if(task.get("id").equals(id)) {
                taskListArray.remove(i);
                taskListObject.put("taskList", taskListArray);

                JSONController.writeJSONFile(taskListObject);
                break;
            }
        }
    }
}
