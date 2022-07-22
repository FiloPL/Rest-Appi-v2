package ttsw.filopl.restappiv2.item.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import ttsw.filopl.restappiv2.item.api.request.ItemRequest;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

public class UpdateItemRequest extends ItemRequest {

    private final Long id;

    @JsonCreator
    public UpdateItemRequest(String name, Long id) {
        super(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}