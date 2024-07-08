package com.example.shop.controller;



import com.example.shop.dto.ItemRequestDto;
import com.example.shop.dto.ItemResponseDto;
import com.example.shop.entity.Mag;
import com.example.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping
    public List<ItemResponseDto> getList(){
        return itemService.getList();
    }

    @PutMapping("/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto){
        return itemService.updateItem(id, itemRequestDto);
    }

    @DeleteMapping("/{id}")
    public Mag deleteItem(@PathVariable Long id){
        return itemService.deleteItem(id);
    }

}
