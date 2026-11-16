// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

public class Character {
    private String name;
    private int health;
    private int level;

    public Character() {
        this("Unknown", 0, 0);
    }

    public Character(String name, int health, int level) {
        this.name = name;
        this.health = (health >= 0 && health <= 10) ? health : 0;
        this.level = (level >= 0 && level <= 5) ? level : 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        if (level < 5) {
            level++;
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += Math.min(amount, 10 - health);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name
                + "\nHealth: " + health
                + "\nLevel: " + level;
    }
}