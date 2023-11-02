- создаем образ

        docker build -t target_java .

- Запуск контейнера должен быть в интерактивном режиме, иначе работать ввод из консоли не будет.

        docker run -it target_java

- Если так не сделать вылезет исколючение

        Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:945)
        at java.base/java.util.Scanner.next(Scanner.java:1486)
        at ru.homework.gb.MVP.View.menu(View.java:22)
        at ru.homework.gb.MVP.Presenter.start(Presenter.java:17)
        at ru.homework.gb.Main.main(Main.java:8)
