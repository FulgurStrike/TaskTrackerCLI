/*
* Author: FulgurStrike
* Description: Class that controls the JSON data within the TaskList file
*/

package jsoncontroller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Is responsible for managing JSON data within a file named TaskList.json. It provides
 * functionality to create and write JSON files, as well as parse existing ones into
 * JSONObject and JSONArray objects. The class ensures the creation of a default JSON
 * structure if the TaskList.json file does not exist.
 */
public class JSONController {

    /**
     * Creates a JSON file named "TaskList.json" at the root directory if it does not
     * exist, and initializes an empty task list within it by writing to the file using
     * a FileWriter. It catches any IOException that may occur during this process.
     */
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

    /**
     * Parses a JSON file named "TaskList.json" into a JSONObject using a JSONParser,
     * catching and propagating any IOException or ParseException that may occur during
     * parsing. A JSONObject representing the task list is then returned.
     *
     * @returns a JSON object parsed from "TaskList.json" file.
     *
     * The output is a JSON object with key-value pairs representing data from "TaskList.json"
     * file.
     * It contains various attributes such as task IDs, descriptions and due dates.
     * The attributes' types can vary depending on their values in the input file.
     */
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

    /**
     * Retrieves a JSONArray from a JSONObject named "taskList". The retrieved JSONArray
     * is returned by the function, allowing it to be used elsewhere in the application
     * for further processing or manipulation. The type cast to JSONArray ensures the
     * correct data structure is obtained.
     *
     * @param taskListObj JSON object from which to extract the "taskList" JSONArray.
     *
     * @returns a JSON array of tasks.
     */
    public static JSONArray createJSONArray(JSONObject taskListObj) {
        return (JSONArray) taskListObj.get("taskList");
    }

    /**
     * Serializes a JSONObject to a JSON file named "TaskList.json". It creates a FileWriter
     * and writes the JSONObject to it as a string, then closes the writer. If any I/O
     * exceptions occur, it throws a RuntimeException with the exception's cause.
     *
     * @param taskListObj JSONObject that contains the task list data to be written to
     * the "TaskList.json" file.
     *
     * The object contains a list or array of task objects.
     * Each task object has properties such as name, description and status.
     */
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
