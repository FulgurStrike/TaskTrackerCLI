import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import add.Add;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

    private static void createJSONFile() {
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
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        createJSONFile();

        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("task-cli ");
        String input = userInputScanner.nextLine();
        String[] arguments =  input.split(" ");
        String command = arguments[0];

        int count = 1;
        while(!command.equals("exit")){

            switch (command){
                case "add":
                    StringBuilder description = new StringBuilder();
                    for(int i=1; i<arguments.length; i++) {
                        description.append(arguments[i] + " ");
                    }

                    try {
                        Add.add(description.toString().trim());
                    }catch (Exception e) {
                        System.out.println("Error try again!");
                    }

                    count++;
                    break;
                case "update":
                    System.out.println(Arrays.toString(arguments));
                    break;
                case "delete":
                    System.out.println(Arrays.toString(arguments));
                    break;
                case "list":
                    System.out.println(Arrays.toString(arguments));
                    break;
            }

            System.out.print("\ntask-cli ");
            input = userInputScanner.nextLine();
            arguments =  input.split(" ");
            command = arguments[0];
        }


    }
}