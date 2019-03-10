package manager;

import action.Action;
import action.WeaponAttack;
import model.Character;

import java.io.FileNotFoundException;

public class CharacterManager {

    private String configFileName;
    private Character character;

    public CharacterManager(String config) throws FileNotFoundException {
        this.configFileName = config;
        this.character = Character.loadFromDisk(config);
    }

    public void dispatch(String[] commandTokens) {
        // TODO: handle things other than actions
        Action action = getAction(commandTokens);
        if (action == null) {
            System.out.println("Unknown action");
            return;
        }
        boolean successful = action.execute(character);
        updateOrRollback(successful);
    }

    private Action getAction(String[] tokens) {
        for (WeaponAttack action : character.getWeaponAttacks()) {
            if (action.getName().equalsIgnoreCase(tokens[0])) {
                return action;
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
