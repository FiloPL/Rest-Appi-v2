package ttsw.filopl.restappiv2.item.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttsw.filopl.restappiv2.item.api.request.ItemRequest;
import ttsw.filopl.restappiv2.item.api.request.UpdateItemRequest;
import ttsw.filopl.restappiv2.item.api.response.ItemResponse;
import ttsw.filopl.restappiv2.item.service.ItemService;

import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

@RestController
@Api(tags = "Items")
@RequestMapping("/api/items")
public class ItemApi {

    private final ItemService itemService;

    ItemApi(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ApiOperation("Create item")
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest) {
        ItemResponse itemResponse = itemService.create(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<ItemResponse> find(@PathVariable Long id) {
        ItemResponse itemResponse = itemService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @PutMapping
    @ApiOperation("Update item")
    public ResponseEntity<ItemResponse> update(@RequestBody UpdateItemRequest updateItemRequest) {
        ItemResponse itemResponse = itemService.update(updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update item alternative version")
    public ResponseEntity<ItemResponse> update(@PathVariable Long id, @RequestBody UpdateItemRequest updateItemRequest) {
        ItemResponse itemResponse = itemService.updateAlternativeVersion(id, updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping
    @ApiOperation("Find all items")
    public ResponseEntity<List<ItemResponse>> findAll() {
        List<ItemResponse> itemResponses = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponses);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete item")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}