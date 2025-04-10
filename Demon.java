
/**
 * Write a description of class Demon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demon extends Creature {

    public Demon(int str, int hp) {
        super(str, hp);
    }

    // Override attack to give Demons a chance to do bonus damage
    @Override
    public int attack() {
        int damage = super.attack();
        if (Randomizer.nextInt(100) <= 5) { // 5% chance
            damage += 50;
        }
        return damage;
    }
}