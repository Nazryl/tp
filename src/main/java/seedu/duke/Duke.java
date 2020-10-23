package seedu.duke;

import org.fusesource.jansi.AnsiConsole;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.data.exception.SystemException;
import seedu.duke.data.notebook.Notebook;
import seedu.duke.data.notebook.TagManager;
import seedu.duke.data.timetable.Timetable;
import seedu.duke.storage.StorageManager;
import seedu.duke.ui.AsciiArt;
import seedu.duke.ui.InterfaceManager;
import seedu.duke.ui.Formatter;
import seedu.duke.util.Parser;

import java.io.IOException;

/**
 * Entry point of the NotUS application.
 */
public class Duke {
    private InterfaceManager interfaceManager;
    private StorageManager storageManager;
    private Notebook notebook;
    private Timetable timetable;
    private TagManager tagManager;

    private static final String WELCOME_MSG_STRING = "Welcome to NotUS! "
            + AsciiArt.getNotusLogo() + Formatter.LS
            + "Type \"help\" if you need to see a list of commands and their usages.";
    private static final String ENTER_COMMAND_MSG = "Enter command:";

    /**
     * Initializes the required managers.
     */
    private void init() {
        this.interfaceManager = new InterfaceManager();
        this.storageManager = new StorageManager();
        this.notebook = new Notebook();
        this.timetable = new Timetable();
        this.tagManager = new TagManager();

        try{
            storageManager.createFiles();
            interfaceManager.prints("created files");
        } catch (SystemException exception){
            interfaceManager.prints(exception.getMessage());
        }
        interfaceManager.prints(WELCOME_MSG_STRING);
    }

    /** Reads the user command and executes it until the user exits the program. */
    private void runCommandLoop() {
        Command command;

        do {
            interfaceManager.prints(ENTER_COMMAND_MSG);
            String userCommandText = interfaceManager.getUserCommandInput();
            command = new Parser().parseCommand(userCommandText);
            String result = executeCommand(command);
            interfaceManager.prints(result);
        } while (!ExitCommand.isExit(command));
    }

    /**
     * Exits the application.
     */
    private void exit() {
    }

    /** Runs the program until termination. */
    private void run() {
        init();
        runCommandLoop();
        exit();
    }

    /**
     * Calls the execute function of the command.
     *
     * @param command The command to be executed.
     * @return String of the executed command.
     */
    private String executeCommand(Command command) {
        command.setData(notebook, timetable, tagManager, storageManager);
        return command.execute();
    }

    /**
     * Main entry-point for the application.
     */
    public static void main(String[] args) {
        //AnsiConsole.systemInstall();
        new Duke().run();
        //AnsiConsole.systemUninstall();
    }
}
