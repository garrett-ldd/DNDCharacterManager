package check;

import model.Character;
import util.Dice;
import util.Dnd;

public class Check {

    public static void check(Character character, String[] commandTokens) {
        int result = Dice.roll(20) + Dnd.skillToModifier(character, commandTokens[1]);
        System.out.println("result: " + result);
    }

}
