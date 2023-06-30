package com.aap.splitbill.dto;

import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Friend;
import com.aap.splitbill.model.Item;
import com.aap.splitbill.utils.BuildBills;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class FriendDtoTest {
    @Mock
    BillDto bill;
    @Mock
    List<ItemDto> items;
    @Mock
    BigDecimal percent;
    @Mock
    BigDecimal totalOrder;
    @Mock
    BigDecimal discount;
    @Mock
    BigDecimal totalPay;
    @Mock
    BigDecimal addFee;
    @Mock
    BigDecimal serviceTax;
    @InjectMocks
    FriendDto friendDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        friendDto = BuildBills.buildBillDto().getFriends().get(0);
    }

    @Test
    void testSetId() {
        friendDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetName() {
        friendDto.setName("name");
    }

    @Test
    void testSetPhone() {
        friendDto.setPhone("phone");
    }

    @Test
    void testSetUrl() {
        friendDto.setUrl("url");
    }

    @Test
    void testSetCreatedOn() {
        friendDto.setCreatedOn(LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41));
    }

    @Test
    void testSetUpdatedOn() {
        friendDto.setUpdatedOn(LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41));
    }

    @Test
    void testSetBill() {
        friendDto.setBill(new BillDto(Long.valueOf(1), Boolean.TRUE, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), List.of(new FriendDto(Long.valueOf(1), "name", "phone", "url", LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), null, List.of(new ItemDto(Long.valueOf(1), "itemName", new BigDecimal(0), LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), LocalDateTime.of(2023, Month.JUNE, 30, 2, 11, 41), null)), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0))), "bank", "customer"));
    }

    @Test
    void testSetItems() {
        friendDto.setItems(List.of(BuildBills.buildBillDto().getFriends().get(0).getItems().get(0)));
    }

    @Test
    void testSetPercent() {
        friendDto.setPercent(new BigDecimal(0));
    }

    @Test
    void testSetTotalOrder() {
        friendDto.setTotalOrder(new BigDecimal(0));
    }

    @Test
    void testSetDiscount() {
        friendDto.setDiscount(new BigDecimal(0));
    }

    @Test
    void testSetTotalPay() {
        friendDto.setTotalPay(new BigDecimal(0));
    }

    @Test
    void testSetAddFee() {
        friendDto.setAddFee(new BigDecimal(0));
    }

    @Test
    void testSetServiceTax() {
        friendDto.setServiceTax(new BigDecimal(0));
    }

    @Test
    void testEquals() {
        boolean result = friendDto.getId().equals("10");
        Assertions.assertFalse(result);
    }

    @Test
    void testCanEqual() {
        boolean result = friendDto.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = friendDto.hashCode();
        Assertions.assertEquals(676235148, result);
    }

    @Test
    void testToString() {
        FriendDto friend = BuildBills.buildBillDto().getFriends().get(0);
        String result = friendDto.toString();
        Assertions.assertEquals(friend.toString(), result);
    }

    @Test
    void testBuilder() {
        FriendDto.FriendDtoBuilder result = FriendDto.builder();
        Assertions.assertNotNull(result);
    }

}
