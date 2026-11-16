// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

import java.util.Arrays;

public class Player extends Character {
    private Item[] inventory;

    public Player(String name, int health, int level) {
        this(name, health, level, new Item[0]);
    }

    public Player(String name, int health, int level, int inventorySize) {
        this(name, health, level, new Item[inventorySize]);
    }

    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);
        this.inventory = inventory;
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            }
        }

        inventory = Arrays.copyOf(inventory, inventory.length + 1);
        inventory[inventory.length - 1] = item;
        return true;
    }

    public int calculateInventoryValue() {
        int total = 0;
        for (Item item : inventory) {
            if (item != null) {
                total += item.getValue();
            }
        }
        return total;
    }

    public boolean hasMagicalItem() {
        for (Item item : inventory) {
            if (item != null && item.isMagical()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder();

        for (Item item : inventory) {
            if (item != null) {
                if (items.length() > 0) {
                    items.append(" | ");
                }
                items.append(item.getName());
            }
        }

        return super.toString() + "\nInventory: " + items;
    }
}