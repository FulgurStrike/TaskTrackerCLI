package add;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Add {

    private static JSONArray readFile(String fileName) {
        Object obj = null;
        JSONArray jsonArray = null;

        try {
            obj = new JSONParser().parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            jsonArray = new JSONArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return jsonArray;
    }

    public static void add(String input, int id) throws Exception {

        JSONObject taskData = new JSONObject();

        if(!input.equals("")) {
            taskData.put("id", id);
            taskData.put("description", input);
            taskData.put("status", "to-do");
            taskData.put("createdAt", LocalDate.now().toString() + " " + LocalTime.now().toString());
            taskData.put("updatedAt", LocalDate.now().toString() + " " + LocalTime.now().toString());
        }else {
            throw new Exception();
        }

//        FileWriter writer = new FileWriter("TaskList.json", true);
//        writer.write(taskData.toJSONString());
//        writer.close();
    }
}
