# Домашнее задание по третьему семинару курса Spring
## Базовое задание:
   1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
   2) Разработать метод processRegistration в котором:
      - создается пользователь из параметров метода
      - созданный пользователь добавляется в репозиторий
      - через notificationService выводится сообщение в консоль
   3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
   4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

## Задание со звездочкой:
   1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса
   2) Перенести репозиторий проекта с List<User> на базу данных H2

## Информация:

При выполнении второго дополнительного задания вместо базы данных H2 была использована СУБД MySQL, развернутая в контейнере Docker.
Для работы с базой данных использовался Spring Data JPA.

[Конфигурация контейнера](https://github.com/mrTwice/GB_HomeWork/blob/main/Spring/ThirdHomework/compose.yaml)

[Настройки переменных окружения для контейнера](https://github.com/mrTwice/GB_HomeWork/blob/main/Spring/ThirdHomework/SpringMvcHomework_03.env)

[Настройки для работы с СУБД](https://github.com/mrTwice/GB_HomeWork/blob/main/Spring/ThirdHomework/src/main/resources/application.properties)

