package com.aap.splitbill.controller;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.dto.FriendDto;
import com.aap.splitbill.dto.ItemDto;
import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Friend;
import com.aap.splitbill.model.Item;
import com.aap.splitbill.service.BillService;
import com.aap.splitbill.utils.BuildBills;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BillControllerTest {
    @Mock
    BillService billService;
    @InjectMocks
    BillController billController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBill() {
        when(billService.saveBill(any())).thenReturn(BuildBills.buildBillDto());
        BillDto result = billController.saveBill(BuildBills.buildBillDto());
        Assertions.assertEquals(BuildBills.buildBillDto(), result);
    }

    @Test
    void testGetAllBills() {
        when(billService.getAllBills()).thenReturn(List.of(BuildBills.buildBillDto()));
        List<BillDto> result = billController.getAllBills();
        Assertions.assertEquals(List.of(BuildBills.buildBillDto()), result);
    }

}
