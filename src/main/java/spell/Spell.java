package spell;

import action.Action;
import model.Character;
import util.Dice;
import util.Resource;

import java.util.List;

public class Spell implements Action {

    private String name;
    private int range;
    private String description;
    private int spellLevel;
    private String damageType;
    private List<Integer> damageDice;
    private int additionalDamagePerRoll;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(Character character) {
        System.out.println("\n" + description + "\n");

        System.out.println("Cast spell? [y/n] ");
        int remaining = character.getSpellSlots().get(spellLevel).getRemaining();
        if (remaining == 0) {
            System.out.println("No spell slots remaining.");
            return true;
        }
        String answer = Resource.console().nextLine().trim();
        if (!answer.equalsIgnoreCase("y")) {
            return true;
        }

        int totalDamage = 0;
        for (int i = 0; i < damageDice.size(); i++) {
            int dmg = Dice.roll(damageDice.get(i));
            System.out.println("Roll #" + (i + 1) + ": " + dmg + " + " + additionalDamagePerRoll);
            totalDamage += dmg + additionalDamagePerRoll;
        }
        System.out.println(totalDamage + " " + damageType + " damage!");

        character.getSpellSlots().get(spellLevel).setRemaining(remaining - 1);

        return true;
    }

}
