//Names: Dan Ben Baruch & Tal Portal//
 //IDs: 324179639 & 212999064//
package ASS1;
public class Player extends Character {
    private Item[] inventory;

    public Player(String name, int health, int level, int inventorySize) {
        super(name, health, level);
        this.inventory = new Item[inventorySize];
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
        return false;
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
        StringBuilder itemsStr = new StringBuilder();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (itemsStr.length() > 0) {
                    itemsStr.append(" | ");
                }
                itemsStr.append(inventory[i].getName());
            }
        }
        return super.toString() + "\nInventory: " + itemsStr.toString();
    }
}
