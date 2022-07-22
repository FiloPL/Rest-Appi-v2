package ttsw.filopl.restappiv2.item.repository;

import org.springframework.stereotype.Repository;
import ttsw.filopl.restappiv2.item.Item;

import java.util.*;

/**
 * Created by T. Filo Zegarlicki on 21.07.2022
 **/

@Repository
public class InMemoryItemRepository {
    protected final Map<Long, Item> map = new HashMap<>();
    protected long counter = 1;

    public Item save(Item entity) {
        setData(entity);
        return entity;
    }

    private Item setData(Item entity) {
        if (entity.getId() != null) {
            map.put(entity.getId(), entity);
        } else {
            entity.setId(counter);
            map.put(counter, entity);
            counter++;
        }

        return entity;
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Item> findAll() {
        return new ArrayList<>(map.values());
    }

    public void deleteById(Long id) {
        map.remove(id);
    }
}
