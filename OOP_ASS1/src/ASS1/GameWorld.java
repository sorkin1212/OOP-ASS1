// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

import java.util.Arrays;

public class GameWorld {
    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty;

    public GameWorld() {
        this("Crystalpath", 1, new Player[0], new Enemy[0]);
    }

    public GameWorld(String name, int difficulty, Player[] players, Enemy[] enemies) {
        this.name = name;
        this.difficulty = difficulty;
        this.players = players;
        this.enemies = enemies;
    }

    public void addPlayer(Player player) {
        players = Arrays.copyOf(players, players.length + 1);
        players[players.length - 1] = player;
    }

    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("------------- Player " + (i + 1) + " -------------");
            System.out.println(players[i]);
            System.out.println();
        }
    }

    public int getTotalValueOfWorld() {
        int total = 0;
        for (Player player : players) {
            if (player != null) {
                total += player.calculateInventoryValue();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "World Name: " + name
                + "\nDifficulty: " + difficulty
                + "\nNumber of players: " + players.length;
    }
}