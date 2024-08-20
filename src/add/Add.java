package add;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Add {

    public static void add(String input) throws Exception {

        JSONParser parser = new JSONParser();
        JSONObject taskListObj = (JSONObject)  parser.parse(new FileReader("TaskList.json"));
        JSONArray taskList = (JSONArray) taskListObj.get("taskList");
        int nextID = taskList.size() + 1;

        JSONObject taskData = new JSONObject();

        if(!input.equals("")) {
            taskData.put("id", nextID);
            taskData.put("description", input);
            taskData.put("status", "to-do");
            taskData.put("createdAt", LocalDate.now().toString() + " " + LocalTime.now().toString());
            taskData.put("updatedAt", LocalDate.now().toString() + " " + LocalTime.now().toString());
        }else {
            throw new Exception();
        }

        taskList.add(taskData);

        FileWriter fileWriter = new FileWriter("TaskList.json");
        fileWriter.write(taskListObj.toJSONString());
        fileWriter.close();

        System.out.printf("Task added successfully (ID: %d)", nextID);;
    }
}
