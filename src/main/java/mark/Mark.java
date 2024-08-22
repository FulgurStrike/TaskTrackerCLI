package mark;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mark {

    public static void mark(Long id, String status) {

        JSONParser parser = new JSONParser();
        JSONObject taskListObj;
        try {
            taskListObj = (JSONObject)  parser.parse(new FileReader("TaskList.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONArray taskList = (JSONArray) taskListObj.get("taskList");

        for(int i=0; i<taskList.size(); i++) {
            JSONObject task = (JSONObject) taskList.get(i);
            System.out.println(task.get("id").getClass());
            if(task.get("id").equals(id)) {
                task.remove("status");
                task.put("status", status);
                taskList.set(i, task);
                taskListObj.put("taskList", taskList);
                try {
                    FileWriter updateWriter = new FileWriter("TaskList.json");
                    updateWriter.write(taskListObj.toJSONString());
                    updateWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
