// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

public class Item {
    private String name;
    private int value;
    private boolean isMagical;

    public Item() {
        this("Unknown", 0, false);
    }

    public Item(String name, int value, boolean isMagical) {
        this.name = name;
        setValue(value);
        this.isMagical = isMagical;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Math.max(0, value);
    }

    public boolean isMagical() {
        return isMagical;
    }

    @Override
    public String toString() {
        String description = "Name: " + name + "\nValue: " + value;
        if (isMagical) {
            description += "\nMagical item";
        }
        return description;
    }
}