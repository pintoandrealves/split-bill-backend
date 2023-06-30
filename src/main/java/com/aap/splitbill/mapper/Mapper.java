package com.aap.splitbill.mapper;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.dto.FriendDto;
import com.aap.splitbill.dto.ItemDto;
import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Friend;
import com.aap.splitbill.model.Item;

public class Mapper {

    private Mapper(){

    }

    public static BillDto mapToBillDto(Bill bill){
        return BillDto.builder()
                .id(bill.getId())
                .customer(bill.getCustomer())
                .isProportional(bill.getIsProportional())
                .discount(bill.getDiscount())
                .addFee(bill.getAddFee())
                .serviceTax(bill.getServiceTax())
                .createdOn(bill.getCreatedOn())
                .updatedOn(bill.getUpdatedOn())
                .bank(bill.getBank())
                .friends(bill.getFriends().stream().map(bills -> Mapper.maptoFriendDto(bills)).toList())
                .build();
    }
    private static FriendDto maptoFriendDto(Friend friend) {
        return FriendDto.builder()
                .id(friend.getId())
                .name(friend.getName())
                .phone(friend.getPhone())
                .createdOn(friend.getCreatedOn())
                .updatedOn(friend.getUpdatedOn())
                .url(friend.getUrl())
                .percent(friend.getPercent())
                .totalOrder(friend.getTotalOrder())
                .discount(friend.getDiscount())
                .totalPay(friend.getTotalPay())
                .addFee(friend.getAddFee())
                .serviceTax(friend.getServiceTax())
                .items(friend.getItems().stream().map(frd -> mapToItemDto(frd)).toList())
                .build();
    }

    private static ItemDto mapToItemDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .price(item.getPrice())
                .createdOn(item.getCreatedOn())
                .updatedOn(item.getUpdatedOn())
                .build();
    }

    public static Bill mapToBill(BillDto billDto){
        return Bill.builder()
                .customer(billDto.getCustomer())
                .id(billDto.getId())
                .isProportional(billDto.getIsProportional())
                .discount(billDto.getDiscount())
                .addFee(billDto.getAddFee())
                .serviceTax(billDto.getServiceTax())
                .createdOn(billDto.getCreatedOn())
                .updatedOn(billDto.getUpdatedOn())
                .bank(billDto.getBank())
                .friends(billDto.getFriends().stream().map(bill -> maptoFriend(bill)).toList().stream().filter(it -> it.getName() != null).toList())
                .build();
    }

    private static Friend maptoFriend(FriendDto friendDto) {
        return Friend.builder()
                .id(friendDto.getId())
                .name(friendDto.getName())
                .phone(friendDto.getPhone())
                .createdOn(friendDto.getCreatedOn())
                .updatedOn(friendDto.getUpdatedOn())
                .url(friendDto.getUrl())
                .percent(friendDto.getPercent())
                .totalOrder(friendDto.getTotalOrder())
                .discount(friendDto.getDiscount())
                .totalPay(friendDto.getTotalPay())
                .addFee(friendDto.getAddFee())
                .serviceTax(friendDto.getServiceTax())
                .items(friendDto.getItems().stream().map(frd -> mapToItem(frd)).toList().stream().filter(it -> it.getItemName() != null).toList())
                .build();
    }

    private static Item mapToItem(ItemDto itemDto) {
        return Item.builder()
                .id(itemDto.getId())
                .itemName(itemDto.getItemName())
                .price(itemDto.getPrice())
                .createdOn(itemDto.getCreatedOn())
                .updatedOn(itemDto.getUpdatedOn())
                .build();
    }
}
