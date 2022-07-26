package ttsw.filopl.restappiv2.item.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ttsw.filopl.restappiv2.share.api.response.ErrorMessageResponse;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

@ControllerAdvice
public class ItemExceptionAdvisor {

    private static final Logger LOG = LoggerFactory.getLogger(ItemExceptionAdvisor.class);

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse itemNotFound( Exception exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }
}
