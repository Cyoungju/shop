package com.example.shop.entity;

import com.example.shop.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public Item(ItemRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();

    }

    public void update(ItemRequestDto itemRequestDto){
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }
}
