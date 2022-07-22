package ttsw.filopl.restappiv2.item.support;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException( Long id ) {
        super(String.format("Item with %d not found", id));
    }

}
