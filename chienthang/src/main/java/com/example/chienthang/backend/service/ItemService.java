package com.example.chienthang.backend.service;

import com.example.chienthang.backend.common.Snowflake;
import com.example.chienthang.backend.dto.request.ItemCreateOrUpdateRequest;
import com.example.chienthang.backend.entity.ItemEntity;
import com.example.chienthang.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {
    private ItemRepository itemRepository;
    private Snowflake snowflake;
    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    public ItemEntity findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public ItemEntity createOrUpdate(ItemCreateOrUpdateRequest request) {
        ItemEntity itemEntity = new ItemEntity();
        if (request.getItemId() != null) {
            // create
            itemEntity = itemRepository.findById(request.getItemId()).orElse(null);
            if (itemEntity != null) {
                itemEntity.setItemName(request.getItemName());
                itemEntity.setDescription(request.getDescription());
            }
        } else {
            // update
            itemEntity.setItemId(String.valueOf(snowflake.nextId()));
            itemEntity.setItemName(request.getItemName());
            itemEntity.setDescription(request.getDescription());
            itemEntity.setCreatedDate(new Date());
            itemEntity.setCreatedBy("admin");
        }

        return itemEntity != null ? itemRepository.save(itemEntity) : null;
    }

}
