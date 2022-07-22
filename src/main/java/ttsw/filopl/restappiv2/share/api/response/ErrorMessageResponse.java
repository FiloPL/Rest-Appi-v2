package ttsw.filopl.restappiv2.share.api.response;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/
public class ErrorMessageResponse {
    private final String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
