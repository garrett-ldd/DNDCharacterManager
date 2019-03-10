package util;

import model.Character;

import java.util.Map;

public class Dnd {

    public static int abilityScoreToModifier(int score) {
        switch (score) {
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            case 20:
            case 21:
                return 5;
            case 22:
            case 23:
                return 6;
            case 24:
            case 25:
                return 7;
            case 26:
            case 27:
                return 8;
            case 28:
            case 29:
                return 9;
            case 30:
                return 10;
        }
        throw new IllegalArgumentException("Invalid ability score: " + score);
    }

    public static int skillToModifier(Character character, String skill) {
        Map<String, Integer> scores = character.getAbilityScores();
        switch (skill) {
            case "athletics":
                return abilityScoreToModifier(scores.get("strength"));
            case "acrobatics":
            case "sleightofhand":
            case "stealth":
                return abilityScoreToModifier(scores.get("dexterity"));
            case "arcana":
            case "history":
            case "investigation":
            case "nature":
            case "religion":
                return abilityScoreToModifier(scores.get("intelligence"));
            case "animalhandling":
            case "insight":
            case "medicine":
            case "perception":
            case "survival":
                return abilityScoreToModifier(scores.get("wisdom"));
            case "deception":
            case "intimidation":
            case "performance":
            case "persuasion":
                return abilityScoreToModifier(scores.get("charisma"));
        }
        throw new IllegalArgumentException("unknown skill");
    }

    public static int levelToProficiencyBonus(int level) {
        switch (level) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case 8:
                return 3;
            case 9:
            case 10:
            case 11:
            case 12:
                return 4;
            case 13:
            case 14:
            case 15:
            case 16:
                return 5;
            case 17:
            case 18:
            case 19:
            case 20:
                return 6;
        }
        throw new IllegalArgumentException("invalid level");
    }

}
