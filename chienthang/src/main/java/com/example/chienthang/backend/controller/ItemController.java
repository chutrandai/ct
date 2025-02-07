package com.example.chienthang.backend.controller;

import com.example.chienthang.backend.dto.request.ItemCreateOrUpdateRequest;
import com.example.chienthang.backend.entity.ItemEntity;
import com.example.chienthang.backend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item")
@AllArgsConstructor
public class ItemController {
    private ItemService itemService;

    @GetMapping(value = "search")
    public List<ItemEntity> search() {
        return itemService.findAll();
    }
    @GetMapping(value = "detail")
    public ItemEntity get(@RequestParam String itemId) {
        return itemService.findById(itemId);
    }
    @PostMapping(value = "create")
    public ItemEntity create(@RequestBody ItemCreateOrUpdateRequest request) {
        return itemService.createOrUpdate(request);
    }
    @PostMapping(value = "save")
    public ItemEntity save(@RequestBody ItemCreateOrUpdateRequest request) {
        return itemService.createOrUpdate(request);
    }
}
