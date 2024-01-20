package org.hometasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;
import java.util.ArrayList;

public class Journal {
    public static final String JOURNAL_TO_BIN = "jourlan.bin";
    public static final String JOURNAL_TO_XML = "jourlan.xml";
    public static final String JOURNAL_TO_JSON = "jourlan.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    private ArrayList<Student> students = new ArrayList<>();

    public Journal() {
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, int age, double gpa){
        students.add(new Student(name, age, gpa));
    }

    public void deleteStudent(int id){
        students.remove(students.stream().filter(s -> s.getId() == id).findFirst().get());
    }

    public void saveToFile(ArrayList<Student> students, String fileFormat){
        try{
            if(fileFormat.endsWith(".bin")){
                try (ObjectOutputStream journalToFile = new ObjectOutputStream(new FileOutputStream(fileFormat))){
                    journalToFile.writeObject(students);
                }
            } else if (fileFormat.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileFormat), students);
            } else if (fileFormat.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileFormat), students);
            }

        }catch (Exception e) {
            System.out.println("Что-то пошло не по плану!");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public ArrayList<Student> loadFromFile(String fileFormat){
        ArrayList<Student> studentArrayList =new ArrayList<>();
        File file = new File(fileFormat);
        if(file.exists()){
            try {
                if (fileFormat.endsWith(".json")) {
                    studentArrayList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Student.class));
                }
                else if (fileFormat.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        studentArrayList = ((ArrayList<Student>)ois.readObject());
                    }

                }
                else if (fileFormat.endsWith(".xml")) {
                    studentArrayList = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  studentArrayList;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
