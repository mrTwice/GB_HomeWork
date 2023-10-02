public class Board {

    private String[] fields = new String[9];

    public Board() {
        for (int i = 0; i < 9; i ++){
            this.fields[i] = String.valueOf(i + 1);
        }
    }

    public void drawBoard() {
        System.out.printf("%2s |%2s |%2s \n", fields[0], fields[1], fields[2]);
        System.out.printf("───┼───┼───\n");
        System.out.printf("%2s |%2s |%2s \n", fields[3], fields[4], fields[5]);
        System.out.printf("───┼───┼───\n");
        System.out.printf("%2s |%2s |%2s \n", fields[6], fields[7], fields[8]);
    }

    public void recordMove(Player player, int fieldChoice) {
        this.fields[fieldChoice -1] = player.getMark();
    }

    public String[] getFields() {
        return fields;
    }
}
