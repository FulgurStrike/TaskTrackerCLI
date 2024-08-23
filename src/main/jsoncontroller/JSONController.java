package main.jsoncontroller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONController {

    public static void createJSONFile() {
        try {
            File TaskListFile = new File("TaskList.json");
            if (!TaskListFile.exists()) {
                TaskListFile.createNewFile();

                JSONObject taskList = new JSONObject();
                JSONArray taskListStart = new JSONArray();
                taskList.put("taskList", taskListStart);

                FileWriter fw = new FileWriter(TaskListFile);
                fw.write(taskList.toJSONString());
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject createJSONObject() {
        JSONParser parser = new JSONParser();
        JSONObject taskListObj;
        try {
            taskListObj = (JSONObject) parser.parse(new FileReader("TaskList.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return taskListObj;
    }

    public static JSONArray createJSONArray(JSONObject taskListObj) {
        return (JSONArray) taskListObj.get("taskList");
    }

    public static void writeJSONFile(JSONObject taskListObj) {
        FileWriter jsonWriter = null;

        try {
            jsonWriter= new FileWriter("TaskList.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            jsonWriter.write(taskListObj.toJSONString());
            jsonWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
