
/**
 * Write a description of class CyberDemon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CyberDemon extends Demon
{
    private static final int MAX_CYBER_STR = 40;
    private static final int MIN_CYBER_STR = 20;
    private static final int MAX_CYBER_HP = 100;
    private static final int MIN_CYBER_HP = 25;

    public CyberDemon()
    {
        super(
            Randomizer.nextInt(MAX_CYBER_STR - MIN_CYBER_STR + 1) + MIN_CYBER_STR,
            Randomizer.nextInt(MAX_CYBER_HP - MIN_CYBER_HP + 1) + MIN_CYBER_HP
        );
    }
}