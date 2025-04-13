package in.olx.inventorymanagement.exception;

public class CustomException extends RuntimeException {
    private final String errorCode;

    // Constructor for setting errorCode and message
    public CustomException(String errorCode, String message) {
        super(message); // Passing the message to RuntimeException constructor
        this.errorCode = errorCode;
    }

    // Getter for errorCode
    public String getErrorCode() {
        return errorCode;
    }
}

