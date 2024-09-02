/*
 * Author: FulgurStrike
 * Description: Class that allows users to either list all tasks or filter by status.
 */

package list;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Provides functionality for listing tasks based on their status and allows users
 * to view all tasks or filter by specific status. It utilizes JSONController to
 * manage task data in JSON format. The class returns display strings containing task
 * details.
 */
public class List {

    /**
     * Constructs a string representing a task's details from its JSON data, including
     * ID, description, status, creation date, and update date, then returns it as a
     * single line of text with each field separated by a newline character.
     *
     * @param taskData JSON data containing information about a task, retrieved from which
     * field values are extracted and appended to the display string.
     *
     * Extracted from the code, taskData has four main properties: id, description, status
     * and timestamps createdAt and updatedAt. These properties are used to construct a
     * display string.
     *
     * @returns a formatted string with task details.
     *
     * The output is a string with multiple lines.
     * It contains information about ID, description, status, created at, and updated at
     * fields of the taskData JSONObject.
     */
    private static String createDisplayString(JSONObject taskData) {
        StringBuilder displayString = new StringBuilder();

        displayString.append("ID: " + taskData.get("id") + "\n");
        displayString.append("Description: " + taskData.get("description") + "\n");
        displayString.append("Status: " + taskData.get("status") + "\n");
        displayString.append("Created at: " + taskData.get("createdAt") + "\n");
        displayString.append("UpdatedAt: " + taskData.get("updatedAt") + "\n");

        return displayString.toString();
    }

    /**
     * Generates a string representation of all tasks stored in an array, retrieved from
     * a JSON object controller. It iterates over each task, appends its stringified form
     * to a StringBuilder, and returns the resulting string. The tasks are displayed in
     * order based on their index in the array.
     *
     * @returns a string displaying all tasks in a formatted manner.
     */
    public static String listAll() {

        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);
        StringBuilder displayString = new StringBuilder();


        for(int i=0; i<taskListArray.size(); i++) {
            JSONObject task = (JSONObject) taskListArray.get(i);
            displayString.append(createDisplayString(task));
        }
        return displayString.toString();
    }

    /**
     * Filters a list of tasks based on their status and returns a string representation
     * of matching tasks. It iterates through a JSON array, checks each task's status
     * against a given value, and appends the corresponding display string to the result
     * if they match.
     *
     * @param status specific status to be searched for in a list of tasks, determining
     * which tasks are displayed by the function.
     *
     * @returns a string containing task displays for specified status.
     *
     * The output is a String object.
     * The string consists of concatenated display strings from tasks that match the
     * specified status.
     */
    public static String listSpecificStatus(String status) {

        JSONObject taskListObject = JSONController.createJSONObject();
        JSONArray taskListArray = JSONController.createJSONArray(taskListObject);
        StringBuilder displayString = new StringBuilder();

        for(int i=0; i<taskListArray.size(); i++) {
            JSONObject task = (JSONObject) taskListArray.get(i);

            if(task.get("status").equals(status)) {
                displayString.append(createDisplayString(task));
            }
        }
        return displayString.toString();
    }
}
