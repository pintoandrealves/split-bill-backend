package com.aap.splitbill.service;

import com.aap.splitbill.dto.BillDto;

import java.util.List;

public interface BillService {
    BillDto saveBill(BillDto billDto);

    List<BillDto> getAllBills();
}
