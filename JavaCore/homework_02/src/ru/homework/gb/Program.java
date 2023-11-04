package ru.homework.gb;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][] field; // Игровое поле

    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Победил компьютер."))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Распечатать игровое поле
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print((y) + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел >>> ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;

    }

    /**
     * TODO: 3. Компьютер должен мешать игроку
     * Ход игрока (компьютер)
     * antiWin хранит результаты следующего хода, если на нем игрок сможет победить
     *
     * warming хранит первый попавшийся ход, который может помешаать игроку сыграть, если не победной комбинации
     * на следующем ходу
     */
    private static void aiTurn() {
        int x, y;
        int[] antiWin = checkHumansMoves(DOT_HUMAN);
        int[] warning = checkPrevention(DOT_HUMAN);
        if(antiWin[0] != -1 && antiWin[1] != -1){
            y = antiWin[0];
            x = antiWin[1];
        } else if (warning[0] != -1 && warning[1] != -1) {
            y = warning[0];
            x = warning[1];
        } else {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellEmpty(x, y));
        }
        field[y][x] = DOT_AI;


    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка корректности координат хода
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param dot    фишка игрока
     * @param winStr победный слоган
     * @return признак завершения игры (true)
     */
    private static boolean gameCheck(char dot, String winStr) {
        if (isWin(dot)) {
            System.out.println(winStr);
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью (все ячейки игрового поля заполнены)
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Универсальный метод для проверки победных комбинаций.
     *
     * @param dot
     * @return
     */
    private static boolean isWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (firsDiagonal(y, x, dot) || secondDiagonal(y, x, dot)
                        || horizontal(y, x, dot) || vertical(y, x, dot))
                    return true;
            }
        }
        return false;
    }

    /**
     * Поиск предпобедных комбинаций игрока. Будет выбрана первая попавшаяся
     * @param dot
     * @return
     */
    private static boolean findWinPlayersCombination(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (firsDiagonalForBot(y, x, dot) || secondDiagonalForBot(y, x, dot)
                        || horizontalForBot(y, x, dot) || verticalForBot(y, x, dot))
                    return true;
            }
        }
        return false;
    }

    /**
     * Метод для бота, который позволяет делать ход с учетом возможной победы пользователя на следующем ходу
     * @param dot
     * @return массив с координатами лушего хода
     */
    private static int[] checkPrevention(char dot) {
        int[] answer = {-1, -1};
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(x,y)) {
                    field[y][x] = dot;
                    if (findWinPlayersCombination(dot)) {
                        answer[0] = y;
                        answer[1] = x;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return answer;
    }

    private static int[] checkHumansMoves(char dot) {
        int[] answer = {-1, -1};
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(x,y)) {
                    field[y][x] = dot;
                    if (isWin(dot)) {
                        answer[0] = y;
                        answer[1] = x;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return answer;
    }

    /**
     * Метод проверки победной комбинации по первой диагонали
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean firsDiagonal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x + (WIN_COUNT - 3)] == dot
                    && field[y + (WIN_COUNT - 2)][x + (WIN_COUNT - 2)] == dot
                    && field[y + (WIN_COUNT - 1)][x + (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


    /**
     * Метод проверки победной комбинации по первой диагонали для поиска предпобедной комбинации
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean firsDiagonalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x + (newWinCount - 2)] == dot
                    && field[y + (newWinCount - 1)][x + (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по второй диагонали
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean secondDiagonal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x - (WIN_COUNT - 3)] == dot
                    && field[y + (WIN_COUNT - 2)][x - (WIN_COUNT - 2)] == dot
                    && field[y + (WIN_COUNT - 1)][x - (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по второй диагонали для поиска предпобедной комбинации
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean secondDiagonalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x - (newWinCount - 2)] == dot
                    && field[y + (newWinCount - 1)][x - (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по горизонтали
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean horizontal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y][x + (WIN_COUNT - 3)] == dot
                    && field[y][x + (WIN_COUNT - 2)] == dot
                    && field[y][x + (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по горизонтали для поиска предпобедной комбинации
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean horizontalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y][x + (newWinCount - 2)] == dot
                    && field[y][x + (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по вертикали
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean vertical(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x] == dot
                    && field[y + (WIN_COUNT - 2)][x] == dot
                    && field[y + (WIN_COUNT - 1)][x] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * Метод проверки победной комбинации по вертикали для поиска предпобедной комбинации
     *
     * @param y   координата X
     * @param x   Координата Y
     * @param dot Символ игрока
     * @return True/False
     */
    private static boolean verticalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x] == dot
                    && field[y + (newWinCount - 1)][x] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


}
