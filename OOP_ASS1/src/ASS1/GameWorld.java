//Names: Dan Ben Baruch & Tal Portal//
 //IDs: 324179639 & 212999064//
package ASS1;

public class GameWorld {
    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty;

    public GameWorld() {
        this.name = "Crystalpath";
        this.difficulty = 1;
        this.players = new Player[0];
        this.enemies = new Enemy[0];
    }

    public GameWorld(String name, int difficulty, Player[] players, Enemy[] enemies) {
        this.name = name;
        this.difficulty = difficulty;
        this.players = players;
        this.enemies = enemies;
    }

    public void addPlayer(Player player) {
        Player[] newPlayers = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }
        newPlayers[newPlayers.length - 1] = player;
        players = newPlayers;
    }

    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1));
            System.out.println(players[i]);
            System.out.println();
        }
    }

    public int getTotalValueOfWorld() {
        int total = 0;
        for (Player p : players) {
            if (p != null) {
                total += p.calculateInventoryValue();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "World Name: " + name + "\nDifficulty: " + difficulty + "\nNumber of players: " + players.length;
    }
}
