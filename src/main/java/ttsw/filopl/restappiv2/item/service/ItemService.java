package ttsw.filopl.restappiv2.item.service;

import org.springframework.stereotype.Service;
import ttsw.filopl.restappiv2.item.Item;
import ttsw.filopl.restappiv2.item.api.response.ItemResponse;
import ttsw.filopl.restappiv2.item.api.request.ItemRequest;
import ttsw.filopl.restappiv2.item.api.request.UpdateItemRequest;
import ttsw.filopl.restappiv2.item.repository.ItemRepository;
import ttsw.filopl.restappiv2.item.support.ItemExceptionSupplier;
import ttsw.filopl.restappiv2.item.support.ItemMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemResponse create(ItemRequest itemRequest) {
        Item item = itemRepository.save(itemMapper.toItem(itemRequest));
        return itemMapper.toItemResponse(item);
    }

    public ItemResponse find(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id));
        return itemMapper.toItemResponse(item);
    }

    public List<ItemResponse> findAll() {
        return itemRepository.findAll().stream().map(itemMapper::toItemResponse).collect(Collectors.toList());
    }

    public ItemResponse update(UpdateItemRequest updateItemRequest) {
        Item item = itemRepository.findById(updateItemRequest.getId()).orElseThrow(
                ItemExceptionSupplier.itemNotFound(updateItemRequest.getId()));
        itemRepository.save(itemMapper.toItem(item, updateItemRequest));
        return itemMapper.toItemResponse(item);
    }

    public ItemResponse updateAlternativeVersion(Long id, UpdateItemRequest updateItemRequest) {
        Item item = itemRepository.findById(id).orElseThrow(
                ItemExceptionSupplier.itemNotFound(id));
        itemRepository.save(itemMapper.toItem(item, updateItemRequest));
        return itemMapper.toItemResponse(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id));
        itemRepository.deleteById(item.getId());
    }
}