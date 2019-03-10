package manager;

import util.Resource;

public class REPL {

    private CharacterManager manager;

    public REPL(CharacterManager manager) {
        this.manager = manager;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.print("character >> ");
            String command = Resource.console().nextLine();
            exit = handleCommand(command);
        }
    }

    private boolean handleCommand(String command) {
        command = command.trim().toLowerCase();
        if (command.isEmpty()) {
            return false;
        }
        if (command.equals("exit")) {
            return true;
        }
        manager.dispatch(command.split("\\s+"));
        return false;
    }

}
