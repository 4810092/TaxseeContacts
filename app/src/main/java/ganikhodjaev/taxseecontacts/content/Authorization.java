package ganikhodjaev.taxseecontacts.content;

/**
 * @author Khasan Ganikhodjaev
 */
public class Authorization {

    private String Message;
    private boolean Success;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }
}
