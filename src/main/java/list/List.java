/*
 * Author: FulgurStrike
 * Description: Class that allows users to either list all tasks or filter by status.
 */

package list;

import main.jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class List {

    private static String createDisplayString(JSONObject taskData) {
        StringBuilder displayString = new StringBuilder();

        displayString.append("ID: " + taskData.get("id") + "\n");
        displayString.append("Description: " + taskData.get("description") + "\n");
        displayString.append("Status: " + taskData.get("status") + "\n");
        displayString.append("Created at: " + taskData.get("createdAt") + "\n");
        displayString.append("UpdatedAt: " + taskData.get("updatedAt") + "\n");

        return displayString.toString();
    }

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
