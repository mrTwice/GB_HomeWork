package ru.MyHomework.UseCase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.MyHomework.Models.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    public static List<File> getJsonFiles(String path) {
        File dir = new File(path);
        List<File> lst = Arrays.stream(dir.listFiles()).toList();
        return lst.stream().filter(file -> file.getName().endsWith(".json")).toList();
    }

    public static void saveToJsonFile(Person person){
        try(FileWriter fileWriter = new FileWriter(person.getFirstName()+person.getLastName()+".json")) {
            Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
            String jsonObject = gsonBuilder.toJson(person);
            fileWriter.write(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Person loadFromJsonFile(String fileName){
        StringBuilder jsonFromFile = new StringBuilder();
        Person person = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                jsonFromFile.append(line);
            }
            GsonBuilder personBuilder = new GsonBuilder();
            Gson gson = personBuilder.create();
            person = gson.fromJson(jsonFromFile.toString(), Person.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }
}
