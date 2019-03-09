import java.io.FileNotFoundException;

public class CharacterManager {

    private Character character;

    enum Command {
        SHOW,
        ATTACK,
        HELP
    }

    public CharacterManager(String config) throws FileNotFoundException {
        this.character = Character.loadFromDisk(config);
    }

    public void dispatch(String[] commandTokens) {

    }

}
