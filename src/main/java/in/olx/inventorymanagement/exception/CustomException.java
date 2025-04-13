package in.olx.inventorymanagement.exception;

public class CustomException {
    private final String errorCode;

    public CustomException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
