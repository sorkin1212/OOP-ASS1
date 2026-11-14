//Names: Dan Ben Baruch & Tal Portal//
 //IDs: 324179639 & 212999064//
package ASS1;

public class Main {
    public static void simulateBattle(Player player, Enemy enemy) {
        System.out.println(player.getName() + " - level: " + player.getLevel() + " VS " + enemy.getName() + " - level:" + enemy.getLevel());
        if (player.getLevel() >= enemy.getLevel()) {
            player.levelUp();
            System.out.println(player.getName() + " wins!");
        } else {
            enemy.levelUp();
            System.out.println(enemy.getName() + " wins!");
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item("Grimoire", 5, true);
        Item item2 = new Item("Ice Sword", 8, true);
        Item item3 = new Item("Guardian Shield", 4, false);

        Player p1 = new Player("Elara the Enchanter", 10, 3, 2);
        p1.addItem(item1);
        p1.addItem(item2);

        Player p2 = new Player("Kael the Windcaller", 10, 1, 1);
        p2.addItem(item3);

        Enemy enemy = new Enemy("Goblin", 10, 2, 3);

        Player[] initialPlayers = {p1, p2};
        Enemy[] initialEnemies = {enemy};
        GameWorld world = new GameWorld("Crystalpath", 2, initialPlayers, initialEnemies);

        world.printAllPlayers();

        System.out.println("--- Inventory Values ---");
        System.out.println(p1.getName() + " inventory value: " + p1.calculateInventoryValue());
        System.out.println(p2.getName() + " inventory value: " + p2.calculateInventoryValue());
        System.out.println();

        System.out.println("--- Battle Simulation ---");
        simulateBattle(p1, enemy);
    }
}
