package ttsw.filopl.restappiv2.item.api.response;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

public class ItemResponse {

    private final Long id;
    private final String name;

    public ItemResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}