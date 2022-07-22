package ttsw.filopl.restappiv2.item.support;

import org.springframework.stereotype.Component;
import ttsw.filopl.restappiv2.item.Item;
import ttsw.filopl.restappiv2.item.api.request.ItemRequest;
import ttsw.filopl.restappiv2.item.api.response.ItemResponse;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

@Component
public class ItemMapper
{
    public Item toItem(ItemRequest itemRequest) {
        return  new Item(itemRequest.getName());
    }

    public Item toItem(Item item, ItemRequest itemRequest) {
        item.setName(itemRequest.getName());
        return item;
    }
    public ItemResponse toItemResponse(Item item) {
        return new ItemResponse(item.getId(), item.getName());
    }
}
