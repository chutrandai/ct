package com.example.chienthang.backend.repository;

import com.example.chienthang.backend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<String, ItemEntity> {
}
