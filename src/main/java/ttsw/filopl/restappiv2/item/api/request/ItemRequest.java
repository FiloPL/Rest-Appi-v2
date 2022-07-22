package ttsw.filopl.restappiv2.item.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/
public class ItemRequest {

    private final String name;

    @JsonCreator
    public ItemRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}