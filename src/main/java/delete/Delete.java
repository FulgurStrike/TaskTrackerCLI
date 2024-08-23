/*
 * Author: FulgurStrike
 * Description: Class that allows users to delete tasks.
 */

package delete;

import jsoncontroller.JSONController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Delete {

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
