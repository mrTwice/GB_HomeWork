### Задача

    Создайте базу данных (например, SchoolDB).
    В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
    Настройте Hibernate для работы с вашей базой данных.
    Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
    Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
    Убедитесь, что каждая операция выполняется в отдельной транзакции.

Каталог размещения файлов базы данных 

    JavaJunior/homework_04/docker/databases

Файл docker-compose для запуска БД в докер-контейнере

    JavaJunior/homework_04/docker/docker-compose.yml

Файл переменных среды для запуска контейнера 

    JavaJunior/homework_04/docker/mysql_homework_04.env

Файл конфигурации Hibernate

    JavaJunior/homework_04/src/main/resources/hibernate.cfg.xml

Точка входа

    JavaJunior/homework_04/src/main/java/org/hometask/Main.java

## Вопросы, которые не смог разрешить на данный момент
* СУБД развернута в докере, сама база создна при старте контейнера, hibernate.cfg.xml имеет такое свойство:
        
      <property name="hibernate.hbm2ddl.auto">update</property>

* Добавление тестовых данных проходит штатно, как и выполнение всех основыных функций.

* Если свойство в hibernate.cfg.xml, не изменить как показано ниже,

      <property name="hibernate.hbm2ddl.none">update</property>

  то при повторном запуске приложения вылетает исключение

      Caused by: java.sql.SQLSyntaxErrorException: Table 'course' already exists
        

Пробовал различные настройки для Hibernate, пока решения не нашел.