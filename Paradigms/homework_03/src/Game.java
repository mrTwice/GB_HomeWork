import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private Board gameBoard;
    private int currentMove;
    private ArrayList<Player> players = new ArrayList<>();
    private Player win;

    public Game(Player playerOne, Player playerTwo, Board gameBoard){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameBoard = gameBoard;
        this.currentMove = 1;
        players.add(this.playerOne);
        players.add(this.playerTwo);
    }

    public void choicePlayersMarks() {
        Scanner consoleInput = new Scanner(System.in);

        System.out.printf("%s введите символ, которым будете играть: ", this.playerOne.getName());
        String mark = consoleInput.nextLine();
        this.playerOne.setMark(mark);

        System.out.printf("%s введите символ, которым будете играть: ", this.playerTwo.getName());
        mark = consoleInput.nextLine();
        this.playerTwo.setMark(mark);
    }

    public Player switchPlayer() {
        if (currentMove == 1){
            this.currentMove = 2;
            return this.playerTwo;
        }
        this.currentMove = 1;
        return this.playerOne;
    }

    public boolean gameOver() {
        if (checkEmptyFields() && !checkWin())
            return false;
        return true;
    }

    public boolean checkEmptyFields() {
        for (String field: this.gameBoard.getFields()){
            if(!field.equalsIgnoreCase("X") && !field.equalsIgnoreCase("O"))
                return true;
        }
        return false;
    }

    public boolean checkWin(){
        for (Player player: this.players) {
            if (this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[1]) && this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[2])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[3].equalsIgnoreCase(this.gameBoard.getFields()[4]) && this.gameBoard.getFields()[3].equalsIgnoreCase(this.gameBoard.getFields()[5])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[6].equalsIgnoreCase(this.gameBoard.getFields()[7]) && this.gameBoard.getFields()[6].equalsIgnoreCase(this.gameBoard.getFields()[8])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[3]) && this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[6])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[1].equalsIgnoreCase(this.gameBoard.getFields()[4]) && this.gameBoard.getFields()[1].equalsIgnoreCase(this.gameBoard.getFields()[7])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[2].equalsIgnoreCase(this.gameBoard.getFields()[5]) && this.gameBoard.getFields()[2].equalsIgnoreCase(this.gameBoard.getFields()[8])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[4]) && this.gameBoard.getFields()[0].equalsIgnoreCase(this.gameBoard.getFields()[8])) {
                this.win =player;
                return true;
            } else if (this.gameBoard.getFields()[2].equalsIgnoreCase(this.gameBoard.getFields()[4]) && this.gameBoard.getFields()[2].equalsIgnoreCase(this.gameBoard.getFields()[6])) {
                this.win =player;
                return true;
            }
        }
        return false;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getWin() {
        return win;
    }
}
