package seedu.duke.data.exception;

/**
 * Signals the different type of possible exceptions.
 */
public class SystemException extends Exception {
    /** Types of exception. */
    public enum ExceptionType {
        EXCEPTION_WRONG_PREFIX("Type of prefix not recognized!"),
        EXCEPTION_MISSING_DESCRIPTION("Missing description!"),
        EXCEPTION_MISSING_TITLE_PREFIX("Missing title prefix!"),
        EXCEPTION_MISSING_TITLE("Missing title!"),
        EXCEPTION_DUPLICATE_NOTE("This note already exists in the notebook!"),
        EXCEPTION_MISSING_NOTE("This note does not exists in the notebook!"),
        EXCEPTION_MISSING_TIMING("This event does not have a timing specified!"),
        EXCEPTION_WRONG_TIMING("Your input has a wrong format for the date time input. Please follow the yyyy-MM-dd HH:mm format with the \"-\" and \":\""),
        EXCEPTION_MISSING_TAG_PREFIX("Missing tag prefix!"),
        EXCEPTION_MISSING_TAG("Missing tag name!"),
        EXCEPTION_MISSING_INDEX_PREFIX("Missing index prefix!"),
        EXCEPTION_MISSING_INDEX("Missing index!"),
        EXCEPTION_MISSING_PIN("Missing pin!"),
        EXCEPTION_MISSING_KEYWORD("No search query input. Please enter a keyword for search results."),
        EXCEPTION_INVALID_INDEX_FORMAT("Invalid index format!"),
        EXCEPTION_INVALID_INDEX_VALUE("Invalid index value!"),
        EXCEPTION_FILE_CREATION_ERROR("Unable to create a file!"),
        EXCEPTION_INVALID_END_INPUT("Input /end on a new line!");

        /** The exception message. */
        private final String exceptionMessage;

        /**
         * Constructor of an ExceptionType.
         *
         * @param exceptionMessage The exception message.
         */
        ExceptionType(String exceptionMessage) {
            this.exceptionMessage = exceptionMessage;
        }

        /**
         * Overrides the parent toString method.
         *
         * @return The exception message.
         */
        @Override
        public String toString() {
            return exceptionMessage;
        }
    }

    public SystemException(ExceptionType exceptionType) {
        super(exceptionType.toString());
    }
}
