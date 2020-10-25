package seedu.notus.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.notus.command.PinCommand.COMMAND_UNSUCCESSFUL_MESSAGE;

import seedu.notus.data.notebook.Note;
import seedu.notus.data.notebook.Notebook;
import seedu.notus.ui.Formatter;

import java.text.Normalizer;
import java.util.ArrayList;

//@@author prachi2023
class PinCommandTest {
    private Note notePinned;
    private Note noteNotPinned;

    private Notebook notebook;

    private static final ArrayList<String> NOTE_CONTENT = new ArrayList<>();

    private static final String NOTE1_TITLE = "TestNote1";
    private static final String NOTE2_TITLE = "TestNote2";

    @BeforeEach
    void setUp() {
        NOTE_CONTENT.add("This is a test note.");
        notePinned = new Note(NOTE1_TITLE, NOTE_CONTENT, true, false);
        noteNotPinned = new Note(NOTE2_TITLE, NOTE_CONTENT, false, false);

        notebook = new Notebook();

        notebook.addNote(notePinned);
        notebook.addNote(noteNotPinned);
    }

    @Test
    void execute() {
    }

    @Test
    void execute_inputIndex_NoteExists_PinsAndUnpinsNotes() {
        String expected1 = Formatter.formatString(NOTE1_TITLE + " pinned: " + 'N');
        String expected2 = Formatter.formatString(NOTE2_TITLE + " pinned: " + 'Y');

        assertEquals(expected1, getExecutionStringInputIndex(notebook, 0));
        assertEquals(expected2, getExecutionStringInputIndex(notebook, 1));

        assertFalse(notePinned.getPinned());
        assertTrue(noteNotPinned.getPinned());
    }

    @Test
    void execute_inputTitle_NoteExists_PinsAndUnpinsNotes() {
        String expected1 = Formatter.formatString(NOTE1_TITLE + " pinned: " + 'N');
        String expected2 = Formatter.formatString(NOTE2_TITLE + " pinned: " + 'Y');

        assertEquals(expected1, getExecutionStringInputTitle(notebook, NOTE1_TITLE));
        assertEquals(expected2, getExecutionStringInputTitle(notebook, NOTE2_TITLE));

        assertFalse(notePinned.getPinned());
        assertTrue(noteNotPinned.getPinned());
    }

    @Test
    void execute_inputIndex_NoteDoesNotExists_returnsUnsuccessful() {
        String expected = Formatter.formatString(COMMAND_UNSUCCESSFUL_MESSAGE);

        assertEquals(expected, getExecutionStringInputIndex(notebook, 5));
        assertEquals(expected, getExecutionStringInputIndex(notebook, 3));
    }

    @Test
    void execute_inputTitle_NoteDoesNotExists_returnsUnsuccessful() {

        String expected = Formatter.formatString(COMMAND_UNSUCCESSFUL_MESSAGE);

        assertEquals(expected, getExecutionStringInputTitle(notebook, "Title"));
        assertEquals(expected, getExecutionStringInputTitle(notebook, "Random"));
    }

    private String getExecutionStringInputIndex(Notebook notebook, int index) {
        PinCommand pinCommand = new PinCommand(index);
        pinCommand.setData(notebook, null, null, null);

        return pinCommand.execute();
    }

    private String getExecutionStringInputTitle(Notebook notebook, String title) {
        PinCommand pinCommand = new PinCommand(title);
        pinCommand.setData(notebook, null,null, null);

        return pinCommand.execute();
    }
}
