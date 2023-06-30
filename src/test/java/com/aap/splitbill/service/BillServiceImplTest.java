package com.aap.splitbill.service;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.dto.FriendDto;
import com.aap.splitbill.dto.ItemDto;
import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Friend;
import com.aap.splitbill.model.Item;
import com.aap.splitbill.repository.BillRepository;
import com.aap.splitbill.strategy.BankService;
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

class BillServiceImplTest {
    @Mock
    BillRepository billRepository;
    @Mock
    BankService someService;
    @InjectMocks
    BillServiceImpl billServiceImpl;

    public static final String URL = "https://nubank.com.br/customer/";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBill() {
        BillDto billDto = BuildBills.buildBillDto();
        when(billRepository.save(any())).thenReturn(BuildBills.buildBill());
        when(someService.getUrlBank(any())).thenReturn(URL);
        BillDto result = billServiceImpl.saveBill(BuildBills.buildBillDto());
        Assertions.assertEquals(billDto, result);
    }

    @Test
    void testProcessBill() {
        when(someService.getUrlBank(any())).thenReturn(URL);
        billServiceImpl.processBill(BuildBills.buildBill());
    }

    @Test
    void testGetAllBills() {
        when(billRepository.findAll()).thenReturn(List.of(BuildBills.buildBill()));
        List<BillDto> result = billServiceImpl.getAllBills();
        Assertions.assertEquals(List.of(BuildBills.buildBillDto()), result);
    }

}
