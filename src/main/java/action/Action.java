package action;

import model.Character;

public interface Action {

    String getName();
    boolean execute(Character character);

}
