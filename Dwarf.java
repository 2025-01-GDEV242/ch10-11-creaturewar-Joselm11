
/**
 * Write a description of class Dwarf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dwarf extends Creature
{
    private static final int MAX_DWARF_STR = 45;
    private static final int MIN_DWARF_STR = 25;
    private static final int MAX_DWARF_HP = 100;
    private static final int MIN_DWARF_HP = 60;

    /**
     * Constructor for objects of class Dwarf
     */
    public Dwarf()
    {
        super(
            Randomizer.nextInt(MAX_DWARF_STR - MIN_DWARF_STR + 1) + MIN_DWARF_STR,
            Randomizer.nextInt(MAX_DWARF_HP - MIN_DWARF_HP + 1) + MIN_DWARF_HP
        );
    }

    /**
     * Overrides takeDamage to give Dwarves a 20% chance to take half damage.
     */
    @Override
    public void takeDamage(int damage)
    {
        // 20% chance to take half damage
        int chance = Randomizer.nextInt(100); // returns 1 to 100
        if (chance <= 20) {
            damage = damage / 2;
        }
        super.takeDamage(damage);
    }
}