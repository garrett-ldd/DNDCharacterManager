import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting DNDCharacterManager...\n");

        if (args.length != 1) {
            System.err.println("Incorrect number of arguments (" + args.length + "), please pass path to character config.");
            System.exit(1);
        }

        // 1) load character config from file
        CharacterManager manager = null;
        try {
            manager = new CharacterManager(args[0]);
        } catch (FileNotFoundException e ) {
            System.err.println("Could not find the provided character config file: " + args[0]);
            System.exit(1);
        }
        // 2) start REPl
        new REPL(manager).start();
    }
}