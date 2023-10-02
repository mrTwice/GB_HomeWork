public class Main {
    public static void main(String[] args) {
        Game zeroCross = new Game(new Player("Иван"), new Player("Виктор"), new Board());
        zeroCross.choicePlayersMarks();

        while (!zeroCross.gameOver()){
            zeroCross.getGameBoard().drawBoard();
            if(zeroCross.getCurrentMove() == 1) {
                System.out.printf("%s, ваш ход: ", zeroCross.getPlayerOne().getName());
                int choice = zeroCross.getPlayerOne().move();
                zeroCross.getGameBoard().recordMove(zeroCross.getPlayerOne(), choice);
                System.out.println();
            } else {
                System.out.printf("%s, ваш ход: ", zeroCross.getPlayerTwo().getName());
                int choice = zeroCross.getPlayerTwo().move();
                zeroCross.getGameBoard().recordMove(zeroCross.getPlayerTwo(), choice);
                System.out.println();
            }

            if(zeroCross.gameOver() && zeroCross.getWin() != null) {
                zeroCross.getGameBoard().drawBoard();
                System.out.printf("%s ПОБЕДИЛ", zeroCross.getWin().getName());
            } else if (zeroCross.gameOver() && zeroCross.getWin() == null) {
                zeroCross.getGameBoard().drawBoard();
                System.out.println("ПОБЕДИЛА ДРУЖБА!!!");
            }
            zeroCross.switchPlayer();

        }
    }
}