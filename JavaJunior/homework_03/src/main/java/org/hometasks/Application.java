package org.hometasks;


import static org.hometasks.Journal.*;

public class Application {
    private final View view = new View();
    private final Journal journal = new Journal();

    public void start(){
        System.out.println();
        String answer = view.getString("Желаете добавить данные для тестирования? (y|n)\n"+
                "Введите ответ: ");
        if (answer.equals("y")){
            journal.addStudent("Петр", 19, 4.8);
            journal.addStudent("Василиса", 22, 4.55);
            journal.addStudent("Иван Васильевич", 35, 4.1);
            journal.addStudent("Николай", 28, 3.85);
            journal.addStudent("Анна", 31, 4.6);
            journal.addStudent("Евгения", 24, 5.0);
            System.out.println("Тестовые данные добавлены.");

        }
        boolean flag = false;
        while (!flag) {
            view.printMenu();
            switch (view.choice()) {
                case "1":
                    System.out.println();
                    view.displayJournal(journal.getStudents());
                    break;
                case "2":
                    System.out.println();
                    journal.addStudent(
                            view.getString("Введи имя студента: "),
                            view.getInt("Укажите возраст: "),
                            view.getDouble("Укажите средний балл: ")
                    );
                    break;
                case "3":
                    journal.deleteStudent(view.getInt("Для удаления студент введите его id: "));
                    break;
                case "4":
                    System.out.println();
                    String typeFile = view.getString("Для сохранения в бинарном формате, введите bin\n"+
                            "Для сохранения в формате документа json, введите json\n"+
                            "Для сохранения в формате документа xml, введите xml\n"
                            +"Укажите в каком формате сохранить журнал: ");
                    if(typeFile.equals("bin"))
                        journal.saveToFile(journal.getStudents(), JOURNAL_TO_BIN);
                    if(typeFile.equals("json"))
                        journal.saveToFile(journal.getStudents(), JOURNAL_TO_JSON);
                    if(typeFile.equals("xml"))
                        journal.saveToFile(journal.getStudents(), JOURNAL_TO_XML);
                    break;
                case "5":
                    System.out.println();
                    String typeFileForLoad = view.getString("Для загрузки из файла бинарного формата, введите bin\n"+
                            "Для загрузки из файла формата json, введите json\n"+
                            "Для загрузки из файла формата xml, введите xml\n"+
                            "Укажите формат для загрузки данных из файла: ");
                    if(typeFileForLoad.equals("bin"))
                       journal.setStudents(journal.loadFromFile(JOURNAL_TO_BIN));
                    if(typeFileForLoad.equals("json"))
                        journal.setStudents(journal.loadFromFile(JOURNAL_TO_JSON));
                    if(typeFileForLoad.equals("xml"))
                        journal.setStudents(journal.loadFromFile(JOURNAL_TO_XML));
                    break;
                case "6":
                    flag = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }
}
