package com.aap.splitbill.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.*;

class ItemDtoTest {
    @Mock
    BigDecimal price;
    @Mock
    FriendDto friend;
    @InjectMocks
    ItemDto itemDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        itemDto = ItemDto.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(58)).build();
    }

    @Test
    void testSetId() {
        itemDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetItemName() {
        itemDto.setItemName("itemName");
    }

    @Test
    void testSetPrice() {
        itemDto.setPrice(new BigDecimal(0));
    }

    @Test
    void testSetCreatedOn() {
        itemDto.setCreatedOn(LocalDateTime.of(2023, Month.JUNE, 30, 1, 59, 5));
    }

    @Test
    void testSetUpdatedOn() {
        itemDto.setUpdatedOn(LocalDateTime.of(2023, Month.JUNE, 30, 1, 59, 5));
    }

    @Test
    void testToString() {
        String result = itemDto.toString();
        Assertions.assertEquals("ItemDto(id=null, itemName=Bolacha, price=58, createdOn=null, updatedOn=null, friend=null)", result);
    }

}

