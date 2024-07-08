package com.example.shop.service;


import com.example.shop.dto.ItemRequestDto;
import com.example.shop.dto.ItemResponseDto;
import com.example.shop.entity.Item;
import com.example.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item(itemRequestDto);

        Item saveItem = itemRepository.save(item);

        ItemResponseDto itemResponseDto = new ItemResponseDto(saveItem);

        return itemResponseDto;
    }
}
