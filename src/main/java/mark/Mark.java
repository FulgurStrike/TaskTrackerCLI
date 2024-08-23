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

public class Mark {

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
