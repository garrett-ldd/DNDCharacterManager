package action;

import model.Character;

public class LongRest implements Action {

    @Override
    public String getName() {
        return "longrest";
    }

    @Override
    public boolean execute(Character character) {
        for (int spellLevel : character.getSpellSlots().keySet()) {
            int max = character.getSpellSlots().get(spellLevel).getTotal();
            character.getSpellSlots().get(spellLevel).setRemaining(max);
        }
        System.out.println("Restored all spell slots!");
        character.setHitPoints(character.getHitPointMax());
        System.out.println("Restored all hit points!");
        return true;
    }

}
