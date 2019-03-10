import java.io.FileNotFoundException;

public class CharacterManager {

    private String configFileName;
    private Character character;

    public CharacterManager(String config) throws FileNotFoundException {
        this.configFileName = config;
        this.character = Character.loadFromDisk(config);
    }

    public void dispatch(String[] commandTokens) {
        Action action = getAction(commandTokens);
        if (action == null) {
            System.out.println("Unknown action");
            return;
        }
        boolean successful = action.execute(character);

        if (successful) {
            // save to disk
            this.character.save();
        } else {
            // rollback
            try {
                this.character = Character.loadFromDisk(configFileName);
            } catch (FileNotFoundException e) {
                System.err.println("Character config file is missing!");
            }
        }
    }

    private Action getAction(String[] tokens) {
        for (Action action : character.getWeaponAttacks()) {
            if (action.getName().equalsIgnoreCase(tokens[0])) {
                return action;
            }
        }
        return null;
    }
}
