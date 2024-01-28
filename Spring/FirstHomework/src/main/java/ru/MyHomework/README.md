### Домашнее задание

    1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
    2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
    3. Создайте класс Person с полями firstName, lastName и age.
    4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
    5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.


В директории docker находятся:
    
- docker-compose.yml для запуска контейнера с mysql
- mysql_Spring_Homework_01.env файл переменных среды, для первоначальной настройки СУБД

После запуска docker-compose.yml будет создан контейнер c СУБД mySQL последней версии, размещенной на DockerHUB с настройками указанными в ysql_Spring_Homework_01.env,
а также каталок с файлами БД /var/lib/mysql будет примонтирован в каталог /database расположенный в каталоге docker-compose.yml

Для работы с базой данных используется фреймворк Hibernate. Базовые настройки находятся в src/main/resources/hibernate.cfg.xml

При выполнении домашней работы так же были использованы:
- projectlombok
- apache commons-lang3
- google gson