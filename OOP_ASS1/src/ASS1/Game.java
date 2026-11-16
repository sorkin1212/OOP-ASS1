// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

public class Game {

    public static void main(String[] args) {
        Item grimoire = new Item("Grimoire", 5, true);
        Item iceSword = new Item("Ice Sword", 8, true);
        Item guardianShield = new Item("Guardian Shield", 4, false);

        Player elara = new Player("Elara the Enchanter", 10, 4);
        elara.addItem(grimoire);
        elara.addItem(iceSword);

        Player kael = new Player("Kael the Windcaller", 10, 1);
        kael.addItem(guardianShield);

        Enemy goblin = new Enemy("Goblin", 10, 2, 3);

        Player[] players = {elara, kael};
        Enemy[] enemies = {goblin};
        GameWorld world = new GameWorld("Crystalpath", 2, players, enemies);

        world.printAllPlayers();

        for (Player player : players) {
            System.out.println(player.getName() + " inventory value: "
                    + player.calculateInventoryValue());
        }

        System.out.println();
        simulateBattle(elara, goblin);
    }

    public static void simulateBattle(Player player, Enemy enemy) {
        System.out.println(player.getName() + " - level : " + player.getLevel()
                + " VS " + enemy.getName() + " - level : " + enemy.getLevel());

        if (player.getLevel() >= enemy.getLevel()) {
            player.levelUp();
            System.out.println(player.getName() + " wins!");
        } else {
            enemy.levelUp();
            System.out.println(enemy.getName() + " wins!");
        }
    }
}