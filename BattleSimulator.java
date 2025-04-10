import java.util.ArrayList;
/**
 * Write a description of class BattleSimulator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class BattleSimulator {

    public static void main(String[] args) {
        ArrayList<Creature> goodArmy = createGoodArmy(100);
        ArrayList<Creature> evilArmy = createEvilArmy(50);

        int goodIndex = 0;
        int evilIndex = 0;

        System.out.println("Battle begins!\n");

        while (goodIndex < goodArmy.size() && evilIndex < evilArmy.size()) {
            Creature good = goodArmy.get(goodIndex);
            Creature evil = evilArmy.get(evilIndex);

            System.out.println("\nSkirmish: " + good.toString() + " #" + (goodIndex+1) + " vs " + evil.toString() + " #" + (evilIndex+1));

            while (good.isAlive() && evil.isAlive()) {
                int goodAttack = good.attack();
                int evilAttack = evil.attack();

                evil.takeDamage(goodAttack);
                good.takeDamage(evilAttack);

                System.out.println("  " + good.toString() + " hits for: " + goodAttack + " | " + evil.toString() + " hits for: " + evilAttack);
                System.out.println("  " + good.toString() + " HP: " + getHp(good) + " | " + evil.toString() + " HP: " + getHp(evil));
            }

            if (!good.isAlive()) {
                System.out.println("  " + good.toString() + " has fallen.");
                goodIndex++;
            }

            if (!evil.isAlive()) {
                System.out.println("  " + evil.toString() + " has fallen.");
                evilIndex++;
            }
        }

        System.out.println("\n=== BATTLE OVER ===");
        if (goodIndex >= goodArmy.size() && evilIndex >= evilArmy.size()) {
            System.out.println("It's a draw. Both armies have fallen.");
        } else if (goodIndex >= goodArmy.size()) {
            System.out.println("Evil army wins!");
        } else {
            System.out.println("Good army wins!");
        }
    }

    private static ArrayList<Creature> createGoodArmy(int size) {
        ArrayList<Creature> army = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int roll = Randomizer.nextInt(10);
            if (roll <= 6) {
                army.add(new Human());
            } else if (roll <= 8) {
                army.add(new Elf());
            } else {
                army.add(new Dwarf());
            }
        }
        return army;
    }

    private static ArrayList<Creature> createEvilArmy(int size) {
        ArrayList<Creature> army = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int roll = Randomizer.nextInt(25);
            if (roll <= 18) {
                army.add(new Human());
            } else if (roll <= 24) {
                army.add(new CyberDemon());
            } else {
                army.add(new Balrog());
            }
        }
        return army;
    }
    
    private static int getHp(Creature c) {
        try {
            java.lang.reflect.Field hpField = Creature.class.getDeclaredField("hp");
            hpField.setAccessible(true);
            return hpField.getInt(c);
        } catch (Exception e) {
            return -1; // Just in case something goes wrong
        }
    }
}
