package display;

import model.Character;
import util.Dnd;

import java.util.Map;

public class Display {

    public static void stats(Character character) {
        Map<String, Integer> scores = character.getAbilityScores();
        for (String scoreName : character.getAbilityScores().keySet()) {
            System.out.println("\t" + scoreName + ": " + Dnd.abilityScoreToModifier(scores.get(scoreName)));
        }
    }

    public static void skill(Character character, String skill) {
        System.out.println(Dnd.skillToModifier(character, skill));
    }

}
