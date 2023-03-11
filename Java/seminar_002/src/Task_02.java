import java.io.*;
import java.util.Scanner;

public class Task_02 {
    /*
        Создать файл с названием file.txt. Если файл уже есть, то создавать не надо Записать в него Слово "TEXT" 100 раз
     */
    public static void main(String[] args) {
        String word = "TEXT";
        Scanner yesNo = new Scanner(System.in);
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("Файл создан.");
                fileWriter(word, file);
            } else {
                System.out.println("Такой файл сществует.");
                BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
                if (fileBuffer.readLine() != null){
                    System.out.println("Файл содержит информацию.");
                    System.out.print("Желате перезаписать информацию? (yes/no): ");
                    String answer = yesNo.nextLine();
                    switch (answer.toLowerCase()) {
                        case "yes":
                            fileWriter(word, file);
                            System.out.println("Файл перезаписан.");
                            break;
                        case "no":
                            System.out.println("Вы ничего не добавили в файл.");
                            break;
                        default:
                            break;
                    }
                }
                fileBuffer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Спасибо, что были с нами!");
        }
    }

    static void fileWriter (String word, File path){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(path.getName()))) {
            for (int i = 0; i < 100; i++) {
                writter.write(word + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
