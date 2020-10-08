package seedu.duke.command;

import static seedu.duke.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.duke.util.PrefixSyntax.PREFIX_INDEX;
import static seedu.duke.util.PrefixSyntax.PREFIX_TITLE;

/**
 * Views a specific Note in the Notebook.
 */
public class ViewNoteCommand extends Command {

    public static final String COMMAND_WORD = "view-n";

    private static final String COMMAND_USAGE = COMMAND_WORD + ": Views a note. Parameters: "
            + "[" + PREFIX_DELIMITER + PREFIX_INDEX + " INDEX] "
            + "[" + PREFIX_DELIMITER + PREFIX_TITLE + " TITLE] ";

    private int index;
    private String title;
    private boolean isViewByIndex;

    public static String getCommandUsage() {
        return COMMAND_USAGE;
    }

    /**
     * Constructs a ViewNoteCommand to view a Note by the index.
     *
     * @param index of the Note.
     */
    public ViewNoteCommand(int index) {
        this.index = index;
        this.title = null;
        this.isViewByIndex = true;
    }

    /**
     * Constructs a ViewNoteCommand to view a Note by the title.
     *
     * @param title of the Note.
     */
    public ViewNoteCommand(String title) {
        this.index = NULL_INT;
        this.title = title;
        this.isViewByIndex = false;
    }

    @Override
    public String execute() {
        return null;
    }
}