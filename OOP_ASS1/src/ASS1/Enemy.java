// Names: Dan Ben Baruch & Tal Portal
//IDs: 324179639 & 212999064
package ASS1;

public class Enemy extends Character {
 private int damage;

 public Enemy(String name, int health, int level, int damage) {
     super(name, health, level);
     this.damage = (damage >= 1 && damage <= 5) ? damage : 1;
 }

 public int getDamage() {
     return damage;
 }

 @Override
 public String toString() {
     return super.toString() + "\nDamage: " + damage;
 }
}