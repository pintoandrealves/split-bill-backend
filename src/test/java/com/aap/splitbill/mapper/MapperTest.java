package com.aap.splitbill.mapper;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.dto.FriendDto;
import com.aap.splitbill.dto.ItemDto;
import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Friend;
import com.aap.splitbill.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MapperTest {

    @Test
    void testMapToBillDto() {
        BillDto billDto = buildBillDto();
        BillDto result = Mapper.mapToBillDto(buildBill());
        Assertions.assertEquals(billDto, result);
    }

    @Test
    void testMapToBill() {
        Bill bill = buildBill();
        Bill result = Mapper.mapToBill(buildBillDto());
        Assertions.assertEquals(bill, result);
    }

    public static Bill buildBill() {
        Bill bill = Bill.builder()
                .customer("12348877")
                .id(1L)
                .discount(new BigDecimal(10))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(10))
                .bank("NUBANK")
                .build();

        List<Item> items = new ArrayList<>();
        Item item = Item.builder()
                .itemName("Suco")
                .price(new BigDecimal(12)).build();
        Item itemTwo = Item.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(13)).build();
        items.addAll(Arrays.asList(item, itemTwo));

        Friend friend = Friend.builder()
                .id(1L)
                .name("Andre")
                .phone("5511987458745")
                .url("https://nubank.com.br/customer/123654987/1000")
                .percent(new BigDecimal(10))
                .discount(new BigDecimal(20))
                .totalPay(new BigDecimal(100))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(20))
                .totalOrder(new BigDecimal(0)).build();
        friend.setItems(items);

        List<Item> itemsTwo = new ArrayList<>();
        Item itemNew = Item.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(58)).build();
        Item itemNewTwo = Item.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(96)).build();
        itemsTwo.addAll(Arrays.asList(itemNew, itemNewTwo));

        Friend friendTwo = Friend.builder()
                .id(1L)
                .name("Paulo")
                .phone("5511987458745")
                .url("https://nubank.com.br/customer/123654987/100")
                .percent(new BigDecimal(10))
                .discount(new BigDecimal(20))
                .totalPay(new BigDecimal(100))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(20))
                .totalOrder(new BigDecimal(0)).build();
        friendTwo.setItems(itemsTwo);

        bill.setFriends(Arrays.asList(friend, friendTwo));

        return bill;
    }

    public static BillDto buildBillDto() {
        BillDto billDto = BillDto.builder()
                .customer("12348877")
                .id(1L)
                .discount(new BigDecimal(10))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(10))
                .bank("NUBANK")
                .build();

        List<ItemDto> items = new ArrayList<>();
        ItemDto item = ItemDto.builder()
                .itemName("Suco")
                .price(new BigDecimal(12)).build();
        ItemDto itemTwo = ItemDto.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(13)).build();
        items.addAll(Arrays.asList(item, itemTwo));

        FriendDto friend = FriendDto.builder()
                .id(1L)
                .name("Andre")
                .phone("5511987458745")
                .url("https://nubank.com.br/customer/123654987/1000")
                .percent(new BigDecimal(10))
                .discount(new BigDecimal(20))
                .totalPay(new BigDecimal(100))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(20))
                .totalOrder(new BigDecimal(0)).build();
        friend.setItems(items);

        List<ItemDto> itemsTwo = new ArrayList<>();
        ItemDto itemNew = ItemDto.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(58)).build();
        ItemDto itemNewTwo = ItemDto.builder()
                .itemName("Bolacha")
                .price(new BigDecimal(96)).build();
        itemsTwo.addAll(Arrays.asList(itemNew, itemNewTwo));

        FriendDto friendTwo = FriendDto.builder()
                .id(1L)
                .name("Paulo")
                .phone("5511987458745")
                .url("https://nubank.com.br/customer/123654987/100")
                .percent(new BigDecimal(10))
                .discount(new BigDecimal(20))
                .totalPay(new BigDecimal(100))
                .addFee(new BigDecimal(10))
                .serviceTax(new BigDecimal(20))
                .totalOrder(new BigDecimal(0)).build();
        friendTwo.setItems(itemsTwo);

        billDto.setFriends(Arrays.asList(friend, friendTwo));

        return billDto;
    }
}

