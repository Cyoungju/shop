package com.example.shop.service;


import com.example.shop.dto.ItemRequestDto;
import com.example.shop.dto.ItemResponseDto;
import com.example.shop.entity.Item;
import com.example.shop.entity.Mag;
import com.example.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<ItemResponseDto> getList() {
        return itemRepository.findAll().stream().map(
                ItemResponseDto::new
        ).toList();
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = findItem(id);

        item.update(itemRequestDto);

        ItemResponseDto itemResponseDto = new ItemResponseDto(item);

        return itemResponseDto;
    }

    public Mag deleteItem(Long id) {
        Item item = findItem(id);

        itemRepository.delete(item);
        return new Mag("삭제 완료");

    }


    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 상품은 존재하지 않습니다.")
        );
    }

}
