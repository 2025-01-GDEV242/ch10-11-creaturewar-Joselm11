
/**
 * Write a description of class Elf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elf extends Creature
{
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 10;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 10;

    public Elf()
    {
        super(
            Randomizer.nextInt(MAX_ELF_STR - MIN_ELF_STR + 1) + MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP - MIN_ELF_HP + 1) + MIN_ELF_HP
        );
    }

    @Override
    public int attack() {
        int damage = super.attack();
        // 10% chance to do double damage
        if (Randomizer.nextInt(10) == 1) {
            damage *= 2;
        }
        return damage;
    }
}
