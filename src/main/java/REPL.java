import java.util.Scanner;

public class REPL {

    private CharacterManager manager;

    private Scanner scanner;

    public REPL(CharacterManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("character >> ");
            String command = scanner.nextLine();
            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        command = command.trim().toLowerCase();
        if (command.isEmpty()) {
            return;
        }

        manager.dispatch(command.split("\\s+"));
    }

}
