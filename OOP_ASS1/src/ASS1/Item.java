//Names: Dan Ben Baruch & Tal Portal//
 //IDs: 324179639 & 212999064//
package ASS1;

public class Item {
    private String name;
    private int value;
    private boolean isMagical;

    public Item() {
        this.name = "Unknown";
        this.value = 0;
        this.isMagical = false;
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
        if (value >= 0) {
            this.value = value;
        }
    }

    public boolean isMagical() {
        return isMagical;
    }

    @Override
    public String toString() {
        String res = "Name: " + name + "\nValue: " + value;
        if (isMagical) {
            res += "\nMagical item";
        }
        return res;
    }
}