package manager;

import action.Action;
import action.WeaponAttack;
import model.Character;
import spell.Spell;
import util.Dice;
import util.Dnd;

import java.io.FileNotFoundException;
import java.util.Map;

public class CharacterManager {

    private String configFileName;
    private Character character;

    public CharacterManager(String config) throws FileNotFoundException {
        this.configFileName = config;
        this.character = Character.loadFromDisk(config);
    }

    public Character getCharacter() {
        return this.character;
    }

    public void dispatch(String[] commandTokens) {
        String command = commandTokens[0];

        if (command.equalsIgnoreCase("act")) {
            if (commandTokens.length < 2) {
                System.out.println("Missing action name");
                return;
            }
            Action action = getAction(commandTokens);
            if (action == null) {
                System.out.println("Unknown action");
                return;
            }
            boolean successful = action.execute(character);
            updateOrRollback(successful);
        } else if (command.equalsIgnoreCase("show")) {
            if (commandTokens.length == 1) {
                System.out.println(character);
            } else if (commandTokens[1].equalsIgnoreCase("stats")) {
                Map<String, Integer> scores = character.getAbilityScores();
                for (String scoreName : character.getAbilityScores().keySet()) {
                    System.out.println("\t" + scoreName + ": " + Dnd.abilityScoreToModifier(scores.get(scoreName)));
                }
            } else if (commandTokens[1].equalsIgnoreCase("skill")) {
                System.out.println(Dnd.skillToModifier(character, commandTokens[2]));
            } else {
                System.out.println("Not implemented yet");
            }
        } else if (command.equalsIgnoreCase("check")) {
            int result = Dice.roll(20) + Dnd.skillToModifier(character, commandTokens[1]);
            System.out.println("result: " + result);
        } else if (command.equalsIgnoreCase("longrest")) {
            for (int spellLevel : character.getSpellSlots().keySet()) {
                int max = character.getSpellSlots().get(spellLevel).getTotal();
                character.getSpellSlots().get(spellLevel).setRemaining(max);
            }
            character.setHitPoints(character.getHitPointMax());
            character.save();
        } else {
            System.out.println("Unknown command");
        }
    }

    private Action getAction(String[] tokens) {
        for (WeaponAttack weaponAttack : character.getWeaponAttacks()) {
            if (weaponAttack.getName().equalsIgnoreCase(tokens[1])) {
                return weaponAttack;
            }
        }
        for (Spell spell : character.getSpells()) {
            if (spell.getName().equalsIgnoreCase(tokens[1])) {
                return spell;
            }
        }
        return null;
    }

    private void updateOrRollback(boolean update) {
        if (update) {
            this.character.save();
        } else {
            try {
                this.character = Character.loadFromDisk(configFileName);
            } catch (FileNotFoundException e) {
                System.err.println("model.Character config file is missing!");
            }
        }
    }
}
