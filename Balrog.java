
/**
 * Write a description of class Balrog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Balrog extends Demon
{
    private static final int MAX_BALROG_STR = 50;
    private static final int MIN_BALROG_STR = 20;
    private static final int MAX_BALROG_HP = 100;
    private static final int MIN_BALROG_HP = 50;

    public Balrog()
    {
        super(
            Randomizer.nextInt(MAX_BALROG_STR - MIN_BALROG_STR + 1) + MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP - MIN_BALROG_HP + 1) + MIN_BALROG_HP
        );
    }

    // Balrog gets to attack twice
    @Override
    public int attack()
    {
        return super.attack() + super.attack();
    }
}