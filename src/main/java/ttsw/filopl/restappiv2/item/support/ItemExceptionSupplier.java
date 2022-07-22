package ttsw.filopl.restappiv2.item.support;

import java.util.function.Supplier;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

public class ItemExceptionSupplier {

    public static Supplier<ItemNotFoundException> itemNotFound(Long id) {
        return () -> new ItemNotFoundException(id);
    }
}
