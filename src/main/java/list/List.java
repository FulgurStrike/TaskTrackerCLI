package list;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class List {

    private static JSONArray readFile() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject taskListObj = (JSONObject)  parser.parse(new FileReader("TaskList.json"));
        JSONArray taskList = (JSONArray) taskListObj.get("taskList");
        return taskList;
    }

    public static String listAll() {
        JSONArray taskList = null;
        try {
            taskList = readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder displayString = new StringBuilder();

        for(int i=0; i<taskList.size(); i++) {
            JSONObject task = (JSONObject) taskList.get(i);
            displayString.append("ID: " + task.get("id") + "\n");
            displayString.append("Description: " + task.get("description") + "\n");
            displayString.append("Status: " + task.get("status") + "\n");
            displayString.append("Created at: " + task.get("createdAt") + "\n");
            displayString.append("UpdatedAt: " + task.get("updatedAt") + "\n\n");
        }

        return displayString.toString();
    }

    public static String listDone() {
        JSONArray taskList;
        try {
            taskList = readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder displayString = new StringBuilder();

        for (int i = 0; i < taskList.size(); i++) {
            JSONObject task = (JSONObject) taskList.get(i);
            if(task.get("status").equals("done")) {
                displayString.append("ID: " + task.get("id") + "\n");
                displayString.append("Description: " + task.get("description") + "\n");
                displayString.append("Status: " + task.get("status") + "\n");
                displayString.append("Created at: " + task.get("createdAt") + "\n");
                displayString.append("UpdatedAt: " + task.get("updatedAt") + "\n\n");
            }
        }

        return displayString.toString();
    }

    public static String listInProgress() {
        JSONArray taskList;
        try {
            taskList = readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder displayString = new StringBuilder();

        for (int i = 0; i < taskList.size(); i++) {
            JSONObject task = (JSONObject) taskList.get(i);
            if(task.get("status").equals("in-progress")) {
                displayString.append("ID: " + task.get("id") + "\n");
                displayString.append("Description: " + task.get("description") + "\n");
                displayString.append("Status: " + task.get("status") + "\n");
                displayString.append("Created at: " + task.get("createdAt") + "\n");
                displayString.append("UpdatedAt: " + task.get("updatedAt") + "\n\n");
            }
        }

        return displayString.toString();
    }
}
